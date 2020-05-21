import java.util.concurrent.atomic.AtomicReference;

/**
 * ABA问题演示
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(atomicReference.compareAndSet(100, 101) + "\tThreadName:" + Thread.currentThread().getName() + "\t" + atomicReference.get());
            System.out.println(atomicReference.compareAndSet(101, 100) + "\tThreadName:" + Thread.currentThread().getName() + "\t" + atomicReference.get());
        }, "AAAA").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\tThreadName:" + Thread.currentThread().getName() + "\t" + atomicReference.get());
        }, "BBBB").start();
    }
}
