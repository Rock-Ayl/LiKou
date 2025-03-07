package easy38;

/**
 * @Author ayl
 * @Date 2024-09-04
 * 3274. 检查棋盘方格颜色是否相同
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
 * <p>
 * 以下是棋盘的参考图。
 * <p>
 * <p>
 * <p>
 * 如果这两个方格颜色相同，返回 true，否则返回 false。
 * <p>
 * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： coordinate1 = "a1", coordinate2 = "c3"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 两个方格均为黑色。
 * <p>
 * 示例 2：
 * <p>
 * 输入： coordinate1 = "a1", coordinate2 = "h3"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 方格 "a1" 是黑色，而 "h3" 是白色。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * coordinate1.length == coordinate2.length == 2
 * 'a' <= coordinate1[0], coordinate2[0] <= 'h'
 * '1' <= coordinate1[1], coordinate2[1] <= '8'
 */
public class Code8 {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        //分别计算奇偶性
        int left1 = coordinate1.charAt(0) % 2;
        int left2 = coordinate1.charAt(1) % 2;
        int right1 = coordinate2.charAt(0) % 2;
        int right2 = coordinate2.charAt(1) % 2;
        //如果奇偶均相同 or 奇偶均不相同,视为一个颜色
        return (left1 == right1 && left2 == right2) || (left1 != right1 && left2 != right2);
    }

    public static void main(String[] args) {
        System.out.println(new Code8().checkTwoChessboards("h7", "c9"));
    }

}
