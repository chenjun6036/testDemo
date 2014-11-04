package designPattern.proxy;


public class BookStoreImpl implements BookStore {

    @Override
    public void sell() {
        System.out.println("sell a book!");
    }

    @Override
    public void buy() {
        // TODO Auto-generated method stub
        System.out.println("buy a book!");
    }
}
