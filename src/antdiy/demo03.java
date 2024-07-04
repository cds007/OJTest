package antdiy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 两个线程交替输出
public class demo03 {
    private static CountDownLatch latch=new CountDownLatch(1);
    public static void main(String[] args) {
        char []a=new char[]{'1','2','3'};
        char []b=new char[]{'a','b','c'};

        Lock lock=new ReentrantLock();
        Condition conditionT1=lock.newCondition();
        Condition conditionT2=lock.newCondition();

        new Thread(()->{
            lock.lock();
            try {
                for (char c : a) {
                    System.out.println(c);
                    latch.countDown();
                    conditionT2.signal();
                    conditionT1.await();
                }
                conditionT2.signal();
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            try {
                latch.await();
                lock.lock();
                for (char c : b) {
                    System.out.println(c);
                    conditionT1.signal();
                    conditionT2.await();
                }
                conditionT1.signal();
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }
}

