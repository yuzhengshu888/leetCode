package my.single;

/**
 * @author yuzhengshu
 * @description: 双重锁检查的懒汉模式
 * @date 2021/7/24 20:46
 */
public class SingletonLazy2Lock {
    private SingletonLazy2Lock singletonLazy2Lock;

    public SingletonLazy2Lock getInstance() {
        if (singletonLazy2Lock == null) {
            synchronized (this) {
                if (singletonLazy2Lock == null) {
                    singletonLazy2Lock = new SingletonLazy2Lock();
                }
            }
        }
        return singletonLazy2Lock;
    }
}
