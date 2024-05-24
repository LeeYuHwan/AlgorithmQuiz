import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayList<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[R];

        for (int i = 0; i < R; i++){
            String str = br.readLine();
            sb.setLength(0);
            for (int j = 0; j < C; j++ ){
                if(str.charAt(j) == '#') {
                    if(sb.length() > 1) al.add(sb.toString());
                    sb.setLength(0);
                }
                else sb.append(str.charAt(j));
            }

            if(sb.length() > 1) al.add(sb.toString());
            arr[i] = str;
        }

        for (int j = 0; j < C; j++){
            sb.setLength(0);
            for (int i = 0; i < R; i++ ){
                if(arr[i].charAt(j) == '#') {
                    if(sb.length() > 1) al.add(sb.toString());
                    sb.setLength(0);
                }
                else sb.append(arr[i].charAt(j));
            }

            if(sb.length() > 1) al.add(sb.toString());
        }

        Collections.sort(al);
        System.out.println(al.get(0));
    }
}
