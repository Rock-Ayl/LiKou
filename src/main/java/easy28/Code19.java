package easy28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-03-05
 * 6312. 最小和分割
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 * <p>
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 * <p>
 * 注意：
 * <p>
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 * <p>
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= num <= 109
 */
public class Code19 {

    public int splitNum(int num) {
        //对应两个数
        int num1 = 0;
        int num2 = 0;
        //缓存
        List<Integer> numList = new ArrayList<>();
        //如果有
        while (num > 0) {
            //记录
            numList.add(num % 10);
            //下一个
            num = num / 10;
        }
        //排序
        Collections.sort(numList);
        //加到哪里
        boolean first = true;
        //循环
        for (Integer integer : numList) {
            //如果是0
            if (integer == 0) {
                //本轮过
                continue;
            }
            //如果是第一个
            if (first) {
                //叠加
                num1 = num1 * 10 + integer;
            } else {
                //叠加
                num2 = num2 * 10 + integer;
            }
            //更换方向
            first = !first;
        }
        //返回结果
        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().splitNum(4325));
    }

}
