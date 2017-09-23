package org.king.algorithms.cversion.calculate;

public class ArrayHelp {

	public static void print(int[] a,int deFrom,int deEnd){
		if (deFrom >= 0 && deFrom < a.length) {
            System.out.print("【");
        }

        for (int i = 0; i < a.length; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(String.format("%2d",a[i]));
            if (deEnd == i) {
                System.out.print("】");
            }
        }
        System.out.println("");
	}
	
}
