package easy35;

/**
 * @Author ayl
 * @Date 2024-01-02
 * 1551. 使数组中所有元素相等的最小操作数
 * 提示
 * 中等
 * 39
 * 相关企业
 * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
 * <p>
 * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
 * <p>
 * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：arr = [1, 3, 5]
 * 第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
 * 第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
 * 示例 2：
 * <p>
 * 输入：n = 6
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 */
public class Code15 {

    public int minOperations(int n) {
        //需要操作的数字数量
        int count = n / 2;
        //操作数字加减量区间,按照 n 为 奇偶数分别计算
        int left = n % 2 == 0 ? 1 : 2;
        int right = (count - 1) * 2 + left;
        //计算结果
        return (left + right) * (count / 2) + (count % 2 == 0 ? 0 : (left + right) / 2);
    }

    // 1 3 5 7 9 11 13 15
    //      1 + 3 + 5 + 7
    // 1 3 5 7 9 11 13
    //         2 +4+ 6
    public static void main(String[] args) {
        System.out.println(new Code15().minOperations(7));
    }

}
