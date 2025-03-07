package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-08-25
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 */
public class Code18 {

    public static int subtractProductAndSum(int n) {
        //拆分
        char[] nValue = (n + "").toCharArray();
        //存正确的数的
        List<Integer> list = new ArrayList<>();
        //循环
        for (char c : nValue) {
            //记录
            list.add(Integer.parseInt((c + "")));
        }
        //各位数积
        int x = list.get(0);
        //各位数和
        int y = list.get(0);
        //0被用了,从1循环
        for (int i = 1; i < list.size(); i++) {
            //求🐔
            x = x * list.get(i);
            //求和
            y = y + list.get(i);
        }
        //返回
        return x - y;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

}
