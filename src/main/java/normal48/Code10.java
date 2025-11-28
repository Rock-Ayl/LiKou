package normal48;

/**
 * @Author ayl
 * @Date 2025-11-28
 * 3227. 字符串元音游戏
 * 算术评级: 4
 * 第 407 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1452
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 小红和小明在玩一个字符串元音游戏。
 * <p>
 * 给你一个字符串 s，小红和小明将轮流参与游戏，小红 先 开始：
 * <p>
 * 在小红的回合，她必须移除 s 中包含 奇数 个元音的任意 非空 子字符串。
 * 在小明的回合，他必须移除 s 中包含 偶数 个元音的任意 非空 子字符串。
 * 第一个无法在其回合内进行移除操作的玩家输掉游戏。假设小红和小明都采取 最优策略 。
 * <p>
 * 如果小红赢得游戏，返回 true，否则返回 false。
 * <p>
 * 英文元音字母包括：a, e, i, o, 和 u。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "leetcoder"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * 小红可以执行如下移除操作来赢得游戏：
 * <p>
 * 小红先手，她可以移除加下划线的子字符串 s = "leetcoder"，其中包含 3 个元音。结果字符串为 s = "der"。
 * 小明接着，他可以移除加下划线的子字符串 s = "der"，其中包含 0 个元音。结果字符串为 s = "er"。
 * 小红再次操作，她可以移除整个字符串 s = "er"，其中包含 1 个元音。
 * 又轮到小明，由于字符串为空，无法执行移除操作，因此小红赢得游戏。
 * 示例 2：
 * <p>
 * 输入： s = "bbcd"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * 小红在她的第一回合无法执行移除操作，因此小红输掉了游戏。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成。
 */
public class Code10 {

    public boolean doesAliceWin(String s) {
        //元音数组
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //循环
        for (char letter : s.toCharArray()) {
            //如果有元音
            if (arr[letter - 'a'] == 1) {
                //赢了
                return true;
            }
        }
        //默认失败
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().doesAliceWin("uc"));
    }

}
