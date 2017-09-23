package org.king.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileTest {
    public static void main(String[] args) {
        File dir = new File("src");
        FileFilter directoryFilter = (File f) -> f.isDirectory();
        File[] dirs = dir.listFiles(directoryFilter);
        for (File f : dirs) {
            System.out.println(f.getAbsolutePath());
        }

        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        
        Predicate<String> matched = s -> s.equalsIgnoreCase("hello");
        //list.filter(matched);
    }
}
