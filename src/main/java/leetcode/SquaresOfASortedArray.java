package leetcode;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
//        System.out.println(Arrays.toString(sortedSquaresBruteForce(nums)));
//        System.out.println(Arrays.toString(sortedSquares(nums)));

        int[] nums2 = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums2)));

    }

    /**
     * TC=O(nlogn) vì sử dụng sort
     * SC=O(1)
     * Brute force. Bình phương mỗi số trong nums sau đó sort => ko đạt yêu cầu đưa ra vì đề yêu cầu TC=O(N)
     * @param nums
     * @return
     */
    public static int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    /**
     * TC=O(N)
     * SC=O(N)
     * Sử dụng Two Pointer, 1 left từ đầu mảng, 1 right từ cuối mảng. Bình phương lên và so sánh
     * Nếu số nào lớn hơn thì push vào cuối mảng kết quả
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int idx = nums.length - 1;

        int[] results = new int[nums.length];

        while (left <= right) {
            int numsLeftSquare = nums[left] * nums[left];
            int numsRightSquare = nums[right] * nums[right];

            if (numsLeftSquare > numsRightSquare) {
                results[idx] = numsLeftSquare;
                left++;
            } else {
                results[idx] = numsRightSquare;
                right--;
            }
            idx--;
        }

        return results;
    }
}
