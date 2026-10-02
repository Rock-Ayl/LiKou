package easy44;

/**
 * 4065. 移除不同值重排数组
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums。
 * <p>
 * 初始时，你有一个 空 数组 ans。重复执行以下操作，直到 nums 变为 空 ：
 * <p>
 * 找出当前 nums 中 所有不同 的值。
 * 将当前 nums 中每个 不同 的值各移除一个，并按 升序 将这些值依次添加到 ans 中。
 * 返回数组 ans。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,1,3,2,1,3]
 * <p>
 * 输出： [1,2,3,1,3,3]
 * <p>
 * 解释：
 * <p>
 * 操作	添加到 ans 的值	操作后的 nums	操作后的 ans
 * 1	1, 2, 3	[3, 1, 3]	[1, 2, 3]
 * 2	1, 3	[3]	[1, 2, 3, 1, 3]
 * 3	3	[]	[1, 2, 3, 1, 3, 3]
 * 此时 nums 已为空，因此答案为 [1, 2, 3, 1, 3, 3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [7,7,4,4,4]
 * <p>
 * 输出： [4,7,4,7,4]
 * <p>
 * 解释：
 * <p>
 * 操作	添加到 ans 的值	操作后的 nums	操作后的 ans
 * 1	4, 7	[7, 4, 4]	[4, 7]
 * 2	4, 7	[4]	[4, 7, 4, 7]
 * 3	4	[]	[4, 7, 4, 7, 4]
 * 此时 nums 已为空，因此答案为 [4, 7, 4, 7, 4]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code10 {

    public int[] rearrangeArray(int[] nums) {
        //计数器
        int[] count = new int[101];
        //循环
        for (int num : nums) {
            //+1
            count[num]++;
        }
        //索引
        int index = 0;
        //循环
        while (index < nums.length) {
            //本次大循环
            for (int i = 1; i <= 100; i++) {
                //如果有
                if (count[i] > 0) {
                    //使用、并+1
                    nums[index++] = i;
                    //计数器-1
                    count[i]--;
                }
            }
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().rearrangeArray(new int[]{3, 1, 3, 2, 1, 3}));
    }

}
