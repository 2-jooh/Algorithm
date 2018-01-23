package boj1110;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 이렇게 하면 틀림
		int num = Integer.parseInt(sc.nextLine());
		int changedNum = 0;
		int cycle = 0;
		while(num != changedNum) {
			if(cycle == 0) changedNum = num;
			int ten = changedNum/10; //6
			int one = changedNum%10; //8
			changedNum = one*10 + (ten+one)%10; 
			cycle++;
		}
		System.out.println(cycle);
		*/

		int num = Integer.parseInt(sc.nextLine());
		int changedNum = num;
		int cycle = 0;
		while(true) {
			int ten = changedNum/10; //6
			int one = changedNum%10; //8
			changedNum = one*10 + (ten+one)%10; 
			//System.out.println(changedNum);
			cycle++;
			if(num == changedNum) break;			
		}
		System.out.println(cycle);
	}
}
