package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-08-21
 * 771. 宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
public class Code15 {

    public static int numJewelsInStones(String J, String S) {
        //宝石个数
        int num = 0;
        //所有宝石类型
        char[] types = J.toCharArray();
        //创建hash
        Set<String> set = new HashSet<>();
        //循环
        for (char type : types) {
            //组装
            set.add(type + "");
        }
        //循环
        for (char c : S.toCharArray()) {
            //判断是否为宝石
            if (set.contains(c + "")) {
                //记录
                num++;
            }
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

}
