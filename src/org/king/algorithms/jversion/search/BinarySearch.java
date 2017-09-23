package org.king.algorithms.jversion.search;

import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int key = 7;
        int[] a = { 1,2,3,4, 5, 6, 7, 8 };
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("index = " + i + " ; value = " + a[i]);
        }
        int rank = rank(key, a);
        System.out.println("key = " + key + " ; rank = " + rank);
    }

}
