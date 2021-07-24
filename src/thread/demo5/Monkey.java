package thread.demo5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuzhengshu
 * @description: 猴子吃香蕉
 * @date 2021/7/21 20:27
 */
public class Monkey implements Runnable {
    AtomicInteger bananaCount;
    final int count;

    public Monkey(AtomicInteger bananaCount, int count1) {
        this.bananaCount = bananaCount;
        this.count = count1;
    }

    @Override
    public void run() {
        while (bananaCount.get() - count >= 0) {
            eat();
        }
    }

    public void eat() {
        int i1 = bananaCount.get();
        bananaCount.compareAndSet(i1, i1 - count);
        System.out.println(Thread.currentThread().getName() + "吃了" + count + "个香蕉");
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(9);
        Thread thread = new Thread(new Monkey(atomicInteger, 2));
        thread.setName("猴1");
        Thread thread1 = new Thread(new Monkey(atomicInteger, 3));
        thread1.setName("猴2");
        thread.start();
        thread1.start();
    }
}
