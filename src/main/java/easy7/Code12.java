package easy7;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Rock-Ayl on 2021-03-08
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 */
public class Code12 {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        //转化为list
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        //转化为str
        String num = K + "";
        //左边的位置
        int ap = list.size() - 1;
        //右边的位置
        int kp = num.length() - 1;
        //如果有进位
        boolean hasCarry = false;
        //循环
        while (kp >= 0) {
            //当前数
            int thisKNum = num.charAt(kp) - '0';
            //如果有进位
            if (hasCarry) {
                //+1
                thisKNum++;
            }
            //计算和
            int sum = thisKNum + list.get(ap);
            //如果进一位
            if (sum > 9) {
                //进位后复制
                list.set(ap, sum - 10);
                //有进位
                hasCarry = true;
            } else {
                //直接复制
                list.set(ap, sum);
                //没有进位
                hasCarry = false;
            }
            //递减
            ap--;
            kp--;
            //如果左边没有值了
            if (ap < 0) {
                //循环
                while (kp >= 0) {
                    //当前数
                    int newSum = num.charAt(kp) - '0';
                    //如果有进位
                    if (hasCarry) {
                        //+1
                        newSum++;
                    }
                    //如果进一位
                    if (newSum > 9) {
                        //进位后复制
                        list.add(0, newSum - 10);
                        //有进位
                        hasCarry = true;
                    } else {
                        //直接复制
                        list.add(0, newSum);
                        //没有进位
                        hasCarry = false;
                    }
                    kp--;
                }
                //如果还有进位
                if (hasCarry) {
                    //进一
                    list.add(0, 1);
                }
                //返回
                return list;
            }
        }
        //一直到没有进位
        while (hasCarry) {
            //如果越界了
            if (ap < 0) {
                //到这里如果还有进位
                if (hasCarry) {
                    //前面插1
                    list.add(0, 1);
                    //结束
                    break;
                }
            }
            //当前数
            int thisKNum = 0;
            //如果有进位
            if (hasCarry) {
                //+1
                thisKNum++;
            }
            //计算和
            int sum = thisKNum + list.get(ap);
            //如果进一位
            if (sum > 9) {
                //进位后复制
                list.set(ap, sum - 10);
                //有进位
                hasCarry = true;
            } else {
                //直接复制
                list.set(ap, sum);
                //没有进位
                hasCarry = false;
            }
            //递减
            ap--;
        }
        //返回
        return list;
    }

    public static void main(String[] args) {
        for (Integer integer : addToArrayForm(new int[]{2, 1, 5}, 806)) {
            System.out.println(integer);
        }
    }
}
