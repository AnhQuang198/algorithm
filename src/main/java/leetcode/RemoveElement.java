package leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));

        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println(removeElement(nums2, val2));
    }

    /**
     * TC=O(N)
     * SC=O(1)
     * Giống bài toán Move Zeroes nhưng thay vì chuyển 0 xuống cuối array thì là move val xuống cuối array
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        return k;
    }
}
