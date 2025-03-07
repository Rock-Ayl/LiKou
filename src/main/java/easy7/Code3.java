package easy7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-02-27
 * 1592. 重新排列单词间的空格
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * <p>
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * <p>
 * 返回 重新排列空格后的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 * 示例 2：
 * <p>
 * 输入：text = " practice   makes   perfect"
 * 输出："practice   makes   perfect "
 * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 * 示例 3：
 * <p>
 * 输入：text = "hello   world"
 * 输出："hello   world"
 * 示例 4：
 * <p>
 * 输入：text = "  walks  udp package   into  bar a"
 * 输出："walks  udp  package  into  bar  a "
 * 示例 5：
 * <p>
 * 输入：text = "a"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 100
 * text 由小写英文字母和 ' ' 组成
 * text 中至少包含一个单词
 */
public class Code3 {

    public static String reorderSpaces(String text) {
        //单词组
        List<String> list = new ArrayList<>();
        //当前单词
        StringBuffer thisWord = new StringBuffer();
        //空格数
        int space = 0;
        //循环
        for (char c : text.toCharArray()) {
            //如果是空格
            if (c == ' ') {
                //叠加空格数
                space++;
                //如果存在单词
                if (thisWord.length() > 0) {
                    //记录
                    list.add(thisWord.toString());
                    //重置
                    thisWord = new StringBuffer();
                }
            } else {
                //组装
                thisWord.append(c);
            }
        }
        //如果存在单词
        if (thisWord.length() > 0) {
            //记录
            list.add(thisWord.toString());
        }
        //计算中间空格数
        int everySpace;
        //判空
        if ((list.size() - 1) == 0) {
            //默认为0
            everySpace = 0;
        } else {
            //计算中间空格数
            everySpace = space / (list.size() - 1);
        }
        //记录一下
        int minus = everySpace;
        //初始化句子
        StringBuffer sentence = new StringBuffer();
        //空格模板
        StringBuffer spaceModel = new StringBuffer();
        //循环
        while (everySpace > 0) {
            //计算
            spaceModel.append(" ");
            //递减
            everySpace--;
        }
        //循环
        for (int i = 0; i < list.size() - 1; i++) {
            //叠加
            sentence.append(list.get(i) + spaceModel.toString());
            //记录
            space = space - minus;
        }
        //最后一段
        sentence.append(list.get(list.size() - 1));
        //结尾
        while (space > 0) {
            //递减
            space--;
            //叠加
            sentence.append(" ");
        }
        //返回
        return sentence.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
    }
}
