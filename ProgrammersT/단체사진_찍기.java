import java.util.HashMap;

class Permutation { 
    private int answer = 0;
    private int n; 
    private int r; 
    private char[] now; // 현재 순열 
    private HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    public int getResult() { 
        return answer; 
    } 

    public Permutation(int n, int r) { 
        this.n = n;
        this.r = r;
        this.now = new char[r];
    } 

    public void swap(char[] arr, int i, int j) { 
        char temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    } 

    public void permutation(char[] arr, int depth, String[] data) { // 현재 순열의 길이가 r일 때 결과 저장 


        if (depth == r) { 
            int idx = 0;
            boolean sw = true;
            while(idx < data.length) {              
                int s1 = map.get(data[idx].charAt(0));
                int s2 = map.get(data[idx].charAt(2));

                int dist = 0;
                if(s1 > s2) dist = s1 - s2 - 1;
                else dist = s2 - s1 - 1; 
                if(data[idx].charAt(3) == '=') {
                    if(!(dist == data[idx].charAt(4) - 48)) {
                        sw = false;
                    }
                }
                else if(data[idx].charAt(3) == '>') {
                    if(!(dist > data[idx].charAt(4) - 48)) {
                        sw = false;
                    }                           
                }
                else if(data[idx].charAt(3) == '<') {
                    if(!(dist < data[idx].charAt(4) - 48)) {
                        sw = false;
                    }
                }

                idx++;
            }

            if(sw == true) answer++;

        } 

        for (int i = depth; i < n; i++) { 
            swap(arr, i, depth); 
            now[depth] = arr[depth];
            map.put(now[depth], depth);
            permutation(arr, depth + 1, data); 
            swap(arr, i, depth); 
        }       
    }   
}

class Solution {
    public int solution(int n, String[] data) {
        char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        Permutation perm = new Permutation(friend.length, friend.length);
        perm.permutation(friend, 0, data); 
        int answer = perm.getResult();               
        return answer;
    }
}