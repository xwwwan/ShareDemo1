/**
 * 证明volatile不保证原子性
 */
public class TestVolatileAtomic {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestVolatileAtomic testVolatileAtomic = new TestVolatileAtomic();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    testVolatileAtomic.increase();
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(testVolatileAtomic.inc);
    }
}






















//方式一：
//public synchronized void increase() {
//    inc++;
//}


//方式二：
//private Lock lock = new ReentrantLock();
//
//    public void increase() {
//        lock.lock();
//        inc++;
//        lock.unlock();
//    }