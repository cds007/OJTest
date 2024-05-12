package 锁示例代码.SynchronizedLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private static Lock lock = new ReentrantLock();

    public void fun1(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        } finally {
            lock.unlock();
        }
    }

}
