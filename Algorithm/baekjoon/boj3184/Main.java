package boj3184;

import java.util.ArrayList;
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
					/*
					Queue<Character> queue = new LinkedList<Character>();
					queue.offer(map[i][j]); //기준 점 (큐에 제일 처음 들어가는 것) 
					flagMap[i][j] = false; //지나갔다는 표시 ===> 큐에서 뽑을 때 지나갔다는 표시 해야 함 
					*/
					ArrayList<Integer> queue = new ArrayList<>(); //flagMap에서 해당 원소의 TF보기 위해 arrayList로 
					queue.add(i);
					queue.add(j);
					
					while(!queue.isEmpty()) {
						int popi = queue.remove(0);
						int popj = queue.remove(0);
						
						if(!flagMap[popi][popj]) continue; //큐에 들어있던 것이 이미 탐색한 것이라면 큐에 들어있는 다음 것 탐색 
						else {
		                     if(map[popi][popj]!='#') {
		                         if(popi-1>=0) {
		                            queue.add(popi-1);
		                            queue.add(popj);
		                         }
		                         if(popi+1<R) {
		                            queue.add(popi+1);
		                            queue.add(popj);
		                         }
		                         if(popj-1>=0) {
		                            queue.add(popi);
		                            queue.add(popj-1);
		                         }
		                         if(popj+1<C) {
		                            queue.add(popi);
		                            queue.add(popj+1);
		                         }
		                         if(map[popi][popj]=='o') tmpSheep++;
		                         if(map[popi][popj]=='v') tmpWolf++;
		                      }
		                      flagMap[popi][popj] = false;							
						}
						
						/*
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
						*/						
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
