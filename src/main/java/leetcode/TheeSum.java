package leetcode;

import java.util.*;

public class TheeSum {
    public static void main(String[] args) {
        //Case 1:
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println("========Case 1=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums));

        //Case 2:
        int[] nums2 = new int[] {0,1,1};
        System.out.println("========Case 2=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums2));

        //Case 3:
        int[] nums3 = new int[] {0,0,0};
        System.out.println("========Case 3=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums3));

    }

    /** O(N^3)
     * Brute force
     * Dùng 3 vòng for để tính tổng từng số => nếu bằng 0 thì thêm vào list
     * @param nums
     * @return
     */
    public static Set<List<Integer>> threeSumON3(int[] nums) {
        Set<List<Integer>> lstResult = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lstResult.add(list);
                    }
                }
            }
        }
        return lstResult;
    }
}
