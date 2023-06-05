import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
    int num;
    int total;
    int time;
    public Pair(int num, int total, int time) {
        this.num = num;
        this.total = total;
        this.time = time;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.total==o.total) {
            return this.time-o.time;
        }else if(this.total<o.total)return -1;
        else return 1;

    }
}

public class Q1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int CNT = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        ArrayList<Pair> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < CNT; i++){
            int p = Integer.parseInt(st.nextToken());

            if(arr[p] > 0) {
                arr[p]++;
                for(int j = 0; j < al.size(); j++){
                    if(al.get(j).num == p){
                        al.get(j).total++;
                        break;
                    }
                }
            }
            else {
                if(al.size() >= N){
                    Collections.sort(al);
                    int num = al.get(0).num;
                    arr[num] = 0;
                    al.remove(0);
                }

                al.add(new Pair(p, 1, i));
                arr[p] = 1;

            }

        }

        for (int i = 0; i < 101; i++) {
            if(arr[i] != 0) {
                System.out.print(i + " ");
            }
        }

    }
}
