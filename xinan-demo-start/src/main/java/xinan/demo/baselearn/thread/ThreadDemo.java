package xinan.demo.baselearn.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @description:
 * @author: xinan
 * @create: 2021-09-09 10:55
 **/
public class ThreadDemo {
    static ExecutorService executors = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        runnableDemo();
        callRunnable();
    }
    static void runnableDemo () {
        new Thread(()->System.out.println("runnableDemo:"+fib(20))).start();
    }

    static void callRunnable (){
        try {
            Future<?> future = executors.submit(new Runnable() {
                @Override
                public void run() {
                    fib(20);
                }
            });
            System.out.println("callRunnable:"+future.get());

            Future<Integer>future1 = executors.submit(()->{
                Integer result = fib(20);
                return result;
            });
            System.out.println("callCallable:"+future1.get());

            FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
                Integer result = fib(20);
                return result;
            });
            executors.submit(futureTask);
            System.out.println("futuretask:"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
        }
    }

    static int fib(int n) {
        int fn = 1;
        while( n>1) {
            fn = fn*n;
            n--;
        }
        return fn;
    }

}
