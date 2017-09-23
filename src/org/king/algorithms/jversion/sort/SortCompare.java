package org.king.algorithms.jversion.sort;

import java.util.Random;

import org.king.algorithms.jversion.util.StdOut;

public class SortCompare {
    public static long time(String alg, Double[] a) {
        long start = System.currentTimeMillis();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        } else if (alg.equals("Selection")) {
            Selection.sort(a);
        } else if (alg.equals("Shell")) {
            Shell.sort(a);
        } else if (alg.equals("Merge")) {
            Merge.sort(a);
        } else if (alg.equals("Quick")) {
            Quick.sort(a);
        } else if (alg.equals("Heap")) {
            Heap.sort(a);
        }
        return System.currentTimeMillis() - start;
    }

    public static double timeRandomInput(String alg, int N, int T) { // 使用算法1将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // 进行一次测试（生成一个数组并排序)
            Random r = new Random(System.currentTimeMillis());
            for (int i = 0; i < N; i++)
                a[i] = r.nextDouble();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        // String alg1 = "Insertion";
        // String alg2 = "Selection";
        // int N = 1000;
        // int T = 500;

        double t1 = timeRandomInput(alg1, N, T); // 算法1的总时间
        double t2 = timeRandomInput(alg2, N, T); // 算法2的总时间
        StdOut.printf(" For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
