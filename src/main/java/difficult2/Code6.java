package difficult2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-04-07
 * 68. 文本左右对齐
 * 困难
 * 相关标签
 * 相关企业
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class Code6 {

    /**
     * 将字符串修正为目标结果
     *
     * @param space    未修正的句子
     * @param theLast  是否为最后一个句子
     * @param maxWidth 目标长度
     * @return
     */
    private String fix(StringBuilder space, boolean theLast, int maxWidth) {
        //拆分为正常的句子
        String[] worldArr = space.toString().split(" ");
        //如果只有一个单词 or 是最后一句话 ,准备强行左对齐
        if (worldArr.length == 1 || theLast) {
            //初始化
            StringBuilder result = new StringBuilder();
            //循环
            for (String word : worldArr) {
                //组装单词以及空格
                result.append(word);
                result.append(" ");
            }
            //如果不够
            while (result.length() < maxWidth) {
                //补充
                result.append(" ");
            }
            //如果多出来
            while (result.length() > maxWidth) {
                //删除
                result.deleteCharAt(result.length() - 1);
            }
            //返回
            return result.toString();
        } else {
            //初始化索引双端队列
            ArrayDeque<Integer> indexList = new ArrayDeque<>();
            //初始化节点列表
            List<StringBuilder> list = new ArrayList<>();
            //长度
            int count = 0;
            //循环
            for (String word : worldArr) {
                //组装
                list.add(new StringBuilder(word));
                list.add(new StringBuilder(" "));
                //计算长度
                count += word.length() + 1;
                //记录空格索引
                indexList.addLast(list.size() - 1);
            }
            //删除最后一个
            list.remove(list.size() - 1);
            indexList.removeLast();
            count--;
            //如果长度不够
            while (count++ < maxWidth) {
                //获取当前优先级最高的索引
                Integer firstIndex = indexList.pollFirst();
                //加一个空格
                list.set(firstIndex, list.get(firstIndex).append(" "));
                //该索引排最后
                indexList.addLast(firstIndex);
            }
            //合并并返回
            return list.stream().reduce(StringBuilder::append).orElse(null).toString();
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        //初始化组列表
        List<StringBuilder> groupList = new ArrayList<>();
        //初始化第一行
        groupList.add(new StringBuilder());
        //循环
        for (String word : words) {
            //获取当前最后一行
            StringBuilder lastStr = groupList.get(groupList.size() - 1);
            //如果正好装一个
            if (lastStr.length() == 0 && word.length() == maxWidth) {
                //直接写入
                lastStr.append(word);
                //本轮过
                continue;
            }
            //如果最后一个装不下了
            if (lastStr.length() + word.length() + 1 > maxWidth) {
                //另启一行
                groupList.add(new StringBuilder());
            }
            //获取目标行
            StringBuilder space = groupList.get(groupList.size() - 1);
            //如果是第一个单词
            if (space.length() == 0) {
                //直接写入
                space.append(word);
            } else {
                //加入空格,直接写入
                space.append(" ");
                space.append(word);
            }
        }
        //初始化结果
        List<String> result = new ArrayList<>();
        //循环
        for (int i = 0; i < groupList.size(); i++) {
            //当前
            StringBuilder space = groupList.get(i);
            //修正为正确结果并组装
            result.add(fix(space, i + 1 == groupList.size(), maxWidth));
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new Code6().fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6);
        System.out.println();
    }

}
