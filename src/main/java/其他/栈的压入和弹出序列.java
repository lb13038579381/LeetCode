package 其他;

import java.util.Stack;

public class 栈的压入和弹出序列 {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(fun(push,pop));
    }

    private static boolean fun(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int  p = 0;
        for (int i : push) {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == pop[p]) {
                p++;
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
