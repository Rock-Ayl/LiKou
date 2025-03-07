package normal27;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2023-12-22
 * 833. 字符串中的查找与替换
 * 中等
 * 174
 * 相关企业
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 * <p>
 * 要完成第 i 个替换操作:
 * <p>
 * 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 * <p>
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 * <p>
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串 。
 * <p>
 * 子字符串 是字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * 输出："eeebffff"
 * 解释：
 * "a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", indices = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * 输出："eeecd"
 * 解释：
 * "ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * k == indices.length == sources.length == targets.length
 * 1 <= k <= 100
 * 0 <= indices[i] < s.length
 * 1 <= sources[i].length, targets[i].length <= 50
 * s 仅由小写英文字母组成
 * sources[i] 和 targets[i] 仅由小写英文字母组成
 */
public class Code9 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //排序索引
        Integer[] sortArr = new Integer[indices.length];
        //循环
        for (int i = 0; i < sortArr.length; i++) {
            //记录位置
            sortArr[i] = i;
        }
        //排序
        Arrays.sort(sortArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //按照indices排序
                return indices[o1] - indices[o2];
            }
        });
        //初始化结果
        StringBuilder str = new StringBuilder();
        //指针
        int p = 0;
        //循环
        for (int i = 0; i < sortArr.length; i++) {
            //当前排序
            int sort = sortArr[i];
            //索引
            int index = indices[sort];
            //源
            String source = sources[sort];
            //目标
            String target = targets[sort];
            //如果不到
            while (p < index) {
                //正常处理
                str.append(s.charAt(p++));
            }
            //如果越界
            if (p + source.length() > s.length()) {
                //本轮过
                continue;
            }
            //切割当前单词
            String word = s.substring(p, p + source.length());
            //如果不是源,不符合修改条件
            if (word.equals(source) == false) {
                //本轮过
                continue;
            }
            //加入目标
            str.append(target);
            //进位
            p += source.length();
        }
        //最终结尾
        while (p < s.length()) {
            //补充最后
            str.append(s.charAt(p++));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code9().findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
    }

}
