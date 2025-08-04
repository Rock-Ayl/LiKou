package normal45;

/**
 * @Author ayl
 * @Date 2025-08-04
 * 3638. 平衡装运的最大数量
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 weight，表示按直线排列的 n 个包裹的重量。装运 定义为包裹的一个连续子数组。如果一个装运满足以下条件，则称其为 平衡装运：最后一个包裹的重量 严格小于 该装运中所有包裹中 最大重量 。
 * <p>
 * 选择若干个 不重叠 的连续平衡装运，并满足 每个包裹最多出现在一次装运中（部分包裹可以不被装运）。
 * <p>
 * 返回 可以形成的平衡装运的最大数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: weight = [2,5,1,4,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 我们可以形成最多两个平衡装运：
 * <p>
 * 装运 1: [2, 5, 1]
 * 包裹的最大重量 = 5
 * 最后一个包裹的重量 = 1，严格小于 5，因此这是平衡装运。
 * 装运 2: [4, 3]
 * 包裹的最大重量 = 4
 * 最后一个包裹的重量 = 3，严格小于 4，因此这是平衡装运。
 * 无法通过其他方式划分包裹获得超过两个平衡装运，因此答案是 2。
 * <p>
 * 示例 2:
 * <p>
 * 输入: weight = [4,4]
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 在这种情况下无法形成平衡装运：
 * <p>
 * 装运 [4, 4] 的最大重量为 4，而最后一个包裹的重量也是 4，不严格小于最大重量，因此不是平衡的。
 * 单个包裹的装运 [4] 中，最后一个包裹的重量等于最大重量，因此也不是平衡的。
 * 由于无法形成任何平衡装运，答案是 0。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= n <= 105
 * 1 <= weight[i] <= 109
 */
public class Code17 {

    public int maxBalancedShipments(int[] weight) {
        //次数
        int count = 0;
        //索引
        int index = 1;
        //循环
        while (index < weight.length) {
            //如果是
            if (weight[index - 1] > weight[index]) {
                //+1
                count++;
                //进位
                index += 2;
            } else {
                //+1
                index++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maxBalancedShipments(new int[]{2, 5, 1, 4, 3}));
    }

}
