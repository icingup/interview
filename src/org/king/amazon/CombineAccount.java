package org.king.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//@formatter:off
/**
 * 
 * 
 * Combine accounts with common email addresses
 * 
 * Example data:
 * 
 * A [jessie@hotmail.com, charles@msn.com, nancy@gmail.com] 
 * B [nancy@gmail.com,jack@gmail.com, lucy@msn.com] 
 * C [lurther@hotmail.com, mandy@gmail.com] 
 * D [charles@msn.com, louis@msn.com] 
 * E [katie@msn.com, danny@gmail.com,lucy@msn.com]
 * F [paul@hotmail.com, lurther@hotmail.com]
 * 
 * result
 * [jessie@hotmail.com, charles@msn.com, nancy@gmail.com, jack@gmail.com, lucy@msn.com, louis@msn.com,katie@msn.com, danny@gmail.com]
 * [lurther@hotmail.com, mandy@gmail.com, paul@hotmail.com]
 * 
 * @author king
 *
 * 
 */
//@formatter:on
public class CombineAccount {
    public static void main(String[] args) {
        String[] input = new String[] {
                "jessie@hotmail.com,charles@msn.com,nancy@gmail.com",
                "lurther@hotmail.com,mandy@gmail.com",
                "charles@msn.com,louis@msn.com",
                "katie@msn.com,danny@gmail.com,lucy@msn.com",
                "paul@hotmail.com,lurther@hotmail.com",
                "nancy@gmail.com,jack@gmail.com,lucy@msn.com",
        };

        List<Collection<String>> inputList = new ArrayList<>();
        for (String inputStr : input) {
            String[] emails = inputStr.split(",");
            List<String> emailList = new ArrayList<>();
            for (String email : emails) {
                emailList.add(email.trim());
            }
            inputList.add(emailList);
        }

        System.out.println("input:");
        printList(inputList);
        System.out.println("excepted:");
        System.out
                .println("[jessie@hotmail.com, charles@msn.com, nancy@gmail.com, jack@gmail.com, lucy@msn.com, louis@msn.com,katie@msn.com, danny@gmail.com]");
        System.out.println("[lurther@hotmail.com, mandy@gmail.com, paul@hotmail.com]");

        List<Collection<String>> outputList = combine(inputList);
        System.out.println("act:");
        printList(outputList);
    }

    public static List<Collection<String>> combine(List<Collection<String>> olist) {
        List<Collection<String>> outputList = new ArrayList<Collection<String>>();

        while (!olist.isEmpty()) {
            Set<String> set = new LinkedHashSet<>(olist.remove(0));
            label: while (true) {
                for (Iterator<Collection<String>> it = olist.iterator(); it.hasNext();) {
                    Collection<String> parList = it.next();
                    for (String email : parList) {
                        if (set.contains(email)) {
                            set.addAll(parList);
                            it.remove();
                            continue label;
                        }
                    }
                }
                break;
            }
            outputList.add(set);

        }

        return outputList;
    }

    private static void printList(List<Collection<String>> outputList) {
        for (Collection<String> list : outputList) {
            System.out.println(list);
        }

    }
}
