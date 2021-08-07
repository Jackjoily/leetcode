package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E_1114 {

}

class Foo {

	public Foo() {
	}

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		printSecond.run();
	}

	public void third(Runnable printThird) throws InterruptedException {
		printThird.run();
	}
}