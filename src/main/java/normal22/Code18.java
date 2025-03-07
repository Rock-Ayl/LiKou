package normal22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-08-08
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 */
public class Code18 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //最深深度
    private int maxDeep = 0;
    //最大深度长度
    private int maxDeepLink = 0;
    //本次结果
    private List<List<String>> resultList;

    //递归寻找最大深度
    private void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //刷新深度
            maxDeep = Math.max(maxDeep, deep);
            //过
            return;
        }
        //下一级
        next(node.left, deep + 1);
        next(node.right, deep + 1);
    }

    //计算最大深度长度
    private void countMaxDeepLink() {
        //当前深度
        int deep = 1;
        //深度长度
        int link = 1;
        //循环
        while (deep++ < maxDeep) {
            //计算
            link = 1 + link * 2;
        }
        //最大长度
        maxDeepLink = link;
    }

    //初始化结果
    private void initResult() {
        //初始化
        resultList = new ArrayList<>();
        //指针
        int p = 0;
        //循环
        while (p++ < maxDeep) {
            //初始化
            List<String> list = new ArrayList<>(maxDeepLink);
            //填充默认
            for (int i = 0; i < maxDeepLink; i++) {
                //默认
                list.add("");
            }
            //组装
            resultList.add(list);
        }
    }

    //填充节点结果
    private void setNodeNext(TreeNode node, int deep, int left, int right) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //中间节点
        int p = (right - left) / 2 + left;
        //记录当前结果
        resultList.get(deep).set(p, new Integer(node.val).toString());
        //下一级
        setNodeNext(node.left, deep + 1, left, p - 1);
        setNodeNext(node.right, deep + 1, p + 1, right);
    }

    public List<List<String>> printTree(TreeNode root) {
        //计算深度
        next(root, 0);
        //根据深度计算长度
        countMaxDeepLink();
        //初始化结果
        initResult();
        //填充节点结果
        setNodeNext(root, 0, 0, maxDeepLink - 1);
        //返回结果
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        one.right = three;
        two.right = four;
        System.out.println(new Code18().printTree(one).toString());
    }

}
