package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTwoArray {
    public static void main(String[] args) {
        int[] a = {2, 5, 8, 9, 10}; //sorted array A
        int[] b = {2, 4, 7, 18}; //sorted array B
        List<Integer> c = new ArrayList<>(); //array result

        int i = 0, j = 0;

        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    c.add(a[i]);
                    i++;
                } else  {
                    c.add(b[j]);
                    j++;
                }
            } else if (i < a.length) {
                c.add(a[i]);
                i++;
            } else {
                c.add(b[j]);
                j++;
            }
        }

        System.out.println(c.toString());
    }
}
