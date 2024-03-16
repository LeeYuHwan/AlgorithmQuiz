import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        int answer = 0;

        for (int food : topping){
            int tmp = 1;
            if (hm1.containsKey(food)) tmp = hm1.get(food) + 1;
            hm1.put(food, tmp);
        }

        for (int food : topping){
            hm2.put(food, 1);

            if(hm1.containsKey(food)) {
                int tmp = hm1.get(food) - 1;

                if(tmp == 0) hm1.remove(food);
                else hm1.put(food, tmp);
            }

            if(hm1.size() == hm2.size()) answer++;
        }

        return answer;
    }
}