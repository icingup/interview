package org.king.algorithm;

/**
 * 两个数相加
 * 
 * @author king
 * 
 */
public class Add {
	public static void main(String[] args) {
		int[] n1 = new int[] { 9, 5, 9 };
		int[] n2 = new int[] { 9, 5, 9 };
		int[] sum = new int[] { 0, 0, 0, 0 };
		add(n1, n2, sum);
		print(sum);	
	}

	public static void add(int[] n1, int[] n2, int[] sum) {
		int position = n1.length - 1;
		int carry = 0;
		while (position >= 0) {
			int total = n1[position] + n2[position] + carry;
			if (total >= 10) {
				sum[position + 1] = total - 10;
				carry = 1;
			} else {
				sum[position + 1] = total;
				carry = 0;
			}

			position--;
		}
		sum[0] = carry;
	}
	
	private static void print(int[] result) {
		boolean valid = false;
		for (int i = 0; i < result.length; i++) {
			if(valid){
				System.out.print(result[i]);
			}else if(result[i] != 0){
				valid=true;
				System.out.print(result[i]);
			}
		}
		
		if(!valid){
			System.out.print(0);
		}
	}
}
