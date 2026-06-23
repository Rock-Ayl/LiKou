package normal54;

/**
 * 3968. 移动后的最大曼哈顿距离
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由字符 'U'、'D'、'L'、'R' 和 '_' 组成的字符串 moves。
 * <p>
 * 从原点 (0, 0) 出发，每个字符表示二维平面上的一次移动：
 * <p>
 * 'U'：向上移动 1 个单位。
 * 'D'：向下移动 1 个单位。
 * 'L'：向左移动 1 个单位。
 * 'R'：向右移动 1 个单位。
 * '_'：可以独立地替换为 'U'、'D'、'L' 或 'R' 中的任意一个字符。
 * 返回执行完所有移动后，能够达到的距离原点的 最大曼哈顿距离 。
 * <p>
 * 两点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 |x1 - x2| + |y1 - y2|。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： moves = "L_D_"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 一种最优选择为：
 * <p>
 * 'L'：(0, 0) -> (-1, 0)
 * 将 '_' 视为 'D'：(-1, 0) -> (-1, -1)
 * 'D'：(-1, -1) -> (-1, -2)
 * 将 '_' 视为 'L'：(-1, -2) -> (-2, -2)
 * 最终位置到原点的曼哈顿距离为 |0 - (-2)| + |0 - (-2)| = 4。
 * <p>
 * 示例 2：
 * <p>
 * 输入： moves = "U_R"
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 一种最优选择为：
 * <p>
 * 'U'：(0, 0) -> (0, 1)
 * 将 '_' 视为 'U'：(0, 1) -> (0, 2)
 * 'R'：(0, 2) -> (1, 2)
 * 最终位置到原点的曼哈顿距离为 |0 - 1| + |0 - 2| = 3。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= moves.length <= 105
 * moves 仅由 'U'、'D'、'L'、'R' 和 '_' 组成。
 */
public class Code14 {

    public int maxDistance(String moves) {
        //上下、左右、自选
        int upDown = 0;
        int leftRight = 0;
        int other = 0;
        //循环
        for (int i = 0; i < moves.length(); i++) {
            //当前字符
            char letter = moves.charAt(i);
            //判断
            if (letter == 'U') {
                //+1
                upDown++;
            } else if (letter == 'D') {
                //-1
                upDown--;
            } else if (letter == 'L') {
                //+1
                leftRight++;
            } else if (letter == 'R') {
                //-1
                leftRight--;
            } else if (letter == '_') {
                //+1
                other++;
            }
        }
        //返回
        return other + Math.abs(upDown) + Math.abs(leftRight);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maxDistance("L_D_"));
    }

}
