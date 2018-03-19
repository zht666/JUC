package com.zht.test;
/**
 * 
 * 构造代码块：直接在类中定义且没有static修饰没有名字的{}代码块称为构造代码块
 * 构造代码块在每次创建对象时都会被调用，并且构造代码块的执行次序优先于类构造函数
 *
 */
public class CodeBlock02 {

	{
		System.out.println("代码块1:111");
	}
	
	public CodeBlock02() {
		System.out.println("构造方法");
	}
	
	{
		System.out.println("代码块2:222");
	}
	public static void main(String[] args) {
		new CodeBlock02();
		System.out.println("*******************");
		new CodeBlock02();

	}

}
