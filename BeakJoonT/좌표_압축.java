import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q18870 {

    static ArrayList<Integer> al;
    static ArrayList<Integer> al2;
    static ArrayList<Integer> idxAl;

    static int lower_bound(int target){
        int l = 0;
        int r = al2.size() - 1;

        while (l < r){
            int m = (l + r) / 2;
            if(al2.get(m) >= target) r = m;
            else l = m + 1;
        }

        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        al = new ArrayList<>();
        al2 = new ArrayList<>();
        idxAl = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            al.add(x);
            idxAl.add(x);
        }

        Collections.sort(idxAl);

        for(int i = 0; i < idxAl.size() - 1; i++){
            if(!idxAl.get(i).equals(idxAl.get(i + 1))) al2.add(idxAl.get(i));
        }
        al2.add(idxAl.get(idxAl.size() - 1));


        for(int i = 0; i < al.size(); i++){
            int pos = lower_bound(al.get(i));
            bw.write(pos + " ");
        }
        bw.close();

    }
}
