package org.king.algorithms.cversion.sort;

/**
 * @formatter:off
 * 
 * 堆排序
 * 
 * 一个堆就是一颗二叉树，它具有以下两个性质：
 * 
 * 一、外形性质：
 * 1、如果深度k-1存在2的k-1次方的节点，那么深度k上存在叶子节点
 * 2、在部分填充的深度级上，节点上从左到右填充的
 * 
 * 二、堆性质：树中每一个节点，如果有子节点的话，其值大于或者等于任意一个子节点的值
 * 
 * 堆排序不是一个稳定的排序，所以它不能使用基于值的数据。
 * 堆排序避免了很多导致快速排序性能退化的令人讨厌的情况。尽管如此，平均情况下，快速排序比堆排序性能要好。
 * 
 * @author wanglq
 * 
 * @formatter:on
 */

public class Heap {

    public static void main(String[] args) {
        //int[] a = new int[] { 5,3,16, 2,10,14 };
        //int[] a = new int[] {1,2,3,4,5,6,7,16,9,10,11,12,13,14,15,8 };
    	int[] a = new int[] { 15, 9, 8, 1, 4, 11, 7, 12, 13, 16, 5, 3, 16, 2,
				10, 14 };

        print(a,
              -1);
        System.out.println("");
        
        sort(a);
        
        System.out.println("");
        print(a,
              -1);
    }

    private static void print(int[] a, int idx) {
        if (idx >= 0 && idx < a.length) {
            System.out.print("【");
        }

        for (int i = 0; i < a.length; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(String.format("%2d",a[i]));
            if (idx == i) {
                System.out.print("】");
            }
        }
        System.out.println("");
    }

    private static void sort(int[] a) {
        buildHeap(a);
        print(a,
              a.length - 1);
        for (int i = a.length - 1; i >= 1; --i) {
            swap(a,
                 0,
                 i);
            heapify(a,
                    0,
                    i);
            print(a,
                  i-1);
        }

    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private static void buildHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; --i) {
            heapify(a,
                    i,
                    a.length);
        }
    }

    private static void heapify(int[] a, int idx, int max) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int largest = 0;

        if (left < max && a[left] > a[idx]) {
            largest = left;
        }else{
            largest = idx;
        }

        if (right < max && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != idx) {
            swap(a,
                    idx,
                    largest);

            heapify(a,
                    largest,
                    max);
        }

    }

}
