package normal10;

/**
 * @Author ayl
 * @Date 2022-01-15
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * 总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。
 * <p>
 * Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
 * <p>
 * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
 * 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
 * Alice 和 Bob 不能 从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：colors = "AAABABB"
 * 输出：true
 * 解释：
 * AAABABB -> AABABB
 * Alice 先操作。
 * 她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。
 * <p>
 * 现在轮到 Bob 操作。
 * Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
 * 因此，Alice 获胜，返回 true 。
 * 示例 2：
 * <p>
 * 输入：colors = "AA"
 * 输出：false
 * 解释：
 * Alice 先操作。
 * 只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
 * 因此，Bob 获胜，返回 false 。
 * 示例 3：
 * <p>
 * 输入：colors = "ABBBBBBBAAA"
 * 输出：false
 * 解释：
 * ABBBBBBBAAA -> ABBBBBBBAA
 * Alice 先操作。
 * 她唯一的选择是删除从右数起第二个 'A' 。
 * <p>
 * ABBBBBBBAA -> ABBBBBBAA
 * 接下来轮到 Bob 操作。
 * 他有许多选择，他可以选择任何一个 'B' 删除。
 * <p>
 * 然后轮到 Alice 操作，她无法删除任何片段。
 * 所以 Bob 获胜，返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= colors.length <= 105
 * colors 只包含字母 'A' 和 'B'
 */
public class Code3 {

    public boolean winnerOfGame(String colors) {
        //两人分别可操作性次数
        int a = 0, b = 0;
        //转化为列表
        char[] arr = colors.toCharArray();
        //初始化第一个
        char last = arr[0];
        //连击次数
        int comb = 1;
        //循环统计
        for (int i = 1; i < arr.length; i++) {
            //当前
            char space = arr[i];
            //如果连击
            if (space == last) {
                //+1
                comb++;
            } else {
                //如果无事发生
                if (comb > 2) {
                    //判断谁增加操作次数
                    if (last == 'A') {
                        //记录
                        a += comb - 2;
                    } else {
                        //记录
                        b += comb - 2;
                    }
                }
                //刷新
                comb = 1;
                last = space;
            }
        }
        //最后结束刷新
        if (comb > 2) {
            //判断谁增加操作次数
            if (last == 'A') {
                //记录
                a += comb - 2;
            } else {
                //记录
                b += comb - 2;
            }
        }
        //返回
        return a > b;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().winnerOfGame("ABBBBBBBAAA"));
    }
}
