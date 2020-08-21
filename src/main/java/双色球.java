import java.util.*;

public class 双色球 {
    public static void main(String[] args) {
        Random r1 = new Random();
        int tBlue = 10;
        List<Integer> red = new ArrayList<>();
        red.add(1);
        red.add(2);
        red.add(3);
        red.add(4);
        red.add(5);
        red.add(6);


        boolean nice = true;
        int cb = 0;
        int ca = 0;
        int allCount = 0;
        Set<Integer> myRed = new TreeSet<>();
        boolean san = false;
        List<Integer> countList = new ArrayList<>();
        while (nice) {
            int myBlue = r1.nextInt(16);
            while (myRed.size() != 6) {
                myRed.add(r1.nextInt(33));
            }
            allCount++;
            if (myBlue == tBlue) {
                cb++;

                int count = 0;
                for (Integer integer : myRed) {
                    if (red.contains(integer)) {
                        count++;
                        if (count == 5 && !san) {
                            san = true;
                            System.out.println("中了三十万" + myRed.toString() + "一共买了" + allCount + "次");
                        }
                        if (count == 6) {
                            countList.add(allCount);
                            int allCounts = 0;
                            int minCount = integer.MAX_VALUE;
                            for (Integer integer1 : countList) {
                                allCounts+=integer1;
                                if(integer1 < minCount) {
                                    minCount = integer1;
                                }
                            }
                            System.out.println("    中了五百万" + myRed.toString() + "一共买了" + allCount + "次" + "平均" + allCounts/countList.size() +" 次能中一次" + "当前最少花了" +minCount );
                            allCount = 0;
                        }
                    }
                }
            }
            myRed.clear();
        }
        System.out.println(r1.nextInt(33));
    }
}
