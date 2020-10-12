package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 上汤 {
    public static void main(String[] args) {
        /*794.478 -175.513
10
202.27 -963.723
-175.924 -891.911
833.666 -514.638
959.625 142.19
936.967 987.264
-481.222 990.566
-846.523 924.932
-968.741 -147.723
-731.881 -755.811
         */
//        Scanner sc = new Scanner(System.in);
//        String f = sc.nextLine();
//        double x = Double.parseDouble(f.split(" ")[0]);
//        double y = Double.parseDouble(f.split(" ")[1]);
//        double res = Double.MAX_VALUE;
//        int n = sc.nextInt();
//        sc.nextLine();
//        System.out.println(n);
//        List<String> list = new ArrayList<>();
//        while(sc.hasNextLine()) {
//            list.add(sc.nextLine());
//        }
//        System.out.println(list);
//        for (String temp : list) {
//            double xs = Double.parseDouble(temp.split(" ")[0]);
//            double ys = Double.parseDouble(temp.split(" ")[1]);
//            double r1 = Math.abs(x - xs);
//            double r2 = Math.abs(y - ys);
//            double r = Math.sqrt((r1 * r1) + (r2 * r2));
//            System.out.println(r);
//            res = Math.min(res, r);
//        }
//        System.out.println(res);
        yesefu(5,3);
        count(5,3);
    }
    public static void count(int personNumber,int number){
        //1.把人放到数组中,数据结构
        int[] persons = new int[personNumber];
        for (int i = 0; i < personNumber; i++) {
            persons[i] = i+1;
        }

        //2.算法
        int index = 0;//从0开始
        int dunNumbers = 0;//记录蹲下人数的数
        int duns = 0;//记录蹲下人的个数

        while (duns !=personNumber ) {
            //有人没有蹲下

            //1.判读当前位置是否是蹲下
            if (persons[index%persons.length] == 0) {
                //蹲下,继续数数
                dunNumbers++;
                index++;
            }else {
                //2.没有蹲下,判读数的数是否是number的数
                if ((index + 1 -dunNumbers)%number == 0) {
                    //是
                    //打印该位置
                    System.out.println(persons[index%persons.length]);
                    //用0标识蹲下
                    persons[index%persons.length] = 0;
                    //蹲下的人数++
                    duns++;
                    //继续数数
                    index++;
                }else {
                    //否
                    //继续数数
                    index++;
                }

            }

        }
    }
    public static void yesefu(int totalNum,int countNum) {
        //初始化人数
        ArrayList<Integer> start = new ArrayList<Integer>();
        for(int i=1;i<=totalNum;i++) {
            start.add(i);
        }
        //从第k个数开始计数
        int k = 0;//从第一个人开始计数
        while(start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;//因为索引是从0开始，进行取余是因为防止k大于圈中人的总数
            //判断是否到队尾，即k的大小为start的大小，此时k为-1
            if(k < 0) {
                //如果到队尾了，则输出队尾元素
                System.out.print(start.get(start.size()-1)+" ");
                start.remove(start.size() - 1);
                k = 0;
            }else {
                //否则，直接输出k对应的元素
                System.out.print(start.get(k)+" ");
                start.remove(k);
            }
        }
    }
}

