import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17199 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N + 1][N + 1];

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dist[i][k] == 1 && dist[k][j] == 1) dist[i][j] = 1;
                }
            }
        }

        int answer = -1;

        for(int i = 1; i <= N; i++){
            int cnt = 0;

            for(int j = 1; j <= N; j++) if(dist[j][i] == 1) cnt++;

            if(cnt == N - 1){
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}
