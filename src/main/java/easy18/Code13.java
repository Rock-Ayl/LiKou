package easy18;

/**
 * @Author ayl
 * @Date 2022-05-03
 * 1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * <p>
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 */
public class Code13 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        //桶
        int[] bucket = new int[51];
        //循环
        for (int[] range : ranges) {
            //循环
            for (int i = range[0]; i <= range[1]; i++) {
                //+1
                bucket[i]++;
            }
        }
        //循环2
        for (int i = left; i <= right; i++) {
            //如果没有
            if (bucket[i] == 0) {
                //返回
                return false;
            }
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().isCovered(new int[][]{}, 2, 5));
    }

}
