package normal49;

/**
 * 2140. 解决智力问题
 * 算术评级: 5
 * 第 276 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1709
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
 * <p>
 * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
 * <p>
 * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
 * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
 * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
 * 请你返回这场考试里你能获得的 最高 分数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：questions = [[3,2],[4,3],[4,4],[2,5]]
 * 输出：5
 * 解释：解决问题 0 和 3 得到最高分。
 * - 解决问题 0 ：获得 3 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 1 和 2
 * - 解决问题 3 ：获得 2 分
 * 总得分为：3 + 2 = 5 。没有别的办法获得 5 分或者多于 5 分。
 * 示例 2：
 * <p>
 * 输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * 输出：7
 * 解释：解决问题 1 和 4 得到最高分。
 * - 跳过问题 0
 * - 解决问题 1 ：获得 2 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 2 和 3
 * - 解决问题 4 ：获得 5 分
 * 总得分为：2 + 5 = 7 。没有别的办法获得 7 分或者多于 7 分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= questions.length <= 105
 * questions[i].length == 2
 * 1 <= pointsi, brainpoweri <= 105
 */
public class Code18 {

    public long mostPoints(int[][] questions) {
        //目标结果
        long max = 0L;
        //dp 当前节点之前允许的结果
        long[] lastArr = new long[questions.length];
        //循环
        for (int i = 0; i < questions.length; i++) {
            //如果后面还有
            if (i > 0) {
                //继承前人的
                lastArr[i] = Math.max(lastArr[i], lastArr[i - 1]);
            }
            //当前分数最大和
            long rankSum = questions[i][0] + lastArr[i];
            //下一个允许的节点
            int nextIndex = i + questions[i][1] + 1;
            //如果还有下一个节点
            if (nextIndex < questions.length) {
                //刷新下一个节点最大分数
                lastArr[nextIndex] = Math.max(lastArr[nextIndex], rankSum);
            }
            //刷新最大结果
            max = Math.max(max, rankSum);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {

        /*

        *System.out.println(new Code18().mostPoints(new int[][]{
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{4, 4},
                new int[]{5, 5}
        }));

        */

        System.out.println(new Code18().mostPoints(new int[][]{
                new int[]{21, 5},
                new int[]{92, 3},
                new int[]{74, 2},
                new int[]{39, 4},
                new int[]{58, 2},
                new int[]{5, 5},
                new int[]{49, 4},
                new int[]{65, 3}
        }));

    }

}
