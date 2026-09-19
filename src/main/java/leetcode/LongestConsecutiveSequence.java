package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println("====O(n^3)====");
        System.out.println(longestConsecutiveO3(nums));
        System.out.println("====O(n^2)====");
        System.out.println(longestConsecutiveO2(nums));
        System.out.println("====O(n)====");
        System.out.println(longestConsecutiveO(nums));

    }

    /** O(n^3)
     * Brute force
     * @param nums
     * @return
     */
    public static int longestConsecutiveO3(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int nextNumber = nums[i] + 1;
            while (isExist(nums, nextNumber)) {
                cnt++;
                nextNumber++;
            }
            if (cnt > count) {
                count = cnt;
            }
        }
        return count;
    }

    public static boolean isExist(int[] arrs, int num) {
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == num) {
                return true;
            }
        }
        return false;
    }

    /** O(n^2)
     * Optimize lan 1 => đưa về O(n^2)
     * @param nums
     * @return
     */
    public static int longestConsecutiveO2(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, num);
        }

        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int nextNumber = nums[i] + 1;
            while (map.containsKey(nextNumber)) { //optimize bước này gọi lấy ra từ Map
                cnt++;
                nextNumber++;
            }
            if (cnt > count) {
                count = cnt;
            }
        }
        return count;
    }

    /** O(n)
     * Optimize lan 2 => đưa về O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutiveO(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, num);
        }

        int count = 1;
        //for (int i = 0; i < nums.length; i++) { //=> cần optimize ở đây. Không cần duyệt toàn bộ mảng ban đầu. Chỉ cần duyệt trong danh sách Keys của Map
        // nếu case array = {0, 2, 1, 0, 9} => trùng 2 giá trị min trong array là 0 nên sẽ duyệt O(2N) => vẫn có khả năng bị Time Limit Exceed
        // => Solution: for trong list key của map (ko có giá trị trùng nhau) => O(N)
        for (int num: map.keySet()) {
            if (map.containsKey(num - 1)) {
                continue;
            }
            int cnt = 1;
            int nextNumber = num + 1;
            while (map.containsKey(nextNumber)) { //optimize bước này gọi lấy ra từ Map
                cnt++;
                nextNumber++;
            }
            if (cnt > count) {
                count = cnt;
            }
        }
        return count;
    }
}
