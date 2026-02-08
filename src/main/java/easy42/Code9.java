package easy42;

/**
 * 3827. 统计单比特整数
 * 算术评级: 2
 * 第 487 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1191
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 如果一个整数的二进制表示中所有位都相同，则称其为 单比特数（Monobit）。
 * <p>
 * 返回范围[0, n]（包括两端）内 单比特数 的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 范围[0, 1]内的整数对应的二进制表示为"0"和"1"。
 * 每个表示都由相同的位组成，因此答案是2。
 * 示例 2：
 * <p>
 * 输入： n = 4
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 范围[0, 4]内的整数对应的二进制表示为"0"、"1"、"10"、"11"和"100"。
 * 只有0、1和3满足单比特条件。因此答案是3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 */
public class Code9 {

    public int countMonobit(int n) {
        //结果
        int count = 0;
        //数组
        int[] arr = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511};
        //循环
        for (int num : arr) {
            //如果是
            if (num <= n) {
                //+1
                count++;
            } else {
                //跳出
                break;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countMonobit(1000));
    }

}
