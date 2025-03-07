package normal36;

/**
 * @Author ayl
 * @Date 2024-10-17
 * 978. 最长湍流子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
 * <p>
 * 如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
 * <p>
 * 更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j ：
 * 当 k 为奇数时， A[k] > A[k+1]，且
 * 当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j ：
 * 当 k 为偶数时，A[k] > A[k+1] ，且
 * 当 k 为奇数时， A[k] < A[k+1]。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 * 示例 2：
 * <p>
 * 输入：arr = [4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：arr = [100]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 4 * 104
 * 0 <= arr[i] <= 109
 */
public class Code7 {

    /**
     * 单一情况实现
     *
     * @param arr   数组
     * @param right 正反
     * @return
     */
    private int hit(int[] arr, boolean right) {
        //最大连击
        int maxHit = 0;
        //当前连击
        int hit = 0;
        //循环
        for (int i = 0; i < arr.length - 1; i++) {
            //逻辑开关计算
            int change = ((i % 2) + (right == true ? 1 : 0)) % 2;
            //判断逻辑方向
            if (change == 0) {
                //如果满足
                if (arr[i] > arr[i + 1]) {
                    //+1
                    hit++;
                } else {
                    //重置
                    hit = 0;
                }
            } else {
                //如果满足
                if (arr[i] < arr[i + 1]) {
                    //+1
                    hit++;
                } else {
                    //重置
                    hit = 0;
                }
            }
            //刷新最大情况
            maxHit = Math.max(maxHit, hit);
        }
        //返回
        return maxHit;
    }

    public int maxTurbulenceSize(int[] arr) {
        //两种情况,实现
        return Math.max(hit(arr, true), hit(arr, false)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

}
