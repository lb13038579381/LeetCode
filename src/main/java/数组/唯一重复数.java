package 数组;

public class 唯一重复数 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static  int findDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = num & result;
        }return result;
    }
}
