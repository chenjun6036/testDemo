package concurrency;

public class PrintABC implements Runnable {
    private String name;
    private Object pre;
    private Object self;

    public PrintABC(String name, Object pre, Object self) {
        this.pre = pre;
        this.name = name;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (pre) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    self.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        PrintABC pa = new PrintABC("A", c, a);
        PrintABC pb = new PrintABC("B", a, b);
        PrintABC pc = new PrintABC("C", b, c);
        new Thread(pa).start();
        Thread.sleep(10);
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }

}