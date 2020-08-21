package 数组;

import java.util.*;

public class 排序数组重复 {

    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 4, 5, 6, 8, 34, 30, 31, 543, 5, 232, 100, 43, 4, 23, 31};
//        int t = 104;
//        Arrays.sort(nums);
//        Queue<Integer> integers = new LinkedList<>();
//        System.out.println(fun(nums, t));
        int[] nums = {1, 1, 2, 5, 6 ,7 ,10};
        System.out.println(combinationSum2(nums,8));
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int t) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helpe1r(0, t, res, new LinkedList<>(), nums);
        return res;
    }

    private static void helpe1r(int start, int curSum, List<List<Integer>> res, Deque<Integer> queue, int[] nums) {
        if (curSum == 0) {
            res.add(new ArrayList<>(queue));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(curSum - nums[i] < 0) {
                break;
            }
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            queue.addLast(nums[i]);
            helpe1r(i+1,curSum-nums[i],res,queue,nums);
            queue.removeLast();
        }
    }


    private static List<List<Integer>> fun(int[] nums, int t) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, t, res, new LinkedList<>(), nums);
        return res;
    }

    private static void helper(int start, int curSum, List<List<Integer>> res, Deque<Integer> queue, int[] nums) {
        if (curSum == 0) {
            res.add(new ArrayList<>(queue));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(curSum - nums[i] < 0) {
                break;
            }
            queue.addLast(nums[i]);
            helper(start,curSum-nums[i],res,queue,nums);
            queue.removeLast();
        }
    }


    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    static Set<List<Integer>> set = new HashSet<>();
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 3};
//        boolean[] booleans = new boolean[arr.length];
//        find(arr, 0, booleans);
//        System.out.println(set);
//    }
//
//    static void find(int[] arr, int position, boolean[] isIns) {
//        if (position == arr.length) {
//            List<Integer> list = new LinkedList<>();
//            for (int i = 0; i < arr.length; i++) {
//                if (isIns[i]) {
//                    list.add(arr[i]);
//                }
//            }
//            set.add(list);
//        } else {
//            isIns[position] = true;
//            find(arr, position + 1, isIns);
//            isIns[position] = false;
//            find(arr, position + 1, isIns);
//        }
//    }
}
