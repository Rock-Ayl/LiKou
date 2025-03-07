package normal30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-03-27
 * 1497. 检查数组对是否可以被 k 整除
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 * <p>
 * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
 * <p>
 * 如果存在这样的分法，请返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * 输出：true
 * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 7
 * 输出：true
 * 解释：划分后的数字对为 (1,6),(2,5) 以及 (3,4) 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5,6], k = 10
 * 输出：false
 * 解释：无法在将数组中的数字分为三对的同时满足每对数字和能够被 10 整除的条件。
 */
public class Code6 {

    public boolean canArrange(int[] arr, int k) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : arr) {
            //该数字的key
            int key;
            //如果是负数
            if (num < 0) {
                //计算
                key = (k - (Math.abs(num) % k)) % k;
            } else {
                //计算key
                key = num % k;
            }
            //记录
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        //如果有特殊情况0 and 奇数
        if (map.containsKey(0) && map.get(0) % 2 != 0) {
            //不可以
            return false;
        }
        //删除特殊情况
        map.remove(0);
        //循环所有情况
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //当前key
            int key = entry.getKey();
            //当前数量
            int count = entry.getValue();
            //计算另一半
            int otherKey = k - key;
            //获取另一半数量
            int otherKeyCount = map.getOrDefault(otherKey, 0);
            //如果数量不同
            if (count != otherKeyCount) {
                //不行
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
    }

}
