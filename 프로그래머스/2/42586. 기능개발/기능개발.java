import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int loading = 100 - progresses[i];
            int sp = 0;
            int cnt= 0;
            while (sp < loading) {
                sp += speeds[i];
                cnt++;
            }
            if (deque.isEmpty()) {
                deque.push(cnt);
            } else {
                Integer pop = deque.peekFirst();
                if (cnt <= pop) {
                    deque.push(pop);
                } else {
                    deque.push(cnt);
                }
            }
        }
        Integer firstPop = deque.pollLast();
        int cnt = 1;
        while (!deque.isEmpty()) {
            Integer secondPop = deque.pollLast();
            if (Objects.equals(firstPop, secondPop)) {
                cnt++;
            } else {
                firstPop = secondPop;
                answer.add(cnt);
                cnt = 1;
            }
            // 5 10 10 10 20 20
        }
        answer.add(cnt);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}