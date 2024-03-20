import java.util.*;


class Solution {
    class Test{
        String name;
        int startTime;
        int playTime;

        public Test(String name, String startTime, String playTime) {
            this.name = name;
            String[] split = startTime.split(":");
            this.startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        public Test(String[] plan) {
            this(plan[0], plan[1], plan[2]);
        }


        public int getEndTime() {
            return startTime + playTime;
        }
    }
    
    
    public String[] solution(String[][] plans) {
        Test[] tests = new Test[plans.length];
        for (int i = 0; i < plans.length; i++) tests[i] = new Test(plans[i]);
        Arrays.sort(tests, Comparator.comparingInt(test -> test.startTime));


        Stack<Test> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < tests.length - 1; i++) {
            Test curTest = tests[i];
            Test nextTest = tests[i + 1];

            if (curTest.getEndTime() > nextTest.startTime) {
                curTest.playTime = curTest.getEndTime() - nextTest.startTime;
                stack.push(curTest);
                continue;
            }
            answer.add(curTest.name);

            int t = nextTest.startTime - curTest.getEndTime();
            
            while (t > 0 && !stack.isEmpty()) {
                Test peek = stack.peek();
                int tidi = peek.playTime - t;
                peek.playTime = tidi;
                t = tidi * - 1;
                if (tidi >0) break;
                answer.add(stack.pop().name);
            }
        }
        answer.add(tests[tests.length-1].name);
        while (!stack.isEmpty()) answer.add(stack.pop().name);
        return answer.toArray(new String[0]);
    }
}