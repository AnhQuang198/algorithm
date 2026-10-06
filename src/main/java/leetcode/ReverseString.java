package leetcode;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseStringBruteForce(s);
        reverseString(s);

        char[] s2 = {'H','a','n','n','a','h'};
        reverseStringBruteForce(s2);
        reverseString(s2);
    }

    /**
     * TC=O(N)
     * SC=O(N)
     * Brute force: duyệt từ cuối mảng về và push từng chữ vào 1 array mới
     * Phương án này không giải được trên LeetCode vì SC=O(N)
     * @param s
     */
    public static void reverseStringBruteForce(char[] s) {
        char[] s2 = new char[s.length];
        int index = 0;
        for (int i = s.length; i > 0; i--) {
            s2[index] = s[i - 1];
            index++;
        }
        System.out.println(s2);
    }

    /**
     * TC=O(N)
     * SC=O(1)
     * Sử dụng Two Pointer. 1 con trỏ duyệt từ đầu array, 1 con trỏ duyệt từ cuối array và swap dần cho nhau
     * @param s
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }
}
