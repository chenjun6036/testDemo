package stack;

import java.util.LinkedList;

/**
 * 剑指offer面试题22：栈的压入弹出顺序<br/>
 * 输入两个整数序列，第一个表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字不相等。
 * @author chenjun
 *
 */
public class IsPopOrder {
	public boolean judge(Integer[] pushOrder, Integer[] popOrder){
		LinkedList<Integer> stack = new LinkedList<>();
		if(pushOrder == null || popOrder == null)
			return false;
		for(int i = 0, j = 0;j < popOrder.length;){
			if(i == pushOrder.length)
				if(stack.peek() == popOrder[j]){
					stack.pop();
					j++;
					continue;
				}else
					break;
			if(pushOrder[i] != popOrder[j]){
				stack.push(pushOrder[i]);
				i++;
			}
			else{
				i++;
				j++;
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}
	
	public boolean judge1(Integer[] pushOrder, Integer[] popOrder){
		if(pushOrder == null || popOrder == null)
			return false;
		LinkedList<Integer> stack = new LinkedList<>();
		int i = 0, j = 0;
		while(i <= pushOrder.length && j < popOrder.length){
			if(i < pushOrder.length && stack.peek() != pushOrder[i]){
				stack.push(pushOrder[i]);
			}
			if(stack.peek() != popOrder[j]){
				i++;
			}else{
				stack.pop();
				j++;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Integer[] pushOrder = {1,2,3,4,5};
		Integer[] popOrder = {4,3,5,1,2};
		IsPopOrder isp = new IsPopOrder();		
		System.out.println(isp.judge1(pushOrder, popOrder) == isp.judge(pushOrder, popOrder));
	}
}
