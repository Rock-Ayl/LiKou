package easy40;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-06-17
 * 3582. 为视频标题生成标签
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 caption，表示一个视频的标题。
 * <p>
 * 需要按照以下步骤 按顺序 生成一个视频的 有效标签 ：
 * <p>
 * 将 所有单词 组合为单个 驼峰命名字符串 ，并在前面加上 '#'。驼峰命名字符串 指的是除第一个单词外，其余单词的首字母大写，且每个单词的首字母之后的字符必须是小写。
 * <p>
 * 移除 所有不是英文字母的字符，但 保留 第一个字符 '#'。
 * <p>
 * 将结果 截断 为最多 100 个字符。
 * <p>
 * 对 caption 执行上述操作后，返回生成的 标签 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： caption = "Leetcode daily streak achieved"
 * <p>
 * 输出： "#leetcodeDailyStreakAchieved"
 * <p>
 * 解释：
 * <p>
 * 除了 "leetcode" 以外的所有单词的首字母需要大写。
 * <p>
 * 示例 2：
 * <p>
 * 输入： caption = "can I Go There"
 * <p>
 * 输出： "#canIGoThere"
 * <p>
 * 解释：
 * <p>
 * 除了 "can" 以外的所有单词的首字母需要大写。
 * <p>
 * 示例 3：
 * <p>
 * 输入： caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * <p>
 * 输出： "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * <p>
 * 解释：
 * <p>
 * 由于第一个单词长度为 101，因此需要从单词末尾截去最后两个字符。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= caption.length <= 150
 * caption 仅由英文字母和 ' ' 组成。
 */
public class Code22 {

    public String generateTag(String caption) {
        //字符串
        StringBuilder str = new StringBuilder("#");
        //拆分
        List<String> wordArr = Arrays.stream(caption.split(" ")).filter(p -> p.length() > 0).collect(Collectors.toList());
        //如果太多
        if (wordArr.isEmpty()) {
            //过
            return str.toString();
        }
        //第一个
        str.append(wordArr.get(0).toLowerCase());
        //循环
        for (int i = 1; i < wordArr.size(); i++) {
            //单词
            String word = wordArr.get(i);
            //组装
            str.append(String.valueOf(word.charAt(0)).toUpperCase());
            str.append(word.substring(1, word.length()).toLowerCase());
        }
        //如果太大了
        if (str.length() > 100) {
            //截断
            return str.subSequence(0, 100).toString();
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code22().generateTag("   "));
    }

}
