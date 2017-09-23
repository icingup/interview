package org.king.algorithms.jversion.util;

public class StdOut {
    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void println() {
        System.out.println();

    }

    public static void printf(String f, Object... objs) {
        System.out.print(String.format(f, objs));

    }

}
