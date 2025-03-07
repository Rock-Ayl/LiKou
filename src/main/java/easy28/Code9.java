package easy28;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-02-19
 * 6359. 替换一个数字后的最大差值
 * 给你一个整数 num 。你知道 Danny Mittal 会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
 * <p>
 * 请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差位多少。
 * <p>
 * 注意：
 * <p>
 * 当 Danny 将一个数字 d1 替换成另一个数字 d2 时，Danny 需要将 nums 中所有 d1 都替换成 d2 。
 * Danny 可以将一个数字替换成它自己，也就是说 num 可以不变。
 * Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
 * 替换后得到的数字可以包含前导 0 。
 * Danny Mittal 获得周赛 326 前 10 名，让我们恭喜他。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 11891
 * 输出：99009
 * 解释：
 * 为了得到最大值，我们将数字 1 替换成数字 9 ，得到 99899 。
 * 为了得到最小值，我们将数字 1 替换成数字 0 ，得到 890 。
 * 两个数字的差值为 99009 。
 * 示例 2：
 * <p>
 * 输入：num = 90
 * 输出：99
 * 解释：
 * 可以得到的最大值是 99（将 0 替换成 9），最小值是 0（将 9 替换成 0）。
 * 所以我们得到 99 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 108
 */
public class Code9 {

    public int minMaxDifference(int num) {

        /**
         * 获取最大值
         */

        //转化为str
        String numValue = String.valueOf(num);
        //指针
        int p = 0;
        //如果当前是9
        while (numValue.charAt(p) == '9') {
            //进位
            p++;
            //如果从头到尾都是9
            if (p == numValue.length()) {
                //直接返回即可
                return num;
            }
        }
        //将第一个发现不是9的换成9,并转化为数字,作为最大值
        int max = Integer.valueOf(numValue.replace(numValue.charAt(p), '9'));

        /**
         * 获取最小值
         */

        //最小值,默认原数字
        int min = num;
        //缓存
        Set<Character> set = new HashSet<>();
        //循环
        for (char c : numValue.toCharArray()) {
            //记录
            set.add(c);
        }
        //循环
        for (Character key : set) {
            //为每个key刷新最小值
            min = Math.min(min, Integer.valueOf(numValue.replace(key, '0')));
        }

        /**
         * 返回结果
         */

        //返回
        return max - min;
    }


    public static void main(String[] args) {
        System.out.println(new Code9().minMaxDifference(456));
    }

}
