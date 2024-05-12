package 锁示例代码.SynchronizedLock;

public class SynchronizedExample {
    /**
     * 同步代码块
     */
    public void fun1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        }
    }

    /**
     * 同步一个方法
     */
    public synchronized void fun2(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
        }
    }

    /**
     * 同步一个类
     */
    public void fun3(){
        /**
         * 判断你是不是这个类的对象，如果是，请拿走一个锁，如果锁被拿了，请等待；
         */
        synchronized (SynchronizedExample.class){
            for (int i = 0; i < 10; i++) {
                System.out.print(i+" ");
            }
        }
    }
}
