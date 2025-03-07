package normal32;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-05-23
 * 1642. 可以到达的最远建筑
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * 示例 2：
 * <p>
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 * 示例 3：
 * <p>
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 */
public class Code3 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //一个优先队列,已经使用的砖头都会进来,单次使用砖头越多,优先级越高
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        //指针
        int p = 0;
        //循环
        while (p < heights.length - 1) {
            //开始、结束的坐标
            int start = heights[p];
            int end = heights[p + 1];
            //如果不需要任何帮助
            if (start >= end) {
                //+1
                ++p;
                //本轮过
                continue;
            }
            //计算出需要的砖头
            int need = end - start;
            //如果砖头够
            if (bricks >= need) {
                //优先用砖头
                bricks -= need;
                //记录该砖头的使用量
                priorityQueue.add(need);
                //+1
                ++p;
                //本轮过
                continue;
            }
            //如果没有梯子了
            if (ladders < 1) {
                //彻底跳出
                break;
            }
            //拿出已经使用过的、最大的转头
            Integer theBig = priorityQueue.peek();
            //如果使用过的、比当前的差距的要大
            if (theBig != null && theBig > need) {
                //原来的砖头使用梯子
                --ladders;
                //原来的砖头回到未使用的砖头中
                bricks += theBig;
                //既然用了梯子,它就不属于砖头队列了
                priorityQueue.poll();
            } else {
                //当前的地方使用梯子
                --ladders;
                //+1
                ++p;
            }
        }
        //返回最大情况
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().furthestBuilding(new int[]{1, 13, 1, 1, 13, 5, 11, 11}, 10, 8));
    }

}
