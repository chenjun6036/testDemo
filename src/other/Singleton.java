package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void print() {
        System.out.println("aa");
    }

    public static void main(String[] args) {
        Singleton.getInstance().print();
        List<Integer> list = new ArrayList<>();
        Iterator it = list.iterator();
    }
}  