package org.king.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonSearch {
    //@formatter:off
    //private static final Matcher matcher = Pattern.compile(".[^{]*124[^}]*.").matcher("");
    //忽略优先
    //private static final Matcher matcher = Pattern.compile(".[^{]*124.*?\\}").matcher("");
    //忽略优先第一个{}
    private static final Matcher matcher = Pattern.compile("^.*?\\{.*?\\}").matcher("");
    //@formatter:on

    public static void main(String[] args) {
        String test = "[{\"key1\":\"value1\",\"lcaid\":123,\"key2\":\"value2\"},{\"key1\":\"value1\",\"lcaid\":124,\"key2\":\"value2\"},{\"key1\":\"value1\",\"lcaid\":125,\"key2\":\"value2\"},{\"key1\":\"value1\",\"lcaid\":126,\"key2\":\"value2\"}]";
        matcher.reset(test);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
