package Thread;

import java.util.concurrent.Semaphore;

public class M_1226 {

}

class DiningPhilosophers {
	Semaphore fork[] = new Semaphore[5];
	Semaphore mutex;

	public DiningPhilosophers() {
		mutex = new Semaphore(1);
		for (int i = 0; i < 5; i++) {
			fork[i] = new Semaphore(1);
		}
	}

	public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
			Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
		mutex.acquire();
		// 左边的叉子
		fork[philosopher].acquire();
		// 右边的叉子
		fork[(philosopher + 1) % 5].acquire();
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();
		// 左边的叉子
		fork[(philosopher + 1) % 5].release();
		// 右边的叉子
		fork[philosopher].release();
		mutex.release();
	}
}