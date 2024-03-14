import java.util.*;

class Solution {
    public int solution(int[] order) {
        int[] priority = new int[order.length];
        for (int i = 0 ; i < order.length; i++) {
            priority[order[i] - 1] = i;
        }
        // p[0] = 2;
        // p[1] = 3;
        // p[2] = 1;
        // p[3] = 0;
        // p[4] = 4; 
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < priority.length; i++) {
            if (priority[i] == answer) {
                answer++;
            } else {
                stack.push(priority[i]);
            }
            while(!stack.isEmpty() && stack.peek() == answer){
                stack.pop();
                answer++;
            }

        }
        return answer;
    }
}