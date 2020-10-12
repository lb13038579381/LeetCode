package 其他;

import java.util.Set;
import java.util.TreeSet;

public class lc36有效的数独 {
    public static void main(String[] args) {
        char[][] nums = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(fun(nums));
    }

    private static boolean fun(char[][] nums) {
        //判读格式是否合法
        if (nums.length % 3 != 0 || nums[0].length % 3 != 0) {
            return false;
        }
        //判断每一行
        Set<Character> setCow = new TreeSet<>();
        Set<Character> setCol = new TreeSet<>();


        for (int i = 0; i < nums.length; i++) {
            setCow.clear();
            setCol.clear();
            for (int j = 0; j < nums[i].length; j++) {
                //判断每一行
                if (setCow.contains(nums[i][j]) && nums[i][j] != '.') {
                    return false;
                }
                setCow.add(nums[i][j]);
                //判断每一列
                if (setCol.contains(nums[j][i]) && nums[j][i] != '.') {
                    return false;
                }
                setCol.add(nums[j][i]);
            }
        }
        //判断每个九宫格
        for (int i = 0; i < nums.length; i += 3) {
            for (int j = 0; j < nums[i].length; j += 3) {
                setCol.clear();
                for (int k = i; k < i + 3 && k < nums.length; k++) {
                    for (int l = j; l < j + 3 && l < nums[i].length; l++) {
                        if (setCol.contains(nums[k][l]) && nums[k][l] != '.') {
                            return false;
                        }
                        setCol.add(nums[k][l]);
                    }
                }
                System.out.println(setCol);
            }
        }
        return true;
    }
}
