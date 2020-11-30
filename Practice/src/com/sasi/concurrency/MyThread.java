package com.sasi.concurrency;

import java.util.concurrent.TimeUnit;

public class MyThread {
	public static void main(String[] args)
	{
		Task task = new Task();
		Thread thread = new Thread(task);
		//Thread thread = new Thread(new Task());
		thread.start();
		
		
		
		try {
			Thread.sleep(3000);
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("inside main .....");
	}
	
	
	
}

class Task implements Runnable
{

	@Override
	public void run() {
		System.out.println("inside run .....");
		try {
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("interrupted");
		}
		go();
	}

	private void go() {
		System.out.println("inside go .....");
		more();
		
	}
	
	private void more() {
		System.out.println("inside more .....");
		
	}
}
