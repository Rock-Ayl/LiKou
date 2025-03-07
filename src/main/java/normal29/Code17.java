package normal29;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-03-07
 * LCR 185. 统计结果概率
 * 中等
 * 相关标签
 * 相关企业
 * 你选择掷出 num 个色子，请返回所有点数总和的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 num 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 3
 * 输出：[0.00463,0.01389,0.02778,0.04630,0.06944,0.09722,0.11574,0.12500,0.12500,0.11574,0.09722,0.06944,0.04630,0.02778,0.01389,0.00463]
 * 示例 2：
 * <p>
 * 输入：num = 5
 * 输出:[0.00013,0.00064,0.00193,0.00450,0.00900,0.01620,0.02636,0.03922,0.05401,0.06944,0.08372,0.09452,0.10031,0.10031,0.09452,0.08372,0.06944,0.05401,0.03922,0.02636,0.01620,0.00900,0.00450,0.00193,0.00064,0.00013]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 11
 */
public class Code17 {

    public double[] statisticsProbability(int num) {
        //色子可以投出的点数
        int[] diceArr = new int[]{1, 2, 3, 4, 5, 6};
        //初始化所有可能路径
        int[][] arr = new int[num][];
        //循环初始化
        for (int i = 0; i < arr.length; i++) {
            //初始化本次点数和可能
            arr[i] = new int[(i + 1) * diceArr.length + 1];
        }
        //初始化第一次色子
        for (int i = 1; i < arr[0].length; i++) {
            //默认1
            arr[0][i] = 1;
        }
        //循环第i+1次色子,从第二次开始
        for (int i = 1; i < arr.length; i++) {
            //当前可能
            int[] thisArr = arr[i];
            //上一次投色子可能
            int[] lastArr = arr[i - 1];
            //循环2,从每个结果开始
            for (int j = 0; j < thisArr.length; j++) {
                //循环色子
                for (int dice : diceArr) {
                    //如果 越界 or 上次没有
                    if (j - dice < 0 || (j - dice) >= lastArr.length || lastArr[j - dice] == 0) {
                        //本轮过
                        continue;
                    }
                    //叠加本次
                    thisArr[j] += lastArr[j - dice];
                }
            }
        }
        //获取最后一次结果
        int[] lastArr = arr[num - 1];
        //所有情况总和,转为double
        double sum = Arrays.stream(lastArr).sum();
        //初始化返回结果
        double[] result = new double[lastArr.length - num];
        //循环
        for (int i = num; i < lastArr.length; i++) {
            //计算本次概率
            result[i - num] = (double) lastArr[i] / sum;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().statisticsProbability(3));
    }

}
