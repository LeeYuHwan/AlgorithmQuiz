import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] tmp = new int[3];
		int[] result = new int[commands.length];
		
		
		for(int i = 0; i < commands.length; i++) {
			for(int j = 0; j < 3; j++) {
				tmp[j] = commands[i][j];					
			}
			int[] ans = new int[(tmp[1] - tmp[0]) + 1];
			int count = 0;
			for(int z = tmp[0] - 1; z < tmp[1]; z++) {
				ans[count] = array[z];
				count++;
			}
			Arrays.sort(ans);
			result[i] = ans[tmp[2] - 1];
		}
        return result;
    }
}