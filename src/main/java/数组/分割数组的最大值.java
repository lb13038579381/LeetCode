package 数组;

public class 分割数组的最大值 {
    public static void main(String[] args) {
        int[] nums = {7, 15, 5, 10, 8};
        System.out.println(fun(nums, 2));
    }

    private static int fun(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = num > max ? num : max;
            sum += num;
        }
        while (max < sum) {
            int mid = max + (sum - max) / 2;
            int splits = split(nums, mid);
            if (splits > k) {
                max = mid + 1;
            } else {
                sum = mid;
            }
        }
        return max;
    }

    private static int split(int[] nums, int mid) {
        int cur = 0;
        int res = 1;
        for (int num : nums) {
            if (cur + num > mid) {
                cur = 0;
                res++;
            }
            cur += num;
        }
        return res;
    }
}
