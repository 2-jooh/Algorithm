package boj1463;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int[] numCnt = new int[num+1];
		numCnt[0] = 0;
		numCnt[1] = 0;
		for(int i=2; i<=num; i++) { //3번째 배열원소부터, numCnt[2] (2의 답)부터 
			if(i%2 == 0 && i%3 == 0){
				//세개 중 가장 작은 것 +1;
				numCnt[i] = Math.min(numCnt[i/2], Math.min(numCnt[i/3], numCnt[i-1])) + 1;
			}else if(i%2 == 0 && i%3 != 0) {
				numCnt[i] = Math.min(numCnt[i/2], numCnt[i-1]) + 1;
			}else if(i%3 == 0 && i%2 != 0) {
				numCnt[i] = Math.min(numCnt[i/3], numCnt[i-1]) + 1;
			}else {
				numCnt[i] = numCnt[i-1] + 1;
			}
		}
//		for(int i=0; i<numCnt.length; i++) {
//			System.out.print(numCnt[i]+" ");
//		}
//		System.out.println("");
		System.out.println(numCnt[num]);
	}
}
