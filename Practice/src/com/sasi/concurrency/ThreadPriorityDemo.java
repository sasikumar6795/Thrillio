package com.sasi.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(100);
		Thread sasi = new Thread(bankAccount);
		Thread reshma = new Thread(bankAccount);
		sasi.setName("sasi");
		reshma.setName("reshma");
		sasi.start();
		reshma.start();
		reshma.setPriority(Thread.MAX_PRIORITY);
		sasi.setPriority(Thread.MIN_PRIORITY);

	}

}

class BankAccount implements Runnable {
	private int balance;

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		makewithdrawable(75);
		if (balance < 0) {
			System.out.println("Money overdrawn!!!");
		}

	}

	private synchronized void makewithdrawable(int amount) {
		// TODO Auto-generated method stub
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " " + "about to withdraw");
			balance = balance - amount;
			System.out.println("balance after withdrawable" + " " + Thread.currentThread().getName() + " " + balance);
		} else {
			System.out.println("not enough balance" + " " + Thread.currentThread().getName());
		}

	}
}
class IDGenerator
{
	private AtomicLong id = new AtomicLong();
	
	public long getNewId()
	{
		return id.incrementAndGet();
	}
}
