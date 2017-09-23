package org.king.local;

/**
 * 一个char是可以放下一个汉字的
 * 
 * @author king
 *
 */
public class Count {
    public static void main(String[] args) {
        String str = "中国aadf的111萨bbb菲的zz萨菲龍";
        int engishCount = 0;
        int chineseCount = 0;
        int digitCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
            {
                digitCount++;
            }
            else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            {
                engishCount++;
            }
            else
            {
                chineseCount++;
            }
        }
        System.out.println("#legth = " + str.length() + " #engishCount = " + engishCount + " #chineseCount = " + chineseCount + " #digitCount = " + digitCount);
    }
}
