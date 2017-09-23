package org.king.algorithms.jversion.sort;

import org.king.algorithms.jversion.util.Sorts;

/*选择排序，也即冒泡排序*/
public class Selection {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (Sorts.less(a[j],a[min])) {
                    min = j;
                }
            }
            Sorts.exch(a, i, min);
        }

    }

    public static void main(String[] args) {
        String[] a = { "1", "5", "3", "4", "9", "8" };
        sort(a);
        assert Sorts.isSorted(a);
        Sorts.show(a);
    }
}
