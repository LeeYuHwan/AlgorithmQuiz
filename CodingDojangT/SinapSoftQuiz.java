package CodingDojang;
import java.util.ArrayList;
import java.util.Collections;

public class SinapSoftQuiz {
	public static void main(String[] args) {
		String ans = "������,���翵,����ǥ,���翵,�ڹ�ȣ,������,���翵,"
				+ "������,�ֽ���,�̼���,�ڿ���,�ڹ�ȣ,������,����ȯ,���缺,������,������";
		
		String[] name = ans.split(",");
		int result_lee = 0, result_kim = 0, result_ljy = 0; 
		
        for(int i = 0; i < name.length; i++) {
        	if(name[i].startsWith("��")) result_lee += 1;
        	else if(name[i].startsWith("��")) result_kim += 1;
        	
        	if(name[i].equals("���翵")) result_ljy += 1;     	
        }
        
        System.out.println("1.�̾��� �� :"+result_lee+" �达�� �� :"+result_kim);
        System.out.println("2.���翵 �̸��� �ݺ��� �� :"+result_ljy);
        
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
        
        System.out.print("3.�ߺ��� ������ �̸� ��� :");
        for(int i = 0; i < array_name.size() - 1; i++) {
        	String n = array_name.get(i);
        	System.out.print(n+",");
        }
        System.out.println(array_name.get(array_name.size() - 1));
       
        Collections.sort(array_name);
        System.out.print("4.�ߺ��� ������ �̸� �������� ���� ��� :");
        for(int i = 0; i < array_name.size() - 1; i++) {
        	String n = array_name.get(i);
        	System.out.print(n+",");
        }
        System.out.println(array_name.get(array_name.size() - 1));
	}
}
