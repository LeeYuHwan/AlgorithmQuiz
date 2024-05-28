import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String paper = br.readLine();

            if(paper.length() % 2 == 1) {
                boolean sw = true;
                while (paper.length() > 1) {
                    if(paper.length() % 2 == 0) {
                        sw = false;
                        break;
                    }

                    int center = paper.length() / 2;

                    int idx1 = center - 1;
                    int idx2 = center + 1;

                    StringBuilder newPaper = new StringBuilder();
                    for (int i = 0; i < center; i++) {
                        if (paper.charAt(idx1) == paper.charAt(idx2)) {
                            sw = false;
                            break;
                        }

                        newPaper.insert(0, paper.charAt(idx1));

                        idx1--;
                        idx2++;
                    }

                    if(!sw) break;
                    paper = newPaper.toString();
                }

                if(sw) System.out.println("YES");
                else System.out.println("NO");
            }
            else System.out.println("NO");
        }
    }
}
