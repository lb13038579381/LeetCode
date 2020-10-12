package 笔试题;

import lombok.val;

import java.util.*;

 class wangyi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);
        Set<Integer> notye = new HashSet<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String now = sc.nextLine();
            temp.add(now);
            notye.add(Integer.valueOf(now.split(" ")[0]));
        }
        int res = 0;
        for (int t : notye) {
            boolean hasLeft = false;
            boolean hasRight = false;
            List<Integer> yes = new ArrayList<>();
            for (String te : temp) {
                String[] ss = te.split(" ");
                if (Integer.valueOf(ss[0]) == t) {
                    if (ss[1].equals("left")) {
                        hasLeft = true;
                    }
                    if (ss[1].equals("right")) {
                        hasRight = true;
                    }
                    yes.add(Integer.valueOf(ss[2]));
                    if (hasLeft && hasRight) {
                        break;
                    }
                }
            }
            if (hasLeft && hasRight) {
                boolean canSuccess = true;
                for (int a : yes) {
                    if (notye.contains(a)) {
                        canSuccess = false;
                    }
                }
                if (canSuccess) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}