package normal26;

/**
 * @Author ayl
 * @Date 2023-11-24
 * 2579. 统计染色格子数
 * 提示
 * 中等
 * 8
 * 相关企业
 * 有一个无穷大的二维网格图，一开始所有格子都未染色。给你一个正整数 n ，表示你需要执行以下步骤 n 分钟：
 * <p>
 * 第一分钟，将 任一 格子染成蓝色。
 * 之后的每一分钟，将与蓝色格子相邻的 所有 未染色格子染成蓝色。
 * 下图分别是 1、2、3 分钟后的网格图。
 * <p>
 * <p>
 * 请你返回 n 分钟之后 被染色的格子 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 分钟后，只有 1 个蓝色的格子，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：5
 * 解释：2 分钟后，有 4 个在边缘的蓝色格子和 1 个在中间的蓝色格子，所以返回 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10.5
 */
public class Code9 {

    public long coloredCells(int n) {
        //计算次数对应的正方形边
        long length = n * 2 - 1;
        //正方形面积
        long all = length * length;
        //计算结果
        return all - (all - 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().coloredCells(3));
    }
}
