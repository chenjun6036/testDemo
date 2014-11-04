package thinkinginjava.Chapter15.Practise25;

public class C implements A, B {
    @Override
    public void printB() {
        // TODO Auto-generated method stub
        System.out.println("B");
    }

    @Override
    public void printA() {
        // TODO Auto-generated method stub
        System.out.println("A");
    }

    public <T extends A> void a(T t) {
        t.printA();
    }

    public <T extends B> void b(T t) {
        t.printB();
    }

    public static void main(String[] args) {
        C c = new C();
        c.a(c);
        c.b(c);
    }
}
