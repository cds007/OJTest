package antdiy;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class Q2AlternatingPrint {
    public static void main(String[] args) {
        /**
         * 使用线程实现多线程交替打印，要实现交替打印的效果可以使用信号量，要实现打印函数接口回调的形式可以使用Consumer函数
         */
        threadPrint(2, 1, 10);
    }

    public static void threadPrint(int threadCount, int start, int end) {
        threadPrintByFunction(threadCount, start, end, (value) -> System.out.println(value));
    }

    public static void threadPrintByFunction(int threadCount, int start, int end, Consumer<String> printAction) {
        //非法参数判断
        if (threadCount==0 || start>end){
            throw new IllegalArgumentException("非法的参数");
        }
        //一组线程和一组信号量
        Semaphore[] semaphores = new Semaphore[threadCount];
        Thread[] threads = new Thread[threadCount];
        //信号量值的初始化
        for (int i = 0; i < threadCount; i++) {
            semaphores[i] = new Semaphore(0);
        }
        //线程组初始化
        for (int i = 0; i < threadCount; i++) {
            //每个i是一个线程
            //先设置好final变量
            final int index = i;
            threads[i] = new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                //重写run方法
                for (int value = start+index; value <= end ; value+=threadCount) {
                    try{
                        semaphores[index].acquire();
                        printAction.accept(threadName+": "+value);
                        semaphores[(index+1)%threadCount].release();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        return;
                    }
                }
            }, "Thread-" + (i + 1));
        }
        //线程启动
        for(Thread thread:threads){
            thread.start();
        }
        //让第一个线程启动
        semaphores[0].release();
    }
}
