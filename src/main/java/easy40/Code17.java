package easy40;

/**
 * 3536. 两个数字的最大乘积
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个正整数 n。
 * <p>
 * 返回 任意两位数字 相乘所得的 最大 乘积。
 * <p>
 * 注意：如果某个数字在 n 中出现多次，你可以多次使用该数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 31
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * n 的数字是 [3, 1]。
 * 任意两位数字相乘的结果为：3 * 1 = 3。
 * 最大乘积为 3。
 * 示例 2：
 * <p>
 * 输入： n = 22
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * n 的数字是 [2, 2]。
 * 任意两位数字相乘的结果为：2 * 2 = 4。
 * 最大乘积为 4。
 * 示例 3：
 * <p>
 * 输入： n = 124
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * n 的数字是 [1, 2, 4]。
 * 任意两位数字相乘的结果为：1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8。
 * 最大乘积为 8。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= n <= 109
 *
 * @Author ayl
 * @Date 2025-05-21
 */
public class Code17 {

    public int maxProduct(int n) {
        //数组
        int[] arr = new int[10];
        //如果还有
        while (n > 9) {
            //+1
            arr[n % 10]++;
            //下一个
            n = n / 10;
        }
        //个位数+1
        arr[n]++;
        //索引
        int index = arr.length - 1;
        //如果没有
        while (arr[index] == 0) {
            //-1
            index--;
        }
        //获取数字1
        int first = index;
        //扣减
        arr[index]--;
        //如果没有
        while (arr[index] == 0) {
            //-1
            index--;
        }
        //获取数字2
        int second = index;
        //返回结果
        return first * second;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maxProduct(13));
    }

}
