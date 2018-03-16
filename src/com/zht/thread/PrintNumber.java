package com.zht.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * 依次打印 12A34B56C ...... 5152Z
 */
public class PrintNumber {

	public static void main(String[] args) {
		Print p1 = new Print();
		
		new Thread(() -> {
			p1.addNumber();
		}, "AA").start();
		
		new Thread(() -> {
			p1.addChar();
		}, "BB").start();
	}

}


class Print{
	private char ch = 'A' - 1;
	private int num = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void addNumber() {
		lock.lock();
		try {
			//1.判断
			while(num != 52) {
				//2.干活
				++num;
				System.out.print(num);
				++num;
				System.out.print(num);
				//3.通知
				condition.signalAll();
				condition.await();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void addChar() {
		lock.lock();
		try {
			while(ch != 'Z') {
				ch+=1;
				System.out.print(ch);
				condition.signalAll();
				if(ch == 'Z') {
					return;
				}
				condition.await();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}