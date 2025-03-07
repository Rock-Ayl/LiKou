package easy;

/**
 * Created By Rock-Ayl on 2020-08-27
 * 1342. 将数字变成 0 的操作次数
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * 示例 2：
 * <p>
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * 示例 3：
 * <p>
 * 输入：num = 123
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 10^6
 * 通过次数25,664提交次数31,160
 */
public class Code19 {

    public static int numberOfSteps(int num) {
        //次数
        int count = 0;
        //循环
        while (num != 0) {
            //如果是偶数
            if (num % 2 == 0) {
                //除以2
                num = num / 2;
            } else {
                //减一
                num--;
            }
            //记录次数
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
}
