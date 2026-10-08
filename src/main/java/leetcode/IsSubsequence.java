package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 392
 */
public class IsSubsequence {
    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
//        System.out.println(isSubsequenceBruteForce(s, t));
//
//        String s2 = "axc", t2 = "ahbgdc";
//        System.out.println(isSubsequenceBruteForce(s2, t2));
//
//        String s3 = "acb", t3 = "ahbgdc";
//        System.out.println(isSubsequenceBruteForce(s3, t3));

        String s4 = "", t4 = "ahbgdc";
        System.out.println(isSubsequenceBruteForce(s4, t4));
    }


    /**
     * TC=O(N)
     * SC=O(K) với K là length của s
     * Sử dụng Queue để offer từng chữ của s vào đảm bảo thứ tự
     * Duyệt qua tất cả các chữ của t. Sử dụng peek để đọc phần tử đầu tiên trong queue (ko remove)
     * và check với từng chữ của t, nếu giống nhau thì pool để xoá chữ trong queue
     * sau cùng check queue nếu empty thì nó là chuỗi con
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequenceBruteForce(String s, String t) {
        if (s.isEmpty()) return true;

        String[] lstS = s.split("");
        String[] lstT = t.split("");

        Queue<String> qData = new LinkedList<>();
        for (String character : lstS) {
            qData.offer(character);
        }

        for (String character : lstT) {
            String a = qData.peek();
            if (character.equalsIgnoreCase(a)) {
                qData.poll();
            }
        }
        return qData.isEmpty();
    }
}
