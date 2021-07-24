package my.single;

/**
 * @author yuzhengshu
 * @description: synchronize 方法的单例模式 懒汉模式
 * @date 2021/7/24 20:40
 */
public class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private synchronized SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
