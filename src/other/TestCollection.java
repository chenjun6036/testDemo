package other;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class TestCollection{
	public static void main(String[] args) {
		TreeMap<Integer,String> m = new TreeMap<>();
		Map<Integer,String> a = new HashMap<>();
		m.put(0, "A");
		m.put(1, "A");
		m.put(2, "A");
		m.put(3, "A");
		m.put(4, "A");
		m.put(5, "A");
		m.put(6, "A");
		m.put(7, "A");
		m.put(8, "A");
		int low = m.firstKey();
		int high = m.lastKey();
		System.out.println(m);
		Iterator<Integer> it = m.keySet().iterator();
		for(int i = 0; i <= 6; i++){
			if(i == 3)
				low = it.next();
			if(i == 6)
				high = it.next();
			else				
				System.out.println(i +  "  "+ it.next());
		}
//		System.out.println(low);
//		System.out.println(high);
//		Proxy.newProxyInstance(loader, interfaces, h)
	}
}

