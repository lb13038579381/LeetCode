package 数组;

import java.util.List;

public class 字节面试 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 5, 5, 8, 9, 7, 6, 6, 6, 5, 4, 3};
        int k = 5;
        System.out.println(fun(nums, 5));
    }

    private static int fun(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int p = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                p = mid;
                break;
            }
            if (nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int res = Integer.MAX_VALUE;
        int ll = 0;
        int lr = p;
        while (ll < lr) {
            int mid = (ll + lr) / 2;
            if (nums[mid] > k) {
                ll = mid + 1;
            } else if (nums[mid] == k) {
                res = Math.min(res, mid);
                if (mid != 0 && nums[mid - 1] != nums[mid]) {
                    break;
                }
                lr = mid;
            } else {
                lr = mid;
            }
        }
        if (nums[res] == k) {
            return res;
        }

        int rl = p + 1;
        int rr = nums.length - 1;
        while (rl < rr) {
            int mid = rl + (rr - rl) / 2;
            if (nums[mid] > k) {
                rl = mid + 1;
            } else if (nums[mid] == k) {
                res = Math.min(mid, res);
                if (mid != 0 && nums[mid - 1] != nums[mid]) {
                    break;
                }
                rr = mid;
            } else {
                rr = mid;
            }
        }

        if (nums[res] == k) {
            return res;
        }
        return -1;
    }
}
