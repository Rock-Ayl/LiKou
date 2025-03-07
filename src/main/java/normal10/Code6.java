package normal10;

/**
 * @Author ayl
 * @Date 2022-01-18
 * 915. 分割数组
 * 给定一个数组 A，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 */
public class Code6 {

    public int partitionDisjoint(int[] nums) {
        //如果太短
        if (nums.length < 3) {
            //返回
            return 1;
        }
        //每个节点最大值
        int[] arr = new int[nums.length];
        //右边最小
        int min = Integer.MAX_VALUE;
        //循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //当前
            int num = nums[i];
            //如果更小
            if (num < min) {
                //刷新
                min = num;
            }
            //记录
            arr[i] = min;
        }
        //左边最大
        int max = Integer.MIN_VALUE;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //当前
            int num = nums[i];
            //如果更大
            if (num > max) {
                //刷新
                max = num;
            }
            //如果已经满足
            if (max <= arr[i + 1]) {
                //返回结果
                return i + 1;
            }
        }
        //默认
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Code6().partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
    }

}
