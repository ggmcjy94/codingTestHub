import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}