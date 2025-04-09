package normal41;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2025-04-09
 * 2271. 毯子覆盖的最多白色砖块数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维整数数组 tiles ，其中 tiles[i] = [li, ri] ，表示所有在 li <= j <= ri 之间的每个瓷砖位置 j 都被涂成了白色。
 * <p>
 * 同时给你一个整数 carpetLen ，表示可以放在 任何位置 的一块毯子的长度。
 * <p>
 * 请你返回使用这块毯子，最多 可以盖住多少块瓷砖。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：tiles = [[1,5],[10,11],[12,18],[20,25],[30,32]], carpetLen = 10
 * 输出：9
 * 解释：将毯子从瓷砖 10 开始放置。
 * 总共覆盖 9 块瓷砖，所以返回 9 。
 * 注意可能有其他方案也可以覆盖 9 块瓷砖。
 * 可以看出，瓷砖无法覆盖超过 9 块瓷砖。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：tiles = [[10,11],[1,1]], carpetLen = 2
 * 输出：2
 * 解释：将毯子从瓷砖 10 开始放置。
 * 总共覆盖 2 块瓷砖，所以我们返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 5 * 104
 * tiles[i].length == 2
 * 1 <= li <= ri <= 109
 * 1 <= carpetLen <= 109
 * tiles 互相 不会重叠 。
 */
public class Code20 {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        //排序
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        //最大结果
        int max = 0;
        //和
        int sum = 0;
        int left = 0;
        int right = 0;
        //循环
        while (left < tiles.length) {

            /**
             * 删除上一个的砖块
             */

            //如果存在上一个
            if (left > 0) {
                //删除上一个
                sum -= tiles[left - 1][1] - tiles[left - 1][0] + 1;
            }

            /**
             * 计算本次开始结束
             */

            //开始
            int start = tiles[left][0];
            //预期结束
            int end = start + carpetLen - 1;

            /**
             * 尝试新增后面的完整区间
             */

            //如果存在后续可加入的完整
            while (right < tiles.length && tiles[right][1] <= end) {
                //叠加全部
                sum += tiles[right][1] - tiles[right][0] + 1;
                //+1
                right++;
            }

            /**
             * 最后一个不完整的区间
             */

            //目前是0
            int other = 0;
            //如果存在一部分不完整的
            if (right < tiles.length && tiles[right][0] <= end) {
                //计算出不完整
                other = end - tiles[right][0] + 1;
            }

            /**
             * 本次可覆盖砖块、刷新结果
             */

            //计算本次覆盖砖块
            int thisSum = sum + other;
            //刷新
            max = Math.max(max, thisSum);

            /**
             * 准备下一个
             */

            //+1
            left++;
        }

        //返回结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maximumWhiteTiles(new int[][]{
                new int[]{1, 5},
                new int[]{12, 18},
                new int[]{10, 11},
                new int[]{20, 25},
                new int[]{30, 32}
        }, 10));
    }

}
