package normal48;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-11-27
 * 3020. 子集中元素的最大数量
 * 算术评级: 5
 * 第 382 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1741
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 正整数 数组 nums 。
 * <p>
 * 你需要从数组中选出一个满足下述条件的子集：
 * <p>
 * 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 8, 4, 2] 则不符合。
 * 返回满足这些条件的子集中，元素数量的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,4,1,2,2]
 * 输出：3
 * 解释：选择子集 {4,2,2} ，将其放在数组 [2,4,2] 中，它遵循该模式，且 22 == 4 。因此答案是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,4]
 * 输出：1
 * 解释：选择子集 {1}，将其放在数组 [1] 中，它遵循该模式。因此答案是 1 。注意我们也可以选择子集 {2} 、{4} 或 {3} ，可能存在多个子集都能得到相同的答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code9 {

    public int maximumLength(int[] nums) {

        /**
         * 构建缓存
         */

        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //+1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //数字列表
        List<Integer> numList = new ArrayList<>(map.keySet());
        //排序
        numList.sort(Integer::compareTo);

        /**
         * 特殊情况 1
         */

        //最长长度
        int maxLength = 0;
        //如果存在1
        if (map.containsKey(1)) {
            //获取特殊情况
            Integer oneCount = map.get(1);
            //如果是偶数
            if (oneCount % 2 == 0) {
                //-1
                oneCount--;
            }
            //覆盖
            maxLength = oneCount;
            //删除之
            map.remove(1);
        }

        /**
         * 递归标准请求
         */

        //循环
        for (Integer first : numList) {
            //如果不存在
            if (map.containsKey(first) == false) {
                //本轮过
                continue;
            }
            //计算结果
            int count = count(map, first);
            //刷新结果
            maxLength = Math.max(maxLength, count);
        }
        //返回
        return maxLength;
    }

    //递归计算结果
    private int count(Map<Integer, Integer> map, int number) {
        //尝试获取数量
        Integer numberCount = map.get(number);
        //判空
        if (numberCount == null) {
            //过
            return 0;
        }
        //删除对应键
        map.remove(number);
        //如果是1
        if (numberCount.equals(1)) {
            //返回
            return 1;
        }
        //下一波
        int count = count(map, number * number);
        //如果为0
        if (count == 0) {
            //返回
            return 1;
        } else {
            //递归
            return 2 + count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code9().maximumLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}));
    }

}
