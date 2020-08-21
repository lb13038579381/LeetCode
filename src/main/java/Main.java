import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    static Set<Integer> sus = new HashSet<>();
    static int maxSize = 0;

    public static void main(String[] args) {
//        int[] nums = {1000};
//        System.out.println(fun1(nums));
//        System.out.println(sus);

//        int[] nums = {5,3,7};
//        System.out.println(fun1(nums));
//        int res = 0;
//        for (int num : nums) {
//            res += num / 2;
//        }
//        System.out.println(res);
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//        int a = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            a = a ^ i ^ nums[i];
//        }
//        System.out.println(a);
        List<List<Integer>> res = new ArrayList<>();

        helper(1, new ArrayList<>(), res, 10);
        System.out.println(res);

    }

    public static int fun1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(1, new ArrayList<>(), res, num);
            int max = Integer.MIN_VALUE;
            for (List<Integer> re : res) {
                System.out.println(re);
                max = Math.max(re.size(), max);
            }
            System.out.println();
            result = max < 0 ? result : result + max;
            max = Integer.MIN_VALUE;
        }
        return result;
    }

    private static boolean isSuShu(List<Integer> re) {
        for (Integer integer : re) {
            if (!issu(integer))
                return false;
        }
        for (Integer integer : re) {
            sus.add(integer);
        }
        return true;
    }

    private static boolean issu(int integer) {
        if (integer <= 1) {
            return false;
        }
        if (sus.contains(integer)) {
            return true;
        }
        for (int i = integer / 2; i > 1; i--) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void helper(int cur, List<Integer> output, List<List<Integer>> res, int k) {
        if (cur - 1 == k) {
            res.add(new ArrayList<>(output));
        }
        for (int i = cur; i <= k; i++) {
            output.add(i);
            helper(cur + i, output, res, k);
            output.remove(output.size() - 1);
        }
    }
}
