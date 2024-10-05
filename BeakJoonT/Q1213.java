import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = new int[26];

        int sw = 0;
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'A']++;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) sw++;
        }

        if(sw > 1) System.out.println("I'm Sorry Hansoo");
        else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i] / 2; j++) sb.append((char) (i + 'A'));
            }
            String answer = sb.toString();
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++){
                if(arr[i] % 2 == 1) sb.append((char) (i + 'A'));
            }

            answer += sb + end;
            System.out.println(answer);
        }

    }
}
