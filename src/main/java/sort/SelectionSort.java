package sort;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("===Learning Selection sort===");
        System.out.println("O(n2)");

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { //duyệt từ đầu mảng đến cuối mảng ở lần đầu, sau 1 vòng giảm length đi 1 đơn vị. Vì phần tử ở cuối là lớn nhất
            int maxNumberIdx = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) { //duyệt mảng và tìm ra index của số lớn nhất, sau đó đổi chỗ với vị trí phần tử cuối cùng của mảng
                if (intArray[maxNumberIdx] < intArray[i]) {
                    maxNumberIdx = i;
                }
            }
            swap(intArray, maxNumberIdx, lastUnsortedIndex);
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
