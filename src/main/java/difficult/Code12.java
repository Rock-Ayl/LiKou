package difficult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-05-16
 * 140. 单词拆分 II
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 示例 2：
 * <p>
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 */
public class Code12 {

    //结果列表
    List<String> result = new ArrayList<>();
    //单词缓存
    Set<String> wordSet = new HashSet<>();
    //单词长度排序
    List<Integer> sizeList;
    //单词本身全局
    String s;
    Integer sLength;

    public void next(Stack<String> stack, int p) {
        //如果正好到头了
        if (p == sLength) {
            //初始化结果,默认第一个
            StringBuilder str = new StringBuilder(stack.get(0));
            //循环
            for (int i = 1; i < stack.size(); i++) {
                //组装后续
                str.append(" " + stack.get(i));
            }
            //组装结果
            result.add(str.toString());
            //过
            return;
        }
        //循环长度,从小到大
        for (Integer size : sizeList) {
            //下一个坐标s
            int nextP = p + size;
            //如果越界了
            if (nextP > sLength) {
                //说明当前和后续越界了,直接结束
                break;
            }
            //尝试分割当前
            String space = s.substring(p, nextP);
            //如果不存在
            if (wordSet.contains(space) == false) {
                //过
                continue;
            }
            //组装当前
            stack.push(space);
            //下一级
            next(stack, nextP);
            //回溯
            stack.pop();
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        //全局
        this.s = s;
        this.sLength = s.length();
        //单词长度缓存set去重
        Set<Integer> sizeSet = new HashSet<>();
        //循环
        for (String word : wordDict) {
            //记录单词
            wordSet.add(word);
            //记录长度
            sizeSet.add(word.length());
        }
        //将长度set转变为list并排序
        sizeList = sizeSet.stream().sorted().collect(Collectors.toList());
        //开始计算,从0开始
        next(new Stack<>(), 0);
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code12().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa", "a"));
    }

}
