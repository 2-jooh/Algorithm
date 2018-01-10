package boj3184;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int sheep = 0, wolf = 0;
		
		Scanner sc = new Scanner(System.in);		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		char[][] map = new char[R][C];
		boolean[][] flagMap = new boolean[R][C];		
		
		sc.nextLine();
		for (int i=0; i<R; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j=0; j<C; j++) {
				map[i][j] = tmp[j];
				if(map[i][j]=='#') {
					flagMap[i][j] = false;
				}else {
					flagMap[i][j] = true;
				}				
			}
		}
		
		for (int i=0; i<R; i++) { //한 칸씩 돌면서 구역별로 큐를 생성해 늑대와 양의 수 탐색 
			for (int j=0; j<C; j++) {
				
				if(flagMap[i][j]) {	
					int tmpSheep = 0, tmpWolf = 0; //한 영역안의 늑대와 양의 수 초기화 
					Queue<Character> queue = new LinkedList<Character>();
					queue.offer(map[i][j]);
					flagMap[i][j] = false; //지나갔다는 표시
					
					while(!queue.isEmpty()) {
						queue.poll();
						if(i-1 >= 0) {
							if(flagMap[i-1][j]) {							
								if(map[i-1][j] == 'o') tmpSheep++;
								if(map[i-1][j] == 'v') tmpWolf++;
								queue.offer(map[i-1][j]);
								flagMap[i-1][j] = false;						
							}
						}
						if(i+1 < R) {
							if(flagMap[i+1][j]) {							
								if(map[i+1][j] == 'o') tmpSheep++;
								if(map[i+1][j] == 'v') tmpWolf++;
								queue.offer(map[i+1][j]);
								flagMap[i+1][j] = false;
							}
						}
						if(j-1 >= 0) {
							if(flagMap[i][j-1]) {							
								if(map[i][j-1] == 'o') tmpSheep++;
								if(map[i][j-1] == 'v') tmpWolf++;
								queue.offer(map[i][j-1]);
								flagMap[i][j-1] = false;
							}
						}
						if(j+1 < C) {
							if(flagMap[i][j+1]) {
								if(map[i][j+1] == 'o') tmpSheep++;
								if(map[i][j+1] == 'v') tmpWolf++;
								queue.offer(map[i][j+1]);
								flagMap[i][j+1] = false;
							}
						}
						
					}
					//큐한번 다 돌면 - 구역별 양과 늑대의 수 세어짐 
					if(tmpWolf >= tmpSheep) tmpSheep = 0;
					else tmpWolf = 0;
					
					sheep += tmpSheep;
					wolf += tmpWolf;
				}
				
			}
		}
		System.out.printf("%d %d\n", sheep, wolf);
		
	}
	

	
}
