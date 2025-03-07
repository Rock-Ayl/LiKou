package normal4;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-24
 * 面试题 17.22. 单词转换
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 * <p>
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class Code10 {

    //结果
    public List<String> result = new ArrayList<>();
    //结果str
    public String end;

    //无法到达终点的集合
    public Set<String> set = new HashSet<>();

    public boolean set(String start, List<String> wordList, List<String> list) {
        //如果没到头
        if (wordList.size() > 0) {
            //循环
            for (int i = 0; i < wordList.size(); i++) {
                //当前单词
                String thisWord = wordList.get(i);
                //如果该节点到头了不行
                if (set.contains(thisWord)) {
                    //下一个
                    continue;
                }
                //残差次数
                int size = 0;
                //循环
                for (int j = 0; j < start.length(); j++) {
                    //如果当前字符不成
                    if (start.charAt(j) != thisWord.charAt(j)) {
                        //叠加
                        size++;
                    }
                }
                //如果残差只有1
                if (size == 1) {
                    //记录当前word
                    list.add(thisWord);
                    //如果所选单词是目标值
                    if (thisWord.equals(end)) {
                        //记录结果
                        result = list;
                        //结果
                        return true;
                    } else {
                        //删除
                        wordList.remove(i);
                        //下一级
                        boolean isCan = set(thisWord, wordList, list);
                        //如果可以
                        if (isCan) {
                            //返回上级
                            return true;
                        } else {
                            //回溯
                            list.remove(list.size() - 1);
                            wordList.add(i, thisWord);
                        }
                    }
                }
            }
        }
        //循环
        for (String s : list) {
            //记录这些节点
            set.add(s);
        }
        //默认不可以
        return false;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        //是否存在结尾
        boolean hasEnd = false;
        //循环
        for (String s : wordList) {
            //如果存在结束
            if (s.equals(endWord)) {
                //可以
                hasEnd = true;
            }
        }
        //如果任意不存在
        if (!hasEnd) {
            //空结果
            return result;
        }
        //全局
        this.end = endWord;
        //结果
        List<String> list = new ArrayList<>();
        //首位
        list.add(beginWord);
        //不断去查询
        set(beginWord, wordList, list);
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("lot");
        list.add("log");
        list.add("cog");
        for (String ladder : new Code10().findLadders("hit", "cog", list)) {
            System.out.println(ladder);
        }
    }
}
