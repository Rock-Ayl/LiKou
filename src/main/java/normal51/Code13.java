package normal51;

/**
 * 2320. 统计放置房子的方式数
 * 算术评级: 4
 * 第 299 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1608
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
 * <p>
 * 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
 * <p>
 * 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：4
 * 解释：
 * 可能的放置方式：
 * 1. 所有地块都不放置房子。
 * 2. 一所房子放在街道的某一侧。
 * 3. 一所房子放在街道的另一侧。
 * 4. 放置两所房子，街道两侧各放置一所。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：9
 * 解释：如上图所示，共有 9 种可能的放置方式。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 */
public class Code13 {

    public int countHousePlacements(int n) {
        //缓存
        long[] arr = new long[n + 1];
        //默认
        arr[0] = 1L;
        arr[1] = 2L;
        //循环
        for (int i = 2; i < arr.length; i++) {
            //计算当前可能
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000007L;
        }
        //最后一个
        long last = arr[arr.length - 1];
        //返回
        return (int) ((last * last) % 1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countHousePlacements(1));
        System.out.println(new Code13().countHousePlacements(2));
        System.out.println(new Code13().countHousePlacements(3));
    }

}
