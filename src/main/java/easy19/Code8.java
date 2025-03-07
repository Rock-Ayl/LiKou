package easy19;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-05-24
 * 2148. 元素计数
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [11,7,2,15]
 * 输出：2
 * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
 * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
 * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,3,3,90]
 * 输出：2
 * 解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
 * 由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -105 <= nums[i] <= 105
 */
public class Code8 {

    public int countElements(int[] nums) {
        //如果太小
        if (nums.length < 3) {
            //返回
            return 0;
        }
        //排序
        Arrays.sort(nums);
        //首位要删除的元素个数,默认0
        int minCount = 0;
        //首尾元素位置
        int firstP = 1;
        int endP = nums.length - 2;
        //如果当前和后一个相同
        while (firstP < nums.length && nums[firstP - 1] == nums[firstP]) {
            //下一个
            firstP++;
            //+1
            minCount++;
        }
        //如果当前和前一个相同
        while (endP >= 0 && nums[endP + 1] == nums[endP]) {
            //下一个
            endP--;
            //+1
            minCount++;
        }
        //如果越界了
        if (firstP > endP) {
            //不存在
            return 0;
        }
        //返回结果
        return nums.length - 2 - minCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().countElements(new int[]{-71, -71, 93, -71, 40}));
    }

}
