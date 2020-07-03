class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int n, test;
		for(int test_case = 0; test_case < T; test_case++) {
		    Answer = 0;
		    n = sc.nextInt();
		    for(int i = 0; i < n; i++){
		        test = sc.nextInt();
		        Answer = Answer ^ test;
		    }

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}