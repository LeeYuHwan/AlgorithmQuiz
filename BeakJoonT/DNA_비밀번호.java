import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12891 {

    static int aNum, cNum, gNum, tNum;
    static int currentANum = 0, currentCNum = 0, currentGNum = 0, currentTNum = 0;

    static boolean check(){
        boolean sw = true;

        if(aNum > currentANum) sw = false;
        if(cNum > currentCNum) sw = false;
        if(gNum > currentGNum) sw = false;
        if(tNum > currentTNum) sw = false;

        return sw;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        aNum = Integer.parseInt(st.nextToken());
        cNum = Integer.parseInt(st.nextToken());
        gNum = Integer.parseInt(st.nextToken());
        tNum = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < p; i++){
            if(str.charAt(i) == 'A') currentANum++;
            else if(str.charAt(i) == 'C') currentCNum++;
            else if(str.charAt(i) == 'G') currentGNum++;
            else if(str.charAt(i) == 'T') currentTNum++;
        }

        if(check()) answer++;

        int limit = s - p;
        int l = 0, r = p - 1;
        for (int i = 1; i <= limit; i++){
            if(str.charAt(l) == 'A') currentANum--;
            else if(str.charAt(l) == 'C') currentCNum--;
            else if(str.charAt(l) == 'G') currentGNum--;
            else if(str.charAt(l) == 'T') currentTNum--;

            l++;
            r++;

            if(str.charAt(r) == 'A') currentANum++;
            else if(str.charAt(r) == 'C') currentCNum++;
            else if(str.charAt(r) == 'G') currentGNum++;
            else if(str.charAt(r) == 'T') currentTNum++;

            if(check()) answer++;
        }

        System.out.println(answer);
    }
}
