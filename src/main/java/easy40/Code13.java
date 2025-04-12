package easy40;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-04-12
 * 3507. 移除最小数对使数组有序 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 * <p>
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * <p>
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,2,3,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。
 * 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。
 * 数组 nums 在两次操作后变为非递减。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,2]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组 nums 已经是非递减的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * -1000 <= nums[i] <= 1000
 */
public class Code13 {

    public int minimumPairRemoval(int[] nums) {
        //转为列表
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        //操作
        int count = 0;
        //循环
        while (true) {
            //最小和
            int minSum = 0;
            //最小和索引
            int minSumIndex = -1;
            //错误数量
            int errorCount = 0;
            //循环
            for (int i = 1; i < numList.size(); i++) {
                //如果不符合规矩
                if (numList.get(i - 1) > numList.get(i)) {
                    //+1
                    errorCount++;
                }
                //如果需要更新
                if (minSumIndex == -1 || (minSum > (numList.get(i - 1) + numList.get(i)))) {
                    //初始化
                    minSumIndex = i;
                    minSum = numList.get(i - 1) + numList.get(i);
                }
            }
            //如果是目标结果
            if (errorCount == 0) {
                //跳出
                break;
            }
            //删除右边的
            numList.remove(minSumIndex - 1);
            //修改
            numList.set(minSumIndex - 1, minSum);
            //+1
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }

}