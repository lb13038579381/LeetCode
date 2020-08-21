//package 字符串;
//
//public class 解方程 {
//    public static void main(String[] args) {
//        String str = "x+5-3+3x=6+x-2";
//        System.out.println(fun(str));
//    }
//
//    private static int fun(String str) {
//        String[] strs = str.split("=");
//        StringBuilder left = new StringBuilder(strs[0]);
//        StringBuilder right = new StringBuilder(strs[1]);
//        int leftLength = left.length();
//        int rightLength = right.length();
//        for (int i = 0; i < leftLength; i++) {
//            if (left.charAt(i) - '0' >= 1 && left.charAt(i) - '0' <= 9 && left.charAt(i)) {
//                if (left.charAt(i - 1) == '+') {
//                    right.append('-').append(left.charAt(i));
//                    left.replace(i-1,i+1,"  ");
//
//                }
//                if (i == 0) {
//                    right.append('-').append(left.charAt(i));
//                    left.replace(i,i," ");
//                }
//                if (left.charAt(i - 1) == '-') {
//                    right.append('+').append(left.charAt(i));
//                    left.replace(i-1,i+1,"  ");
//
//                }
//
//            }
//        }
//        System.out.println(left.toString());
//        System.out.println(right.toString());
//return -1;
//    }
//}
