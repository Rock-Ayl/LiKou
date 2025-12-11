package normal48;

/**
 * @Author ayl
 * @Date 2025-12-11
 * LCP 68. 美观的花束
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 力扣嘉年华的花店中从左至右摆放了一排鲜花，记录于整型一维矩阵 flowers 中每个数字表示该位置所种鲜花的品种编号。你可以选择一段区间的鲜花做成插花，且不能丢弃。 在你选择的插花中，如果每一品种的鲜花数量都不超过 cnt 朵，那么我们认为这束插花是 「美观的」。
 * <p>
 * 例如：[5,5,5,6,6] 中品种为 5 的花有 3 朵， 品种为 6 的花有 2 朵，每一品种 的数量均不超过 3
 * 请返回在这一排鲜花中，共有多少种可选择的区间，使得插花是「美观的」。
 * <p>
 * 注意：
 * <p>
 * 结果无需取模，用例保证输出为 int32 范围内的整数。
 * 示例 1：
 * <p>
 * 输入：flowers = [1,2,3,2], cnt = 1
 * <p>
 * 输出：8
 * <p>
 * 解释：相同的鲜花不超过 1 朵，共有 8 种花束是美观的； 长度为 1 的区间 [1]、[2]、[3]、[2] 均满足条件，共 4 种可选择区间 长度为 2 的区间 [1,2]、[2,3]、[3,2] 均满足条件，共 3 种可选择区间 长度为 3 的区间 [1,2,3] 满足条件，共 1 种可选择区间。 区间 [2,3,2],[1,2,3,2] 都包含了 2 朵鲜花 2 ，不满足条件。 返回总数 4+3+1 = 8
 * <p>
 * 示例 2：
 * <p>
 * 输入：flowers = [5,3,3,3], cnt = 2
 * <p>
 * 输出：8
 * <p>
 * 提示：
 * <p>
 * 1 <= flowers.length <= 10^5
 * 1 <= flowers[i] <= 10^5
 * 1 <= cnt <= 10^5
 */
public class Code21 {

    public int beautifulBouquet(int[] flowers, int cnt) {
        //结果
        int result = 0;
        //双指针
        int left = 0;
        int right = 0;
        //缓存
        int[] arr = new int[100001];
        //第一个初始化
        arr[flowers[right]]++;
        //循环
        while (left < flowers.length) {
            //如果可以右滑,右滑
            while (right + 1 < flowers.length && arr[flowers[right + 1]] + 1 <= cnt) {
                //+1
                arr[flowers[++right]]++;
            }
            //清算本次
            result += right - left + 1;
            //左滑一次
            arr[flowers[left++]]--;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().beautifulBouquet(new int[]{5, 3, 3, 3}, 2));
    }

}
