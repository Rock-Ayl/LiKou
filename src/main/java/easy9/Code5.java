package easy9;

/**
 * @Author 安永亮
 * @Date 2021-06-17
 * @Description 1812. 判断国际象棋棋盘中一个格子的颜色
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * <p>
 * <p>
 * <p>
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * <p>
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * 示例 2：
 * <p>
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 * <p>
 * 输入：coordinates = "c7"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 */
public class Code5 {

    public boolean squareIsWhite(String coordinates) {
        //数字
        int num = coordinates.charAt(1) - '0';
        //是否为奇数
        boolean isSingle;
        //如果是偶数
        if (num % 2 == 0) {
            //偶数
            isSingle = false;
        } else {
            //奇数
            isSingle = true;
        }
        //是否为奇数
        boolean isSingle2;
        //字符转化为奇偶数
        int space = coordinates.charAt(0) - 'b';
        //如果是偶数
        if (space % 2 == 0) {
            //偶数
            isSingle2 = false;
        } else {
            //奇数
            isSingle2 = true;
        }
        //相同为黑色
        if (isSingle == isSingle2) {
            //返回
            return false;
        } else {
            //白色
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code5().squareIsWhite("h3"));
    }

}
