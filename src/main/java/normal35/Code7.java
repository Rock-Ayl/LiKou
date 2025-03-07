package normal35;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-09-20
 * 3175. 找到连续赢 K 场比赛的第一位玩家
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
 * <p>
 * 给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不相同 。
 * <p>
 * 所有玩家从编号 0 到 n - 1 排成一列。
 * <p>
 * 比赛进行方式如下：
 * <p>
 * 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
 * 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
 * 这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
 * <p>
 * 请你返回这个比赛的赢家编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：skills = [4,2,6,3,9], k = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 一开始，队列里的玩家为 [0,1,2,3,4] 。比赛过程如下：
 * <p>
 * 玩家 0 和 1 进行一场比赛，玩家 0 的技能等级高于玩家 1 ，玩家 0 胜出，队列变为 [0,2,3,4,1] 。
 * 玩家 0 和 2 进行一场比赛，玩家 2 的技能等级高于玩家 0 ，玩家 2 胜出，队列变为 [2,3,4,1,0] 。
 * 玩家 2 和 3 进行一场比赛，玩家 2 的技能等级高于玩家 3 ，玩家 2 胜出，队列变为 [2,4,1,0,3] 。
 * 玩家 2 连续赢了 k = 2 场比赛，所以赢家是玩家 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：skills = [2,5,4], k = 3
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 一开始，队列里的玩家为 [0,1,2] 。比赛过程如下：
 * <p>
 * 玩家 0 和 1 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
 * 玩家 1 和 2 进行一场比赛，玩家 1 的技能等级高于玩家 2 ，玩家 1 胜出，队列变为 [1,0,2] 。
 * 玩家 1 和 0 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
 * 玩家 1 连续赢了 k = 3 场比赛，所以赢家是玩家 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == skills.length
 * 2 <= n <= 105
 * 1 <= k <= 109
 * 1 <= skills[i] <= 106
 * skills 中的整数互不相同。
 */
public class Code7 {

    //用户
    private static class User {

        //编号
        private int number;

        //技能
        private int skill;

        //赢下的对手
        private Set<User> successSet = new HashSet<>();

        //初始化
        public User(int number, int skill) {
            this.number = number;
            this.skill = skill;
        }

    }

    public int findWinningPlayer(int[] skills, int k) {
        //双端队列
        ArrayDeque<User> arrayDeque = new ArrayDeque<>();
        //循环
        for (int i = 0; i < skills.length; i++) {
            //初始化用户实体,并组装
            arrayDeque.addLast(new User(i, skills[i]));
        }
        //如果还没有人连胜
        while (true) {
            //获取前两个
            User first = arrayDeque.pollFirst();
            User second = arrayDeque.pollFirst();
            //判断大小
            User big = first.skill > second.skill ? first : second;
            User small = first.skill > second.skill ? second : first;
            //清算胜负
            small.successSet.clear();
            big.successSet.add(small);
            //获取目前连胜
            int successHit = big.successSet.size();
            //如果已经赢过了所有人 or 达到目标连胜
            if (successHit >= skills.length - 1 || successHit >= k) {
                //直接返回
                return big.number;
            }
            //重新放回
            arrayDeque.addFirst(big);
            arrayDeque.addLast(small);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code7().findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
    }


}
