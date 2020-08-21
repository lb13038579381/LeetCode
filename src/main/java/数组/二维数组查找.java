package 数组;

public class 二维数组查找 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 333, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(fun(nums, 17));
    }

    private static boolean fun(int[][] nums, int k) {
        int s1 = nums.length - 1;
        int s2 = 0;
        while (s1 >= 0 && s2 <= nums[0].length - 1) {
            if (nums[s1][s2] < k) {
                s2++;
            } else if (nums[s1][s2] > k) {
                s1--;
            } else {
                return true;
            }
        }
        return false;
    }
}
