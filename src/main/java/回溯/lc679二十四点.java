package 回溯;

public class lc679二十四点 {
    public static void main(String[] args) {
        int[] nums = {1, 9, 1,2};
        System.out.println(judgePoint24(nums));
        System.out.println(fun(nums));

    }

    private static boolean fun(int[] nums1) {
        double[] nums = new double[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        return helper(nums);
    }

    private static boolean helper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) < 0.001;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curIndex = 0;
                double[] nums1 = new double[nums.length - 1];
                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        nums1[curIndex] = nums[k];
                        curIndex++;
                    }
                }
                for (double temp : helper1(nums[i], nums[j])) {
                    nums1[nums1.length - 1] = temp;
                    if(helper(nums1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static double[] helper1(double a, double b) {
        return new double[]{a + b, a - b, b - a,a * b, a / b, b / a};
    }


    public static boolean judgePoint24(int[] nums) {
        double[] nums_2 = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_2[i] = nums[i];
        }
        return dfs(nums_2);
    }

    private static boolean dfs(double[] nums_2) {
        if (nums_2.length == 1) {
            return Math.abs(nums_2[0] - 24.0) < 0.001;
        }
        for (int i = 0; i < nums_2.length; i++) {
            for (int j = i + 1; j < nums_2.length; j++) {
                double[] nums_3 = new double[nums_2.length - 1];
                for (int k = 0, index = 0; k < nums_2.length; k++) {
                    if (k != i && k != j) {
                        nums_3[index++] = nums_2[k];
                    }
                }
                for (double r : compute(nums_2[i], nums_2[j])) {
                    nums_3[nums_3.length - 1] = r;
                    if (dfs(nums_3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static double[] compute(double i, double j) {
        return new double[]{i + j, i - j, j - i, i * j, i / j, j / i};
    }
}
