package 笔试题;

import domain.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最有 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        map.put('g', 16);
        map.put('h', 17);
        map.put('i', 18);
        map.put('j', 19);
        map.put('k', 20);
        map.put('l', 21);
        map.put('m', 22);
        map.put('n', 23);
        map.put('o', 24);
        map.put('p', 25);
        map.put('q', 26);
        map.put('r', 27);
        map.put('s', 28);
        map.put('t', 29);
        map.put('u', 30);
        map.put('v', 31);
        map.put('w', 32);
        map.put('x', 33);
        map.put('y', 34);
        map.put('z', 35);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = s.length() - 1;
        int n = 0;
        long res = 0;
        boolean isfu = false;
        while (i >= 0) {
            if (i == 0 && s.charAt(i) == '-') {
                isfu = true;
                break;
            }
            char t = s.charAt(i);
            if (!Character.isDigit(t) && !Character.isLetter(t)) {
                System.out.println("0");
                return;
            }
            double temp = map.getOrDefault(t, t - '0') * Math.pow(36, n);
            res += temp;
            n++;
            i--;
        }
        if (isfu) {
            System.out.println("-" + res);
            return;
        }
        System.out.println(res);
        System.out.println(reConstructBinaryTree(new int[]{2, 3, 1}, new int[]{1, 2, 3}));
    }

    public static String help(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int temp = 0;
        StringBuilder res = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) {
                temp += a.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                temp += b.charAt(p2) - '0';
                p2--;
            }
            res.append(temp % 10);
            temp = temp / 10;
        }
        return res.reverse().toString();
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }
}
