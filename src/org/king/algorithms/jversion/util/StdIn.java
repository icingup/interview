package org.king.algorithms.jversion.util;

import java.io.DataInputStream;
import java.io.IOException;

public class StdIn {
    /* 如果输入流中没有剩余的值则返回 true， 否则返回 false */
    public static boolean isEmpty() throws IOException {
        return System.in.available() == 0;
    }

    /* 读取一个 int 类型的值 */
    public static int readInt() throws IOException {
        return new DataInputStream(System.in).readInt();
    }

    /* 读取一个 double 类型的值 */
    public static double readDouble() throws IOException {
        return new DataInputStream(System.in).readDouble();
    }

    /* 读取一个 float 类型的值 */
    public static float readFloat() throws IOException {
        return new DataInputStream(System.in).readFloat();
    }

    /* 读取一个 long 类型的值 */
    public static long readLong() throws IOException {
        return new DataInputStream(System.in).readLong();
    }

    /* 读取一个 boolean 类型的值 */
    public static boolean readBoolean() throws IOException {
        return new DataInputStream(System.in).readBoolean();
    }

    /* 读取一个 char 类型的值 */
    public static char readChar() throws IOException {
        return new DataInputStream(System.in).readChar();
    }

    /* 读取一个 byte 类型的值 */
    public static byte readByte() throws IOException {
        return new DataInputStream(System.in).readByte();
    }

    /* 读取一个 String 类型的值 */
    @SuppressWarnings("deprecation")
    public static String readString() throws IOException {
        return new DataInputStream(System.in).readLine();
    }

    /* 输入流中是否还有下一行 */
    public static boolean hasNextLine() {
        //TODO
        return false;
    }

    /* 读取该行的其余内容 */
    @SuppressWarnings("deprecation")
    public static String readLine() throws IOException {
        return new DataInputStream(System.in).readLine();
    }

    /* 读取输入流中的其余内容 */
    @SuppressWarnings("deprecation")
    public static String readAll() throws IOException {
        return new DataInputStream(System.in).readLine();
    }
}
