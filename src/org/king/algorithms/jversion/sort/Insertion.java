package org.king.algorithms.jversion.sort;

import org.king.algorithms.jversion.util.Sorts;

public class Insertion {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && Sorts.less(a[j], a[j - 1]); j--) {
                Sorts.exch(a, j - 1, j);
            }
        }
    }

    /*
     * 要大幅提高插入排序的速度并不难， 只需要在内循环中将较大的元素都向右移动而不总是交换 两个元素（这样访问数组的次数就能减半）
     */
    @SuppressWarnings("rawtypes")
    public static void sort2(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable t = a[i];
            int j = i-1;
            for (; j >= 0 && Sorts.less(t, a[j]); j--) {
                a[j + 1] = a[j];
            }
            a[++j]=t;
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 15, 9, 8, 1, 4, 11, 7, 12, 13, 16, 5, 3, 16, 2, 10, 14 };
        sort2(a);
        assert Sorts.isSorted(a);
        Sorts.show(a);
    }

}
