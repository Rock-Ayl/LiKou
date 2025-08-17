package easy41;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-08-17
 * 1560. 圆形赛道上经过次数最多的扇区
 * 算术评级: 2
 * 第 203 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1443
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 * <p>
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 * <p>
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, rounds = [1,3,1,2]
 * 输出：[1,2]
 * 解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
 * 1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
 * 其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。
 * 示例 2：
 * <p>
 * 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * 输出：[2]
 * 示例 3：
 * <p>
 * 输入：n = 7, rounds = [1,3,5,7]
 * 输出：[1,2,3,4,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= m <= 100
 * rounds.length == m + 1
 * 1 <= rounds[i] <= n
 * rounds[i] != rounds[i + 1] ，其中 0 <= i < m
 */
public class Code6 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        //结果列表
        List<Integer> result = new ArrayList<>();
        //开始
        int start = rounds[0];
        //结束
        int end = rounds[rounds.length - 1];
        //如果不是目标
        while (start != end) {
            //记录并+1
            result.add(start++);
            //如果越界了
            if (start > n) {
                //重新来
                start = 1;
            }
        }
        //记录结束
        result.add(start);
        //排序
        result.sort((a, b) -> a.compareTo(b));
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code6().mostVisited(3, new int[]{3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1});
        System.out.println();
    }

}
