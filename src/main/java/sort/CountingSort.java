package sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 4, 3, 9, 8, 9, 10};

        int maxNumber = findMaxNumber(arr);
        int[] countArr = new int[maxNumber + 1];
        countNumberInArr(arr, countArr);

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        } //cumulative frequency

        int[] resultArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) { //duyệt ngược từ cuối arr lên để đảm bảo stable cho Counting Sort
            int position = countArr[arr[i]] - 1;
            resultArr[position] = arr[i];
            countArr[arr[i]]--;
        }

        System.out.println(Arrays.toString(resultArr));
    }

    public static void countNumberInArr(int[] sourceArr, int[] countArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            countArr[sourceArr[i]]++;
        }
    }

    /**
     * Find max number in arr
     * @param arr
     * @return
     */
    public static int findMaxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
