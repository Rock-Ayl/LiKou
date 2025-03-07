package easy33;

/**
 * @Author ayl
 * @Date 2023-09-23
 * 2843. 统计对称整数的数目
 * 提示
 * 简单
 * 9
 * 相关企业
 * 给你两个正整数 low 和 high 。
 * <p>
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * <p>
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 1, high = 100
 * 输出：9
 * 解释：在 1 到 100 范围内共有 9 个对称整数：11、22、33、44、55、66、77、88 和 99 。
 * 示例 2：
 * <p>
 * 输入：low = 1200, high = 1230
 * 输出：4
 * 解释：在 1200 到 1230 范围内共有 4 个对称整数：1203、1212、1221 和 1230 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= low <= high <= 104
 */
public class Code12 {

    public int countSymmetricIntegers(int low, int high) {
        //结果
        int count = 0;
        //循环
        for (int i = low; i <= high; i++) {
            //如果是2位数
            if (i > 9 && i < 100) {
                //如果是结果
                if (i % 11 == 0) {
                    //记录
                    count++;
                }
            }//如果是4位数
            if (i > 999 && i < 10000) {
                //左右分别和
                int left = 0;
                int right = 0;
                //当前数字
                int num = i;
                //叠加
                right += num % 10;
                num = num / 10;
                right += num % 10;
                num = num / 10;
                //叠加
                left += num % 10;
                num = num / 10;
                left += num % 10;
                num = num / 10;
                //如果是结果
                if (left == right) {
                    //记录
                    count++;
                }
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().countSymmetricIntegers(1200, 1230));
    }

}
