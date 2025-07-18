package normal44;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-07-10
 * 769. 最多能完成排序的块
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * 示例 2:
 * <p>
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 * 对每个块单独排序后，结果为 [0, 1], [2], [3], [4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都 不同
 */
public class Code21 {

    public int maxChunksToSorted(int[] arr) {
        //分组
        int[][] groupArr = new int[arr.length][2];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字
            int num = arr[i];
            //计算开始结束
            int start = Math.min(num, i);
            int end = Math.max(num, i);
            //记录区间
            groupArr[i] = new int[]{start, end};
        }
        //排序
        Arrays.sort(groupArr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        //结果数量
        int count = 1;
        //结束
        int last = groupArr[0][1];
        //循环
        for (int i = 1; i < groupArr.length; i++) {
            //当前分组
            int[] group = groupArr[i];
            //如果完全隔开了
            if (last < group[0]) {
                //+1
                count++;
                //下一个
                last = group[1];
            } else {
                //刷新最远距离
                last = Math.max(last, group[1]);
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(new Code21().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }

}
