package 数组;

import java.util.*;

public class topK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,67,7,8,56,54,34,3,3,3,5,5,45,45,45,43,34,2324324,534,543,5,436,54,654,6,344,32,42,4,2432};
        System.out.println(fun(nums,10));
    }

    private static List<Integer> fun(int[] nums, int i) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int num : nums) {
            if(queue.size() < i) {
                queue.offer(num);
            }else if(num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
