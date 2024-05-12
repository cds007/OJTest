package 锁示例代码.SynchronizedLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantMain {
    public static void main(String[] args) {
        /**
         * e1，e2肯定会异步，因为此时lock是私有变量。而当设置为类变量static之后，就是同步了，因为此时锁是共享的了。
         */
        ReentrantExample e1 = new ReentrantExample();
        ReentrantExample e2 = new ReentrantExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e1.fun1());
        executorService.execute(()->e2.fun1());
    }
}
