package easy26;

/**
 * @Author ayl
 * @Date 2023-01-09
 * 2529. 正整数和负整数的最大计数
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [-3,-2,-1,0,0,1,2]
 * 输出：3
 * 解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,20,66,1314]
 * 输出：4
 * 解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums 按 非递减顺序 排列。
 */
public class Code14 {

    public int maximumCount(int[] nums) {
        //如果边界就是
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            //返回
            return nums.length;
        }
        //如果都是0
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
            //过
            return 0;
        }
        //中间坐标
        int p = nums.length / 2;
        //中间数字
        int mid = nums[p];
        //双指针
        int left = p;
        int right = p;
        //如果正好是0
        if (mid == 0) {
            //循环
            while (nums[right] == 0) {
                //先进位,如果到头了
                if (++right == nums.length) {
                    //退一位
                    right--;
                    //跳出
                    break;
                }
            }
            //循环
            while (nums[left] == 0) {
                //进位
                left--;
                //如果到头了
                if (left < 0) {
                    //退一位
                    left = 0;
                    //跳出
                    break;
                }
            }
        } else if (mid > 0) {
            //循环
            while (nums[right - 1] > 0) {
                //进位
                right--;
            }
            //接力
            left = right - 1;
            //循环
            while (nums[left] == 0) {
                //进位
                left--;
                //如果到头了
                if (left < 0) {
                    //退一位
                    left = 0;
                    //跳出
                    break;
                }
            }
        } else {
            //循环
            while (nums[left + 1] < 0) {
                //进位
                left++;
            }
            //接力
            right = left + 1;
            //循环
            while (nums[right] == 0) {
                //先进位,如果到头了
                if (++right == nums.length) {
                    //退一位
                    right--;
                    //跳出
                    break;
                }
            }
        }
        //返回最大结果
        return Math.max(left + 1, nums.length - right);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maximumCount(new int[]{-1764, -1562, -1226, -1216, -402, -386, -133, 979, 1227, 1992}));
    }

}
