package normal34;

/**
 * @Author ayl
 * @Date 2024-08-21
 * 3147. 从魔法师身上吸取的最大能量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在神秘的地牢中，n 个魔法师站成一排。每个魔法师都拥有一个属性，这个属性可以给你提供能量。有些魔法师可能会给你负能量，即从你身上吸取能量。
 * <p>
 * 你被施加了一种诅咒，当你从魔法师 i 处吸收能量后，你将被立即传送到魔法师 (i + k) 处。这一过程将重复进行，直到你到达一个不存在 (i + k) 的魔法师为止。
 * <p>
 * 换句话说，你将选择一个起点，然后以 k 为间隔跳跃，直到到达魔法师序列的末端，在过程中吸收所有的能量。
 * <p>
 * 给定一个数组 energy 和一个整数k，返回你能获得的 最大 能量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： energy = [5,2,-10,-5,1], k = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：可以从魔法师 1 开始，吸收能量 2 + 1 = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： energy = [-2,-3,-1], k = 2
 * <p>
 * 输出： -1
 * <p>
 * 解释：可以从魔法师 2 开始，吸收能量 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= energy.length <= 105
 * -1000 <= energy[i] <= 1000
 * 1 <= k <= energy.length - 1
 */
public class Code12 {

    public int maximumEnergy(int[] energy, int k) {
        //循环
        for (int i = k; i < energy.length; i++) {
            //计算本位置最大可能
            energy[i] = energy[i] + Math.max(0, energy[i - k]);
        }
        //默认最大情况
        int max = energy[energy.length - 1];
        //循环
        for (int i = energy.length - k; i < energy.length; i++) {
            //刷新最大情况
            max = Math.max(max, energy[i]);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
    }
}
