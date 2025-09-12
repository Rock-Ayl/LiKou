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
    private static int[] ARR = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};

    public int countPairs(int[] deliciousness) {
        //数量缓存
        Map<Integer, Integer> countMap = new HashMap<>();
        //循环
        for (int num : deliciousness) {
            //+1
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //结果
        int result = 0;
        //循环
        for (int num : deliciousness) {
            //循环所有可能
            for (int target : ARR) {
                //另一个数字
                int other = target - num;
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
