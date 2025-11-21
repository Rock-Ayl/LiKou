package normal48;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-11-21
 * 1124. 表现良好的最长时间段
 * 算术评级: 7
 * 第 145 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1908
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 */
public class Code5 {

    //劳累的最小时间
    private static final int HARD = 9;

    public int longestWPI(int[] hours) {
        //最大结果
        int max = 0;
        //前缀和
        int[] sumArr = new int[hours.length];
        //索引缓存
        Map<Integer, Integer> indexMap = new HashMap<>();
        //循环
        for (int i = 0; i < sumArr.length; i++) {
            //计算本次
            sumArr[i] = (hours[i] >= HARD ? 1 : -1) + (i > 0 ? sumArr[i - 1] : 0);
            //如果是最大
            if (sumArr[i] > 0) {
                //直接最大
                max = i + 1;
            } else {
                //所需
                int need = sumArr[i] - 1;
                //如果存在结果
                if (indexMap.containsKey(need)) {
                    //获取开始索引
                    int start = indexMap.get(need);
                    //长度
                    int length = i - start;
                    //刷新最大
                    max = Math.max(max, length);
                }
            }
            //如果没出现过
            if (indexMap.containsKey(sumArr[i]) == false) {
                //记录索引
                indexMap.put(sumArr[i], i);
            }
        }
        //返回最大
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().longestWPI(new int[]{6, 6, 9, 9, 9, 6, 0, 6, 6, 9}));
    }

}
