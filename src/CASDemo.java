import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5, 6);
        atomicInteger.compareAndSet(5, 2020);
        System.out.println(atomicInteger.get());
    }
}
