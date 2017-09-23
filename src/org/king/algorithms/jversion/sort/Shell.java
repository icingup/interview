package org.king.algorithms.jversion.sort;

import org.king.algorithms.jversion.util.Sorts;

/**
 * 如果你需要 解决一个排序问题而又没有系统排序函数可用（例如直接接触硬件或是运行于嵌入式系统中的代 码） ， 可以先用希尔排序，
 * 然后再考虑是否值得将它替换为更加复杂的排序算法。
 * 
 * @author thomas
 *
 */
public class Shell {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) { // 将数组变为h有序
            for (int i = h; i < N; i++) { // 将a[i]插入到a[i-h], a[i-2*h],
                                          // a[i-3*h]... 之中
                for (int j = i; j >= h && Sorts.less(a[j], a[j - h]); j -= h) {
                    Sorts.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 15, 9, 8, 1, 4, 11, 7, 12, 13, 16, 5, 3, 16, 2, 10, 14 };
        sort(a);
        assert Sorts.isSorted(a);
        Sorts.show(a);
    }

}
