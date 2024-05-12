package 锁示例代码.SynchronizedLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 锁对象，两把锁
 */
public class SynchronizedObjectLock2 implements Runnable{
    static SynchronizedObjectLock2 instance = new SynchronizedObjectLock2();

    /**
     * 能锁的还有变量
     */
    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run(){
        synchronized (lock1){
            System.out.println("我是lock1锁，我是线程 "+Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("lock1锁，"+Thread.currentThread().getName()+" 结束");
        }

        synchronized (lock2){
            System.out.println("我是lock2锁，我是线程 "+Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("lock2锁，"+Thread.currentThread().getName()+" 结束");
        }
    }

    public static void main(String[] args) {
        /**
         * 用线程池创建一下线程试试
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->instance.run());
        executorService.execute(()->instance.run());
        //线程1抢到Lock1，线程2等待，线程1释放lock1，线程2立马拿到lock1然后开始执行。
    }


}
