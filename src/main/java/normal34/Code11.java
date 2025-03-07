package normal34;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-08-20
 * LCP 30. 魔塔游戏
 * 中等
 * 相关标签
 * 相关企业
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * <p>
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
 * <p>
 * 输出：1
 * <p>
 * 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-200,-300,400,0]
 * <p>
 * 输出：-1
 * <p>
 * 解释：调整访问顺序也无法完成全部房间的访问。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 */
public class Code11 {

    public int magicTower(int[] nums) {
        //初始化结果、最少调整次数
        int resultMinChangeCount = 0;
        //优先队列,每次返回 单次已经被扣除的最大血量
        PriorityQueue<Integer> useList = new PriorityQueue<>();
        //生命值
        long life = 1L;
        //已经调整到末尾的和
        long theLastSum = 0L;
        //循环
        for (int num : nums) {
            //如果是 加血
            if (num >= 0) {
                //直接叠加
                life += num;
                //本轮过
                continue;
            }
            //先扣除
            useList.add(num);
            life += num;
            //如果还有血
            if (life >= 1L) {
                //本轮过
                continue;
            }
            //获取当前单词最大扣除血量
            Integer maxUse = useList.poll();
            //治疗回来
            life -= maxUse;
            //加入末尾队列
            theLastSum += maxUse;
            //记录次数
            resultMinChangeCount++;
        }
        //如果不够存活
        if (life + theLastSum < 1L) {
            //不可以
            return -1;
        }
        //返回次数
        return resultMinChangeCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
    }

}
