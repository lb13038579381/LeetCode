package 字符串;

public class 回文串 {
    public static void main(String[] args) {
        String s = "A man, a plasn, a canal: Panama";
        System.out.println(fun(s));
    }

    private static boolean fun(String s) {
        StringBuilder newS = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newS.append(c);
            }
        }
        int left = 0;
        int right = newS.length()-1;
        while(left <= right) {
            if(newS.toString().charAt(left) == newS.toString().charAt(right)) {
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
