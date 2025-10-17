package normal47;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-10-17
 * 面试题 17.14. 最小K个数
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Code3 {

    public int[] smallestK(int[] arr, int k) {
        //实现
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    public static void main(String[] args) {

    }

}
