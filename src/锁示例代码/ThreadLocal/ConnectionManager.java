package 锁示例代码.ThreadLocal;

import java.sql.Connection;

public class ConnectionManager implements Runnable{
    /**
     * 那么这种情况下使用ThreadLocal是再适合不过的了，
     * 因为ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量，
     * 且在线程内部任何地方都可以使用，线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
     */
    static ConnectionManager instance1 = new ConnectionManager();
    static ConnectionManager instance2 = new ConnectionManager();

    private static final ThreadLocal<Connection> dbConnectionLocal = new ThreadLocal<Connection>() {
        /**
         * 重写initialValue方法
         * @return
         */
        @Override
        protected Connection initialValue() {
            System.out.println("init1");
            return null;
        }
    };

    public Connection getConnection() {
        /**
         * 这个内置方法，应该会调用initialValue方法
         */
        System.out.println("我是："+ Thread.currentThread().getName());
        return dbConnectionLocal.get();
    }

    @Override
    public void run(){
        //getConnection();
        System.out.println("我是线程："+Thread.currentThread().getName());
        System.out.println("线程："+Thread.currentThread().getName()+" 结束！");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.run();
        t2.run();
    }

}
