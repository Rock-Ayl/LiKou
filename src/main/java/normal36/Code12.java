package normal36;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-10-22
 * 2491. 划分技能点相等的团队
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 skill ，数组长度为 偶数 n ，其中 skill[i] 表示第 i 个玩家的技能点。将所有玩家分成 n / 2 个 2 人团队，使每一个团队的技能点之和 相等 。
 * <p>
 * 团队的 化学反应 等于团队中玩家的技能点 乘积 。
 * <p>
 * 返回所有团队的 化学反应 之和，如果无法使每个团队的技能点之和相等，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：skill = [3,2,5,1,3,4]
 * 输出：22
 * 解释：
 * 将玩家分成 3 个团队 (1, 5), (2, 4), (3, 3) ，每个团队的技能点之和都是 6 。
 * 所有团队的化学反应之和是 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22 。
 * 示例 2：
 * <p>
 * 输入：skill = [3,4]
 * 输出：12
 * 解释：
 * 两个玩家形成一个团队，技能点之和是 7 。
 * 团队的化学反应是 3 * 4 = 12 。
 * 示例 3：
 * <p>
 * 输入：skill = [1,1,2,3]
 * 输出：-1
 * 解释：
 * 无法将玩家分成每个团队技能点都相等的若干个 2 人团队。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= skill.length <= 105
 * skill.length 是偶数
 * 1 <= skill[i] <= 1000
 */
public class Code12 {

    public long dividePlayers(int[] skill) {
        //求取每个团队的目标数字
        int groupSum = Arrays.stream(skill).sum() / (skill.length / 2);
        //缓存
        Map<Integer, Integer> countMap = new HashMap<>();
        //和
        long sum = 0L;
        //循环
        for (int num : skill) {
            //另一半应该是多少
            int other = groupSum - num;
            //如果不存在
            if (countMap.containsKey(other) == false) {
                //存入
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                //本轮过
                continue;
            }
            //叠加本次和
            sum += num * other;
            //获取对应数量
            int otherCount = countMap.getOrDefault(other, 0);
            //判断是删除还是减1
            if (otherCount < 2) {
                //删除
                countMap.remove(other);
            } else {
                //减1
                countMap.put(other, otherCount - 1);
            }
        }
        //如果还有
        if (countMap.isEmpty() == false) {
            //不可以
            return -1;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }

}
