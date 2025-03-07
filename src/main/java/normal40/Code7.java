package normal40;

/**
 * @Author ayl
 * @Date 2025-02-16
 * 3207. 与敌人战斗后的最大分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 enemyEnergies ，它表示一个下标从 0 开始的敌人能量数组。
 * <p>
 * 同时给你一个整数 currentEnergy ，它表示你一开始拥有的能量值总量。
 * <p>
 * 你一开始的分数为 0 ，且一开始所有的敌人都未标记。
 * <p>
 * 你可以通过以下操作 之一 任意次（也可以 0 次）来得分：
 * <p>
 * 选择一个 未标记 且满足 currentEnergy >= enemyEnergies[i] 的敌人 i 。在这个操作中：
 * 你会获得 1 分。
 * 你的能量值减少 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy - enemyEnergies[i] 。
 * 如果你目前 至少 有 1 分，你可以选择一个 未标记 的敌人 i 。在这个操作中：
 * 你的能量值增加 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy + enemyEnergies[i] 。
 * 敌人 i 被标记 。
 * 请你返回通过以上操作，最多 可以获得多少分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：enemyEnergies = [3,2,2], currentEnergy = 2
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 通过以下操作可以得到最大得分 3 分：
 * <p>
 * 对敌人 1 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 1 且 currentEnergy = 0 。
 * 对敌人 0 使用第二种操作：currentEnergy 增加 3 ，敌人 0 被标记。所以 points = 1 ，currentEnergy = 3 ，被标记的敌人包括 [0] 。
 * 对敌人 2 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 2 且 currentEnergy = 1 ，被标记的敌人包括[0] 。
 * 对敌人 2 使用第二种操作：currentEnergy 增加 2 ，敌人 2 被标记。所以 points = 2 ，currentEnergy = 3 且被标记的敌人包括 [0, 2] 。
 * 对敌人 1 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 3 ，currentEnergy = 1 ，被标记的敌人包括 [0, 2] 。
 * 示例 2：
 * <p>
 * 输入：enemyEnergies = [2], currentEnergy = 10
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 通过对敌人 0 进行第一种操作 5 次，得到最大得分。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= enemyEnergies.length <= 105
 * 1 <= enemyEnergies[i] <= 109
 * 0 <= currentEnergy <= 109
 */
public class Code7 {

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        //最小能量
        int min = Integer.MAX_VALUE;
        //当前能量、转类型
        long energy = currentEnergy;
        //循环
        for (int enemyEnergy : enemyEnergies) {
            //叠加能量
            energy += enemyEnergy;
            //刷新最小
            min = Math.min(min, enemyEnergy);
        }
        //如果最小的比当前拥有的大
        if (min > currentEnergy) {
            //结束
            return 0L;
        }
        //计算出可以扣几次(积分),需要删除最后一个min的得分
        return energy / min - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maximumPoints(new int[]{3, 2, 2}, 2));
    }

}
