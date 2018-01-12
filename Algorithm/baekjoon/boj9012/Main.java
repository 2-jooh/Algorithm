package boj9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); //시행 횟수
		for(int i = 0; i < T; i++) {
			String expression = sc.nextLine();	
			if(check(expression)) System.out.println("YES");
			else		   System.out.println("NO");
		}	
	}
	
	public static boolean check(String expression) {
		Stack stack = new Stack();				
		for(char c : expression.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else { 
				if(stack.isEmpty()) return false;
				else stack.pop();
			}			
		}
		return stack.isEmpty();
	}
}
