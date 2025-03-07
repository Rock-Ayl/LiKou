package normal32;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-05-30
 * 1386. 安排电影院座位
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * <p>
 * <p>
 * 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 * <p>
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，reservedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 * <p>
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * 输出：4
 * 解释：上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
 * 示例 2：
 * <p>
 * 输入：n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^9
 * 1 <= reservedSeats.length <= min(10*n, 10^4)
 * reservedSeats[i].length == 2
 * 1 <= reservedSeats[i][0] <= n
 * 1 <= reservedSeats[i][1] <= 10
 * 所有 reservedSeats[i] 都是互不相同的。
 */
public class Code8 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //需要效验的索引map,以及对应阻挡
        Map<Integer, int[]> needCheckMap = new HashMap<>();
        //循环障碍
        for (int[] reservedSeat : reservedSeats) {
            //如果不存在
            if (needCheckMap.containsKey(reservedSeat[0]) == false) {
                //初始化
                needCheckMap.put(reservedSeat[0], new int[11]);
            }
            //该行有阻挡
            ++needCheckMap.get(reservedSeat[0])[reservedSeat[1]];
        }
        //可以的数量,如果没有任何预定,一行默认2个
        int count = (n - needCheckMap.size()) * 2;
        //循环所有有预定的行
        for (int[] reservedSeat : needCheckMap.values()) {
            //每一行,都有三个点可以做成目标结果
            int[] siteAbleArr = new int[4];
            //循环可判定位置
            for (int y = 2; y <= 6; y = y + 2) {
                //如果当前1号位不行
                if (reservedSeat[y] == 1) {
                    //过
                    continue;
                }
                //如果当前2号位不行
                if (reservedSeat[y + 1] == 1) {
                    //过
                    continue;
                }
                //如果当前3号位不行
                if (reservedSeat[y + 2] == 1) {
                    //过
                    continue;
                }
                //如果当前4号位不行
                if (reservedSeat[y + 3] == 1) {
                    //过
                    continue;
                }
                //记录当前位置是否可以
                ++siteAbleArr[y / 2];
            }
            //如果最大可能
            if (siteAbleArr[1] == 1 & siteAbleArr[3] == 1) {
                //直接用最大情况
                count += 2;
                //过
                continue;
            }
            //接下来,最多只有一个
            if (siteAbleArr[1] == 1 || siteAbleArr[2] == 1 || siteAbleArr[3] == 1) {
                //+1
                ++count;
                //过
                continue;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxNumberOfFamilies(3, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 8},
                new int[]{2, 6},
                new int[]{3, 1},
                new int[]{3, 10}
        }));
    }

}
