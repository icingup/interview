package org.king.meituan;

/**
 * 给定一个自然数n，打印1-n之间所有的数，要求：按螺旋形状顺时针打印
 * 
 * http://www.cnblogs.com/graphics/archive/2010/06/05/1739658.html
 * 
 * @author thomas
 *
 */
public class SpiralPrint {
    public static void main(String[] args) {
        int n = 7;
        int[][] a = new int[n][n];
        spiralSet(a, 0, 0, n, 1);
        print(a);
    }

    private static void spiralSet(int[][] a, int x, int y, int n, int m) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            a[x][y] = m;
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            a[x][y + i] = m + i;
            a[x + i][y + n - 1] = m + n - 1 + i;
            a[x + n - 1][y + n - 1 - i] = m + 2 * n - 2 + i;
            a[x + n - 1 - i][y] = m + 3 * n - 3 + i;
        }
        spiralSet(a, x + 1, y + 1, n - 2, m + 4 * n - 4);

    }

    private static void print(int[][] a) {
        for (int[] b : a) {
            for (int v : b) {
                System.out.print(String.format("%2d  ", v));
            }
            System.out.println("");
        }
    }
}
