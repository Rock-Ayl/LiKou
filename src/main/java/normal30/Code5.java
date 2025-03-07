package normal30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-03-26
 * 1726. 同积元组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums 中的所有元素 互不相同
 */
public class Code5 {

    public int tupleSameProduct(int[] nums) {
        //缓存
        Map<Integer, Integer> cacheMap = new HashMap<>();
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //计算key
                int key = nums[i] * nums[j];
                //记录
                cacheMap.put(key, cacheMap.getOrDefault(key, 0) + 1);
            }
        }
        //结果
        int count = 0;
        //循环
        for (Map.Entry<Integer, Integer> entry : cacheMap.entrySet()) {
            //少于2组,本次结果为0,否则每2组就有8种情况,根据高斯算法计算组数*8
            count += entry.getValue() < 2 ? 0 : (entry.getValue() - 1) * entry.getValue() * 4;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().tupleSameProduct(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}));
    }

}
