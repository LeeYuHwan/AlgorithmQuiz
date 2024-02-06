class Solution {
    public int[] solution(String[] wallpaper) {
        int firstHI = 0, lastHI = 0, firstWJ = 0, lastWJ = 0;
        boolean firstHSw = false, firstWSw = false;

        for (int i = 0; i < wallpaper.length; i++){
            for (int j = 0; j < wallpaper[i].length(); j++){
                if (wallpaper[i].charAt(j) == '#') {
                    if (!firstHSw) {
                        firstHI = i;
                        firstHSw = true;
                    }

                    lastHI = i;

                }
            }
        }

        for (int i = 0; i < wallpaper[0].length(); i++) {
            for (int j = 0; j < wallpaper.length; j++) {
                if (wallpaper[j].charAt(i) == '#') {
                    if (!firstWSw) {
                        firstWJ = i;
                        firstWSw = true;
                    }

                    lastWJ = i;

                }
            }
        }

        int[] answer = {firstHI, firstWJ, lastHI + 1, lastWJ + 1};
        return answer;
    }
}