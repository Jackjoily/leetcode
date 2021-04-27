package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.management.jmx.Trace;

import javafx.scene.shape.Line;
import leetcode_list.ListNode;
import leetcode_tree.TreeNode;

/**
 * 
 * @author jackjoily
 *
 */
public class M_1117 {


}
class H2O1 {
	ReentrantLock lock;
    public H2O1() {
    
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	releaseHydrogen.run();
    
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    	releaseOxygen.run();
    }
}




class H2O {
	CyclicBarrier cyclicBarrier;
	Semaphore hsemaphore;
	Semaphore osemaphore;
    public H2O() {
    	hsemaphore=new Semaphore(2);
    	osemaphore=new Semaphore(1);
    	 cyclicBarrier=new CyclicBarrier(3,()->{
    		 hsemaphore.release(2);
    		 osemaphore.release(1);
    	 });
    
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	hsemaphore.acquire();
    	releaseHydrogen.run();
    	try {
    	    cyclicBarrier.await();
    	}catch (Exception e) {
		}finally {
			
		}
    
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    	osemaphore.acquire();
    	releaseOxygen.run();
	  	try {
	  		cyclicBarrier.await();
    	}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
    }
}
