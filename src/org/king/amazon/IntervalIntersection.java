package org.king.amazon;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//@formatter:off
/**
* Question 2:
* 
* Given a set of intervals - [a0,b0] [a1,b1] [a2,b2] [a3,b3] ......
* 
* Let’s assume the first interval [a0,b0] to be set A, and the union of all the rest intervals to 
* be set B. Please write a program to calculate the intersection of A and B.
* 
* Ground Rules: 
* 
* 1. All intervals are finite closed intervals, 
* their boundaries are integers. e.g. [2,17] [-9,0]
* 
* 2. Input: the given intervals are in the format like [3,5] [5,17] [1,6] [ -2,0]. intervals are 
* separated by a space, the boundaries are separated by a comma. please note there are 
* no spaces inside the brackets []. The intervals are unordered and may overlap with one 
* another.
* 
* 3. Output: the intersection should be printed in the same format as the input. when the 
* intersection includes more than one intervals, the intervals must NOT overlap and they 
* should be sorted in ascending order. when the intersection is an empty set, please 
* print empty. If the input is invalid, please print invalid.
* 
* Sample:
* 
* 1. input:[6,27] [5,7] [21,34] [13,25] output:[6,7] [13,27]
* 2. input:[24,35] [3,20] [-2,9] [37,40] output:empty
* 
* @author king
*
*/
//@formatter:on
class Interval implements Comparable<Interval> {
    int start;
    int end;

    private Interval(){
        
    }
    
    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }

    @Override
    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }
    
    public static Interval createInterval(String invStr) {
        try {
            int start = Integer.valueOf(invStr.substring(invStr.indexOf("[") + 1, invStr.indexOf(",")));
            int end = Integer.valueOf(invStr.substring(invStr.indexOf(",") + 1, invStr.indexOf("]")));
            Interval inv = new Interval();
            inv.start = start;
            inv.end = end;
            return inv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

public class IntervalIntersection {

    public static String calculate(String intervals) {
        if (intervals == null || intervals.isEmpty()) {
            System.out.println("invalid");
            return null;
        }

        List<Interval> intersectionList = new LinkedList<>();
        Interval a = null;
        //@formatter:off
        /*
        String[] invs = intervals.split(" ");
        for (String invStr : invs) {
            Interval inv = createInterval(invStr);
            if (inv == null) {
                continue;
            }
            if (a == null) {
                a = inv;
                continue;
            }
            int start = a.start > inv.start ? a.start : inv.start;
            int end = a.end < inv.end ? a.end : inv.end;
            if (start < end) {
                inv.start = start;
                inv.end = end;
                intersectionList.add(inv);
            }
        }
        */
      //@formatter:on
        StringTokenizer stz = new StringTokenizer(intervals, " ");
        while (stz.hasMoreElements()) {
            Interval inv = Interval.createInterval(stz.nextToken());
            if (inv == null) {
                continue;
            } else if (a == null) {
                a = inv;
                continue;
            }
            int start = a.start > inv.start ? a.start : inv.start;
            int end = a.end < inv.end ? a.end : inv.end;
            if (start < end) {
                inv.start = start;
                inv.end = end;
                intersectionList.add(inv);
            }
        }
        // empty
        if (intersectionList.isEmpty()) {
            return "empty";
        }

        merge(intersectionList);

        return toString(intersectionList);
    }

    private static void merge(List<Interval> intersectionList) {
        Collections.sort(intersectionList);

        Iterator<Interval> it = intersectionList.iterator();
        it.next();
        int preIndex = 0;
        while (it.hasNext()) {
            Interval currentInv = it.next();
            Interval preInv = intersectionList.get(preIndex);
            if (currentInv.start < preInv.end) {
                if (currentInv.end > preInv.end) {
                    preInv.end = currentInv.end;
                }
                it.remove();
                continue;
            }
            preIndex++;
        }

    }

    private static String toString(List<Interval> invList) {
        StringBuilder str = new StringBuilder();
        for (Interval inv : invList) {
            str.append(inv.toString()).append(" ");
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String str = calculate("[6,27] [5,7] [21,34] [13,25]");
        System.out.println(str);

        str = calculate("[24,35] [3,20] [-2,9] [37,40]");
        System.out.println(str);
    }
    
}
