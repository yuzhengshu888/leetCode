package thread.demo1;

/**
 * @description:
 * @Author: yuzhengshu
 * @Date: 2020/12/14 21:39
 */
public class FooTest01 {
    Foo foo = new Foo();
    Thread thread1 = new Thread(() -> {
        foo.first(() -> {
            System.out.println("one");
        });
    });
    Thread thread2 = new Thread(() -> {
        try {
            foo.second(() -> {
                System.out.println("two");
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    Thread thread3 = new Thread(() -> {
        try {
            foo.third(() -> {
                System.out.println("third");
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public FooTest01() {
        thread2.start();
        thread1.start();
        thread3.start();
    }

    public static void main(String[] args) throws InterruptedException {
        new FooTest01();
    }
}
