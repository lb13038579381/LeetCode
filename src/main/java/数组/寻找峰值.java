package 数组;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/17 3:11 下午
 */
public class 寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 7, 10, 2, 1, 3, 5, 9, 7};
        System.out.println(fun(nums));
    }

    /**
     * @description:
     * @params: [nums]
     * @return: boolean
     * @author: lb
     * @time: 2020/7/17 3:11 下午
     */
    private static int fun(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return nums[mid];
            }else if(nums[mid] > nums[mid-1]) {
                left = mid +1;
            }else if(nums[mid] < nums[mid-1]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
