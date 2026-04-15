package difficult5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 632. 最小区间
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] 按非递减顺序排列
 */
public class Code4 {

    private static class Node {

        //数字
        private int num;

        //分组
        private int group;

        //初始化
        public Node(int num, int group) {
            this.num = num;
            this.group = group;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", group=" + group +
                    '}';
        }

    }

    public int[] smallestRange(List<List<Integer>> nums) {

        /**
         * 构建节点
         */

        //包含的分组数量
        int groupCount = nums.size();
        //分组数量统计数组
        int[] groupCountArr = new int[nums.size()];
        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.size(); i++) {
            //循环2
            for (Integer num : nums.get(i)) {
                //初始化节点
                nodeList.add(new Node(num, i));
                //分组数量统计
                groupCountArr[i]++;
            }
        }
        //排序
        nodeList.sort((a, b) -> a.num - b.num);

        /**
         * 初始化滑动
         */

        //双指针
        int left = 0;
        int right = -1;

        //当前包含的分组数量
        int thisGroupCount = 0;
        //当前包含的分组数量统计数组
        int[] thisGroupCountArr = new int[nums.size()];

        //如果还不够
        while (thisGroupCount < groupCount) {
            //+1,如果是第一个
            if (++thisGroupCountArr[nodeList.get(++right).group] == 1) {
                //+1分组数量
                thisGroupCount++;
            }
        }

        //结果
        int[] resultArr = new int[2];
        //第一个结果区间
        resultArr[0] = left;
        resultArr[1] = right;

        /**
         * 不断滑动
         */

        //如果还可以滑动
        while (left < nodeList.size()) {

            /**
             * 左滑一次
             */

            //-1,如果是最后一个
            if (--thisGroupCountArr[nodeList.get(left++).group] == 0) {
                //-1分组数量
                thisGroupCount--;
            }

            /**
             * 不断右滑
             */

            //如果还不够
            while (right + 1 < nodeList.size() && thisGroupCount < groupCount) {
                //+1,如果是第一个
                if (++thisGroupCountArr[nodeList.get(++right).group] == 1) {
                    //+1分组数量
                    thisGroupCount++;
                }
            }
            //如果不够了
            if (thisGroupCount < groupCount) {
                //跳出
                break;
            }

            /**
             * 本次结果
             */

            //当前区间
            int[] thisRageArr = new int[2];
            //记录
            thisRageArr[0] = left;
            thisRageArr[1] = right;
            //如果当前的更大
            if (isSmall(nodeList, resultArr, thisRageArr) == true) {
                //使用心得
                resultArr = thisRageArr;
            }

        }
        //返回最终结果
        return new int[]{nodeList.get(resultArr[0]).num, nodeList.get(resultArr[1]).num};
    }

    //判断当前是否更大
    private boolean isSmall(List<Node> nodeList, int[] resultArr, int[] thisRageArr) {
        //获取数字
        int a = nodeList.get(thisRageArr[0]).num;
        int b = nodeList.get(thisRageArr[1]).num;
        int c = nodeList.get(resultArr[0]).num;
        int d = nodeList.get(resultArr[1]).num;
        //计算
        int x = b - a;
        int y = d - c;
        //如果更小
        if (x < y) {
            //更小
            return true;
        }
        //实现
        return a < c;
    }

    public static void main(String[] args) {
        /*int[] ints = new Code4().smallestRange(Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        ));*/


        /*
        * int[] ints = new Code4().smallestRange(Arrays.asList(
                Arrays.asList(10, 10),
                Arrays.asList(11, 11)
        ));*/

        int[] ints = new Code4().smallestRange(Arrays.asList(
                Arrays.asList(1, 3, 5, 7, 9, 10),
                Arrays.asList(2, 4, 6, 8, 10)
        ));

        System.out.println();
    }

}
