package com.zht.thread02;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * 
 * CyclicBarrier    做加法
 * 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有
 * 被屏障拦截的线程才会继续干活。
 * 线程进入屏障通过CyclicBarrier的await()方法。
 * 
 * 集齐7颗龙珠就可以召唤神龙
 * 下午开会，所有人都到齐了才能开会
 */
public class CyclicBarrierDemo
{
	private static final int NUMBER = 7;
	
	public static void main(String[] args)
	{
		//CyclicBarrier(int parties, Runnable barrierAction) 
		CyclicBarrier cb = new CyclicBarrier(NUMBER, () -> { System.out.println("******召唤神龙");} ) ;
		
		for (int i = 1; i <=NUMBER; i++) 
		{
			int tempInt = i;//内部类用到的局部变量必须是final修饰的，final可省略
			new Thread(() -> {
				try {
					System.out.println(Thread.currentThread().getName()+"\t 收集到第:"+tempInt+"\t 龙珠");
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
		
	}
}
