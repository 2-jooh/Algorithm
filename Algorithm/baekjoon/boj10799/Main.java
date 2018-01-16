package boj10799;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		ArrayList<Character> tmpStack = new ArrayList<Character>();
		int totalDividedStick = 0;
		int cnt = 0;
		int idx = 0;
		for(char c : input.toCharArray()) {
			cnt++;
			tmpStack.add(c);
			System.out.println(cnt+" "+tmpStack);
			if(c == '(') {
				stack.push(c);
				System.out.println("열린 괄호 ");
			}else {
				System.out.println("닫힌 괄호 ");
				if(tmpStack.get(idx-1) == '(') { //레이저가 생성된 경우
					stack.pop();
					totalDividedStick += stack.size();
					System.out.println(cnt+" : 레이저 - "+stack.size()+", "+totalDividedStick);
				}else {//하나의 쇠막대기가 완성된 경우
					totalDividedStick += 1;
					System.out.println(cnt+" : 쇠막대기 - "+stack.size()+", "+totalDividedStick);
				}
			}
			idx++;
		}
		System.out.println("result : "+totalDividedStick);
		//()(((()())(())()))(())
		
	}
}
