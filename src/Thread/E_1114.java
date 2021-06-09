package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E_1114 {

}

class Foo2 {
	//使用闭锁
	CountDownLatch first = new CountDownLatch(1);
	CountDownLatch second = new CountDownLatch(1);
	public void first(Runnable printFirst) throws InterruptedException {
		first.countDown();
		printFirst.run();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		first.await();
		printSecond.run();
		second.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		second.await();
		printThird.run();
	}
}

class Foo1 {
	volatile int a = 1;

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		a = 2;
	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (a != 2) {
		}
		printSecond.run();
		a = 3;
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (a != 3) {
		}
		printThird.run();
		a = 1;
	}
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
			while (num != 3) {
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