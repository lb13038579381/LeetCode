package 数组;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] nums = {5,3,6,2,7,1,8,4,9,10};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    private static int[] mergeSort(int[] nums) {
        if(nums.length <= 1) return nums;
        int mid = nums.length/2;
        int[] leftArr = Arrays.copyOfRange(nums,0,mid);
        int[] rightArr = Arrays.copyOfRange(nums,mid,nums.length);
        return mergeTwoArray(mergeSort(leftArr),mergeSort(rightArr));
    }

    private static int[] mergeTwoArray(int[] a, int[] b) {
        int i =0;
        int j = 0;
        int k =0;
        int[] result = new int[a.length+b.length];
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                result[k] = a[i];
                i++;
                k++;
            }else{
                result[k] = b[j];
                j++;
                k++;
            }
        }
        while(i < a.length) {
            result[k] = a[i];
            k++;
            i++;
        }
        while(j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }
        return result;
    }
}
