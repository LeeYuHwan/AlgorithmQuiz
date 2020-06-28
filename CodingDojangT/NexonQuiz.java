package CodingDojang;

public class NexonQuiz {
	public static void main(String[] args) {
		int[] ans = new int[5000];		
		int a, b, c, d, result, sum = 0;
		
		for(int i = 0; i < 5000; i++) {
			a = i / 1000;
			b = (i / 100) % 10;
			c = (i / 10) % 10;
			d = i % 10;
			
			result = a + b + c + d + i;
			if(result >= 1 && result < 5000)
				ans[result] = 1;		
		} 
		
		for(int i = 0; i < 5000; i++) {
			if(ans[i] != 1)
				sum += i;
		}
		System.out.println(sum);
	}
}