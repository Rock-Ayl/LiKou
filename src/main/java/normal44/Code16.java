package normal44;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-07-04
 * 3493. 属性图
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 properties，其维度为 n x m，以及一个整数 k。
 * <p>
 * 定义一个函数 intersect(a, b)，它返回数组 a 和 b 中 共有的不同整数的数量 。
 * <p>
 * 构造一个 无向图，其中每个索引 i 对应 properties[i]。如果且仅当 intersect(properties[i], properties[j]) >= k（其中 i 和 j 的范围为 [0, n - 1] 且 i != j），节点 i 和节点 j 之间有一条边。
 * <p>
 * 返回结果图中 连通分量 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： properties = [[1,2],[1,1],[3,4],[4,5],[5,6],[7,7]], k = 1
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 生成的图有 3 个连通分量：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： properties = [[1,2,3],[2,3,4],[4,3,5]], k = 2
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 生成的图有 1 个连通分量：
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入： properties = [[1,1],[1,1]], k = 2
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * intersect(properties[0], properties[1]) = 1，小于 k。因此在图中 properties[0] 和 properties[1] 之间没有边。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == properties.length <= 100
 * 1 <= m == properties[i].length <= 100
 * 1 <= properties[i][j] <= 100
 * 1 <= k <= m
 */
public class Code16 {

    public int numberOfComponents(int[][] properties, int k) {

        //节点数量
        int nodeCount = properties.length;

        /**
         * 构建每个节点数字count
         */

        //缓存
        Map<Integer, Integer>[] countMapArr = new Map[nodeCount];
        //循环
        for (int i = 0; i < nodeCount; i++) {
            //初始化
            Map<Integer, Integer> countMap = new HashMap<>();
            //循环
            for (int num : properties[i]) {
                //+1
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            //记录
            countMapArr[i] = countMap;
        }

        /**
         * 初始化并查集
         */

        //并查集-节点分组
        int[] groupArr = new int[nodeCount];
        //循环
        for (int i = 0; i < nodeCount; i++) {
            //初始化分组
            groupArr[i] = i;
        }

        /**
         * 计算 并查集
         */

        //循环1
        for (int i = 0; i < nodeCount; i++) {
            //循环2
            for (int j = i + 1; j < nodeCount; j++) {
                //如果是联通的
                if (connect(countMapArr[i], countMapArr[j], k)) {
                    //关联二者分组
                    findAndSet(groupArr, i, j);
                }
            }
        }

        /**
         * 统计并返回结果
         */

        //结果
        int result = 0;
        //循环
        for (int i = 0; i < groupArr.length; i++) {
            //如果是主节点
            if (groupArr[i] == i) {
                //+1
                result++;
            }
        }

        //返回最终结果
        return result;
    }

    //如果是连接的,则并查集二者分组
    private int findAndSet(int[] groupArr, int left, int right) {
        //主节点
        int root;
        //如果左边是主节点
        if (groupArr[left] == left) {
            //记录主节点
            root = left;
        } else {
            //递归出主节点
            root = findAndSet(groupArr, groupArr[left], left);
        }
        //如果右边也是
        if (groupArr[right] != right) {
            //递归之
            findAndSet(groupArr, root, groupArr[right]);
        }
        //记录本次主节点
        groupArr[right] = root;
        //返回
        return root;
    }

    //判断 2个节点 是否连接
    private boolean connect(Map<Integer, Integer> one, Map<Integer, Integer> two, int k) {
        //数量
        int count = 0;
        //循环
        for (Integer key : one.keySet()) {
            //本次共有
            count += two.containsKey(key) ? 1 : 0;
            //如果满足
            if (count >= k) {
                //可以
                return true;
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        /*System.out.println(new Code16().numberOfComponents(new int[][]{
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{3, 4},
                new int[]{4, 5},
                new int[]{5, 6},
                new int[]{7, 7}
        }, 1));*/

        System.out.println(new Code16().numberOfComponents(new int[][]{
                new int[]{1, 1},
                new int[]{1, 1}
        }, 2));

    }

}
