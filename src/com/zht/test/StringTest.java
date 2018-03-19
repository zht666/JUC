package com.zht.test;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("abc"); //分别在常量池和堆中各创建了一个对象
		String s2 = "abc";  //因为常量池中已有，所以没有创建对象
		String s3 = new String("abc"); //在堆中创建了一个对象，因为在常量池中已有，所以常量池不创建对象
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s1 == s3);
		
		System.out.println("--------------------------------");
		//intern代表常量池规范化表示
		System.out.println(s1 == s1.intern()); 
		System.out.println(s2 == s2.intern());
		System.out.println(s2.intern() == s3.intern());
		
		System.out.println("--------------------------------");
		//常量找池，变加找堆
		String s4 = "java";
		String s5 = "ja";
		String s6 = "va";
		
		System.out.println(s4 == "java");
		System.out.println(s4 == (s5+s6));
		System.out.println(s4 == "ja"+s6);
		
	}

}
