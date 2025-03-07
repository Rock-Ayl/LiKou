package normal39;

/**
 * @Author ayl
 * @Date 2025-02-05
 * 1361. 验证二叉树
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * <p>
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * <p>
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * <p>
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == leftChild.length == rightChild.length
 * 1 <= n <= 104
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class Code25 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        /**
         * 构建默认并查集数组
         */

        //初始化数组
        int[] arr = new int[n];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //默认分组
            arr[i] = i;
        }

        /**
         * 不断修改并查集
         */

        //根据父子关系,构建并查集,如果有问题返回
        if (buildGroup(leftChild, arr) == false || buildGroup(rightChild, arr) == false) {
            //返回
            return false;
        }

        /**
         * 最终,要统计有几个顶级
         */

        //顶级数量
        int rootCount = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是顶级 and 奇数、顶级如果有2个
            if (arr[i] == i && ++rootCount == 2) {
                //不可能
                return false;
            }
        }

        //最终视为一棵树
        return true;
    }

    /**
     * 根据 父子关系 ,构建并查集
     *
     * @param childArr 父子关系数组
     * @param arr      并查集数组
     * @return
     */
    private boolean buildGroup(int[] childArr, int[] arr) {
        //循环
        for (int father = 0; father < childArr.length; father++) {
            //获取孩子索引
            int child = childArr[father];
            //如果没有父子关系
            if (child == -1) {
                //本轮过
                continue;
            }
            //递归、发现、并设置其先祖,并判断是否合法
            if (findAndSet(arr, father, child, 0) == -1) {
                //不合法
                return false;
            }
        }
        //默认可以
        return true;
    }

    /**
     * 递归、发现、并设置其先祖
     *
     * @param arr    并查集数组
     * @param father 父亲索引
     * @param child  孩子索引
     * @param count  递归次数
     * @return
     */
    private int findAndSet(int[] arr, int father, int child, int count) {
        //如果父亲是孩子
        if (father == child) {
            //不合法
            return -1;
        }
        //如果是第一次设置 and 如果孩子已经寻找过了,说明有2个父亲
        if (count == 0 && arr[child] != child) {
            //不合法
            return -1;
        }
        //如果父亲是顶级
        if (arr[father] == father) {
            //覆盖并返回
            return arr[child] = father;
        }
        //递归出顶级父亲
        int rootFather = findAndSet(arr, arr[father], child, count + 1);
        //不合法 or 如果顶级父亲是孩子
        if (rootFather == -1 || rootFather == child) {
            //不合法
            return -1;
        }
        //更新其父亲并返回
        return arr[father] = rootFather;
    }

    public static void main(String[] args) {
        //System.out.println(new Code25().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        //System.out.println(new Code25().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        //System.out.println(new Code25().validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1}));
        System.out.println(new Code25().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
    }

}
