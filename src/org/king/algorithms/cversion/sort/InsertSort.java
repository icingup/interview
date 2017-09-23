package org.king.algorithms.cversion.sort;

import org.king.algorithms.cversion.calculate.ArrayHelp;

/**
 * 如果有小规模数据需要排序，并且初始数据几乎是有序的，可以考虑使用插入排序
 * 插入排序的是二次方的运行时间(O(n*n))；插入排序对基于值的效率很低，因为很多内存需要移位，以给新的值腾出位置。
 * @author king
 *
 */

public class InsertSort {
	public static void main(String[] args) {
        //int[] a = new int[] { 5,3,16, 2,10,14 };
        //int[] a = new int[] {1,2,3,4,5,6,7,16,9,10,11,12,13,14,15,8 };
    	int[] a = new int[] { 15, 9, 8, 1, 4, 11, 7, 12, 13, 16, 5, 3, 16, 2,10, 14 };
		
    	ArrayHelp.print(a,
              -1,-1);
        System.out.println("");
        
        sort(a);
        
        System.out.println("");
        ArrayHelp.print(a,
              -1,-1);
    }

	private static void sort(int[] a) {
		for( int i = 1;i < a.length;i++){
		    insertSort(a,i,a[i]);
			ArrayHelp.print(a, 0, i);
		}
	}

	private static void insertSort(int[] a, int pos, int value) {
		int i = pos -1;
		while(i >=0 && a[i] > value){
			a[i+1] = a[i];
			i--;
		}
		a[i+1] = value;
	}
}
