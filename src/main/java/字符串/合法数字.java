package 字符串;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class 合法数字 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        String str = "123.5e2";
//        System.out.println(fun(str));
//        HashMap<String, String> map = new HashMap<>(127);
        Object a = new Object();
        Object b = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("thread1 a");
                System.out.println(Thread.currentThread().getName());

                synchronized (b) {
                    System.out.println("thread1 b");
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("thread2 b");
                System.out.println(Thread.currentThread().getName());

                synchronized (a) {
                    System.out.println("thread2 a");
                    System.out.println(Thread.currentThread().getName());

                }
            }
        });
        thread1.start();
        thread2.start();
    }

    private static boolean fun(String str) {
        str = str.trim();
        char[] cs = str.toCharArray();
        if (cs.length == 0) {
            return false;
        }
        boolean hasNum = false;
        boolean hasPoint = false;
        boolean hasE = false;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                hasNum = true;
            } else if (cs[i] == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;

            } else if (cs[i] == 'e' || cs[i] == 'E') {
                if (!hasNum || hasE) {
                    return false;
                }
                hasE = true;
                hasNum = false;
            } else if (cs[i] == '+' || cs[i] == '-') {
                if (i != 0 && cs[i - 1] != 'e' && cs[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNum;
    }

}
