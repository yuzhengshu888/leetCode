package thread.demo4;

import java.util.concurrent.*;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2021/2/5 15:38
 */
public class H2O1 {
    Semaphore semO = new Semaphore(0);
    Semaphore semH2 = new Semaphore(2);

    public H2O1() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH2.acquire();
        releaseHydrogen.run();
        semO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire(2);
        releaseOxygen.run();
        semH2.release(2);
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        H2O1 h2O = new H2O1();
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
