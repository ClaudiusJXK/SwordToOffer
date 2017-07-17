package ali.ali715;

/**
 * Created by Claudius on 2017/7/15.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 传入数据，一共有多少个坐标，从源点出发然后依次到达这些坐标然后返回原点。
 * 传入的坐标为五维坐标，每次移动只能一个方向移动，前三维每次移动耗费1单位能量，第4维耗费10单位，第5维耗费100单位
 * <p>
 * 我的思路，建立邻接矩阵，保存任意两个节点间的距离（包括源点）
 * <p>
 * 然后遍历所有可能。
 * <p>
 * 使用了一个静态域存储最小值，
 */
public class SavePeopleInFiveDimensional {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/

    //用来存储最后的sum值
    private static long finallySum = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();

        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        guessMyPath(dimList);
        System.out.println(finallySum);
    }


    //根据上面数据，构建邻接矩阵表，然后调用下面的计算函数进行递归遍历。
    public static void guessMyPath(List<Long[]> dimList) {
        int num = dimList.size();
        Long[] first = new Long[5];
        for (int j = 0; j < 5; j++) {
            first[j] = 0L;
        }
        long[][] dims = new long[num + 1][num + 1];
        for (int i = 0; i <= num; i++) {
            Long[] row;
            if (i == 0) {
                row = first;
            } else {
                row = dimList.get(i - 1);
            }
            for (int j = 0; j <= num; j++) {
                Long[] coloum;
                if (j == 0) {
                    coloum = first;
                } else {
                    coloum = dimList.get(j - 1);
                }
                dims[i][j] = Math.abs(row[0] - coloum[0])
                        + Math.abs(row[1] - coloum[1])
                        + Math.abs(row[2] - coloum[2])
                        + 10 * Math.abs(row[3] - coloum[3])
                        + 100 * Math.abs(row[4] - coloum[4]);
                System.out.print(dims[i][j] + " ");
            }
            System.out.println();
        }
        boolean[] flags = new boolean[num + 1];
        for (int i = 0; i <= num; i++) {
            flags[i] = false;
        }
        compute(dims, 0, flags, 0L);
    }


    //递归遍历，计算所有的可能，如果最后sum值比较小，则赋值给静态变量
    public static void compute(long[][] dims, int begin, boolean[] flags, long sum) {
        int length = dims.length;
        flags[begin] = true;
        boolean result = false;

        //判断还有点没访问吗
        for (int i = 0; i < length; i++) {
            if (flags[i] == false)
                result = true;
        }


        //计算返回去的值
        if (result != true) {
            if (sum + dims[begin][0] < finallySum) {
                finallySum = sum + dims[begin][0];
            }
            flags[begin] = false;
            return;
        }

        for (int i = 1; i < length; i++) {
            if (flags[i] == false) {
                sum += dims[begin][i];
                compute(dims, i, flags, sum);
            }
        }
        flags[begin] = false;
    }
}