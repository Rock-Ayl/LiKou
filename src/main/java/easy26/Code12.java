package easy26;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-01-01
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 */
public class Code12 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //转化为结果map
        Map<Integer, Integer> map = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toMap(p -> p, p -> -1));
        out:
        //循环
        for (int i = 0; i < nums2.length; i++) {
            //数字
            int num = nums2[i];
            //如果不存在
            if (map.containsKey(num) == false) {
                //本轮过
                continue;
            }
            //循环,开始寻找
            for (int j = i + 1; j < nums2.length; j++) {
                //下一个
                int next = nums2[j];
                //如果更大了
                if (next > num) {
                    //记录
                    map.put(num, next);
                    //本轮过
                    continue out;
                }
            }
        }
        //初始化结果
        int[] result = new int[nums1.length];
        //循环
        for (int i = 0; i < nums1.length; i++) {
            //组装
            result[i] = map.get(nums1[i]);
        }
        //返回
        return result;
    }

    //单调栈
    public int[] star(int[] nums1, int[] nums2) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //循环,倒叙
        for (int i = nums2.length - 1; i >= 0; --i) {
            //当前数字
            int num = nums2[i];
            //如果栈有东西,并且当前比站内更大
            while (stack.isEmpty() == false && num >= stack.peek()) {
                //
                stack.pop();
            }
            //记录更大的结果
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            //记录更大
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().star(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }

}
