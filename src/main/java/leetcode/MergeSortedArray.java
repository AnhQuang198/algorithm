package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        int m = 3, n = 3;
//        merge(num1, m, num2, n);
        merge2(num1, m, num2, n);
    }

    /**
     * TC=O(m+n)
     * SC=O(m+n)
     * Brute Force. Tạo 1 mảng mới chứa tổng tất cả phần tử của 2 mảng
     * Sử dụng 2 con trỏ left và right để duyệt từ đầu mỗi mảng nums1 và nums2
     * so sánh 2 phần tử nếu left < right thì copy left vào result array
     * nếu left > right thì copy right vào result array
     * nếu left = right thì copy cả left và right vào array
     * sau đó nếu left = m => mảng nums1 đã hết phần tử => copy toàn bộ phần tử còn lại trên nums2 vào result
     * nếu right = m => mảng nums2 đã hết phần tử => copy toàn bộ phần tử còn lại trên nums1 vào result
     * Copy lại results vào nums1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int left = 0, right = 0, idx = 0;

        while (left < m || right < n) {
            if (left < m && right < n) {
                if (nums1[left] < nums2[right]) {
                    result[idx] = nums1[left];
                    left++;
                } else if (nums1[left] > nums2[right]){
                    result[idx] = nums2[right];
                    right++;
                } else {
                    result[idx] = nums1[left];
                    result[++idx] = nums2[right];
                    left++;
                    right++;
                }
            } else if (left < m) {
                result[idx] = nums1[left];
                left++;
            } else {
                result[idx] = nums2[right];
                right++;
            }
            idx++;
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }

    /**
     * Sử dụng 2 Pointer duyệt từ cuối về và so sánh, nếu số nào lớn hơn thì đây vào cuối nums1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int idx = m + n - 1; //lấy index của phần tử cuối array nums1 đẩy phần tử lớn nhất vào

        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[idx] = nums1[left];
                left--;
            } else {
                nums1[idx] = nums2[right];
                right--;
            }
            idx--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
