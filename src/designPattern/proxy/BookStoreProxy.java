package designPattern.proxy;


public class BookStoreProxy implements BookStore {
    BookStore bs = new BookStoreImpl();

    @Override
    public void sell() {
        System.out.println("before sell.");
        bs.sell();
        System.out.println("after sell.");
    }

    public static void main(String[] args) {
        BookStoreProxy bp = new BookStoreProxy();
        bp.sell();
    }

    @Override
    public void buy() {
        // TODO Auto-generated method stub

    }
}


