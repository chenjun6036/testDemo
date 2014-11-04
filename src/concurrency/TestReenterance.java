package concurrency;

public class TestReenterance {

    public synchronized void out() {
        inner();
        System.out.println("outer");
        inner();
    }

    public synchronized void inner() {
        System.out.println("inner");
    }

    public static void main(String[] args) throws InterruptedException {
        TestReenterance reenterance = new TestReenterance();
        reenterance.out();

    }
}