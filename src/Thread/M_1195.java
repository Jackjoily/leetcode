package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class M_1195 {
	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz(16);
		Thread a = new Thread(() -> {
			try {
				f.number(System.out::println);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "1");
		Thread b = new Thread(() -> {
			// try {
			//// f.fizz();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}, "2");
		Thread c = new Thread(() -> {
			// try {
			//// f.buzz();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}, "3");
		Thread d = new Thread(() -> {
			// try {
			//// f.fizzbuzz();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}, "4");
		a.start();
		b.start();
		c.start();
		d.start();
	}
}

/**
 * 使用栅栏来进行控制
 * 
 * 类似四个线程在竞争同一个东西，一轮结束之后则这个栅栏会重置
 * 
 * @author jackjoily
 *
 */
class FizzBuzz1 {
	private static CyclicBarrier barrier = new CyclicBarrier(4);
	private int n;

	public FizzBuzz1(int n) {
		this.n = n;
	}
	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				printFizz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 == 0) {
				printBuzz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				printFizzBuzz.run();
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				printNumber.accept(i);
			}
			try {
				barrier.await();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 使用多个信号量解决的办法
 * 
 * @author jackjoily
 *
 */
class FizzBuzz {
	private int n;
	Semaphore a = new Semaphore(0);
	Semaphore b = new Semaphore(0);
	Semaphore c = new Semaphore(0);
	Semaphore d = new Semaphore(0);
	volatile int val = 1;

	public FizzBuzz(int n) {
		this.n = n;
	}

	public void number(IntConsumer printNumber) throws InterruptedException {
		while (val <= n) {
			if (val % 3 == 0 && val % 5 == 0) {
				d.release();
				a.acquire();
			} else if (val % 3 == 0 && val % 5 != 0) {
				b.release();
				a.acquire();
			} else if (val % 3 != 0 && val % 5 == 0) {
				c.release();
				a.acquire();
			} else {
				printNumber.accept(val);
				val++;
			}
		}
		c.release();
		b.release();
		d.release();
	}

	// Runnable printFizz
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (val <= n) {
			if (val % 3 == 0 && val % 5 == 0) {
				d.release();
				b.acquire();
			} else if (val % 3 == 0 && val % 5 != 0) {
				printFizz.run();
				// System.out.println("Fizz");
				val++;
			} else if (val % 3 != 0 && val % 5 == 0) {
				c.release();
				b.acquire();
			} else {
				a.release();
				b.acquire();
			}

		}
		a.release();
		c.release();
		d.release();
	}

	// Runnable printBuzz
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (val <= n) {
			if (val % 3 == 0 && val % 5 == 0) {
				d.release();
				c.acquire();
			} else if (val % 3 == 0 && val % 5 != 0) {
				b.release();
				c.acquire();
			} else if (val % 3 != 0 && val % 5 == 0) {
				printBuzz.run();
				// System.out.println("Buzz");
				val++;
			} else {
				a.release();
				c.acquire();
			}
		}
		a.release();
		b.release();
		d.release();
	}

	// Runnable printFizzBuzz
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (val <= n) {
			if (val % 3 == 0 && val % 5 == 0) {
				printFizzBuzz.run();
				// System.out.println("FizzBuzz");
				val++;
			} else if (val % 3 == 0 && val % 5 != 0) {
				b.release();
				d.acquire();
			} else if (val % 3 != 0 && val % 5 == 0) {
				c.release();
				d.acquire();
			} else {
				a.release();
				d.acquire();
			}
		}
		a.release();
		b.release();
		c.release();
	}
}