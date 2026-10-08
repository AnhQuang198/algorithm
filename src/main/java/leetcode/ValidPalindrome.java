package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 125
 */
public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
////        System.out.println(isPalindrome1(s));
//        System.out.println(isPalindrome2(s));
//
//        String s2 = "race a car";
////        System.out.println(isPalindrome1(s2));
//        System.out.println(isPalindrome2(s2));
//
//        String s3 = " ";
////        System.out.println(isPalindrome1(s3));
//        System.out.println(isPalindrome2(s3));

        String s4 = "A man, a plan, a anal: Panama";
//        System.out.println(isPalindrome1(s4));
        System.out.println(isPalindrome2(s4));
    }

    /**
     * TC = O(N)
     * SC = O(N)
     * Chia array String thành 2 phần. Sử dụng Queue push từ phần tử đầu tiên đến length / 2 vào queue
     * sau đó duyệt từ cuối mảng đến length / 2 + step để dequeue và check ký tự => nếu khác nhau thì return false
     * nếu duyệt hết 2 vòng for mà Queue empty => chuỗi cân bằng
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        String[] sData = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split("");
        if (sData.length == 0) return true;

        Queue<String> queueData = new LinkedList<>();

        //check mảng cân bằng không. Nếu có thì duyệt cả mảng, nếu không thì bỏ phần tử ở giữa
        int concatStep = 1;
        if (sData.length % 2 == 0) {
            concatStep = 0;
        }

        // Step 1: duyệt từ 0 -> length / 2 và push vào Stack
        for (int i = 0; i < sData.length / 2; i++) {
            queueData.offer(sData[i]);
        }

        // Step 2: duyệt từ sData.length
        for (int i = sData.length - 1; i >= sData.length / 2 + concatStep; i--) {
            String character = queueData.poll();
            if (!character.equalsIgnoreCase(sData[i])) {
                return false;
            }
        }

        return queueData.isEmpty();
    }

    /**
     * TC = O(N)
     * SC = O(1)
     * Sử dụng Two Pointer, 1 con trỏ left chạy từ đầu mảng, 1 con trỏ right chạy từ cuối mảng
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
