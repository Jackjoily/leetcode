package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class M_1115 {

}

class FooBar1 {
	private int n;

	public FooBar1(int n) {
	        this.n = n;
	    }

	CyclicBarrier cb = new CyclicBarrier(2);
	volatile boolean fin = true;

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			while (!fin)
				;
			printFoo.run();
			fin = false;
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
			}
			printBar.run();
			fin = true;
		}
	}

}

class FooBar {
	private int n;
	Object o = new Object();
	Object o1 = new Object();
	Semaphore foo = new Semaphore(1);
	Semaphore bar = new Semaphore(0);

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			foo.acquire();
			printFoo.run();
			bar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			bar.acquire();
			printBar.run();
			foo.release();
		}
	}
}

/**
 * 使用ReentrantLock和Condition条件进行编写
 * 
 * @author jackjoily
 * 
 *         class FooBar { private int n; Lock lock; Condition a; Condition b;
 *         int num = 1;
 * 
 *         public FooBar(int n) { this.n = n; lock = new ReentrantLock(); a =
 *         lock.newCondition(); b = lock.newCondition(); }
 * 
 *         public void foo(Runnable printFoo) throws InterruptedException {
 * 
 *         for (int i = 0; i < n; i++) { try { lock.lock(); while (num != 1) {
 *         a.await(); } printFoo.run(); num = 2; b.signal(); } catch (Exception
 *         e) { // TODO: handle exception } finally { lock.unlock(); } } }
 * 
 *         public void bar(Runnable printBar) throws InterruptedException {
 * 
 *         for (int i = 0; i < n; i++) { try { lock.lock(); while (num != 2) {
 *         b.await(); } printBar.run(); num = 1; a.signal(); } catch (Exception
 *         e) { // TODO: handle exception } finally { lock.unlock(); }
 * 
 *         } } }
 *
 */