package easy6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-28
 * 1033. 移动石子直到连续
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * <p>
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 */
public class Code1 {

    public static int[] numMovesStones(int a, int b, int c) {
        //放入组里
        List<Integer> list = new ArrayList<>();
        //组装
        list.add(a);
        list.add(b);
        list.add(c);
        //排序
        Collections.sort(list);
        //最小的
        int x = list.get(0);
        //中间
        int y = list.get(1);
        //最大的
        int z = list.get(2);
        //初始化结果
        int[] result = new int[2];
        //最小次数
        int minSize = 0;
        //左右两差
        int left = y - x - 1, right = z - y - 1;
        //如果有一个是特殊情况
        if (left == 0 && right == 0) {

        }
        //如果有一个是特殊情况
        else if (left == 0 || right == 0) {
            //一下就成
            minSize = 1;
        } else {
            //计算当前最小间距
            int space = Math.min(left, right);
            //当间距还存在时
            while (space > 0) {
                //间距缩小
                space = space / 2;
                //计算最小次数
                minSize++;
            }
            //最大为2
            minSize = Math.min(2, minSize);
        }
        //记录最小次数
        result[0] = minSize;
        //直接计算出最大次数
        result[1] = 0 + left + right;
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : numMovesStones(21, 27, 3)) {
            System.out.println(i);
        }
    }
}
