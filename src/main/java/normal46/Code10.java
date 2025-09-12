package normal46;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-09-12
 * 1711. 大餐计数
 * 算术评级: 5
 * 第 222 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1798
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 * <p>
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 */
public class Code10 {

    //所有2的幂
    private static long[] ARR = new long[]{1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L};

    public int countPairs(int[] deliciousness) {
        //数量缓存
        Map<Long, Integer> countMap = new HashMap<>();
        //循环
        for (long num : deliciousness) {
            //+1
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //结果
        int result = 0;
        //循环
        for (long num : deliciousness) {
            //循环所有可能
            for (long target : ARR) {
                //另一个数字
                long other = target - num;
                //如果无效
                if (other < 0) {
                    //本轮过
                    continue;
                }
                //获取另一个数字的数量
                int otherCount = countMap.getOrDefault(other, 0);
                //如果二者相同
                if (other == num) {
                    //额外少一个
                    otherCount--;
                }
                //叠加本次结果
                result = (result + otherCount) % 1000000007;
            }
            //-1
            countMap.put(num, countMap.get(num) - 1);
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        long num = 1;
        System.out.println(num);
        //如果满足
        while (num * 2 > 0) {
            num = num * 2;
            System.out.println(num);
        }
        System.out.println(new Code10().countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

}
