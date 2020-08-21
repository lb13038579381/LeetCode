package 数组;

import java.util.Arrays;

/**
 * @description: 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @author: lb
 * @time: 2020/7/17 4:25 下午
 */
public class 最大交换 {
    public static void main(String[] args) {
        int num = 964687395;
        System.out.println(Arrays.toString(fun(num)));
    }

    public static char[] fun(int num) {
        char[] nums = Integer.valueOf(num).toString().toCharArray();
        int[] max = new int[nums.length];
        int m = Integer.MIN_VALUE;
        int maxIndex= 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] - '0' > m) {
                m = nums[i] - '0';
                maxIndex = i;
            }
            max[i] = maxIndex;
        }
        for(int i = 0;i < nums.length;i++) {
            if(max[i]!=i && nums[i] != nums[max[i]]) {
                int temp = nums[i] - '0';
                nums[i] = nums[max[i]];
                nums[max[i]] = String.valueOf(temp).charAt(0);
                break;
            }
        }
        return nums;
    }
}
