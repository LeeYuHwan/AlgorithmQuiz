import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q10825 {

    static class Students {
        private String name;
        private int koreanLanguage;
        private int english;
        private int math;

        public Students(String name, int koreanLanguage, int english, int math){
            this.name = name;
            this.koreanLanguage = koreanLanguage;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Students> al = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int koreanLanguage = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            al.add(new Students(name, koreanLanguage, english, math));
        }

        Collections.sort(al, ((o1, o2) -> {
            if(o1.koreanLanguage == o2.koreanLanguage) {
                if(o1.english == o2.english) {
                    if(o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }
            return o2.koreanLanguage - o1.koreanLanguage;
        }));

        for (Students students : al) System.out.println(students.name);
    }
}
