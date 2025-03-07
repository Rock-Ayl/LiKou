package normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-03-18
 * 1094. 拼车
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 * <p>
 * 这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：
 * <p>
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 * <p>
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：trips = [[2,1,5],[3,5,7]], capacity = 3
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设乘客会自觉遵守 “先下后上” 的良好素质
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */
public class Code13 {

    public static boolean carPooling(int[][] trips, int capacity) {
        //路程的位置、总人数
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int[] trip : trips) {
            //开始结束
            int start = trip[1], end = trip[2];
            //循环
            while (start < end) {
                //获取
                Integer num = map.get(start);
                //判空
                if (num == null) {
                    //缺省
                    num = 0;
                }
                //计算现有乘客
                num += trip[0];
                //如果超员了
                if (num > capacity) {
                    //不可以
                    return false;
                }
                //更新乘客数
                map.put(start, num);
                //递增
                start++;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{new int[]{2, 1, 5}, new int[]{3, 5, 7}}, 3));
    }
}
