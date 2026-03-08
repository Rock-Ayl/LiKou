package easy42;

/**
 * 101010. 容量最小的箱子
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 capacity，其中 capacity[i] 表示第 i 个箱子的容量，以及一个整数 itemSize，表示一个物品的大小。
 * <p>
 * 如果第 i 个箱子的容量满足 capacity[i] >= itemSize，那么该箱子可以存放该物品。
 * <p>
 * 要求返回可以存放该物品的容量 最小 的箱子的下标。如果有多个这样的箱子，返回下标 最小 的一个。
 * <p>
 * 如果没有任何箱子可以存放该物品，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： capacity = [1,5,3,7], itemSize = 3
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 下标为 2 的箱子容量为 3，是可以存放该物品的容量最小的箱子，因此答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： capacity = [3,5,4,3], itemSize = 2
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 可以存放该物品的最小容量为 3，出现在下标 0 和 3。由于下标 0 更小，因此答案是 0。
 * <p>
 * 示例 3：
 * <p>
 * 输入： capacity = [4], itemSize = 5
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 没有任何箱子的容量足够存放该物品，因此答案是 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity.length <= 100
 * 1 <= capacity[i] <= 100
 * 1 <= itemSize <= 100
 */
public class Code15 {

    public int minimumIndex(int[] capacity, int itemSize) {
        //结果
        int result = -1;
        int min = Integer.MAX_VALUE;
        //循环
        for (int i = 0; i < capacity.length; i++) {
            //当前
            int num = capacity[i];
            //如果满足
            if (num >= itemSize && num < min) {
                //更新结果
                result = i;
                //更新最小容量
                min = num;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().minimumIndex(new int[]{1, 5, 3, 7}, 3));
    }

}
