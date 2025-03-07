package normal29;

/**
 * @Author ayl
 * @Date 2024-03-18
 * 1155. 掷骰子等于目标和的方法数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n、k 和 target，请返回投掷骰子的所有可能得到的结果（共有 kn 种方式），使得骰子面朝上的数字总和等于 target。
 * <p>
 * 由于答案可能很大，你需要对 109 + 7 取模。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你掷了一个有 6 个面的骰子。
 * 得到总和为 3 的结果的方式只有一种。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你掷了两个骰子，每个骰子有 6 个面。
 * 有 6 种方式得到总和为 7 的结果: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1。
 * 示例 3：
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须对 109 + 7 取模。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class Code24 {

    public int numRollsToTarget(int n, int k, int target) {
        //如果没有
        if (n < 1) {
            //过
            return 0;
        }
        //结果列表
        long[][] arr = new long[n][target + 1];
        //循环
        for (int i = 1; i <= k; i++) {
            //如果未越界
            if (i < arr[0].length) {
                //初始化第一次投色子
                arr[0][i] = 1L;
            }
        }
        //循环
        for (int i = 1; i < arr.length; i++) {
            //本轮色子的结果
            long[] thisArr = arr[i];
            //上次投的结果
            long[] lastArr = arr[i - 1];
            //循环每次结果
            for (int j = 1; j < thisArr.length; j++) {
                //循环色子
                for (int b = 1; b <= k; b++) {
                    //如果上次有结果
                    if (j - b >= 0 && j - b < lastArr.length) {
                        //叠加
                        thisArr[j] = (thisArr[j] + lastArr[j - b] % 1000000007L);
                    }
                }
            }
        }
        //获取最终结果
        long targetCount = arr[arr.length - 1][arr[0].length - 1];
        //取模
        return (int) (targetCount % 1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(new Code24().numRollsToTarget(4, 6, 21));
    }

}
