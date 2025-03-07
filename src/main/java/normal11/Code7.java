package normal11;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-02-04
 * 1338. 数组大小减半
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * <p>
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * 输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * 示例 2：
 * <p>
 * 输入：arr = [7,7,7,7,7,7]
 * 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 * 示例 3：
 * <p>
 * 输入：arr = [1,9]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [1000,1000,3,7]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * arr.length 为偶数
 * 1 <= arr[i] <= 10^5
 */
public class Code7 {

    public int minSetSize(int[] arr) {
        //目标值
        int target = arr.length / 2;
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr) {
            //记录
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //转化为列表
        List<Integer> list = map
                .entrySet()
                .stream()
                .map(p -> p.getValue())
                .collect(Collectors.toList());
        //排序
        Collections.sort(list);
        //结果初始化
        int count = 0;
        //循环
        for (int i = list.size() - 1; i >= 0; i--) {
            //计算
            target -= list.get(i);
            //+1
            count++;
            //如果目标结果了
            if (target <= 0) {
                //返回
                return count;
            }
        }
        //返回默认
        return map.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }

}
