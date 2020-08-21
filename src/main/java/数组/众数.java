package 数组;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/17 3:30 下午
 */
public class 众数 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,6,7,8,6,6,8,8,7,8,8,6,6,6,6,6,6,8,8,8,8,8,8};
        System.out.println(fun(nums));
    }
    public static List<Integer> fun(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if(num == n1) {
                c1++;
                continue;
            }
            if(num == n2) {
                c2++;
                continue;
            }
            if(c1 == 0) {
                n1 = num;
                continue;
            }
            if(c2 == 0) {
                n2=num;
                continue;
            }
            c1--;
            c2--;
        }
        c1=0;
        c2=0;
        for (int num : nums) {
            if(num == n1) {
                c1++;
            }
            if(num == n2) {
                c2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(c1 > nums.length/3){
            result.add(n1);
        }
        if(c2 > nums.length/3) {
            result.add(n2);
        }
        return result;

    }
}
