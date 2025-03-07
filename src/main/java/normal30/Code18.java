package normal30;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-04-15
 * 274. H 指数
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * <p>
 * 输入：citations = [1,3,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class Code18 {

    public int hIndex(int[] citations) {
        //排序
        Arrays.sort(citations);
        //指针
        int p = 0;
        //当前指针目标值
        int target = citations.length;
        //循环
        while (p < citations.length) {
            //当前数字
            int num = citations[p];
            //如果当前就是
            if (num >= target) {
                //返回结果
                return target;
            }
            //下一级
            target--;
            p++;
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().hIndex(new int[]{3, 0, 6, 1, 5}));
    }

}
