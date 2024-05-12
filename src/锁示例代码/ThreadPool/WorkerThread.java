package 锁示例代码.ThreadPool;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        /**
         * 可以加个类锁，让其变成线程安全的。
         */
        synchronized (WorkerThread.class){
            System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
            processCommand();
            System.out.println(Thread.currentThread().getName()+" End.");
        }
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}