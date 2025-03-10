package easy36;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-03-10
 * 3069. 将元素分配到两个数组中 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。
 * <p>
 * 你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 * <p>
 * 如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
 * 通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 * <p>
 * 返回数组 result 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：[2,3,1]
 * 解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
 * 在第 3 次操作中，由于 arr1 的最后一个元素大于 arr2 的最后一个元素（2 > 1），将 nums[3] 追加到 arr1 。
 * 3 次操作后，arr1 = [2,3] ，arr2 = [1] 。
 * 因此，连接形成的数组 result 是 [2,3,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,3,8]
 * 输出：[5,3,4,8]
 * 解释：在前两次操作后，arr1 = [5] ，arr2 = [4] 。
 * 在第 3 次操作中，由于 arr1 的最后一个元素大于 arr2 的最后一个元素（5 > 4），将 nums[3] 追加到 arr1 ，因此 arr1 变为 [5,3] 。
 * 在第 4 次操作中，由于 arr2 的最后一个元素大于 arr1 的最后一个元素（4 > 3），将 nums[4] 追加到 arr2 ，因此 arr2 变为 [4,8] 。
 * 4 次操作后，arr1 = [5,3] ，arr2 = [4,8] 。
 * 因此，连接形成的数组 result 是 [5,3,4,8] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 50
 * 1 <= nums[i] <= 100
 * nums中的所有元素都互不相同。
 */
public class Code13 {

    public int[] resultArray(int[] nums) {
        //两组
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //初始化
        list1.add(nums[0]);
        list2.add(nums[1]);
        //循环
        for (int i = 2; i < nums.length; i++) {
            //如果左边更大
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                //组装
                list1.add(nums[i]);
            } else {
                //组装
                list2.add(nums[i]);
            }
        }
        //指针
        int p = 0;
        //循环1
        for (Integer num : list1) {
            //覆盖
            nums[p++] = num;
        }
        //循环2
        for (Integer num : list2) {
            //覆盖
            nums[p++] = num;
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().resultArray(new int[]{5, 4, 3, 8}));
    }

}
