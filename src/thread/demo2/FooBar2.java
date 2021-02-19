package thread.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/4 19:37
 */
public class FooBar2 {
    private int n;
    int count = 0;
    Thread threadA = null;
    Thread threadB = null;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        threadA = Thread.currentThread();
        for (int i = 0; i < n; i++) {
            LockSupport.unpark(threadA);
            while (count != 0) {
                LockSupport.park(threadB);
            }
            printFoo.run();
            count = 1;
            LockSupport.unpark(threadB);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        threadB = Thread.currentThread();
        for (int i = 0; i < n; i++) {
            LockSupport.unpark(threadB);
            while (count != 1) {
                LockSupport.park(threadB);
            }
            printBar.run();
            count = 0;
            LockSupport.unpark(threadA);
        }
    }

    public static void main(String[] args) {
        FooBar2 fooBar = new FooBar2(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //executorService.shutdownNow();
    }
}
