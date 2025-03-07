package normal4;

/**
 * @Author ayl
 * @Date 2021-07-08
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class Code14 {

    /***
     * 倒着找
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        //次数
        int size = 0;
        //结束
        int end = nums.length - 1;
        //循环
        while (end != 0) {
            //最小
            int min = end;
            //循环
            for (int i = end - 1; i >= 0; i--) {
                //如果能一步走过去
                if ((nums[i] + i) >= end) {
                    //刷新
                    min = i;
                }
            }
            //如果不在更新
            if (end == min) {
                //结束
                break;
            }
            //刷新
            end = min;
            //次数+1
            size++;
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
