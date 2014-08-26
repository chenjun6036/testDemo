package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 四则运算
 * @author chenjun
 *
 */
public class ArithmeticOperation {
	private static final String operations = "+-*/()";
	private static final Map<Character,Integer> op = new TreeMap<Character, Integer>();
	static {
		op.put('+', 1);
		op.put('-', 1);
		op.put('*', 2);
		op.put('/', 2);
		op.put('(', 0);
	}
	
	public static void main(String[] args) {
		System.out.println(simpleArithmetic("1+3+4/2-3*3"));
		System.out.println(complexArithmetic("1+3+4/2-3*3"));
	}
	
	/**
	 * 简单四则运算，只有+、-、*、/
	 * @param input
	 * @return
	 */
	public static int simpleArithmetic(String input) {
		List<String> infix = separateString(input);
		LinkedList<String> result = new LinkedList<>();
		for (int i = 0; i < infix.size(); i++) {
			if (infix.get(i).equals("*") || infix.get(i).equals("/")) {				
				int num1 = Integer.parseInt(result.pop());
				int num2 = Integer.parseInt(infix.get(++i));
				int tmpresult = 0;
				if(infix.get(i - 1).equals("*"))
					tmpresult = num1 * num2;
				else
					tmpresult = num1 / num2;
				result.push(String.valueOf(tmpresult));
			} else {
				result.push(infix.get(i));
			}
		}
		LinkedList<String> result1 = new LinkedList<>();
		while (result.peekLast() != null) {
			String tmp = result.pollLast();
			if(tmp.equals("+") || tmp.equals("-")) {
				int num1 = Integer.parseInt(result1.pop());
				int num2 = Integer.parseInt(result.pollLast());
				int tmpresult = 0;
				if(tmp.equals("+")) {
					tmpresult = num1 + num2;
				}else
					tmpresult = num1 - num2;
				result1.push(String.valueOf(tmpresult));
			}else{
				result1.push(tmp);
			}
		}
		
		return Integer.parseInt(result1.get(0));
	}
	
	/**
	 * 复杂四则运算，包括括号。
	 * @param input
	 * @return
	 */
	public static int complexArithmetic(String input) {
		List<String> infix = separateString(input);
		List<String> postfix = infixToPostfix(infix);
		LinkedList<String> result = new LinkedList<>();
		for(int i = 0; i < postfix.size(); i++) {
			if (operations.contains(postfix.get(i))) {
				int num1 = Integer.parseInt(result.pop());
				int num2 = Integer.parseInt(result.pop());
				int temp = 0;
				switch(postfix.get(i).charAt(0)){
				case '+' :
					temp = num2 + num1;
					break;
				case '-' :
					temp = num2 - num1;
					break;
				case '*' :
					temp = num2 * num1;
					break;
				case '/' :
					temp = num2 / num1;
					break;				
				}
				result.push(String.valueOf(temp));
			} else {
				result.push(postfix.get(i));
			}
		}
		return Integer.parseInt(result.pop());
	}
	
	/**
	 * 规则1：若出现的符号等级低于栈顶的表达式等级(如符号为'+或-'，而栈顶为'*或/'，则除顶部自己外其余全部出栈；若碰到同级则只出栈一个(如符号为'+'，而栈顶为'-'且栈中还有'+-'，则只出栈顶一个'-') 
	 * 规则2：若出现左右括号，则括号内的内容全部出栈 
	 * 规则3：非符号(即数字)不用进栈，只需依次记录即可 
	 * @param infix 中缀表达式
	 * @return 后缀表达式
	 */
	public static List<String> infixToPostfix (List<String> infix) {
		List<String> postfix = new ArrayList<>();
		LinkedList<Character> operation = new LinkedList<>();
		int i = 0;
		while (i < infix.size() || !operation.isEmpty()) {
			if (i >= infix.size()) {
				postfix.add(operation.pop().toString());
				continue;
			}
			if (!operations.contains(infix.get(i))) {
				postfix.add(infix.get(i));
			} else {
				if(infix.get(i).equals(")")) {
					while (!operation.peek().equals('(')) {
						postfix.add(String.valueOf(operation.pop()));
					}
					operation.pop();
				} else {
					while (operation.size() > 0 && op.get(infix.get(i).charAt(0)) < op.get(operation.peek())) {
						postfix.add(String.valueOf(operation.pop()));
					}
					if(operation.size() > 0 && op.get(infix.get(i).charAt(0)) == op.get(operation.peek())) {
						postfix.add(String.valueOf(operation.pop()));
					}
					operation.push(infix.get(i).charAt(0));
				}
			}
			i++;
		}
		return postfix;
	}
	
	/**
	 * 分割字符串，将一个字符串分为
	 * @param input
	 * @return
	 */
	private static List<String> separateString(String input) {
		List<String> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		String current;
		for (int i = 0; i < input.length(); i++) {
			current = String.valueOf(input.charAt(i));
			if(operations.contains(current)) {
				if (sb.length() > 0) {
					list.add(sb.toString());
					sb.delete(0, sb.length());
				}
				list.add(current);
			}else{
				sb.append(current);
			}
		}
		if (sb.length() > 0){
			list.add(sb.toString());
		}
		return list;
	}
}
