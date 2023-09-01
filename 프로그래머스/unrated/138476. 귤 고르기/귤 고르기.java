import java.util.*;
class Solution {
     public int solution(int k, int[] tangerine) {
        int answer = 0;
        //6	[1, 3, 2, 5, 4, 5, 2, 3]	3 23514
        //4	[1, 3, 2, 5, 4, 5, 2, 3]	2
        //2	[1, 1, 1, 1, 2, 2, 2, 3]	1
        
        // 3 3 cnt 2 2 2 cnt 4
        // 3 3 cnt 2 2 2 cnt 4 break
        // 1 1 cnt 2 bre
        Map<Integer , Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i , 0) + 1);
        }
        List<Integer> ketList = new ArrayList<>(map.keySet());
        Collections.sort(ketList, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for (int i : ketList) {
            k -= map.get(i);
            answer++;
            if (k <= 0) return answer;
        }
        return answer;
    }
}