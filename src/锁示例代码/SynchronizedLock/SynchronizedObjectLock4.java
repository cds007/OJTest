package 锁示例代码.SynchronizedLock;

/**
 * 类锁之静态方法
 */

public class SynchronizedObjectLock4 implements Runnable {
    static SynchronizedObjectLock4 instance1 = new SynchronizedObjectLock4();
    static SynchronizedObjectLock4 instance2 = new SynchronizedObjectLock4();

    @Override
    public void run() {
        method();
    }

    // synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把
    public static synchronized void method() {
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        /**
         * 两个不同的对象，但是调用的方法是一样的，所以仍然需要抢占同一把锁
         */
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
}

