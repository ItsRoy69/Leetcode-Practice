class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int openIndex = stack.pop();
                pair[openIndex] = i;
                pair[i] = openIndex;
            }
        }

        StringBuilder result = new StringBuilder();
        int curr = 0;
        int direction = 1;

        while (curr < n) {
            char ch = s.charAt(curr);
            if (ch == '(' || ch == ')') {
                curr = pair[curr];
                direction = -direction;
            } else {
                result.append(ch);
            }
            curr += direction;
        }

        return result.toString();
    }
}