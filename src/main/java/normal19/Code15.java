package normal19;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-03-24
 * 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * <p>
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 */
public class Code15 {

    public List<Integer> pathInZigZagTree(int label) {
        //层
        int stair = 1;
        //每层节点数(也是下一层的开始数)
        int count = 1;
        //总和
        int sum = 1;
        //如果不能覆盖
        while (sum < label) {
            //计算当前层节点数
            count = count * 2;
            //叠加总数
            sum += count;
            //层级
            stair++;
        }
        //初始化结果列表
        LinkedList<Integer> result = new LinkedList<>();
        //循环,逐级找节点
        while (stair > 0) {
            //先记录当前层结果
            result.addFirst(label);
            //计算下一层当前层节点数
            int nextSum = sum - count;
            //计算下一层节点数
            int nextCount = count / 2;
            //下一次结果
            int nextLabel;
            /**
             * 根据奇数偶数层判断当前方向,进而计算下一次label
             * 偶数下层右到左,上层左到右
             * 奇数下层左到右,上层右到左
             */
            if (stair % 2 == 0) {
                //当前层其属于第几个数
                int size = sum - label + 1;
                //如果是奇数
                if (size % 2 != 0) {
                    //进一位
                    size++;
                }
                //下一层第几个
                int nextSize = size / 2;
                //计算出下一个节点
                nextLabel = nextSize + nextCount - 1;
            } else {
                //当前层其属于第几个数
                int size = label - count + 1;
                //如果是奇数
                if (size % 2 != 0) {
                    //进一位
                    size++;
                }
                //下一层第几个
                int nextSize = size / 2;
                //计算出下一个节点
                nextLabel = nextSum - nextSize + 1;
            }
            //跟换层级
            label = nextLabel;
            sum = nextSum;
            count = nextCount;
            stair = stair - 1;
        }
        //返回列表
        return result;
    }

    public static void main(String[] args) {
        new Code15().pathInZigZagTree(26);
    }

}
