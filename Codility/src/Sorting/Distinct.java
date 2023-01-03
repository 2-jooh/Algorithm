package Sorting;

import java.util.*;

public class Distinct {
	
    public int solution(int[] A) {  

    	Set set = new HashSet();
	    for(int i:A) {
	    	set.add(i);
	    } 
	    
	    //System.out.println(set);
    	return set.size();
    			
    }

}
