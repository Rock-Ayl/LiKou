package normal37;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-11-09
 * 3324. 出现在屏幕上的字符串序列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 target。
 * <p>
 * Alice 将会使用一种特殊的键盘在她的电脑上输入 target，这个键盘 只有两个 按键：
 * <p>
 * 按键 1：在屏幕上的字符串后追加字符 'a'。
 * 按键 2：将屏幕上字符串的 最后一个 字符更改为英文字母表中的 下一个 字符。例如，'c' 变为 'd'，'z' 变为 'a'。
 * 注意，最初屏幕上是一个空字符串 ""，所以她 只能 按按键 1。
 * <p>
 * 请你考虑按键次数 最少 的情况，按字符串出现顺序，返回 Alice 输入 target 时屏幕上出现的所有字符串列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： target = "abc"
 * <p>
 * 输出： ["a","aa","ab","aba","abb","abc"]
 * <p>
 * 解释：
 * <p>
 * Alice 按键的顺序如下：
 * <p>
 * 按下按键 1，屏幕上的字符串变为 "a"。
 * 按下按键 1，屏幕上的字符串变为 "aa"。
 * 按下按键 2，屏幕上的字符串变为 "ab"。
 * 按下按键 1，屏幕上的字符串变为 "aba"。
 * 按下按键 2，屏幕上的字符串变为 "abb"。
 * 按下按键 2，屏幕上的字符串变为 "abc"。
 * 示例 2：
 * <p>
 * 输入： target = "he"
 * <p>
 * 输出： ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 400
 * target 仅由小写英文字母组成。
 */
public class Code6 {

    public List<String> stringSequence(String target) {
        //初始化
        StringBuilder str = new StringBuilder("a");
        //初始化结果
        List<String> result = new ArrayList<>();
        //初始化第一个
        result.add(str.toString());
        //如果是
        if (str.toString().equals(target)) {
            //返回
            return result;
        }
        //循环
        while (true) {
            //判断最后一个是否相同
            if (str.charAt(str.length() - 1) != target.charAt(str.length() - 1)) {
                //组装
                str.append((char) (str.charAt(str.length() - 1) + 1));
                //删除旧的
                str.deleteCharAt(str.length() - 2);
            } else {
                //下一个
                str.append('a');
            }
            //转为字符串
            String word = str.toString();
            //组装至结果
            result.add(word);
            //如果是
            if (word.equals(target)) {
                //跳出
                break;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String he : new Code6().stringSequence("he")) {
            System.out.println(he);
        }
    }
}
