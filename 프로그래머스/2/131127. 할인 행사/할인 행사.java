import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        int day = 10;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) map.put(want[i], number[i]);


        for (int i = 0; i < discount.length -day +1; i++) {
            Map<String, Integer> cMap = new HashMap<>();

            for (int j = 0; j < day; j++) {
                cMap.put(discount[i + j], cMap.getOrDefault(discount[i+j],0) + 1);
            }
            boolean check = true;

            for (String s : map.keySet()) {
                if (map.get(s) != cMap.get(s)) {
                    check = false;
                    break;
                }
            }
            answer += check ? 1 : 0;
        }
        return answer;
    }
}