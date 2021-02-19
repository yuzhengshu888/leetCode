package thread.demo2;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/4 19:37
 */
public class FooBar1 {
    private int n;
    private Semaphore fooSem = new Semaphore(1);
    private Semaphore barSem = new Semaphore(0);

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            printFoo.run();
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //acquire从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断
            //fooSem的许可从1->0
            barSem.acquire();
            printBar.run();
            //释放一个许可，将其返回给信号量
            //barSem的许可从0->1
            fooSem.release();
        }
    }
}
