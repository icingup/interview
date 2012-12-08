package org.king.company.igt;

public class CodeResult {
	public static void main(String[] args) {
		if( a() ){
			System.out.println("cdef");
		}
	}
	
	public static boolean a(){
		try{
			return true;
		}catch(Exception e){
			
		}finally{
			System.out.println("abcd");
		}
		return false;
	}
}
