package com.zht.test;

//方法的作用域
/**
 * 
 * 普通代码块：在方法或语句中出现的{}就称为普通代码块
 * 普通代码块和一般的语句执行顺序由他们在代码中出现的次序决定--“先出现先执行”
 *
 */
public class CodeBlock01 {

	public static void main(String[] args) {
		
		{
			int x = 1;
			System.out.println("普通代码快x = "+x);
		}
		
		int x = 3;
		System.out.println("局部变量x = "+x);
		
		{
			int y = 2;
			System.out.println("普通代码块y = "+y);
		}
		
//		int x = 3;
//		System.out.println("局部变量x = "+x);
	}
}
