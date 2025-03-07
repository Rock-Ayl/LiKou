package normal39;

/**
 * @Author ayl
 * @Date 2025-01-24
 * 3259. 超级饮料的最大强化能量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
 * <p>
 * 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
 * <p>
 * 返回在接下来的 n 小时内你能获得的 最大 总强化能量。
 * <p>
 * 注意 你可以选择从饮用任意一种能量饮料开始。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 第一个小时饮用能量饮料 A。
 * 切换到能量饮料 B ，在第二个小时无法获得强化能量。
 * 第三个小时饮用能量饮料 B ，并获得强化能量。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == energyDrinkA.length == energyDrinkB.length
 * 3 <= n <= 105
 * 1 <= energyDrinkA[i], energyDrinkB[i] <= 105
 */
public class Code14 {

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        //动态规划数组
        long[] aArr = new long[energyDrinkA.length];
        long[] bArr = new long[energyDrinkB.length];
        //初始化
        aArr[0] = energyDrinkA[0];
        bArr[0] = energyDrinkB[0];
        aArr[1] = energyDrinkA[0] + energyDrinkA[1];
        bArr[1] = energyDrinkB[0] + energyDrinkB[1];
        //循环
        for (int i = 2; i < aArr.length; i++) {
            //分别计算当前时间阶段的动态规划
            aArr[i] = Math.max(aArr[i - 1] + energyDrinkA[i], bArr[i - 2] + energyDrinkA[i]);
            bArr[i] = Math.max(bArr[i - 1] + energyDrinkB[i], aArr[i - 2] + energyDrinkB[i]);
        }
        //返回
        return Math.max(aArr[aArr.length - 1], bArr[bArr.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }

}
