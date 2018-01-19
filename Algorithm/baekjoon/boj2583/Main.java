package boj2583;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//전체 직사각형 영역을 그리고
		//직사각형이 그려지는 영역을 체크 
		//영역별로 큐를 만들어서
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[M][N]; //0:비어있는 상태  1:차있는상태 
		boolean[][] flagMap = new boolean[M][N];
		for(int j=0; j<M; j++) {
			for(int jj=0; jj<N; jj++) {
				map[j][jj] = 0;
				flagMap[j][jj] = true;
			}
		}
		
		int K = sc.nextInt(); //삼각형 갯수
		for(int i = 0; i<K; i++) {
			//한개의 삼각형에 대한 좌표를 입력받을 때 마다 전체 직사각형에 표시 
			int m1 = sc.nextInt();
			int n1 = sc.nextInt();
			int m2 = sc.nextInt();
			int n2 = sc.nextInt();
			for(int j=0; j<M; j++) { //세로축이 증가 
				for(int jj=0; jj<N; jj++) { //가로축이 증가 
					if((M-n2 <= j && j < M-n1) 
				     &&(m1 <= jj && jj < m2)) {
						map[j][jj] = 1;
						flagMap[j][jj] = false;
					}
				}
			}
		}
		

		ArrayList rec = new ArrayList(); //영역의 넓이 담을 리스트
		for(int j=0; j<M; j++) {
			for(int jj=0; jj<N; jj++) {
				
				//System.out.print(map[j][jj]);
				//System.out.print(flagMap[j][jj]);
				
				
				if(flagMap[j][jj]) {
					int tmpRec = 0;
					ArrayList<Integer> queue = new ArrayList<>(); //flagMap에서 해당 원소의 TF보기 위해 arrayList로 
					queue.add(j);
					queue.add(jj);
					
					while(!queue.isEmpty()) {
						int popi = queue.remove(0);
						int popj = queue.remove(0);
						
						if(!flagMap[popi][popj]) continue; //큐에 들어있던 것이 이미 탐색한 것이라면 큐에 들어있는 다음 것 탐색 
						else {
		                     if(map[popi][popj]!=1) {
		                         if(popi-1>=0) {
		                            queue.add(popi-1);
		                            queue.add(popj);
		                         }
		                         if(popi+1<M) {
		                            queue.add(popi+1);
		                            queue.add(popj);
		                         }
		                         if(popj-1>=0) {
		                            queue.add(popi);
		                            queue.add(popj-1);
		                         }
		                         if(popj+1<N) {
		                            queue.add(popi);
		                            queue.add(popj+1);
		                         }
		                      }
		                      tmpRec++;
		                      flagMap[popi][popj] = false;							
						}						
					}
				
				//큐 한번 다 돌면 => 해당 넓이 더하기
				rec.add(tmpRec);
				
				}//System.out.println("");
			
			} 
		} //영역 다 돈 for문 
	
		Collections.sort(rec); //오름차순으로 정렬 
		System.out.println(rec.size());
		for(int i=0; i<rec.size(); i++) {
			System.out.print(rec.get(i)+" ");
		}
	}
}
