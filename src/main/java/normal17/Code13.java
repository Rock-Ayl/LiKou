package normal17;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-12-04
 * 2410. 运动员和训练师的最大匹配数
 * 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
 * <p>
 * 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
 * <p>
 * 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：players = [4,7,9], trainers = [8,2,5,8]
 * 输出：2
 * 解释：
 * 得到两个匹配的一种方案是：
 * - players[0] 与 trainers[0] 匹配，因为 4 <= 8 。
 * - players[1] 与 trainers[3] 匹配，因为 7 <= 8 。
 * 可以证明 2 是可以形成的最大匹配数。
 * 示例 2：
 * <p>
 * 输入：players = [1,1,1], trainers = [10]
 * 输出：1
 * 解释：
 * 训练师可以匹配所有 3 个运动员
 * 每个运动员至多只能匹配一个训练师，所以最大答案是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= players.length, trainers.length <= 105
 * 1 <= players[i], trainers[j] <= 109
 */
public class Code13 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        //排序
        Arrays.sort(players);
        Arrays.sort(trainers);
        //数量
        int count = 0;
        //双指针
        int p1 = 0;
        int p2 = 0;
        //循环
        while (p2 < trainers.length && p1 < players.length) {
            //如果可以匹配
            if (players[p1++] <= trainers[p2++]) {
                //进位
                count++;
                //本轮过
                continue;
            }
            //回滚
            p1--;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
    }

}
