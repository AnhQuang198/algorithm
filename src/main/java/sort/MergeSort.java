package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        mergeSort(intArray, 0,intArray.length - 1);
        System.out.println(Arrays.toString(intArray));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        combine(arr, start, mid, end);
    }

    public static void combine(int[] arr, int start, int mid, int end) {
        int totalElements = (end - start) + 1;
        int[] temp = new int[totalElements]; //tạo bảng temp với size bằng tổng của 2 mảng

        int i = start, j = mid + 1, k = 0;
        // Cả 2 mảng trái và phải vẫn còn phần tử
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) { //nếu bên trái nhỏ hơn thì lấy phần tử bên trái vào bảng temp
                temp[k] = arr[i];
                k++;
                i++;
            } else { //nếu bên phải nhỏ hơn thì lấy phần tử bên phải vào bảng temp
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        // Trường hợp mảng bên phải đã hết phần tử => copy hết tất cả các phần tử bên trái còn vào cuối mảng temp
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        // Trường hợp mảng bên trái đã hết phần tử => copy hết tất cả các phần tử bên phải còn vào cuối mảng temp
        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // Copy kết quả từ temp về lại arr (vì temp là 1 mảng mới nên cần copy lại)
        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }
}
