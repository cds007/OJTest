package 锁示例代码.SynchronizedLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMain {

    public static void main(String[] args) {
        //1.相同的对象进行同步
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.fun1());
//        executorService.execute(() -> e1.fun1());

        //2.不同的对象不同步
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.fun3());
        executorService.execute(() -> e2.fun3());
    }
}
