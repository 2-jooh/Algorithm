package boj9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(sc.nextLine());
			int one = dfs(n, 1);
			int two = dfs(n, 2);
			int three = dfs(n, 3);
			System.out.println(one + two + three);
		}
	}

	private static int dfs(int n, int sum) {
		if (n == sum)
			return 1;
		else if (n < sum)
			return 0;
		else {
			int one = dfs(n, sum + 1);
			int two = dfs(n, sum + 2);
			int three = dfs(n, sum + 3);
			return one + two + three;
		}
	}
	   /* 연습용 찍어보기 
	   public static void main(String[] args) {
		      Scanner sc = new Scanner(System.in);
		      int T = Integer.parseInt(sc.nextLine());
		      for(int i=0; i<T; i++) {
		         int n  = Integer.parseInt(sc.nextLine());
		         int one = dfs(n, 1, "1");
		         int two = dfs(n, 2, "2");
		         int three = dfs(n, 3, "3");
		         System.out.println(one+two+three);
		      }
	   }
		   
	   private static int dfs(int n, int sum, String printvalue) {
	      if(sum == n) {
	         System.out.println("sum: "+printvalue);
	         return 1;
	      }
	      else if(sum > n) return 0;
	      else {
	         System.out.println(printvalue);
	         printvalue += "+";
	         int one = dfs(n, sum+1, printvalue+"1");
	         int two = dfs(n, sum+2, printvalue+"2");
	         int three = dfs(n, sum+3, printvalue+"3");
	         return one+two+three;
	      }
	   }
	  */
} 

