package org.king.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
    public static void main(String[] args) {
        /**
         * 把一、二、三 替换为 壹、贰、叁
         */

        String[] a = { "一", "二", "三" };
        String[] b = { "壹", "贰", "叁" };

        String[] tests = { "一三年", "没有", "三四", "年三","一万三" };

        Pattern p = Pattern.compile("[一二三]");

        for (String test : tests) {
            StringBuffer sb = new StringBuffer();
            Matcher m = p.matcher(test);
            while (m.find()) {
                String s = m.group();
                String d = null;
                for (int i = 0; i < a.length; i++) {
                    if (s.equals(a[i])) {
                        d = b[i];
                        break;
                    }
                }
                m.appendReplacement(sb, d);
            }
            m.appendTail(sb);
            System.out.println("#source : " + test + " #dest : " + sb);
        }

    }
}
