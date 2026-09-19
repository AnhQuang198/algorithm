package sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("===Learning Insertion sort===");
        System.out.println("O(n2)");

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        LinkedList linkedList = new LinkedList();
        Map<Integer, Integer> map = new HashMap<>();


//        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex ++) {
//            int newElement = intArray[firstUnsortedIndex];
//
//            int i;
//
//            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
//                intArray[i] = intArray[i - 1];
//            }
//
//            intArray[i] = newElement;
//        }

        int firstElement = intArray[0];
        for (int i = 1; i < intArray.length - 1; i++) {
            int key = intArray[i];
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
