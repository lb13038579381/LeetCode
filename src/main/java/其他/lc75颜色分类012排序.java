package 其他;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class lc75颜色分类012排序 {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        };
        Integer call = callable.call();
        System.out.println(call);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int[] nums = {1, 2, 0};
//        System.out.println(Arrays.toString(fun(nums)));
    }

    private static int[] fun(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int indexOf0 = 0;
        int indexOf2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                swap(nums, i, indexOf2);
                indexOf2--;
                if (i != indexOf2) {
                    i--;
                }
            } else if (nums[i] == 0) {
                swap(nums, i, indexOf0);
                if (i != indexOf0) {
                    i--;
                }
                indexOf0++;
            }
            if (i == indexOf2) {
                break;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
