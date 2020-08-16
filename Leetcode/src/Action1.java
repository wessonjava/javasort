import java.util.Scanner;

/**
 * @author wesson
 * @date 2020/8/12   01:27
 * <p>
 * 题目：给若干个区间，区间数少于1000，区间范围[-10000,10000]。当区间数少于2个时输出None。当各个区间有交集的时候取交集，再求交集的并集。具体看下面的列子
 * 1、如:[1,3]、[2,4]、[4,8]、[5,9]4个区间，
 * 输入demo:1 3 2 4 4 8 5 9
 * [1,3]与[2,4]交集为[2,3],。。[1,3]与[4,8]、[5,9]没有交集。
 * [2,4]与[4,8]]交集为[4,4]。[2,4]与[5,9]没有交集。
 * [4,8]与[5,9]的交集为[5,8]
 * 所以最终的输出为[2,3]、[4,4]、[5,8]
 * 输出demo:2 3 4 4 5 8
 * 2、如:[1,2]、[3,4]2个区间，
 * 最后输出为None
 * 3、如:[1,6]、[2,5]、[5,7]3个区间，
 * [1,6]、[2,5]的交集为[2,5]，，，[1,6]、[5,7]的交集为[5,6]
 * [2,5]、[5,7]的交集为[5,5]
 * 最后的输出为：2 6
 */
public class Action1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] qujianyuansu = new int[20000];
            for (int i = 0; i < qujianyuansu.length; i++) {
                qujianyuansu[i] = 10001;
            }
            //输入的数据0 3 1 4 4 7 5 8
            String str = in.nextLine();
            String[] arrStr = str.split(" ");
            //区间数量
            int qujianshuliang = arrStr.length / 2;
            int[][] qujianshu = new int[qujianshuliang][2];
            if (qujianshuliang <= 1) {
                System.out.println("None");
                return;
            }
            //将输入的数据0 3 1 4 4 7 5 8转化为区间{0 3} {1 4} {4 7} {5 8}
            for (int i = 0; i < qujianshuliang; i++) {
                qujianshu[i][0] = Integer.parseInt(arrStr[i * 2]);
                qujianshu[i][1] = Integer.parseInt(arrStr[i * 2 + 1]);
            }
            //比较区间
            for (int i = 0; i < qujianshuliang - 1; i++) {
                for (int j = i + 1; j < qujianshuliang; j++) {
                    //取左区间最大的数
                    int max0 = Math.max(qujianshu[i][0], qujianshu[j][0]);
                    //取右区间最小的数
                    int min1 = Math.min(qujianshu[i][1], qujianshu[j][1]);
                    if (max0 > min1) {
                        //无交集不管
                    } else {
                        //将区间元素数组标记为有数据
                        for (int k = 0; k <= min1 - max0; k++) {
                            //qujianyuansu[max0+k+10000]!=10001表示以前存在交集
                            if (qujianyuansu[max0 + k + 10000] != 10001) {
                                //表示存过数字,存过数字，表示有交集，我要把我后面的数据全部表示为这个起始位置的大小
                                //看你的边界小还是我的边界小
                                if (qujianyuansu[max0 + k + 10000] < max0) {
                                    qujianyuansu[max0 + k + 10000] = max0;
                                }
                            } else {
                                qujianyuansu[max0 + k + 10000] = max0;
                            }
                        }
                    }
                }
            }

            int start = 0;
            int count = 1;
            int none = 0;
            //遍历数组，输出打印
            for (int i = 0; i < qujianyuansu.length - 1; i++) {

                if (qujianyuansu[i] == 10001) {
                    start++;
                } else {
                    none++;
                    if (qujianyuansu[i] == qujianyuansu[i + 1]) {
                        count++;
                    } else {
                        System.out.print(qujianyuansu[start] + " " + (qujianyuansu[start] + count - 1) + " ");
                        start += count;
                        count = 1;
                    }
                }

            }
            if (none == 0) {
                System.out.println("none");
            }

        }
    }
}