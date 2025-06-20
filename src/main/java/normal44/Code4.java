package normal44;

/**
 * @Author ayl
 * @Date 2025-06-20
 * 1218. 最长定差子序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 * <p>
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 */
public class Code4 {

    public int longestSubsequence(int[] arr, int difference) {
        //前置最大缓存
        int[] maxArr = new int[20002 + (Math.abs(difference) * 2)];
        //最大结果
        int max = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //计算出缓存索引
            int num = arr[i] + maxArr.length / 2;
            //计算出上一个值,并计算出当前位置最大可能
            int maxCount = maxArr[num - difference] + 1;
            //刷新最大
            max = Math.max(max, maxCount);
            //刷新最大
            maxArr[num] = Math.max(maxCount, maxArr[num]);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

}