import java.util.ArrayList;
import java.util.Scanner;

class Permutation1 { 
	private int n; 
	private int r; 
	private char[] now; // 현재 순열 
	private ArrayList<ArrayList<Character>> result; // 모든 순열
	
	public ArrayList<ArrayList<Character>> getResult() { 
		return result; 
	} 
	
	public Permutation1(int n, int r) { 
		this.n = n;
		this.r = r;
		this.now = new char[r];
		this.result = new ArrayList<ArrayList<Character>>(); 
	} 
	
	public void swap(char[] arr, int i, int j) { 
		char temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 
	
	public void permutation(char[] arr, int depth) { // 현재 순열의 길이가 r일 때 결과 저장 
		if (depth == r) { 
			ArrayList<Character> temp = new ArrayList<>(); 
		
			for (int i = 0; i < now.length; i++) { 
				temp.add(now[i]); 
			} 
			
			result.add(temp); 
			
			return; 
		} 
		
		for (int i = depth; i < n; i++) { 
			swap(arr, i, depth); 
			now[depth] = arr[depth]; 
			permutation(arr, depth + 1); 
			swap(arr, i, depth); 
		} 
	} 	
}

public class 연산자_끼워넣기 {	
	public static void main(String[] args) {      
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> al = new ArrayList<>(); 
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int operSize = 0;
		for(int i = 0; i < 4; i++) {
			int oper = sc.nextInt();
			
			for(int j = 0; j < oper; j++) {
				if(i == 0) {
					al.add('+');
					operSize++;					
				}
				else if(i == 1) {
					al.add('-');
					operSize++;	
				}
				else if(i == 2) {
					al.add('*');
					operSize++;	
				}
				else {
					al.add('/');
					operSize++;	
				}
			}			
		}
		char[] operArr = new char[al.size()];
		for(int i = 0; i < al.size(); i++) {
			operArr[i] = al.get(i);
		}
		
        Permutation1 perm = new Permutation1(operArr.length, operSize);
        perm.permutation(operArr, 0); 
        ArrayList<ArrayList<Character>> result = perm.getResult();
		
        long max = -1000000001;
        long min = 1000000001;
        for(int i = 0; i < result.size(); i++) {
        	
        	long sum = A[0];
        	for(int j = 0; j < result.get(i).size(); j++) {
        		if(result.get(i).get(j) == '+') {
        			sum += A[j + 1];
        		}
        		else if(result.get(i).get(j) == '-') {
        			sum -= A[j + 1];
        		}
        		else if(result.get(i).get(j) == '*') {
        			sum *= A[j + 1];
        		}
        		else if(result.get(i).get(j) == '/') {
        			sum /= A[j + 1];
        		}
        	}

        	if(sum > max) max = sum;
        	if(sum < min) min = sum;
        }
        
        System.out.println(max);
        System.out.println(min);
	}
}