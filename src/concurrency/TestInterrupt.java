package concurrency;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Atask task = new Atask();
        Thread t1 = new Thread(task);
        t1.start();
        Thread.sleep(3000);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t1.interrupt();
    }
}

class Atask implements Runnable {
    private double d = 0.0;

    @Override
    public void run() {
        try {
            // TODO Auto-generated method stub
            while (true) {
                System.out.println("Atask");
                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
                Thread.sleep(50);
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

