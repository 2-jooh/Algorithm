package boj7785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); //기록될 출입 기록의 수 

		ArrayList enterList = new ArrayList();
		
		for(int i = 0; i < T; i++) {
			String str = sc.nextLine();
			
			int idx = str.indexOf(" ");
			String name = str.substring(0, idx);
			String enterOrleave = str.substring(idx+1);
			
			if(enterOrleave.equals("enter")) {
				enterList.add(name);
			}else if(enterOrleave.equals("leave")) {
				int removeIdx = 0;
				for(int j=0; j<enterList.size(); j++) {
					if((enterList.get(j)).equals(name)) {
						removeIdx = j;
						break;
					}
				}
				enterList.remove(removeIdx);
			}
		}
		
		//역순으로 정렬 
		Collections.sort(enterList, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        return o2.compareTo(o1);
		    }		    
		});

		for(Object list : enterList) {
			System.out.println(list);
		}
	}


 
	
}
