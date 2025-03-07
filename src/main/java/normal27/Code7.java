package normal27;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-12-20
 * 2348. 全 0 子数组的数目
 * 提示
 * 中等
 * 17
 * 相关企业
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * <p>
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,0,0,2,0,0,4]
 * 输出：6
 * 解释：
 * 子数组 [0] 出现了 4 次。
 * 子数组 [0,0] 出现了 2 次。
 * 不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,2,0,0]
 * 输出：9
 * 解释：
 * 子数组 [0] 出现了 5 次。
 * 子数组 [0,0] 出现了 3 次。
 * 子数组 [0,0,0] 出现了 1 次。
 * 不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,10,2019]
 * 输出：0
 * 解释：没有全 0 子数组，所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Code7 {

    //连续0的数量
    private Map<Integer, Integer> zeroMap = new HashMap<>();
    //结果
    private long result = 0;

    public long zeroFilledSubarray(int[] nums) {
        //左边界
        int left = 0;
        //循环
        while (left < nums.length) {
            //如果不是0
            while (left < nums.length && nums[left] != 0) {
                //进位
                left++;
            }
            //如果越界
            if (left == nums.length) {
                //跳出
                break;
            }
            //有边界
            int right = left;
            //如果可以进位
            while (right < nums.length - 1 && nums[right + 1] == 0) {
                //进位
                right++;
            }
            //本次连续0的数量
            int count = right - left + 1;
            //记录
            zeroMap.put(count, zeroMap.getOrDefault(count, 0) + 1);
            //重新来
            left = right + 1;
        }
        //判空
        if(zeroMap.isEmpty()){
            //返回
            return result;
        }
        //最大连续长度
        int maxLength = zeroMap.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
        //计算结果
        count(maxLength);
        //返回
        return result;
    }

    //根据0的连续数,计算出现的次数
    private void count(long zeroCount) {
        //指针
        int p = 1;
        //和
        long sum = 0L;
        //循环
        while (p <= zeroCount) {
            //计算
            sum += p;
            //如果存在
            if (zeroMap.containsKey(p)) {
                //叠加结果
                result += zeroMap.get(p) * sum;
            }
            //进位
            p++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code7().zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }

}
