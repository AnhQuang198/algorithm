package leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * TC = O(N)
     * SC = O(1)
     * Sử dụng 2 con trỏ left và right để duyệt qua array.
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
