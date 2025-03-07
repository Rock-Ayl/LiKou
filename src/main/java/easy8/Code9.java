package easy8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 安永亮
 * @Date 2021-06-05
 * @Description 1742. 盒子中小球的最大数量
 * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。
 * <p>
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 * <p>
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lowLimit = 1, highLimit = 10
 * 输出：2
 * 解释：
 * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
 * 小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
 * 编号 1 的盒子放有最多小球，小球数量为 2 。
 * 示例 2：
 * <p>
 * 输入：lowLimit = 5, highLimit = 15
 * 输出：2
 * 解释：
 * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
 * 小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
 * 编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
 * 示例 3：
 * <p>
 * 输入：lowLimit = 19, highLimit = 28
 * 输出：2
 * 解释：
 * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
 * 小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
 * 编号 10 的盒子放有最多小球，小球数量为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= lowLimit <= highLimit <= 105
 */
public class Code9 {

    public int countBalls(int lowLimit, int highLimit) {
        //盒子
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i = lowLimit; i <= highLimit; i++) {
            //盒子编号
            int num = 0;
            //循环
            for (char c : (i + "").toCharArray()) {
                //组装
                num += (c - '0');
            }
            //小球数量
            int size;
            //如果存在
            if (map.containsKey(num)) {
                //用已有的
                size = map.get(num) + 1;
            } else {
                //初始化
                size = 1;
            }
            //记录
            map.put(num, size);
        }
        //最大数量
        int max = 0;
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //如果刷新了记录
            if (entry.getValue() > max) {
                //记录
                max = entry.getValue();
            }
        }
        //返回结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countBalls(1,10));
    }

}
