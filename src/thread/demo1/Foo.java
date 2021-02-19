package thread.demo1;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/14 21:12
 */
class Foo {

    Boolean goSecond = false;
    Boolean goThird = false;

    public Foo() {
    }

    public void first(Runnable printFirst) {
        printFirst.run();
        this.goSecond = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!this.goSecond) {
            Thread.sleep(10);
        }
        printSecond.run();
        this.goThird = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!this.goThird) {
            Thread.sleep(10);
        }
        printThird.run();
    }
}
