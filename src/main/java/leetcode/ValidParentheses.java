package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("===Case 1===");
        String s = "()";
        System.out.println(isValid(s));

        System.out.println("===Case 2===");
        String s1 = "()[]{}";
        System.out.println(isValid(s1));

        System.out.println("===Case 3===");
        String s2 = "(]";
        System.out.println(isValid(s2));

        System.out.println("===Case 4===");
        String s3 = "([)]";
        System.out.println(isValid(s3));
    }

    public static boolean isValid(String s) {
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();

        for (String str : arr) {
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String top = stack.pop();
                if (str.equals(")") && !top.equals("(")) return false;
                if (str.equals("]") && !top.equals("[")) return false;
                if (str.equals("}") && !top.equals("{")) return false;
            }
        }
        return stack.isEmpty();
    }
}
