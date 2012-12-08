package org.king.algorithm.sort;

/**
 * 
 * @author king
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		// int[] a = new int[] { 6, 5, 3, 1, 4, 2, 7, 21, 14, 8 };
		int[] a = new int[] { 15, 9, 8, 1, 4, 11, 7, 12, 13, 16, 5, 3, 16, 2,
				10, 14 };
		print(a, -1);
		System.out.println("");
		quickSort(a, 0, a.length - 1);
		System.out.println("");
		print(a, -1);
	}

	private static void print(int[] a, int index) {
		for (int i = 0; i < a.length; ++i) {
			if (i > 0) {
				System.out.print(",");
			}

			if (i == index) {
				System.out.print("【" + a[i] + "】");
			} else {
				System.out.print(a[i]);
			}
		}
		System.out.println("");
	}

	private static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int pi = partition(a, left, right);
			quickSort(a, left, pi - 1);
			quickSort(a, pi + 1, right);
		}

	}

	private static int partition(int[] a, int left, int right) {
		int p = (left + right) / 2;
		int store = left;
		swap(a, p, right);
		for (int i = left; i < right; ++i) {
			if (a[i] <= a[right]) {
				swap(a, i, store);
				++store;
			}
		}
		swap(a, store, right);
		print(a, store);
		return store;
	}

	private static void swap(int[] a, int left, int right) {
		if (left != right) {
			int t = a[right];
			a[right] = a[left];
			a[left] = t;
		}
	}
}
