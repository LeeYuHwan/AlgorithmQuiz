class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerTime = 0;

        m = m.replace("C#", "H");
        m = m.replace("D#", "I");
        m = m.replace("F#", "J");
        m = m.replace("G#", "K");
        m = m.replace("A#", "M");
        m = m.replace("E#", ".");
        m = m.replace("B#", ".");

        for (String musicInfo : musicinfos){
            String[] tmp = musicInfo.split(",");

            String[] startTimeStr = tmp[0].split(":");
            int startTime = (Integer.parseInt(startTimeStr[0]) * 60) + Integer.parseInt(startTimeStr[1]);

            String[] endTimeStr = tmp[1].split(":");
            int endTime = (Integer.parseInt(endTimeStr[0]) * 60) + Integer.parseInt(endTimeStr[1]);

            String musicName = tmp[2];
            String melody = tmp[3];

            melody = melody.replace("C#", "H");
            melody = melody.replace("D#", "I");
            melody = melody.replace("F#", "J");
            melody = melody.replace("G#", "K");
            melody = melody.replace("A#", "M");
            melody = melody.replace("E#", ".");
            melody = melody.replace("B#", ".");

            System.out.println(melody);

            int mIdx = 0;
            int melodyIdx = 0;

            StringBuilder currentMelody = new StringBuilder();

            for (int i = 0; i < endTime - startTime; i++){
                if(melodyIdx > melody.length() - 1) melodyIdx = 0;
                currentMelody.append(melody.charAt(melodyIdx));

                if(currentMelody.toString().contains(m)) {
                    if(answerTime < endTime - startTime) {
                        answerTime = endTime - startTime;
                        answer = musicName;
                    }

                    break;
                }

                System.out.println(mIdx);

                melodyIdx++;
            }
        }

        return answer;
    }
}