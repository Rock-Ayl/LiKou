package easy33;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-09-03
 * 2833. 距离原点最远的点
 * 提示
 * 简单
 * 4
 * 相关企业
 * 给你一个长度为 n 的字符串 moves ，该字符串仅由字符 'L'、'R' 和 '_' 组成。字符串表示你在一条原点为 0 的数轴上的若干次移动。
 * <p>
 * 你的初始位置就在原点（0），第 i 次移动过程中，你可以根据对应字符选择移动方向：
 * <p>
 * 如果 moves[i] = 'L' 或 moves[i] = '_' ，可以选择向左移动一个单位距离
 * 如果 moves[i] = 'R' 或 moves[i] = '_' ，可以选择向右移动一个单位距离
 * 移动 n 次之后，请你找出可以到达的距离原点 最远 的点，并返回 从原点到这一点的距离 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：moves = "L_RL__R"
 * 输出：3
 * 解释：可以到达的距离原点 0 最远的点是 -3 ，移动的序列为 "LLRLLLR" 。
 * 示例 2：
 * <p>
 * 输入：moves = "_R__LL_"
 * 输出：5
 * 解释：可以到达的距离原点 0 最远的点是 -5 ，移动的序列为 "LRLLLLL" 。
 * 示例 3：
 * <p>
 * 输入：moves = "_______"
 * 输出：7
 * 解释：可以到达的距离原点 0 最远的点是 7 ，移动的序列为 "RRRRRRR" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= moves.length == n <= 50
 * moves 仅由字符 'L'、'R' 和 '_' 组成
 */
public class Code7 {

    //结果
    private int max = Integer.MIN_VALUE;

    //是否走过
    private Set<String> set = new HashSet<>();

    private void next(String moves, int p, int num) {
        //如果到头了
        if (p == moves.length()) {
            //刷新最大
            max = Math.max(max, Math.abs(num));
            //过
            return;
        }
        //唯一key
        String key = p + "," + num;
        //如果走过了
        if (set.contains(key)) {
            //过
            return;
        }
        //记录
        set.add(key);
        //当前
        char space = moves.charAt(p);
        //根据字符操作
        switch (space) {
            case 'R':
                //下一个
                next(moves, p + 1, num + 1);
                break;
            case 'L':
                //下一个
                next(moves, p + 1, num - 1);
                break;
            case '_':
                //两个方向
                next(moves, p + 1, num + 1);
                next(moves, p + 1, num - 1);
                break;
        }
    }

    public int furthestDistanceFromOrigin(String moves) {
        //走下去
        next(moves, 0, 0);
        //返回结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().furthestDistanceFromOrigin("RR_LLL"));
    }

}
