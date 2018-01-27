package boj1966;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
		int T = Integer.parseInt(sc.nextLine()); //시행 횟수
		int result = 0;
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			/*
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
			*/
			
			/*
			PriorityQueue pq = new PriorityQueue();
			List queue = new ArrayList();
			for(int j = 0; j<N; j++) {
				int num = sc.nextInt();
				pq.offer(num);
				queue.add(num);
			}

			PriorityQueue reversedPq = new PriorityQueue(pq.size(), Collections.reverseOrder());
			reversedPq.addAll(pq);
			
			int print = 0; //출력 횟수 
			int target = (int) queue.get(M);
			while(!reversedPq.isEmpty()) {
				if(reversedPq.peek() != queue.get(0)) {
					int first = (int) queue.get(0);
					queue.add(queue.size(), first);
					queue.remove(0);
				}else {
					while(reversedPq.) {
						print++;
						reversedPq.poll();
						//if((int)queue.remove(0) == target) break;
						System.out.println("야1 ");
					}
					print++;
					reversedPq.poll();
					if((int)queue.remove(0) == target) break;
					System.out.println("야2");
				}
			}
			System.out.println(print);
			*/
			
			/*
			List pq = new ArrayList();
			List queue = new ArrayList();
			for(int j = 0; j<N; j++) {
				int num = sc.nextInt();
				pq.add(num);
				queue.add(num);
			}
			
			//우선순위 내림차순 
			Collections.sort(pq);
			Collections.reverse(pq);
			
			int print = 0; //출력 횟수 
			int target = (int) queue.get(M);
			while(!pq.isEmpty()) {
				if(pq.get(0) != queue.get(0)) {
					int first = (int) queue.get(0);
					queue.add(queue.size(), first);
					queue.remove(0);
				}else {
					int tmpTarget = 0;
					System.out.println(pq.get(0)+" "+pq.get(1));
					while(pq.get(0) == pq.get(1)) {
						print++;
						tmpTarget = (int) pq.remove(0);
						System.out.println("1: "+tmpTarget);
						queue.remove(0);
					}
					System.out.println("2: "+tmpTarget);
					if(tmpTarget == target) {						
						System.out.println("야아아");
						break;
					}
					print++;
					pq.remove(0);
					if((int)queue.remove(0) == target) {
						
						System.out.println("호로롤로");
						break;
					}
					System.out.println("야2");
				}
			}
			System.out.println("정답은 "+print);
			*/
		}			
	}
}
