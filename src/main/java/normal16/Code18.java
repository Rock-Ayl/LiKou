package normal16;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-10-20
 */
public class Code18 {

    public class TreeNode {
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

    //每层节点数
    Map<Integer, Integer> map = new HashMap<>();
    //最大深度
    int maxDeep = 0;
    //最深层是否有空
    boolean maxKong = false;

    //第一遍遍历
    public void next(TreeNode node, int deep) {
        //如果节点为空
        if (node == null) {
            //如果是最大深度
            if (deep == maxDeep) {
                //记录
                maxKong = true;
            }
            //过
            return;
        }
        //如果刷新了最大深度
        if (deep > maxDeep) {
            //刷新最大深度和最大深度节点逻辑
            maxDeep = deep;
            maxKong = false;
        }
        //记录每层节点数
        map.put(deep, map.getOrDefault(deep, 0) + 1);
        //下一级deep
        int nextDeep = deep + 1;
        //下一层,从右往左遍历,这样最大深度列表如果有空,肯定不是目标树
        next(node.right, nextDeep);
        next(node.left, nextDeep);
    }

    public boolean isCompleteTree(TreeNode root) {
        //先遍历一遍
        next(root, 1);
        //如果最深一层存在空
        if (maxKong == true) {
            //不是
            return false;
        }
        //从root开始
        int deep = 1;
        int deepCount = 1;
        //判断除了最深一层,其余是否是完全的节点数
        while (deep < maxDeep) {
            //如果当前节点数量与预计节点数量不符
            if (map.get(deep++) != deepCount) {
                //直接返回
                return false;
            }
            //成倍
            deepCount *= 2;
        }
        //默认可以
        return true;
    }

}
