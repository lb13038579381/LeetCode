package 其他;

import java.util.Stack;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/20 3:25 下午
 */
public class 双栈实现队列 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack1 = new Stack<>();

    private void put(Integer a ){
        if(stack1.isEmpty()) {
            stack1.push(a);
        }else {
            stack.clear();
            while(!stack1.isEmpty()) {
                stack.push(stack1.pop());
            }
            stack1.push(a);
            while(!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
        }
    }

    private Integer get() {
        if(stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    private void delete() {
                stack1.pop();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        while(!stack1.isEmpty()) {
            result.append(stack1.pop()).append(",");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        双栈实现队列 s = new 双栈实现队列();
        s.put(1);
        s.put(2);
        s.put(3);
        s.put(4);
        s.put(5);
        System.out.println(s.get());
        s.delete();
        System.out.println(s.toString());
    }
}
