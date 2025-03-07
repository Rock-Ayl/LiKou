package easy30;

/**
 * @Author ayl
 * @Date 2023-05-01
 * 6341. 保龄球游戏的获胜者
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * <p>
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * <p>
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * 如果玩家在前两轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：player1 = [4,10,7,9], player2 = [6,5,2,3]
 * 输出：1
 * 解释：player1 的得分是 4 + 10 + 2*7 + 2*9 = 46 。
 * player2 的得分是 6 + 5 + 2 + 3 = 16 。
 * player1 的得分高于 player2 的得分，所以 play1 在比赛中获胜，答案为 1 。
 * 示例 2：
 * <p>
 * 输入：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * 输出：2
 * 解释：player1 的得分是 3 + 5 + 7 + 6 = 21 。
 * player2 的得分是 8 + 10 + 2*10 + 2*2 = 42 。
 * player2 的得分高于 player1 的得分，所以 play2 在比赛中获胜，答案为 2 。
 * 示例 3：
 * <p>
 * 输入：player1 = [2,3], player2 = [4,1]
 * 输出：0
 * 解释：player1 的得分是 2 + 3 = 5 。
 * player2 的得分是 4 + 1 = 5 。
 * player1 的得分等于 player2 的得分，所以这一场比赛平局，答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == player1.length == player2.length
 * 1 <= n <= 1000
 * 0 <= player1[i], player2[i] <= 10
 */
public class Code16 {

    public int isWinner(int[] player1, int[] player2) {
        //双方得分
        int oneSum = player1[0];
        int twoSum = player2[0];
        //如果够长
        if (player1.length > 1) {
            //如果第一个是连击
            if (player1[0] == 10) {
                //*2
                oneSum += player1[1] * 2;
            } else {
                //*1
                oneSum += player1[1];
            }
            //循环
            for (int i = 2; i < player1.length; i++) {
                //如果前两轮有连击
                if (player1[i - 1] == 10 || player1[i - 2] == 10) {
                    //*2
                    oneSum += player1[i] * 2;
                } else {
                    //*1
                    oneSum += player1[i];
                }
            }
        }
        //如果够长
        if (player2.length > 1) {
            //如果第一个是连击
            if (player2[0] == 10) {
                //*2
                twoSum += player2[1] * 2;
            } else {
                //*1
                twoSum += player2[1];
            }
            for (int i = 2; i < player2.length; i++) {
                //如果前两轮有连击
                if (player2[i - 1] == 10 || player2[i - 2] == 10) {
                    //*2
                    twoSum += player2[i] * 2;
                } else {
                    //*1
                    twoSum += player2[i];
                }
            }
        }
        //判断
        if (oneSum > twoSum) {
            //1赢
            return 1;
        } else if (oneSum < twoSum) {
            //2赢
            return 2;
        } else {
            //平局
            return 0;
        }
    }

    public static void main(String[] args) {
        new Code16().isWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3});
    }

}
