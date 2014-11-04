package thinkinginjava.Chapter15.Practice20;

import java.lang.reflect.Array;

public class B<T> implements A {

    @Override
    public void a() {
        // TODO Auto-generated method stub

    }

    @Override
    public void a1() {
        // TODO Auto-generated method stub

    }

    public void b1() {
    }

    /**
     * @param args
     */

    private Class<T> kind;

    public B(Class<T> kind) {
        this.kind = kind;
    }

    T test() throws InstantiationException, IllegalAccessException {
        return kind.newInstance();
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) throws Throwable, Exception {
        // TODO Auto-generated method stub
        B<String> b = new B<>(String.class);
        //T t  = new T();
        String a = b.test();
        System.out.println(a);
    }

}
