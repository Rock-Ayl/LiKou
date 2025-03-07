package normal29;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-03-14
 * 1024. 视频拼接
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * <p>
 * 使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
 * <p>
 * 甚至可以对这些片段自由地再剪辑：
 * <p>
 * 例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
 * 输出：3
 * 解释：
 * 选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在手上的片段为 [0,2] + [2,8] + [8,10]，而这些覆盖了整场比赛 [0, 10]。
 * 示例 2：
 * <p>
 * 输入：clips = [[0,1],[1,2]], time = 5
 * 输出：-1
 * 解释：
 * 无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 * <p>
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
 * 输出：3
 * 解释：
 * 选取片段 [0,4], [4,7] 和 [6,9] 。
 */
public class Code21 {

    public int videoStitching(int[][] clips, int time) {
        //按照规则排序,左边更小的优先级高,右边更大的优先级高
        Arrays.sort(clips, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        //如果开始不是0
        if (clips[0][0] != 0) {
            //不可能
            return -1;
        }
        //连击次数,默认第一个节点一定选上
        int hitResult = 1;
        //最后边的数字初始化
        int rightNum = clips[0][1];
        //从1开始
        int index = 1;
        //循环
        while (index < clips.length && rightNum < time) {
            //如果当前节点被覆盖了
            if (rightNum >= clips[index][1]) {
                //进位
                index++;
                //本轮过
                continue;
            }
            //如果中间缺帧
            if (rightNum < clips[index][0]) {
                //不可能
                return -1;
            }
            //初始化本次可以连接的最大右边数字
            int maxNextRightNum = clips[index][1];
            //递归,如果都满足下一个梯队
            while (index < clips.length && clips[index][0] <= rightNum) {
                //刷新最大可能并进位
                maxNextRightNum = Math.max(maxNextRightNum, clips[index++][1]);
            }
            //本次节点最大连接情况
            rightNum = maxNextRightNum;
            //选择次数+1
            hitResult++;
        }
        //如果最大时间不够目标时间
        if (rightNum < time) {
            //不行
            return -1;
        }
        //返回结果
        return hitResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().videoStitching(new int[][]{
                new int[]{1, 6},
                new int[]{0, 2},
                new int[]{3, 10}
        }, 10));
    }

}
