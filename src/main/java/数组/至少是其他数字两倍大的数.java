package 数组;

/*
1594918992866
 */
public class 至少是其他数字两倍大的数 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,70,7,30,40};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        int less = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if(num > max) {
                less = max;
                max = num;
            }else if(num > less) {
                less = num;
            }
        }
        if(max > 2 * less) {
            return max;
        }else {
            return -1;
        }

    }

}
