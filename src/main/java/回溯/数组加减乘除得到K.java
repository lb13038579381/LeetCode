package 回溯;

public class 数组加减乘除得到K {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {2, 10, 2, 6, 2};
        int k = 4;
        double[] nums1 = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        System.out.println(fun(nums1, k));
    }

    private static boolean fun(double[] nums, int k) {
        if (nums.length == 1) {
            if (Math.abs(nums[0] - k) < 0.001) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double[] nums1 = new double[nums.length - 1];
                int curIndex = 0;
                for (int p = 0; p < nums.length; p++) {
                    if (p != i && p != j) {
                        nums1[curIndex] = nums[p];
                        curIndex++;
                    }
                }
                for (double temp : help(nums[i], nums[j])) {
                    nums1[nums1.length - 1] = temp;
                    if (fun(nums1, k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static double[] help(double a, double b) {
        return new double[]{a + b, a - b, b - a, a * b, a / b, b / a};
    }
}
