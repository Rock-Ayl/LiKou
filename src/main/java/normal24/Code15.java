package normal24;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-10-05
 * LCR 100. 三角形最小路径和
 * 中等
 * 43
 * 相关企业
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * <p>
 * <p>
 * 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/
 */
public class Code15 {

    public int minimumTotal(List<List<Integer>> triangle) {
        //循环
        for (int i = 1; i < triangle.size(); i++) {
            //获取当前层级
            List<Integer> linkList = triangle.get(i);
            //上一层
            List<Integer> lastLinkList = triangle.get(i - 1);
            //叠加第一个必定的
            linkList.set(0, linkList.get(0) + lastLinkList.get(0));
        }
        //循环
        for (int i = 1; i < triangle.size(); i++) {
            //获取当前层级
            List<Integer> linkList = triangle.get(i);
            //上一层
            List<Integer> lastLinkList = triangle.get(i - 1);
            //循环2
            for (int j = 1; j < linkList.size(); j++) {
                //上面的数字、左上的数字
                int up = Integer.MAX_VALUE;
                //如果有上面的
                if (lastLinkList.size() > j) {
                    //获取
                    up = lastLinkList.get(j);
                }
                //左上
                int upLeft = lastLinkList.get(j - 1);
                //计算最大情况
                linkList.set(j, linkList.get(j) + Math.min(up, upLeft));
            }
        }
        //返回结果
        return triangle.get(triangle.size()-1).stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Code15().minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        )));
    }

}
