import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result[] = new int[T];
		for(int l = 0; l < T; l++){
		int ans1 = sc.nextInt();
		int x[] = new int[ans1 + 1];
		
		
		int value = 0;
		int o = 0;
		
		x[0] = 0;
		for(int i = 1; i <= ans1; i++){
			x[i] = sc.nextInt();		
		}
		int ans2 = sc.nextInt();
		
		for(int i = 0; i <= ans1; i++){
			if(x[i] == o){				
			    for(int j = i + 1; j <= ans1; j++){
				    if(x[j] - o > ans2){
				    	o = x[j - 1];
					    value++;
					    break;
				    }
				    if(j == ans1){
				    	if(x[j] - o <= ans2){
				    		value++;
				    		o = x[j];
				    	}			    	
				    }		    
			    }
			}
		}
	if(o != x[ans1])
		value = -1;
	result[l] = value;			
	}
		for(int test_case = 0; test_case < T; test_case++) {
			System.out.println("Case #"+(test_case+1));
			System.out.println(result[test_case]);
		}
	}
}