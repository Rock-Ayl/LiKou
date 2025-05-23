package easy33;

/**
 * @Author ayl
 * @Date 2023-08-23
 * LCR 003. 比特位计数
 * 简单
 * 143
 * 相关企业
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 * <p>
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * 说明 :
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
 * 要求算法的空间复杂度为 O(n) 。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。
 * <p>
 * <p>
 * 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/
 */
public class Code1 {

    public int[] countBits(int n) {
        //结果
        int[] result = new int[n + 1];
        //指针
        int p = 0;
        //循环
        while (p < result.length) {
            //1的数量
            int sum = 0;
            //当前数字
            int num = p;
            //如果有数字
            while (num > 0) {
                //叠加1的数量
                sum += num % 2;
                //位移1位
                num = num >> 1;
            }
            //记录结果并+1
            result[p++] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int num = 8;
        //如果有
        while (num > 0) {
            System.out.println();
            num = num >> 1;
        }
        new Code1().countBits(5);
    }

}
