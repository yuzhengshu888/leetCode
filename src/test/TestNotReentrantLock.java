package test;

import thread.NotReentrantLock;

public class TestNotReentrantLock {
    static int count = 1;

    public static void main(String[] args) {
        NotReentrantLock notReentrantLock = new NotReentrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //第一次上锁
                notReentrantLock.lock();
                count++;
                System.out.println(count);
                notReentrantLock.unlock();
                count++;
                System.out.println(count);
                notReentrantLock.lock();
                count++;
                System.out.println(count);
                notReentrantLock.unlock();
                count++;
                System.out.println(count);
                //打印2 3 4 5


                notReentrantLock.lock();
                count++;
                System.out.println(count);
                //卡死
                notReentrantLock.lock();
                count++;
                System.out.println(count);
                count++;
                System.out.println(count);
                notReentrantLock.unlock();
                count++;
                System.out.println(count);
                notReentrantLock.unlock();

            }
        };
        new Thread(runnable).start();
    }
}
