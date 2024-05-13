package sort;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("===Learning Bubble sort===");
        System.out.println("O(n2)");

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { //duyệt từ đầu đến cuối, sau mỗi vòng giảm length đi 1 vì phần tử cuối cùng đc so sánh và là lớn nhất
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) { //so sánh 2 số liền kề nhau, nếu số nào lớn hơn thì đẩy về bên phải
                    swap(intArray, i, i + 1);
                }
            }
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
