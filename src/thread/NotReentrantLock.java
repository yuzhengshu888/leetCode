package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NotReentrantLock implements Lock {
    private Thread thread;

    @Override
    public void lock() {
        Thread currentThread = Thread.currentThread();
        while (currentThread == thread) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        thread = currentThread;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        while (currentThread != thread) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        thread = null;
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
