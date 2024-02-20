class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int startIdx = 0;
        boolean firstSw = true;

        int[] points = new int[3];

        for (int i = 0; i < 3; i++){
            int num = 0;

            for (int j = startIdx; j < dartResult.length(); j++){
                if(dartResult.charAt(j) >= 48 && dartResult.charAt(j) <= 57) {
                    if(dartResult.charAt(j) == 49 && dartResult.charAt(j + 1) == 48) {
                        num = 10;
                        startIdx = j + 2;
                    }
                    else {
                        num = dartResult.charAt(j) - 48;
                        startIdx = j + 1;
                    }

                    break;
                }
            }

            for (int j = startIdx; j < dartResult.length(); j++){
                if(dartResult.charAt(j) >= 48 && dartResult.charAt(j) <= 57) {
                    startIdx = j;
                    break;
                }

                if (dartResult.charAt(j) == 'D') num = (int) Math.pow(num, 2);
                else if (dartResult.charAt(j) == 'T') num = (int) Math.pow(num, 3);
                else if (dartResult.charAt(j) == '*') {
                    if(firstSw) num *= 2;
                    else {
                        points[i - 1] *= 2;
                        num *= 2;
                    }
                }
                else if (dartResult.charAt(j) == '#') num *= -1;

            }

            points[i] = num;
            firstSw = false;
        }

        for (int point : points) answer += point;
        return answer;
    }
}