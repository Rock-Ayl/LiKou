package normal6;

/**
 * @Author ayl
 * @Date 2021-08-17
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 */
public class Code10 {

    public int longestSubarray(int[] nums) {
        //最长
        int max = 0;
        //当前长度
        int thisSize = 0;
        //上一段的长度
        int lastSize = 0;
        //全局是否有0
        boolean zero = false;
        //是否中间有0
        boolean hasZero = false;
        //指针
        int p = 0;
        //循环
        while (p < nums.length) {
            //寻找第一个1
            if (nums[p] == 1) {
                //结束
                break;
            } else {
                //存在
                zero = true;
            }
            //下一个
            p++;
        }
        //循环
        for (int i = p; i < nums.length; i++) {
            //如果是连续
            if (nums[i] == 1) {
                //+1
                thisSize++;
            } else {
                //如果有
                if (hasZero) {
                    //更新
                    max = Math.max(max, thisSize);
                    //计算
                    thisSize -= lastSize;
                    lastSize = thisSize;
                } else {
                    //记录
                    lastSize = thisSize;
                    //有0了
                    hasZero = true;
                }
            }
        }
        //如果都没有0
        if (zero == false && hasZero == false) {
            //还需要删除一个
            thisSize--;
        }
        //返回
        return Math.max(max, thisSize);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().longestSubarray(new int[]{1, 1, 0, 1}));
    }
}
