package com.zht.test;

class Code{
	public Code() {
		System.out.println("Code的构造方法111");
	}
	{
		System.out.println("Code的构造块222");
	}
	static {
		System.out.println("Code的静态代码块333");
	}
}

public class CodeBlock03 {
	{
		System.out.println("CodeBlock03的构造块444");
	}
	static {
		System.out.println("CodeBlock03的静态代码块555");
	}
	public CodeBlock03() {
		System.out.println("CodeBlock03的构造方法666");
	}
	public static void main(String[] args) {
		System.out.println("---------------CodeBlock03的main方法000");
		new Code();
		System.out.println("********************");
		new CodeBlock03();
	}

}
