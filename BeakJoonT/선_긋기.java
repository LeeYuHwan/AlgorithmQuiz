import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Line implements Comparable<Line>{
    int x;
    int y;

    public Line(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Line o) {
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}

public class DrawLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Line> al = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            al.add(new Line(x, y));
        }

        Collections.sort(al);

        int oldX = al.get(0).x;
        int oldY = al.get(0).y;

        int answer = oldY - oldX;

        for (int i = 1; i < al.size(); i++){
            Line line = al.get(i);

            if(oldX <= line.x && line.y <= oldY) continue;

            if(line.x < oldY) answer += line.y - oldY;
            else answer += line.y - line.x;

            oldX = line.x;
            oldY = line.y;
        }

        System.out.println(answer);
    }
}
