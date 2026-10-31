package normal58;

/**
 * 3361. 两个字符串的切换距离
 * 算术评级: 4
 * 第 144 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1553
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度相同的字符串 s 和 t ，以及两个整数数组 nextCost 和 previousCost 。
 * <p>
 * 一次操作中，你可以选择 s 中的一个下标 i ，执行以下操作 之一 ：
 * <p>
 * 将 s[i] 切换为字母表中的下一个字母，如果 s[i] == 'z' ，切换后得到 'a' 。操作的代价为 nextCost[j] ，其中 j 表示 s[i] 在字母表中的下标。
 * 将 s[i] 切换为字母表中的上一个字母，如果 s[i] == 'a' ，切换后得到 'z' 。操作的代价为 previousCost[j] ，其中 j 是 s[i] 在字母表中的下标。
 * 切换距离 指的是将字符串 s 变为字符串 t 的 最少 操作代价总和。
 * <p>
 * 请你返回从 s 到 t 的 切换距离 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abab", t = "baba", nextCost = [100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], previousCost = [1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 选择下标 i = 0 并将 s[0] 向前切换 25 次，总代价为 1 。
 * 选择下标 i = 1 并将 s[1] 向后切换 25 次，总代价为 0 。
 * 选择下标 i = 2 并将 s[2] 向前切换 25 次，总代价为 1 。
 * 选择下标 i = 3 并将 s[3] 向后切换 25 次，总代价为 0 。
 * 示例 2：
 * <p>
 * 输入：s = "leet", t = "code", nextCost = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1], previousCost = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
 * <p>
 * 输出：31
 * <p>
 * 解释：
 * <p>
 * 选择下标 i = 0 并将 s[0] 向前切换 9 次，总代价为 9 。
 * 选择下标 i = 1 并将 s[1] 向后切换 10 次，总代价为 10 。
 * 选择下标 i = 2 并将 s[2] 向前切换 1 次，总代价为 1 。
 * 选择下标 i = 3 并将 s[3] 向后切换 11 次，总代价为 11 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length == t.length <= 105
 * s 和 t 都只包含小写英文字母。
 * nextCost.length == previousCost.length == 26
 * 0 <= nextCost[i], previousCost[i] <= 109
 */
public class Code11 {

    //todo 可以把两个cost数组作为前缀和,懒得做了....
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        //结果
        long result = 0L;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //计算本次
            result += change(s.charAt(i) - 'a', t.charAt(i) - 'a', nextCost, previousCost);
        }
        //返回
        return result;
    }

    //切换本次
    private long change(int left, int right, int[] nextCostArr, int[] previousCostArr) {
        //如果相同
        if (left == right) {
            //过
            return 0L;
        }
        //正着过去
        long a = 0L;
        //正着过去-如果不用转一圈
        if (left < right) {
            //循环
            for (int i = left; i < right; i++) {
                //叠加
                a += nextCostArr[i];
            }
        } else {
            //循环
            for (int i = left; i < nextCostArr.length; i++) {
                //叠加
                a += nextCostArr[i];
            }
            //循环
            for (int i = 0; i < right; i++) {
                //叠加
                a += nextCostArr[i];
            }
        }
        //反着过去
        long b = 0L;
        //反着过去-如果不用转一圈
        if (left > right) {
            //循环
            for (int i = left; i > right; i--) {
                //叠加
                b += previousCostArr[i];
            }
        } else {
            //循环
            for (int i = left; i >= 0; i--) {
                //叠加
                b += previousCostArr[i];
            }
            //循环
            for (int i = previousCostArr.length - 1; i > right; i--) {
                //叠加
                b += previousCostArr[i];
            }
        }
        //返回
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println(new Code11().shiftDistance("abab", "baba", new int[]{100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    }

}
