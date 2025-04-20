import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] answer = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        return answer;
    }
}