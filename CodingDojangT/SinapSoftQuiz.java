package CodingDojang;
import java.util.ArrayList;
import java.util.Collections;

public class SinapSoftQuiz {
	public static void main(String[] args) {
		String ans = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,"
				+ "김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
		
		String[] name = ans.split(",");
		int result_lee = 0, result_kim = 0, result_ljy = 0; 
		
        for(int i = 0; i < name.length; i++) {
        	if(name[i].startsWith("이")) result_lee += 1;
        	else if(name[i].startsWith("김")) result_kim += 1;
        	
        	if(name[i].equals("이재영")) result_ljy += 1;     	
        }
        
        System.out.println("1.이씨의 수 :"+result_lee+" 김씨의 수 :"+result_kim);
        System.out.println("2.이재영 이름의 반복의 수 :"+result_ljy);
        
        ArrayList<String> array_name = new ArrayList<String>();
        int array_count = 0;
        
        for(int i = 0; i < name.length; i++) {
        	for(int j = i + 1; j < name.length; j++) {   		
       		    if(name[i].equals(name[j])) {
       		    	name[i] = "";    		 	   			 
         	    }     		    
            }
        	if(name[i] != "") {
        		array_name.add(array_count, name[i]);
        		array_count++;
        	}
        }
        
        System.out.print("3.중복을 제거한 이름 출력 :");
        for(int i = 0; i < array_name.size() - 1; i++) {
        	String n = array_name.get(i);
        	System.out.print(n+",");
        }
        System.out.println(array_name.get(array_name.size() - 1));
       
        Collections.sort(array_name);
        System.out.print("4.중복을 제거한 이름 오름차순 으로 출력 :");
        for(int i = 0; i < array_name.size() - 1; i++) {
        	String n = array_name.get(i);
        	System.out.print(n+",");
        }
        System.out.println(array_name.get(array_name.size() - 1));
	}
}
