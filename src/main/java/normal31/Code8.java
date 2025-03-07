package normal31;

/**
 * @Author ayl
 * @Date 2024-04-30
 * 面试题 08.11. 硬币
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 */
public class Code8 {

    public int waysToChange(int n) {
        //初始化动态规划
        int[] arr = new int[n + 1];
        //一分钱没有的情况只有一次
        arr[0] = 1;
        //每种金币循环一次,防止重复
        for (int price : new int[]{1, 5, 10, 25}) {
            System.out.println();
            //循环
            for (int i = price; i < arr.length; i++) {
                //叠加结果
                arr[i] = (arr[i] + arr[i - price]) % 1000000007;
            }
        }
        //返回结果
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code8().waysToChange(10));
    }

}
