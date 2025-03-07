package easy4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-12-14
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Code11 {

    public static boolean isHappy(int n) {
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        while (true) {
            //和
            int sum = 0;
            //转化为每个数并循环
            for (char c : (n + "").toCharArray()) {
                //计算出数
                int a = c - '0';
                //求平方叠加
                sum += a * a;
            }
            //如果不是快乐数
            if (sum != 1) {
                //如果缓存已经存在了当前数
                if (set.contains(sum)) {
                    //无限循环,不是快乐数
                    return false;
                }
                //记录缓存
                set.add(sum);
                //变更当前数
                n = sum;
            } else {
                //是快乐数
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
