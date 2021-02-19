package thread.demo4;

import thread.demo3.ZeroEvenOdd;

import java.util.concurrent.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/5 14:31
 */
public class H2O {
    Semaphore semO = new Semaphore(1);
    Semaphore semH2 = new Semaphore(2);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        semH2.release(2);
        semO.release(1);
    });

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH2.acquire();
        releaseHydrogen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire();
        releaseOxygen.run();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        H2O h2O = new H2O();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                h2O.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                h2O.hydrogen(() -> System.out.println("H"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                h2O.oxygen(() -> System.out.println("O"));
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
