package Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class M_1116 {
	public static void main(String[] args) {
		ZeroEvenOdd z = new ZeroEvenOdd(6);
		Thread a = new Thread(() -> {
			try {
				z.zero(System.out::println);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "AA");
		Thread b = new Thread(() -> {
			try {
				z.odd(System.out::println);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "BB");
		Thread c = new Thread(() -> {
			try {
				z.even(System.out::println);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "CC");
		a.start();
		b.start();
		c.start();
	}
}

class ZeroEvenOdd {
	private int n;
	int val = 1;
	Semaphore a = new Semaphore(1);
	Semaphore b = new Semaphore(0);
	Semaphore c = new Semaphore(0);

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			a.acquire();
			printNumber.accept(0);
			if (val % 2 == 1) {
				b.release();
			} else {
				c.release();
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			b.acquire();
			printNumber.accept(i);
			val++;
			a.release();
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			c.acquire();
			printNumber.accept(i);
			val++;
			a.release();
		}
	}

}