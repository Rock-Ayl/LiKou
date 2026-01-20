package normal49;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 */
public class Code22 {

    public int numSquares(int n) {
        //积木的情况
        List<Integer> partList = new ArrayList<>();
        //积木
        int index = 1;
        //循环
        while (true) {
            //本次
            int part = index * index;
            //如果是目标
            if (part == n) {
                //特殊情况
                return 1;
            }
            //如果越界
            if (part > n) {
                //跳出
                break;
            }
            //记录本次
            partList.add(part);
            //下一个
            index++;
        }
        //动态规划
        int[] arr = new int[n + 1];
        //默认0的情况
        arr[0] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //循环
            for (int j = 0; j < partList.size(); j++) {
                //获取当前
                int part = partList.get(j);
                //目标索引
                int target = i - part;
                //如果越界
                if (target < 0) {
                    //彻底跳出
                    break;
                }
                //如果没有
                if (arr[target] == 0) {
                    //本轮过
                    continue;
                }
                //两种情况
                if (arr[i] == 0) {
                    //记录本次
                    arr[i] = arr[target] + 1;
                } else {
                    //最小情况
                    arr[i] = Math.min(arr[i], arr[target] + 1);
                }
            }
        }
        //返回结果
        return arr[arr.length - 1] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().numSquares(12));
    }

}
