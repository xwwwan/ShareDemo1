class MyData {
    //    volatile int number = 0;
    int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

/**
 * volatile保证可见性验证
 */
public class TestVolatileVisibility {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t " + myData.number);
        }, "AAAA").start();

        //如果volatile不保证可见性 将陷入死循环
        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t 主线程结束");
    }
}
