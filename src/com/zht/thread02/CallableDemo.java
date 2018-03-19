package com.zht.thread02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种获得多线程的方式 Callable 程序的异步回调通知，后台计算 get方法最好放最后 只计算一次，后面反复复用
 * 
 * 1.java中获得多线程方法可以通过Callable接口实现
 * Callable域Runnable接口区别：1.方法名不同；2.有无返回值；3.有无抛异常；4.有无带泛型
 * 2.面向接口编程，多态的思想找关联，把不相干的两个方法调用两个类捆一块，需要找一个类同时实现多个接口 以传接口，面向接口编程，把多个不相关的类绑在一块
 * 3.Callable接口如何获得返回值？用get方法，如果当它没有计算完成即get写到前面，会导致线程阻塞，尽量把get放最后，不耽误主线程
 * 4.当有且仅有一个new FutureTask时，不管有几个线程来调用，它只被调用一次，即只计算一次
 * 
 * awt swing applet 图形化 不用学
 *
 */
class MyThread implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println("**********call() ****");
		// Thread.sleep(4000);
		return 1018;
	}
}

/**
 * 第三种获得多线程的方式
 * 
 * @Description: Callable接口获得多线程
 * 
 *               笔记结论见最后
 *
 * 
 */
public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> ft = new FutureTask<Integer>(new MyThread());
		new Thread(ft, "AA").start();
		new Thread(ft, "BB").start();

		System.out.println(Thread.currentThread().getName() + "***********我是上课主线程");

		Integer result01 = ft.get();
		System.out.println("******result01: " + result01);

		// 作业： 改写Callable
//		FutureTask<Integer> ft1 = new FutureTask<Integer>(() -> {
//			System.out.println("************call()*********");
//			Thread.sleep(2000);
//			return 300;
//		});
//		new Thread(ft1, "BB").start();
//		System.out.println(Thread.currentThread().getName() + "**********我是主线程");
//		Integer result03 = ft1.get();
//		System.out.println("=============result01: " + result03);

	}
}

/**
 * 
 * 
 * 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，
 * 当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。
 * 
 * 一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。
 * 
 * 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，
 * 就不能再重新开始或取消计算。get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态， 然后会返回结果或者抛出异常。
 * 
 * 只计算一次 get方法放到最后
 */
