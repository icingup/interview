package org.king.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String regex = ".*((abcd)|(1234))([\\w\\d-]+)\\1.*";
        String[] strs = new String[] { "eabcd234Sa-DD3432abcdef",
                "12341234adSDe-r51234ef",
                "abcd2345-ssdfe1234ef"
        };
        Pattern pattern = Pattern.compile(regex);
        for (String str : strs) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                System.out.println(matcher.group(4));
                System.out.println("ok");
                StringBuffer sb = new StringBuffer();
                matcher.appendReplacement(sb, "$4");
                System.out.println(sb.toString());
            }

        }

        // System.out.println(sb.toString());

        Pattern pattern1 = Pattern.compile("正则表达式");
        Matcher matcher = pattern1.matcher("正则表达式 Hello World,正则表达式 Hello World");
        // 替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));

        // 带转义字符的匹配
        Pattern p = Pattern.compile("(?:[^\"]|(?<=\\\\)\")+");
        strs = new String[] { "张三说:\"这是完整的一句话\""
                , "李四说:\"张三说:\\\"这是完整的一句话\\\"\""
                , "2\\\"x3\\\""
        };
        Matcher m = p.matcher("");
        for (String str : strs) {
            System.out.println(str);
            System.out.println("=========");
            m.reset(str);
            while (m.find()) {
                System.out.println(m.group());
            }
        }

        Pattern url_P = Pattern.compile("^http://([^/]+)(:\\d+)?(/.*)?$", Pattern.CASE_INSENSITIVE);
        strs = new String[] { "http://WWW.sina.com.cn",
                "http://yx-admin.lenovomm.com/admin/" };
        m = url_P.matcher("");
        for (String str : strs) {
            System.out.println(str);
            System.out.println("=========");
            m.reset(str);
            if (m.find()) {
                String host = m.group(1);
                String port = m.group(2) == null ? "80" : m.group(2);
                String path = m.group(3);
                System.out.println("#host : " + host + " #port : " + port + " #path : " + path);
            }
        }
    }
}
