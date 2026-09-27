package pattern;

public class SlidingWindow {
    /**
     * TC = O(N)
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 2, 7, 8, 11, 13, 15};
        int k = 3, sum = 0;
        for (int i = 0; i < k; i++) { //Tính tổng k số đầu tiên (window 1)
            sum += arr[i];
        }
        System.out.println(sum);
        for (int i = 1; i < arr.length - k; i++) { //slide từ i = 1, lấy tổng k số đầu trừ đi phần tử trước và cộng phần tử sau
            sum = sum - arr[i - 1] + arr[i + k - 1];
            System.out.println(sum);
        }
    }
}
