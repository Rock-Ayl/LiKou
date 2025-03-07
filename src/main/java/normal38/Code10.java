package normal38;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-12-06
 * 2554. 从一个范围内选择最多整数 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 banned 和两个整数 n 和 maxSum 。你需要按照以下规则选择一些整数：
 * <p>
 * 被选择整数的范围是 [1, n] 。
 * 每个整数 至多 选择 一次 。
 * 被选择整数不能在数组 banned 中。
 * 被选择整数的和不超过 maxSum 。
 * 请你返回按照上述规则 最多 可以选择的整数数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：banned = [1,6,5], n = 5, maxSum = 6
 * 输出：2
 * 解释：你可以选择整数 2 和 4 。
 * 2 和 4 在范围 [1, 5] 内，且它们都不在 banned 中，它们的和是 6 ，没有超过 maxSum 。
 * 示例 2：
 * <p>
 * 输入：banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
 * 输出：0
 * 解释：按照上述规则无法选择任何整数。
 * 示例 3：
 * <p>
 * 输入：banned = [11], n = 7, maxSum = 50
 * 输出：7
 * 解释：你可以选择整数 1, 2, 3, 4, 5, 6 和 7 。
 * 它们都在范围 [1, 7] 中，且都没出现在 banned 中，它们的和是 28 ，没有超过 maxSum 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= banned.length <= 104
 * 1 <= banned[i], n <= 104
 * 1 <= maxSum <= 109
 */
public class Code10 {

    public int maxCount(int[] banned, int n, int maxSum) {
        //黑名单集合
        Set<Integer> cannotSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        //当前和
        int sum = 0;
        //结果数量
        int count = 0;
        //索引
        int index = 1;
        //循环
        while (index <= n) {
            //如果是黑名单
            if (cannotSet.contains(index)) {
                //+1
                index++;
                //本轮过
                continue;
            }
            //清算
            sum += index++;
            //如果大于结果
            if (sum > maxSum) {
                //跳出
                break;
            }
            //+1
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().maxCount(new int[]{1, 6, 5}, 5, 6));
    }

}
