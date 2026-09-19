package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;

        System.out.println("===Brute force===");
        System.out.println(Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("===Optimized===");
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /** Brute force O(n^2)
     * Sử dụng 2 vòng lặp để cộng từng số, sau đó so sánh với target
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    /** Optimize O(n)
     * Sử dụng HashMap để giảm độ phức tạp thuật toán về O(n). Check hiệu của target với số i,
     * sau đó get key trong Map, nếu có thì return vị trí value trong map và i
     * nếu chưa có trong Map thì put giá trị hiện tại và i vào Map
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapData = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(mapData.containsKey(temp)) {
                return new int[]{mapData.get(temp), i};
            }
            mapData.put(nums[i], i);
        }
        return new int[]{};
    }
}
