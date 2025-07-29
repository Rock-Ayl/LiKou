package normal45;

/**
 * @Author ayl
 * @Date 2025-07-29
 * 983. 最低票价
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有 三种不同的销售方式 ：
 * <p>
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * <p>
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class Code12 {

    public int mincostTickets(int[] days, int[] costs) {
        //动态规划
        int[] arr = new int[days.length];
        //每张票锁覆盖的时间
        int[] coverArr = new int[]{1, 7, 30};
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //当前时间
            int day = days[i];
            //默认
            if (i > 0) {
                //初始化
                arr[i] = arr[i - 1] + costs[0];
            } else {
                //初始化
                arr[i] = costs[0];
            }
            //循环2
            for (int j = 1; j < costs.length; j++) {
                //本次花费
                int cost = costs[j];
                //覆盖的时间
                int coverDay = coverArr[j];
                //最早生效时间
                int target = day - coverDay + 1;
                //如果完全覆盖
                if (target <= days[0]) {
                    //计算最小
                    arr[i] = Math.min(arr[i], cost);
                    //本轮过
                    continue;
                }
                //寻找
                int index = findIndex(days, target, 0, i - 1);
                //如果有结果
                if (index != -1) {
                    //计算最小
                    arr[i] = Math.min(arr[i], cost + arr[index]);
                }
            }
        }

        //返回
        return arr[arr.length - 1];
    }

    //递归寻找距离目标值最近的索引
    private int findIndex(int[] days, int target, int start, int end) {
        //结果
        int res = -1;
        //循环
        while (start <= end) {
            //计算中点
            int mid = start + (end - start) / 2;
            //判断左右
            if (days[mid] < target) {
                //右边
                res = mid;
                start = mid + 1;
            } else {
                //左边
                end = mid - 1;
            }
        }
        //默认
        return res == -1 ? 0 : res;
    }

    public static void main(String[] args) {
        //System.out.println(new Code12().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 5, 15}));
        //System.out.println(new Code12().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        //System.out.println(new Code12().mincostTickets(new int[]{1, 5, 8, 9, 10, 12, 13, 16, 17, 18, 19, 20, 23, 24, 29}, new int[]{3, 12, 54}));
        //System.out.println(new Code12().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        //System.out.println(new Code12().mincostTickets(new int[]{1, 5, 8, 9, 10, 12, 13, 16, 17, 18, 19, 20, 23, 24, 29}, new int[]{3, 12, 54}));
        //System.out.println(new Code12().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(new Code12().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));
    }

}
