package 笔试题;

import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c' };


    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 7;
        System.out.println(++x*y ++);
        int[] nums = {1, 2, 3, 0, 0, 0, 3, 0, 0, 2, 3, 2, 0, 3};
        int p = nums.length - 1;
        int i = 0;
        while (i < p) {
            while (i < p && nums[i] != 0) {
                i++;
            }
            while (p > i && nums[p] == 0) {
                p--;
            }
            swap(nums, i, p);
        }
        System.out.println(Arrays.toString(nums));


        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }

    public void change(String str, char[] s) {
        str = "tttok";
        s[0] = 'g';
    }
}
