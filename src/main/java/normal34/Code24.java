package normal34;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-09-09
 * 1705. 吃苹果的最大数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * <p>
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 * <p>
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * <p>
 * 提示：
 * <p>
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 */
public class Code24 {

    //苹果分组类
    public static class AppleGroup {

        //苹果库存
        private int appleStock;

        //到该天,苹果腐烂
        private int theLastDay;

        //初始化
        public AppleGroup(int appleStock, int theLastDay) {
            this.appleStock = appleStock;
            this.theLastDay = theLastDay;
        }

    }

    public int eatenApples(int[] apples, int[] days) {
        //初始化优先队列,按照腐烂时间排列
        PriorityQueue<AppleGroup> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.theLastDay));
        //当前天,从0开始
        int day = 0;
        //当前吃的苹果数量
        int eat = 0;
        //循环
        while (day < apples.length || priorityQueue.isEmpty() == false) {
            //如果还有新的苹果加入
            if (day < apples.length) {
                //初始化苹果分组
                AppleGroup appleGroup = new AppleGroup(apples[day], day + 1 + days[day]);
                //加入优先队列
                priorityQueue.add(appleGroup);
            }
            //获取最应该被吃的
            AppleGroup theLastGroup = priorityQueue.poll();
            //如果有苹果 and 该苹果腐烂了
            while (theLastGroup != null && theLastGroup.theLastDay <= day + 1) {
                //先扔了
                theLastGroup = null;
                //如果还有
                if (priorityQueue.isEmpty() == false) {
                    //获取下一个苹果
                    theLastGroup = priorityQueue.poll();
                }
            }
            //如果有未腐烂的苹果
            if (theLastGroup != null) {
                //吃一个
                eat++;
                //如果还有多个
                if (--theLastGroup.appleStock > 0) {
                    //重新加入
                    priorityQueue.add(theLastGroup);
                }
            }
            //下一天
            day++;
        }
        //返回最终苹果的数量
        return eat;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }

}
