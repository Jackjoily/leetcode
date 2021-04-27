package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E_1114 {

}

class Foo {
	Lock lock;
	Condition a;
	Condition b;
	Condition c;
	int num = 1;

	public Foo() {
		lock = new ReentrantLock();
		a = lock.newCondition();
		b = lock.newCondition();
		c = lock.newCondition();
	}

	public void first(Runnable printFirst) throws InterruptedException {
		try {
			lock.lock();
			while (num != 1) {
				a.await();
			}
			printFirst.run();
			num = 2;
			b.signal();
		} finally {
			lock.unlock();
		}

	}

	public void second(Runnable printSecond) throws InterruptedException {
		try {
			lock.lock();
			while (num != 2) {
				b.await();
			}
			printSecond.run();
			num = 3;
			c.signal();
		} finally {
			lock.unlock();
		}

	}

	public void third(Runnable printThird) throws InterruptedException {
		try {
			lock.lock();
			while (num != 2) {
				c.await();
			}
			printThird.run();
			num = 1;
			a.signal();
		} finally {
			lock.unlock();
		}
	}
}