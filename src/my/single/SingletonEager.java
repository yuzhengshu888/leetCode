package my.single;

/**
 * @author yuzhengshu
 * @description: 饿汉模式
 * @date 2021/7/24 20:43
 */
public class SingletonEager {
    private static final SingletonEager singletonEager = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return singletonEager;
    }
}
