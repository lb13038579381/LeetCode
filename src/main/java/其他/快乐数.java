package 其他;

public class 快乐数 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        int slow = n;
        int quick = n;
        do {
            slow = helper(slow);
            quick = helper(quick);
            quick = helper(quick);
        } while (slow != quick);
        return slow == 1;
    }

    private static int helper(int num) {
        int temp = 0;
        while(num > 0) {
            temp += (num % 10) * (num % 10);
            num = num/10;
        }
        return temp;

    }
}
