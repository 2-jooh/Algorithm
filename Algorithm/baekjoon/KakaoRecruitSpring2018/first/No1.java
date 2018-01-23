package KakaoRecruitSpring2018.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2018 카카오 블라인드 채용 코딩테스트 1차
 * 1번 - 비밀지도 
 * @author juhyunlee
 *
 */
public class No1 {
	static int length = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		length = Integer.parseInt(sc.nextLine()); //지도 한 변
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		while(arr1.size() != length) {
			arr1.add(Integer.parseInt(sc.next()));
		}
		while(arr2.size() != length) {
			arr2.add(Integer.parseInt(sc.next()));
		}
		System.out.println(bitwise(arr1, arr2));
		
	}
	public static List<String> bitwise(List<Integer> arr1, List<Integer> arr2) {
		List<String> resultList = new ArrayList<>();

		for(int i=0; i<length; i++) {
			String bin1 = Integer.toBinaryString(arr1.get(i));
			String bin2 = Integer.toBinaryString(arr2.get(i));
			
			StringBuffer sb1 = new StringBuffer(bin1);
			while(sb1.length() != length) {
				sb1.insert(0, "0");
			}
			bin1 = sb1.toString();
			StringBuffer sb2 = new StringBuffer(bin2);
			while(sb2.length() != length) {
				sb2.insert(0, "0");
			}
			bin2 = sb2.toString();
			
			String result = "";
			for(int j=0; j<bin1.length(); j++) {
				if(bin1.charAt(j) == '0' && bin2.charAt(j) == '0') {
					result += " ";
				}else {
					result += "#";
				}					
			}
			resultList.add(result);
		}

		return resultList;
	}
}
