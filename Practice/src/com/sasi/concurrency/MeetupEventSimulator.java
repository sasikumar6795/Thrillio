package com.sasi.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MeetupEventSimulator {
	public static class MeetupEvent {
		private String name;
		private AtomicInteger count = new AtomicInteger(1); // 1 for organizer

		public MeetupEvent(String name) {
			this.name = name;
		}

		public void attending(int guestCount) {
			if (guestCount == 1) {
				count.incrementAndGet();
			} else {
				count.addAndGet(guestCount);
			}
		}

		public void notAttending(int guestCount) {
			if (guestCount == 1) {
				count.decrementAndGet();
			} else {
				boolean updated = false;
				while (!updated) {
					// System.out.println("before" + updated);
					int currentCount = count.get();
					int newCount = currentCount - guestCount;
					System.out.println("currentCount" + currentCount);
					System.out.println("newCount" + newCount);
					updated = count.compareAndSet(currentCount, newCount);
					// System.out.println("after" + updated);
				}
			}
		}

		public int getCount() {
			return count.get();
		}
	}

	public static void main(String[] args) {
		MeetupEvent meetupEvent = new MeetupEvent("Learn Java");

		Thread user1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				meetupEvent.attending(4);
				System.out.println(Thread.currentThread().getName() + ":" + " " + meetupEvent.getCount());

			}
		});

		Thread user2 = new Thread(new Runnable() {

			@Override
			public void run() {
				meetupEvent.attending(5);
				System.out.println(Thread.currentThread().getName() + ":" + " " + meetupEvent.getCount());
				meetupEvent.notAttending(2);
				System.out.println(Thread.currentThread().getName() + ":" + " " + meetupEvent.getCount());

			}
		});

		Thread user3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				meetupEvent.attending(1);
				System.out.println(Thread.currentThread().getName() + ":" + " " + meetupEvent.getCount());
			}
		});

		user1.setName("sasi");
		user2.setName("pavithra");
		user3.setName("sadhvee");

		user1.start();
		sleep(1);
		user2.start();
		sleep(2);
		user3.start();
		sleep(3);

	}

	private static void sleep(int i) {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
