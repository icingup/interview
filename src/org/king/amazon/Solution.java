package org.king.amazon;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = 0, n = 0;
        for (int t = 0; t < n; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
        }

        int zone[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                zone[i][j] = sc.nextInt();
            }
        }

        int distance[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dist = calculateDist(zone, m, n, i, j);
                distance[i][j] = dist;

            }
        }

        int min = 0, x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] < min) {
                    min = distance[i][j];
                    x = i;
                    y = j;
                }

            }
        }
        System.out.println(x + " " + y);

    }

    static int calculateDist(int[][] zone, int m, int n, int x, int y) {
        int distance = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int distx = x - i;
                int disty = y - j;
                if (distx < 0)
                    distx = -distx;
                if (disty < 0)
                    disty = -disty;

                distance += (distx + disty) * zone[i][j];

            }
        }
        return distance;
    }
}