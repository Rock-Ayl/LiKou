package easy26;

/**
 * @Author ayl
 * @Date 2023-01-05
 * 2520. 统计能整除数字的位数
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 * <p>
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 * <p>
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 * num 的数位中不含 0
 */
public class Code13 {

    public int countDigits(int num) {
        //结果
        int count = 0;
        //当前数字
        int nextNum = num;
        //如果有数字
        while (nextNum > 0) {
            //如果可以整除当前值
            if (num % (nextNum % 10) == 0) {
                //记录
                count++;
            }
            //下一个
            nextNum = nextNum / 10;
        }
        //返回count
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countDigits(121));
    }
}
