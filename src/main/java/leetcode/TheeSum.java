package leetcode;

import java.util.*;

public class TheeSum {
    public static void main(String[] args) {
        //Case 1:
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println("========Case 1=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums));
        System.out.println("========O(N^2)==========");
        System.out.println(threeSumON2(nums));
        System.out.println("========O(N^2) Two Pointer==========");
        System.out.println(threeSumON2TwoPointer(nums));

        //Case 2:
        int[] nums2 = new int[] {0,1,1};
        System.out.println("========Case 2=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums2));
        System.out.println("========O(N^2)==========");
        System.out.println(threeSumON2(nums2));
        System.out.println("========O(N^2) Two Pointer==========");
        System.out.println(threeSumON2TwoPointer(nums2));

        //Case 3:
        int[] nums3 = new int[] {0,0,0};
        System.out.println("========Case 3=========");
        System.out.println("========O(N^3)==========");
        System.out.println(threeSumON3(nums3));
        System.out.println("========O(N^2)==========");
        System.out.println(threeSumON2(nums3));
        System.out.println("========O(N^2) Two Pointer==========");
        System.out.println(threeSumON2TwoPointer(nums3));

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

    /**
     * O(N^2 * K) : Với K là số lần lặp khi tính twoSum
     * Tái sử dụng bài toán twosum
     * @param nums
     * @return
     */
    public static Set<List<Integer>> threeSumON2(int[] nums) {
        Set<List<Integer>> lstResult = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return lstResult;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip nếu 2 số giống nhau => ko cần chạy lại
            int targetTwoSum = 0 - nums[i];

            List<List<Integer>> resultOfTwoSum = twoSum(nums, i + 1, nums.length, targetTwoSum);
            if (!resultOfTwoSum.isEmpty()) {
                for (List<Integer> list : resultOfTwoSum) {
                    List<Integer> rs = new ArrayList<>();
                    rs.add(nums[i]);
                    rs.add(nums[list.get(0)]);
                    rs.add(nums[list.get(1)]);
                    lstResult.add(rs);
                }
            }
        }
        return lstResult;
    }

    /**
     * O(N)
     * Tìm tổng 2 số trong 1 array = target truyền vào. Return về nhiều hơn 1 List vì có thể có nhiều số cộng lại = target
     * @param nums: Array
     * @param start: Vị trí bắt đầu trong array
     * @param end: Vị trí kết thúc trong array
     * @param target: Số muốn tính tổng
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                List<Integer> list = new ArrayList<>();
                list.add(map.get(num));
                list.add(i);
                result.add(list);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * TC: O(N^2)
     * Using two pointer
     * @param nums
     * @return
     */
    public static Set<List<Integer>> threeSumON2TwoPointer(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    left++;
                    right--;
                }  else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
