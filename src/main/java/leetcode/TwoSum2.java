package leetcode;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        int[] nums3 = {-1, 0};
        int target3 = -1;
        System.out.println(Arrays.toString(twoSum(nums3, target3)));
    }

    /**
     * TC=O(N)
     * SC=O(1)
     * Sử dụng Two Pointer để chạy từ đầu và cuối array, nếu tổng lớn hơn target => cần giảm đi => lùi right
     * Nếu tổng nhỏ hơn target => cần tăng lên => tăng left
     * Vì array đã được sắp xếp theo thứ tự tăng dần nên tăng left sẽ tăng tổng, và giảm right sẽ giảm tổng
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left] + numbers[right];

            if (temp > target) {
                right--;
            } else if (temp < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}
