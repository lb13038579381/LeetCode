package 数组;

/*
1594920770999
 */
public class 三个数的最大乘积 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,-55,8,9,10,-20};
        System.out.println(fun(nums));
    }

    private static int fun(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if(num < min1) {
                min2 = min1;
                min1 = num;
            }else if(num < min2) {
                min2 = num;
            }
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2) {
                max3=max2;
                max2=num;
            }else if(num > max3) {
                max3= num;
            }
        }
        if(max1 * max2*max3 > min1*min2*max1) {
            return max1 * max2*max3;
        }else {
            return min1*min2*max1;
        }
    }
}
