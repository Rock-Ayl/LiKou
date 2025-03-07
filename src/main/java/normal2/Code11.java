package normal2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-04-12
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Code11 {

    //位置
    Set<String> pSet = new HashSet<>();
    //全局
    List<String> publicWordDict;

    public boolean remove(String s) {
        //如果到过
        if (pSet.contains(s)) {
            //直接返回
            return false;
        }
        //循环
        for (String word : publicWordDict) {
            //如果完全相同
            if (word.equals(s)) {
                //返回
                return true;
            }
            //如果未越界
            if (word.length() < s.length()) {
                //切割
                String str = s.substring(0, word.length());
                //如果开头是这个
                if (word.equals(str)) {
                    //下一个
                    String next = s.substring(word.length());
                    //记录
                    pSet.add(s);
                    //下一级
                    boolean isCan = remove(next);
                    //如果有成功的
                    if (isCan) {
                        //可以
                        return true;
                    }
                }
            }
        }
        //默认是不可行的
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //换成全局
        publicWordDict = wordDict;
        //返回
        return remove(s);
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new Code11().wordBreak("leetcode", list));
    }
}
