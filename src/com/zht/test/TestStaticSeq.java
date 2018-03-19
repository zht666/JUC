package com.zht.test;

/**
 * 从父到子 模板先有 ， 静态加载 只有一次
 * 从父到子 静态先行
 * 先有模板 后有实例
 *
 *先要有Father的模板 再有Son的模板，先有Father的实例 才会有Son的实例
 *普通代码块加载 优先于构造方法执行
 *
 * static 静态的 ： 属于全部类的
 * static可以用在 实例变量、实例方法、静态内部类上面
 * static不可以用在 局部变量、构造方法、外部类上面
 *
 */
public class TestStaticSeq {

	public static void main(String[] args) {
		new Son();//362154    ---》Son.class --->Father.class --->Father Instance --->Sun Instance
		System.out.println("================");
		new Son();//2154
		System.out.println("=================");
		new Father();//21
	}

}

// Father f1 = new Father();    *.class 类模板      2.按照类模板出来具体的类实例
class Father{
	public Father() {
		System.out.println("111");
	}
	{
		System.out.println("222");
	}
	static {
		System.out.println("333");
	}
}

class Son extends Father{
	public Son(){
		super();
		System.out.println("444");
	}
	{
		System.out.println("555");
	}
	static {
		System.out.println("666");
	}
}






















