package normal35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-09-17
 * 3179. K 秒后第 N 个元素的值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 n 和 k。
 * <p>
 * 最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。
 * <p>
 * 返回 k 秒后 a[n - 1] 的值。
 * <p>
 * 由于答案可能非常大，返回其对 109 + 7 取余 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 5
 * <p>
 * 输出：56
 * <p>
 * 解释：
 * <p>
 * 时间（秒）	数组状态
 * 0	[1,1,1,1]
 * 1	[1,2,3,4]
 * 2	[1,3,6,10]
 * 3	[1,4,10,20]
 * 4	[1,5,15,35]
 * 5	[1,6,21,56]
 * 示例 2：
 * <p>
 * 输入：n = 5, k = 3
 * <p>
 * 输出：35
 * <p>
 * 解释：
 * <p>
 * 时间（秒）	数组状态
 * 0	[1,1,1,1,1]
 * 1	[1,2,3,4,5]
 * 2	[1,3,6,10,15]
 * 3	[1,4,10,20,35]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 1000
 */
public class Code5 {

    public int valueAfterKSeconds(int n, int k) {
        //缓存
        int[][] allArr = new int[k + 1][n];
        //初始化第一行
        Arrays.fill(allArr[0], 1);
        //循环
        for (int i = 1; i < allArr.length; i++) {
            //获取当前数组
            int[] arr = allArr[i];
            //获取上一个数组
            int[] lastArr = allArr[i - 1];
            //固定第一个
            arr[0] = 1;
            //循环2
            for (int j = 1; j < arr.length; j++) {
                //计算当前
                arr[j] = (lastArr[j] + arr[j - 1]) % 1000000007;
            }
        }
        //返回
        return allArr[allArr.length - 1][allArr[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code5().valueAfterKSeconds(4, 5));
    }

}
