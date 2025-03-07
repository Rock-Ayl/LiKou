package easy35;

/**
 * @Author ayl
 * @Date 2024-02-03
 * 3000. 对角线最长的矩形的面积
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 dimensions。
 * <p>
 * 对于所有下标 i（0 <= i < dimensions.length），dimensions[i][0] 表示矩形 i 的长度，而 dimensions[i][1] 表示矩形 i 的宽度。
 * <p>
 * 返回对角线最 长 的矩形的 面积 。如果存在多个对角线长度相同的矩形，返回面积最 大 的矩形的面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dimensions = [[9,3],[8,6]]
 * 输出：48
 * 解释：
 * 下标 = 0，长度 = 9，宽度 = 3。对角线长度 = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487。
 * 下标 = 1，长度 = 8，宽度 = 6。对角线长度 = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10。
 * 因此，下标为 1 的矩形对角线更长，所以返回面积 = 8 * 6 = 48。
 * 示例 2：
 * <p>
 * 输入：dimensions = [[3,4],[4,3]]
 * 输出：12
 * 解释：两个矩形的对角线长度相同，为 5，所以最大面积 = 12。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dimensions.length <= 100
 * dimensions[i].length == 2
 * 1 <= dimensions[i][0], dimensions[i][1] <= 100
 */
public class Code24 {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        //最大结果
        int result = 0;
        //最大对角线
        int maxSqrt = 0;
        //循环
        for (int[] dimension : dimensions) {
            //计算权重
            int sqrt = (dimension[0] * dimension[0]) + (dimension[1] * dimension[1]);
            //如果更大可能
            if (sqrt > maxSqrt) {
                //刷新结果
                maxSqrt = sqrt;
                result = dimension[0] * dimension[1];
                //本轮过
                continue;
            }
            //如果更大可能
            if (sqrt == maxSqrt) {
                //尝试计算更大
                result = Math.max((dimension[0] * dimension[1]), result);
                //本轮过
                continue;
            }
        }
        //返回最大结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().areaOfMaxDiagonal(new int[][]{
                new int[]{2, 10},
                new int[]{8, 6}
        }));
    }

}
