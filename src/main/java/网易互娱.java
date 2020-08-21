//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class 网易互娱 {
//    //七星不靠java
//    public static void main(String[] args) {
///*
//4
//1T 4T 7T 2B 5B 8B 9W
//1T 2T 3T 4T 5T 6T 7T
//1B 2W 3T 4B 5W 6T 8W
//2B 8B 5B 2B 6T 7W 4W
// */
//
////        for (List<String> te : all) {
////            List<String> tList = new ArrayList<>();
////            List<String> bList = new ArrayList<>();
////            List<String> wList = new ArrayList<>();
////            for (String s : te) {
////                if (s.charAt(1) == 'T') {
////                    tList.add(s);
////                } else if (s.charAt(1) == 'B') {
////                    bList.add(s);
////                } else {
////                    wList.add(s);
////                }
////            }
////        }
//        int[][] nums = {
//                {1, 0, 0},
//                {0, 10, 10},
//                {0, 10, 10}
//        };
//        shizizhan(nums);
//    }
//
//    /*3
//1 0 0
//0 10 10
//0 10 10
//
//     */
//    private static List<List<Integer>> shizizhan(int[][] nums) {
//        int cowMax = Integer.MIN_VALUE;
//        int cowIndex = -1;
//        int colMax = Integer.MIN_VALUE;
//        int colIndex = -1;
//        int count = 0;
//        int[][] newArray = nums;
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < newArray.length; i++) {
//            int curSum = 0;
//            for (int j = 0; j < newArray.length; j++) {
//                curSum += newArray[i][j];
//            }
//            if (curSum > cowMax) {
//                cowMax = curSum;
//                cowIndex = i + 1;
//            }
//            int curSumCol = 0;
//            for (int j = 0; j < newArray.length; j++) {
//                curSumCol += newArray[j][i];
//            }
//            if (curSumCol > colMax) {
//                colMax = curSumCol;
//                colIndex = i + 1;
//            }
//            List<Integer> ttt = new ArrayList<>();
//            ttt.add(cowIndex);
//            ttt.add(colIndex);
//            res.add(ttt);
//            cowMax = -1;
//            colMax = -1;
//            count++;
//
//            newArray = new int[newArray.length - count][newArray.length - count];
//            for (int i1 = 0; i1 < newArray.length; i1++) {
//                for (int j1 = 0; j1 < newArray.length; j1++) {
//                    if (i1 != cowIndex && j1 != colIndex) {
//                        newArray[i2][j2] = newArray[i1][j1];
//                    }
//                }
//            }
//
//
//        }
//        System.out.println(cowIndex + " " + colIndex);
//        System.out.println(res);
//        return new ArrayList<>();
//    }
//}
//
