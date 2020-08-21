package 数组;

public class 重复数 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
            }
            if(nums[nums[i]] > 0) {
                nums[nums[i]]=-nums[nums[i]];
            }else {
                return nums[nums[i]];
            }

        }
        return -1;
    }
}
