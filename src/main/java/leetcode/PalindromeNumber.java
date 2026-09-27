package leetcode;

import java.util.Stack;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));

        int x1 = 12345;
        System.out.println(isPalindrome(x1));

        int x2 = 10;
        System.out.println(isPalindrome(x2));
    }

    /** TC = O(3N)
     * SC = O(2N)
     * Sử dụng Stack để revert lại number. Chia 10 để lấy ra từng số trong x
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int originNum = x;
        Stack<Integer> stack = new Stack<>();
        while (x > 0) {
            int digit = x % 10;
            stack.push(digit);
            x = x / 10;
        }

        Stack<Integer> reverseStack = new Stack<>();
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }

        int reverseNum = 0;
        while (!reverseStack.isEmpty()) {
            reverseNum = reverseNum * 10 + reverseStack.pop();
        }
        return originNum == reverseNum;
    }

    /**
     * TC = O(N)
     * SC = O(1)
     * @param x
     * @return
     */
    public static boolean isPalindromeOptimize(int x) {
        if (x < 0) return false;

        int originNum = x;
        int reverseNum = 0;
        while (x > 0) {
            int digit = x % 10;
            reverseNum = reverseNum * 10 + digit;
            x = x / 10;
        }
        return originNum == reverseNum;
    }
}
