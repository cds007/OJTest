package 锁示例代码.SynchronizedLock;

/**
 * 类锁之SynchronizedObjectLock5.class
 */
public class SynchronizedObjectLock5 implements Runnable{
    static SynchronizedObjectLock5 instance1 = new SynchronizedObjectLock5();
    static SynchronizedObjectLock5 instance2 = new SynchronizedObjectLock5();
    Object lock1 = new Object();
    @Override
    public void run(){
        /**
         * 锁是类，所以不同的实例仍然需要抢占
         */
        synchronized (SynchronizedObjectLock5.class){
            System.out.println("我是线程："+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程："+Thread.currentThread().getName()+" 结束！");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}
