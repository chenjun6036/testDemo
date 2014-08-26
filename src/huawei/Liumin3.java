package huawei;

import java.util.*;
/**
 * 输入一段字符串，找出出现最多和次多的单词，单词间以空格，逗号，句号分割。
 * @author chenjun
 *
 */
public class Liumin3 {
	
	public static void main(String[] args) {		
		Integer a = 127;
		Integer a1 = new Integer(126);
		System.out.println(a == ++a1);
	}
	
	@SuppressWarnings("resource")
	static void findByList(){
		Scanner cin = new Scanner(System.in);
		String line = cin.nextLine();
		if(!line.endsWith("."))
			line += '.';
		List<String> keys = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) != ' ' && line.charAt(i) != ',' && line.charAt(i) != '.') {
				sb.append(line.charAt(i));
			} else {
				if(sb.length() > 0){
					if(keys.contains(sb.toString())){
						counts.set(keys.indexOf(sb.toString()), counts.get(keys.indexOf(sb.toString())) + 1) ;
					} else {
						keys.add(sb.toString());
						counts.add(1);
					}
					sb.delete(0, sb.length());
				}
			}			
		}
		
		int max = 0, min = 0;
		for (int i = 1; i < keys.size(); i++) {
			if (counts.get(i) > counts.get(max)) {
				min = max;
				max = i;
			}
			else if(counts.get(i) > counts.get(min));
				min = i;
		}
		System.out.println(keys.get(max));
		System.out.println(keys.get(min));
	}
	
	@SuppressWarnings("resource")
	static void findByMap(){
		Scanner cin = new Scanner(System.in);
		String line = cin.nextLine();
		line += '.';
		Map<String, Integer> map = new TreeMap<>();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) != ' ' && line.charAt(i) != ',' && line.charAt(i) != '.') {
				sb.append(line.charAt(i));
			} else {
				if(sb.length() > 0){
					if(map.containsKey(sb.toString())){
						map.put(sb.toString(), map.get(sb.toString()) + 1);
					} else {
						map.put(sb.toString(), 1);
					}
					sb.delete(0, sb.length());
				}
			}			
		}
		System.out.println(map);
		List<Integer> values = new ArrayList<>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			values.add(map.get(key));
		}
		
		Collections.sort(values);
		
		for (String key : keys) {
			if (map.get(key).equals(values.get(values.size() - 1)) || map.get(key).equals(values.get(values.size() - 2))) {
				System.out.println(key);
			}
		}
 	}
	
}
