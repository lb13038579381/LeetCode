package 多线程;

public class 奇偶打印 {
    static int a = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        String target = "a";
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if(target == "a")
                        System.out.println("a");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                        System.out.println("b");
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (a <= 1000) {
                synchronized (lock) {
                    if (a <= 100 && a % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + a);
                        a++;
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }, "jishu");
        t1.start();
        t3.start();

    }

}
