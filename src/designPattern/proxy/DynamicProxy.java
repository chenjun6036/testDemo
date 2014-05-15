package designPattern.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxy implements InvocationHandler{
	private Object target;
	public DynamicProxy(Object target) {
		this.target = target;
	}
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before method!");
		Object result = method.invoke(target, args);
		System.out.println("after method!");
		return result;
	}
	
	public static void main(String[] args) {
		BookStore bookStore = new BookStoreImpl();
		DynamicProxy dp = new DynamicProxy(bookStore);
//		BookStore p = (BookStore) dp.bind(new BookStoreImpl());
//		p.sell();
		BookStore bs = (BookStore) Proxy.newProxyInstance(bookStore.getClass().getClassLoader(), bookStore.getClass().getInterfaces(), dp);
		Class<?>[] interfaces = bs.getClass().getInterfaces();
		for (Class<?> class1 : interfaces) {
			System.out.println(class1.getSimpleName());
		}
		Field[] fields = bs.getClass().getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName()+"  ");
		}
		
		Method[] mds = bs.getClass().getDeclaredMethods();
		for (Method method : mds) {
			System.out.println(method.getName());
		}
		bs.sell();
	}
}
