package normal23;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-09-05
 * 2657. 找到两个数组的前缀公共数组
 * 提示
 * 中等
 * 4
 * 相关企业
 * 给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
 * <p>
 * A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
 * <p>
 * 请你返回 A 和 B 的 前缀公共数组 。
 * <p>
 * 如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,3,2,4], B = [3,1,2,4]
 * 输出：[0,2,3,4]
 * 解释：i = 0：没有公共元素，所以 C[0] = 0 。
 * i = 1：1 和 3 是两个数组的前缀公共元素，所以 C[1] = 2 。
 * i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
 * i = 3：1，2，3 和 4 是两个数组的前缀公共元素，所以 C[3] = 4 。
 * 示例 2：
 * <p>
 * 输入：A = [2,3,1], B = [3,1,2]
 * 输出：[0,1,3]
 * 解释：i = 0：没有公共元素，所以 C[0] = 0 。
 * i = 1：只有 3 是公共元素，所以 C[1] = 1 。
 * i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length == B.length == n <= 50
 * 1 <= A[i], B[i] <= n
 * 题目保证 A 和 B 两个数组都是 n 个元素的排列。
 */
public class Code20 {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        //缓存
        Map<Integer, int[]> map = new HashMap<>();
        //初始化结果
        int[] arr = new int[A.length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取当前数字
            int num1 = A[i];
            int num2 = B[i];
            //如果一不存在
            if (map.containsKey(num1) == false) {
                //默认
                map.put(num1, new int[2]);
            }
            //如果二不存在
            if (map.containsKey(num2) == false) {
                //默认
                map.put(num2, new int[2]);
            }
            //记录
            map.get(num1)[0] = 1;
            map.get(num2)[1] = 1;
            //统计结果数量
            int count = (int) map.values().stream().filter(p -> p[0] + p[1] == 2).count();
            //记录
            arr[i] = count;
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        int[] thePrefixCommonArray = new Code20().findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4});
        System.out.println();
    }

}
