package org.king.company.igt;

import java.util.HashMap;
import java.util.Map;

public class PutInMap {

	
    public static void main(String[] args) {
    	Map<Object,Object> map = new HashMap();
    	//作为值放入map
    	System.out.println("=========作为值放入map==========");
    	MyClass m = new MyClass();
    	m.name = "myname";
    	map.put("key1", m);
    	map.put("key2", m);
    	System.out.println("=========作为值放入map完毕==========");
    	
    	printMap(map);
    	
    	map.clear();
    	
    	System.out.println("=========作为键放入map==========");
    	MyClass k1 = new MyClass();
    	k1.name = "name1";
    	
    	MyClass k2 = new MyClass();
    	k2.name = "name2";
    	map.put(k1, "value1");
    	map.put(k2, "value2");
    	System.out.println("=========作为键放入map完毕==========");
    	
    	printMap(map);
	}

	private static void printMap(Map<Object, Object> map) {
		System.out.println("\n\n=========开始打印map值==========");
		for(Map.Entry<Object, Object> entry : map.entrySet()){
			System.out.println(entry.getKey() + " === " + entry.getValue());
		}
		System.out.println("=========开始打印map值完毕==========\n\n");
	}
	
	
}
class MyClass{
	String name ;
	@Override
	public int hashCode() {
		System.out.println("获取hashcode");
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("调用equals");
		return super.equals(obj);
	}
}