package stack;

import java.util.LinkedList;

/**
 * ��ָoffer������22��ջ��ѹ�뵯��˳��<br/>
 * ���������������У���һ����ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������ֲ���ȡ�
 * @author chenjun
 *
 */
public class IsPopOrder {
	public boolean judge(int[] pushOrder, int[] popOrder){
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
	
	public static void main(String[] args) {
		int[] pushOrder = {1,2,3,4,5};
		int[] popOrder = {4,3,5,1,2};
		IsPopOrder isp = new IsPopOrder();		
		System.out.println(isp.judge(pushOrder, popOrder));
	}
}
