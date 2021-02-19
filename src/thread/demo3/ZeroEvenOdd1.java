package thread.demo3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/5 11:46
 */
public class ZeroEvenOdd1 {
    private int n;
    private AtomicInteger i = new AtomicInteger(1);
    private volatile boolean finished0 = true;

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            while (finished0) {
                if (i.get() > n) {
                    return;
                }
                Thread.yield();
            }
            printNumber.accept(0);
            finished0 = true;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            while (i.get() % 2 != 0) {
                Thread.yield();
            }
            if (i.get() > n) {
                break;
            }
            finished0 = false;
            while (!finished0) {
                Thread.yield();
            }
            printNumber.accept(i.get());
            i.incrementAndGet();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i.get() <= n) {
            while (i.get() % 2 != 1) {
                Thread.yield();
            }
            if (i.get() > n) {
                break;
            }
            finished0 = false;
            while (!finished0) {
                Thread.yield();
            }
            printNumber.accept(i.get());
            i.incrementAndGet();
        }
    }
}
