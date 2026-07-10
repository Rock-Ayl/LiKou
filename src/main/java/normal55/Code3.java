package normal55;

import java.util.ArrayList;
import java.util.List;

/**
 * LCP 78. 城墙防线
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 在探险营地间，小扣意外发现了一片城墙遗迹，在探索期间，却不巧遇到迁徙中的兽群向他迎面冲来。情急之下小扣吹响了他的苍蓝笛，随着笛声响起，遗迹中的城墙逐渐发生了横向膨胀。 已知 rampart[i] = [x,y] 表示第 i 段城墙的初始所在区间。当城墙发生膨胀时，将遵循以下规则：
 * <p>
 * 所有的城墙会同时膨胀相等的长度；
 * 每个城墙可以向左、向右或向两个方向膨胀。
 * 小扣为了确保自身的安全，需要在所有城墙均无重叠的情况下，让城墙尽可能的膨胀。请返回城墙可以膨胀的 最大值 。
 * <p>
 * 注意：
 * <p>
 * 初始情况下，所有城墙均不重叠，且 rampart 中的元素升序排列；
 * 两侧的城墙可以向外无限膨胀。
 * 示例 1：
 * <p>
 * 输入：rampart = [[0,3],[4,5],[7,9]]
 * <p>
 * 输出：3
 * <p>
 * 解释：如下图所示： rampart[0] 向左侧膨胀 3 个单位； rampart[2] 向右侧膨胀 3 个单位； rampart[1] 向左侧膨胀 1 个单位，向右膨胀 2 个单位。 不存在膨胀更多的方案，返回 3。image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入：rampart = [[1,2],[5,8],[11,15],[18,25]]
 * <p>
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 3 <= rampart.length <= 10^4
 * rampart[i].length == 2
 * 0 <= rampart[i][0] < rampart[i][1] <= rampart[i+1][0] <= 10^8
 */
public class Code3 {

    public int rampartDefensiveLine(int[][] rampart) {

        /**
         * 每个空间允许膨胀
         */

        //空间列表
        List<Integer> spaceList = new ArrayList<>();
        //循环
        for (int i = 1; i < rampart.length; i++) {
            //记录本次
            spaceList.add(rampart[i][0] - rampart[i - 1][1]);
        }

        /**
         * 计算最大可能
         */

        //最大结果
        int max = Integer.MAX_VALUE;
        //循环
        for (int i = 1; i < spaceList.size(); i++) {
            //最大可能
            int sum = spaceList.get(i) + spaceList.get(i - 1);
            //刷新最大
            max = Math.min(max, sum);
        }
        //和
        int sum = spaceList.stream().mapToInt(Integer::intValue).sum();
        //刷新最小
        max = Math.min(max, sum / (spaceList.size() - 1));

        /**
         * 膨胀
         */

        //如果满足
        if (checkt(spaceList, max)) {
            //直接返回
            return max;
        } else {
            //少一个肯定可以
            return max - 1;
        }
    }

    //检查
    private boolean checkt(List<Integer> spaceList, int target) {
        //循环
        for (int i = 1; i < spaceList.size(); i++) {
            //要删除的
            int remove = target;
            //如果左边不够
            if (remove > spaceList.get(i - 1)) {
                //清理
                remove = remove - spaceList.get(i - 1);
                //清空
                spaceList.set(i - 1, 0);
                //如果还是大
                if (remove > spaceList.get(i)) {
                    //失败
                    return false;
                } else {
                    //清算
                    spaceList.set(i, spaceList.get(i) - remove);
                }
            } else {
                //全部用左边的
                spaceList.set(i - 1, spaceList.get(i - 1) - remove);
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {

        //System.out.println(new Code3().rampartDefensiveLine(new int[][]{{0, 3}, {4, 5}, {7, 9}}));

        //[3,5],[12,29],[31,38],[39,42],[43,44],[46,47]
        /*System.out.println(new Code3().rampartDefensiveLine(new int[][]{
                {3, 5}, {12, 29}, {31, 38}, {39, 42}, {43, 44}, {46, 47}
        }));*/

        //[1,2],[5,8],[11,15],[18,25]
        System.out.println(new Code3().rampartDefensiveLine(new int[][]{
                {1, 2}, {5, 8}, {11, 15}, {18, 25}
        }));
    }

}
