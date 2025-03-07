package normal39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2025-01-09
 * 2007. 从双倍数组中还原原数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 * <p>
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 * <p>
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 */
public class Code4 {

    public int[] findOriginalArray(int[] changed) {
        //如果是奇数
        if (changed.length % 2 != 0) {
            //过
            return new int[]{};
        }
        //排序
        Arrays.sort(changed);
        //缓存
        Map<Integer, Stack<Integer>> indexMap = new HashMap<>();
        //循环
        for (int i = 0; i < changed.length; i++) {
            //当前数字
            int num = changed[i];
            //判断
            if (indexMap.containsKey(num)) {
                //记录
                indexMap.get(num).push(i);
            } else {
                //初始化
                Stack<Integer> stack = new Stack<>();
                //记录
                stack.push(i);
                //组装
                indexMap.put(num, stack);
            }
        }
        //使用过的缓存
        int[] useArr = new int[changed.length];
        //目标数组长度
        int targetLength = changed.length / 2;
        //初始化结果
        int[] result = new int[targetLength];
        //返回数字
        int resultIndex = 0;
        //循环
        for (int i = changed.length - 1; i >= 0; i--) {
            //如果被用过
            if (useArr[i] > 0) {
                //本轮过
                continue;
            }
            //记录被使用了
            useArr[i]++;
            //获取当前数字
            int big = changed[i];
            //如果是奇数
            if (big % 2 == 1) {
                //不可能
                return new int[]{};
            }
            //计算目标
            int small = big / 2;
            //如果没有
            if (indexMap.containsKey(small) == false) {
                //不可能
                return new int[]{};
            }
            //获取索引列表
            Stack<Integer> stack = indexMap.get(small);
            //如果被使用了
            while (stack.isEmpty() == false && useArr[stack.peek()] > 0) {
                //删除废弃的
                stack.pop();
            }
            //如果不可能
            if (stack.isEmpty()) {
                //不可能
                return new int[]{};
            }
            //记录使用过
            useArr[stack.pop()]++;
            //记录结果
            result[resultIndex++] = small;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] originalArray = new Code4().findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
        System.out.println();
    }

}
