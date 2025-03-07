package normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-01
 * 849. 到最近的人的最大距离
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 示例 3：
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= seats.length <= 2 * 104
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 */
public class Code25 {

    public static int maxDistToClosest(int[] seats) {
        //总长度
        int size = seats.length;
        //人的位置
        List<Integer> list = new ArrayList<>();
        //循环
        for (int i = 0; i < size; i++) {
            //如果该位置有人
            if (seats[i] == 1) {
                //记录
                list.add(i);
            }
        }
        //右边边界
        int right = list.size() - 1;
        //最大距离初始化,左右两边距先选个最大的
        int max = Math.max(list.get(0), size - list.get(right) - 1);
        //循环判断
        for (int i = 0; i < right; i++) {
            //中间有多少空位
            int x = list.get(i + 1) - list.get(i) - 1;
            //如果至少有一个空位
            if (x > 0) {
                //计算最大距离
                int y = (x + 1) / 2;
                //如果是最大的
                if (y > max) {
                    //更新
                    max = y;
                }
            }
        }
        //默认
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,}));
    }
}
