package easy22;

/**
 * @Author ayl
 * @Date 2022-09-13
 * 个黑块的最少涂色次数
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 */
public class Code17 {

    public int minimumRecolors(String blocks, int k) {
        //如果太小
        if (blocks.length() < k) {
            //直接返回
            return 0;
        }
        //结束位置
        int end = 0;
        //次数
        int count = 0;
        //初始化
        while (end < k) {
            //如果要填充
            if (blocks.charAt(end++) == 'W') {
                //记录
                count++;
            }
        }
        //初始化最小数
        int minCount = count;
        //循环
        for (int i = end; i < blocks.length(); i++) {
            //如果是
            if (blocks.charAt(i) == 'W') {
                //+1
                count++;
            }
            //如果是
            if (blocks.charAt(i - k) == 'W') {
                //+1
                count--;
            }
            //刷新最小
            minCount = Math.min(minCount, count);
        }
        //返回
        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minimumRecolors("WBBWWBBWBW", 7));
    }

}
