import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if(pop != '(' && c == ')') {
                    return false;
                } else if(pop != '{' && c == '}') {
                    return false;
                } if(pop != '[' && c == ']') {
                    return false;
                }
            }
        }
        if(stack.size() > 0) return false;

        return true;
    }
}