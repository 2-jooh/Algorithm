package boj1966;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//우선순위 큐 사용해서 다시 풀어보기 
public class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); //시행 횟수
		int result = 0;
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			List queue = new ArrayList();
			for(int j = 0; j<N; j++) {
				queue.add(sc.nextInt());
			}
			int target = (int) queue.get(M);
			System.out.println("target "+target);
			Collections.reverse(queue);
			for(int jj = 0; jj<queue.size(); jj++) {
				if((int)queue.get(jj) == target) {
					result = jj+1;
					break;
				}
			}
			System.out.println(result);
		}			
	}
}
