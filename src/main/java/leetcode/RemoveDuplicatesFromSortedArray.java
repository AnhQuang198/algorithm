package leetcode;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
//        System.out.println(removeDuplicates(nums));

        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(nums2));
    }

    /**
     * TC=O(N)
     * SC=O(1)
     * Sử dụng Two Pointer để set giá trị lặp = -101, sau đó dùng bài toán move zero để đổi vị trí số -101 ra sau
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 1;

        while (left < right && right < nums.length) {
            if (nums[left] == nums[right]) {
                nums[right] = -1;
            } else {
                left = right;
            }
            right++;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        return k;
    }

    /**
     * TC=O(N)
     * SC=O(1)
     * Sử dụng Two Pointer với 2 con trỏ i và j
     * với i = 0, j = 1. Duyệt j chạy từ 1 đến cuối array
     * nếu số ở vị trí i != j thì tăng giá trị i lên 1 sau đó set nums[i] = nums[j]
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
