package leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * TC = O(N)
     * SC = O(1)
     * Sử dụng 2 con trỏ left và right để duyệt qua array. Với width là length dài nhất của array, so sánh số ở vị trí left và right,
     * nếu left nhỏ hơn thì tăng vị trí left và ngược lại nếu right nhỏ hơn thì giảm vị trí right. Vì width đã là chiều dài lớn (lúc đầu = length)
     * nên nếu cột left hoặc right nhỏ hơn, thì cần dịch chuyển cột nhỏ hơn để tìm vùng lớn hơn
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int widthOfArea = right - left;
            int heightOfArea = Math.min(height[left], height[right]);

            int area = widthOfArea * heightOfArea;
            maxArea = Math.max(maxArea, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
