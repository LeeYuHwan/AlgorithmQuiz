import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize > cities.length || cacheSize == 0) {
            answer = cities.length * 5;
        }
        else {
            LinkedList<String> cache = new LinkedList<>();

            for(int i = 0 ; i < cities.length ; i++){
                if(cache.remove(cities[i].toUpperCase())){
                    cache.addFirst(cities[i].toUpperCase());
                    answer += 1;

                } else {                   
                    if(cache.size() == cacheSize){
                        cache.pollLast();
                    }

                    cache.addFirst(cities[i].toUpperCase());
                    answer += 5;
                }
            }
        }

        return answer;
    }
}