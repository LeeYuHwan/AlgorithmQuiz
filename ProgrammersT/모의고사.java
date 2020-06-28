import java.util.Vector;
class Solution {
    public int[] solution(int[] answer) {
        Vector<Integer> v = new Vector();
		
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int count1 = 0, count2 = 0, count3 = 0;
		
	    for(int i = 0; i < answer.length; i++) {   	
	        if(student1[i % student1.length] == answer[i]) {
	        	count1++;
	        }
	        if(student2[i % student2.length] == answer[i]) {
	        	count2++;
	        }
	        if(student3[i % student3.length] == answer[i]) {
	        	count3++;
	        }        
	    }
	    
	    if(count1 >= count2 && count1 >= count3)
	    	v.add(1);
	    
	    if(count2 >= count3 && count2 >= count1)
	    	v.add(2);
	    
	    if(count3 >= count1 && count3 >= count2)
	    	v.add(3);
	   
	    int[] result = new int[v.size()];
	    
	    for(int i = 0; i < v.size(); i++) {
	    	result[i] = v.get(i);
	    }
        return result;
    }
}