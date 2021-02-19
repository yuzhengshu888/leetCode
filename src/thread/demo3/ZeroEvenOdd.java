package thread.demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/5 10:43
 */
public class ZeroEvenOdd {
    private int n;
    Integer count = 1;
    int evenNum = 1;
    int oddNum = 2;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        if (n < 0) {
            return;
        }
        int max = 2 * n;
        while (count < max) {
            synchronized (this) {
                if (count % 2 == 1) {
                    printNumber.accept(0);
                    count++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        if (n <= 0) {
            return;
        }
        int max = 2 * n;

        while (count <= max) {
            synchronized (this) {
                if (count % 4 == 2) {
                    printNumber.accept(evenNum);
                    evenNum += 2;
                    count++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        if (n <= 0) {
            return;
        }
        int max = 2 * n;

        while (count <= max) {
            synchronized (this) {
                if (count % 4 == 0) {
                    printNumber.accept(oddNum);
                    oddNum += 2;
                    count++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                long time2 = System.currentTimeMillis();
                System.out.println();
                System.out.println(time2 - time1);
                System.out.println("所有的子线程都结束了！");
                break;
            }
        }
    }
}
