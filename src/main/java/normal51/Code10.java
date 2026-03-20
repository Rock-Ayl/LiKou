package normal51;

/**
 * LCP 62. 交通枢纽
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 为了缓解「力扣嘉年华」期间的人流压力，组委会在活动期间开设了一些交通专线。path[i] = [a, b] 表示有一条从地点 a通往地点 b 的 单向 交通专线。 若存在一个地点，满足以下要求，我们则称之为 交通枢纽：
 * <p>
 * 所有地点（除自身外）均有一条 单向 专线 直接 通往该地点；
 * 该地点不存在任何 通往其他地点 的单向专线。
 * 请返回交通专线的 交通枢纽。若不存在，则返回 -1。
 * <p>
 * 注意：
 * <p>
 * 对于任意一个地点，至少被一条专线连通。
 * 示例 1：
 * <p>
 * 输入：path = [[0,1],[0,3],[1,3],[2,0],[2,3]]
 * <p>
 * 输出：3
 * <p>
 * 解释：如下图所示： 地点 0,1,2 各有一条通往地点 3 的交通专线， 且地点 3 不存在任何通往其他地点的交通专线。image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入：path = [[0,3],[1,0],[1,3],[2,0],[3,0],[3,2]]
 * <p>
 * 输出：-1
 * <p>
 * 解释：如下图所示：不存在满足 交通枢纽 的地点。image.png
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 1000
 * 0 <= path[i][0], path[i][1] <= 1000
 * path[i][0] 与 path[i][1] 不相等
 *
 */
public class Code10 {

    public int transportationHub(int[][] path) {

        /**
         * 计算最大节点,并寻找交通节点
         */

        //计数器
        int[] countArr = new int[1001];
        //最大节点
        int max = 0;
        //循环
        for (int[] ints : path) {
            //刷新最大
            max = Math.max(ints[0], max);
            max = Math.max(ints[1], max);
            //+1
            countArr[ints[0]]++;
        }
        //交通枢纽节点数量
        int zeroCount = 0;
        //交通枢纽索引
        int targetNumber = -1;
        //循环
        for (int i = 0; i <= max; i++) {
            //如果是
            if (countArr[i] == 0) {
                //+1
                zeroCount++;
                targetNumber = i;
            }
        }
        //如果不是只有一个
        if (zeroCount != 1) {
            //过
            return -1;
        }

        /**
         * 构建路径(反过来),计算结果
         */

        //次数
        int count = 0;
        //循环
        for (int[] ints : path) {
            //如果是目标节点
            if (ints[1] == targetNumber) {
                //+1
                count++;
            }
        }
        //返回结果
        return count == max ? targetNumber : -1;
    }

    public static void main(String[] args) {
        /*System.out.println(new Code10().transportationHub(new int[][]{
                {0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}
        }));*/

        System.out.println(new Code10().transportationHub(new int[][]{
                {0, 3}, {1, 3}, {4, 0}, {2, 0}, {2, 4}
        }));
    }

}
