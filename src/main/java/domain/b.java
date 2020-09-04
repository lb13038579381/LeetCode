package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class b extends a {
    public b() {
        System.out.println("b构造");
    }

    public b(int d) {
        System.out.println("b" + d);
    }

    public void ddd(int o) {
        System.out.println("bddd" + o);
    }

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "asdjzcnjhsd";
        int l = 0;
        int r = s.length() - 1;
        char[] cs = s.toCharArray();
        while (l < r) {
            swap(cs, l, r);
            l++;
            r--;
        }
        HashSet<Integer> set = new HashSet<>();
        System.out.println(String.valueOf(cs));
        l = 0;
        r = s.length()-1;
        while (l < r) {
            swap(cs, l, r);
            l++;
            r--;
        }
        System.out.println(String.valueOf(cs));


    }

    private static void swap(char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
