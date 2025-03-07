package normal6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-08-16
 * 1324. 竖直打印单词
 * 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "HOW ARE YOU"
 * 输出：["HAY","ORO","WEU"]
 * 解释：每个单词都应该竖直打印。
 * "HAY"
 * "ORO"
 * "WEU"
 * 示例 2：
 * <p>
 * 输入：s = "TO BE OR NOT TO BE"
 * 输出：["TBONTB","OEROOE","   T"]
 * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * 示例 3：
 * <p>
 * 输入：s = "CONTEST IS COMING"
 * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 200
 * s 仅含大写英文字母。
 * 题目数据保证两个单词之间只有一个空格。
 */
public class Code9 {

    public List<String> printVertically(String s) {
        //分割
        String[] words = s.split(" ");
        //最大长度
        int maxLength = 0;
        //循环
        for (String word : words) {
            //刷新最大长度
            maxLength = Math.max(maxLength, word.length());
        }
        //结果
        List<String> result = new ArrayList<>(maxLength);
        //循环
        for (int i = 0; i < maxLength; i++) {
            //字符串
            StringBuffer str = new StringBuffer();
            //循环
            for (String word : words) {
                //获取
                char x;
                //如果可以切割
                if (i < word.length()) {
                    //获取
                    x = word.charAt(i);
                } else {
                    //默认
                    x = ' ';
                }
                //组装
                str.append(x);
            }
            //如果末尾是空格
            while (str.charAt(str.length() - 1) == ' ') {
                //去除
                str.deleteCharAt(str.length() - 1);
            }
            //组装
            result.add(str.toString());
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().printVertically("CONTEST IS COMING"));
    }
}
