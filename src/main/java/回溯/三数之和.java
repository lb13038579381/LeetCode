package 回溯;

import java.util.*;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 45, 4, 3};
        int k = 15;
        Set<int[]> set = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0] && o1[1] == o2[1] && o1[2] == o2[2]) {
                return 0;
            }
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) {
                    return -1;
                } else if (o1[1] < o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    if (o1[2] > o2[2]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
            return 0;
        });
        set.add(new int[]{-1,0,1});
        set.add(new int[]{-1,0,1});
        set.add(new int[]{2,-1,-1});
        for (int[] ints : set) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(fun(nums, k));
    }

    private static List<List<Integer>> fun(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            List<Integer> temp = new ArrayList<>();
            while (l < r) {
                if (nums[l] + nums[r] == k - nums[i]) {
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(new ArrayList<>(temp));
                    break;
                } else if (nums[l] + nums[r] < k - nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
