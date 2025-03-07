package normal31;

/**
 * @Author ayl
 * @Date 2024-05-06
 * LCR 121. 寻找目标值 - 二维数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
 * <p>
 * 每行中，每棵植物的右侧相邻植物不矮于该植物；
 * 每列中，每棵植物的下侧相邻植物不矮于该植物。
 * <p>
 * <p>
 * 请判断 plants 中是否存在目标高度值 target。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：plants = [[2,3,6,8],[4,5,8,9],[5,9,10,12]], target = 8
 * <p>
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：plants = [[1,3,5],[2,5,7]], target = 4
 * <p>
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Code11 {

    //实现单个二分
    private boolean next(int[] plant, int target, int left, int right) {
        //如果越界
        if (left > right) {
            //过
            return false;
        }
        //如果只有一个点
        if (left + 1 >= right) {
            //过
            return plant[left] == target || plant[right] == target;
        }
        //计算出中间点
        int mid = (right - left) / 2 + left;
        //如果是目标节点
        if (plant[mid] == target) {
            //过
            return true;
        }
        //判断下一步的方向、并递归
        if (plant[mid] > target) {
            //继续
            return next(plant, target, left, mid);
        } else {
            //继续
            return next(plant, target, mid, right);
        }
    }

    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        //循环
        for (int[] plant : plants) {
            //如果找到了
            if (next(plant, target, 0, plant.length - 1)) {
                //结束
                return true;
            }
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().findTargetIn2DPlants(new int[][]{
                new int[]{-5}
        }, -2));
    }

}
