import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        if (cacheSize > 0) {
            for (int i = 0; i < cities.length; i++) {
                String lowerCase = cities[i].toLowerCase();
                if (cache.contains(lowerCase)) {
                    cache.remove(lowerCase);
                    cache.add(lowerCase);
                    answer+=1;
                } else {
                    if (cache.size() == cacheSize) {
                        cache.remove(0);
                    }
                    cache.add(lowerCase);
                    answer+=5;
                }
            }
        } else {
            answer = cities.length * 5;
        }
        return answer;
    }
}