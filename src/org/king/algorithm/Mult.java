package org.king.algorithm;

/**
 * 乘法
 * @author king
 *
 */
public class Mult {
	public static void main(String[] args) {
		int[] n1 = new int[] { 9, 5, 9 };
		int[] n2 = new int[] { 9, 5, 9 };
		int[] result = new int[n1.length + n2.length];
		mult(n1, n2, result);
		print(result);		
	}

	public static void mult(int[] n1, int[] n2, int[] result) {
		int pos = result.length - 1;
		
		//清除所有值
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}
		
		for (int m = n1.length -1 ; m >= 0; m--) {
			int off = n1.length -1 - m;
			for (int n = n2.length -1 ; n >= 0; n--,off++) {
				int prod = n1[m]*n2[n];
				
				//计算部分和，并加上进位
				result[pos - off] += prod % 10;
				result[pos - off - 1] += result[pos - off]/10 + prod/10;
				result[pos - off] %= 10;
			}
		}
	}
	
	
	private static void print(int[] result) {
		boolean valid = false;
		for (int i = 0; i < result.length; i++) {
			if(valid){
				System.out.print(result[i]);
			}else if(result[i] > 0){
				valid=true;
				System.out.print(result[i]);
			}
		}
		
		if(!valid){
			System.out.print(0);
		}
	}
}
