package easy42;

/**
 * 836. 矩形重叠
 * 尝试过
 * 算术评级: 3
 * 第 85 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1443
 * 相关标签
 * premium lock icon
 * 相关企业
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 * <p>
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * rect1.length == 4
 * rect2.length == 4
 * -109 <= rec1[i], rec2[i] <= 109
 * rec1 和 rec2 表示一个面积不为零的有效矩形
 */
public class Code17 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //如果x轴不相交
        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2]) {
            //过
            return false;
        }
        //如果y轴不相交
        if (rec1[1] >= rec2[3] || rec2[1] >= rec1[3]) {
            //过
            return false;
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        new Code17().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3});
    }

}