/**
 * DCL机制不一定线程安全，原因是由指令重排序的存在
 */
public class SingletonDemo {
    private SingletonDemo() {

    }

    private static SingletonDemo instance;

    public static SingletonDemo getInstance() {
        if (instance != null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
