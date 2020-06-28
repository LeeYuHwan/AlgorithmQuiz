class Solution {
  public String solution(String s) {
		String answer = "";
		int size = s.length();
		
		if(size % 2 == 0) {
			char[] tmp = new char[2];
			tmp[0] = s.charAt((size / 2) - 1);
			tmp[1] = s.charAt(size / 2);
			answer = new String(tmp, 0, tmp.length);							
		}
		else {
			char[] tmp = new char[1];
			tmp[0] = s.charAt(size / 2);
			answer = new String(tmp, 0, tmp.length);
		}
      return answer;
  }
}