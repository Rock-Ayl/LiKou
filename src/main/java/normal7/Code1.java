package normal7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-08-30
 * 1813. 句子相似性 III
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * <p>
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * <p>
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
 * 输出：true
 * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
 * 示例 2：
 * <p>
 * 输入：sentence1 = "of", sentence2 = "A lot of words"
 * 输出：false
 * 解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
 * 示例 3：
 * <p>
 * 输入：sentence1 = "Eating right now", sentence2 = "Eating"
 * 输出：true
 * 解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
 * 示例 4：
 * <p>
 * 输入：sentence1 = "Luky", sentence2 = "Lucccky"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 和 sentence2 都只包含大小写英文字母和空格。
 * sentence1 和 sentence2 中的单词都只由单个空格隔开。
 */
public class Code1 {

    //拆分
    String[] big;
    String[] small;
    //初始化数组
    List<Integer> notFound;

    public boolean right() {
        //初始化数组
        notFound = new ArrayList<>(Math.max(big.length, small.length));
        //双指针
        int bigP = big.length - 1, smallP = small.length - 1;
        //如果满足继续比对的条件
        while (smallP >= 0 && bigP >= 0) {
            //获取当前
            String a = big[bigP], b = small[smallP];
            //如果当前一致
            if (a.equals(b)) {
                //各自-1
                bigP--;
                smallP--;
            } else {
                //记录并-1
                notFound.add(bigP--);
            }
        }
        //如果还有
        while (bigP >= 0) {
            //记录并-1
            notFound.add(bigP--);
        }
        //如果小的没有走到结尾
        if (smallP != -1) {
            //不可以
            return false;
        }
        //如果存在缺失的
        if (!notFound.isEmpty()) {
            //上一级
            int last = notFound.get(0);
            //循环
            for (int i = 1; i < notFound.size(); i++) {
                //当前
                int space = notFound.get(i);
                //如果非正常
                if (last - 1 != space) {
                    //不可以
                    return false;
                }
                //记录
                last = space;
            }
        }
        //默认可以
        return true;
    }

    public boolean left() {
        //初始化数组
        notFound = new ArrayList<>(Math.max(big.length, small.length));
        //双指针
        int bigP = 0, smallP = 0;
        //如果满足继续比对的条件
        while (smallP < small.length && bigP < big.length) {
            //获取当前
            String a = big[bigP], b = small[smallP];
            //如果当前一致
            if (a.equals(b)) {
                //各自+1
                bigP++;
                smallP++;
            } else {
                //记录并+1
                notFound.add(bigP++);
            }
        }
        //如果还有
        while (bigP < big.length) {
            //记录并+1
            notFound.add(bigP++);
        }
        //如果小的没有走到结尾
        if (smallP != small.length) {
            //不可以
            return false;
        }
        //如果存在缺失的
        if (!notFound.isEmpty()) {
            //上一级
            int last = notFound.get(0);
            //循环
            for (int i = 1; i < notFound.size(); i++) {
                //当前
                int space = notFound.get(i);
                //如果非正常
                if (last + 1 != space) {
                    //不可以
                    return false;
                }
                //记录
                last = space;
            }
        }
        //默认可以
        return true;
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        //如果
        if (sentence1.length() == sentence2.length()) {
            //如果相同
            if (sentence1.equals(sentence2)) {
                //可以
                return true;
            } else {
                //不可以
                return false;
            }
        }
        //根据长短判断攻受
        if (sentence1.length() > sentence2.length()) {
            //拆分
            big = sentence1.split(" ");
            small = sentence2.split(" ");
        } else {
            //拆分
            small = sentence1.split(" ");
            big = sentence2.split(" ");
        }
        //如果有一个对的
        if (left() || right()) {
            //视为对的
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code1().areSentencesSimilar("UI wqhw Lf", "ezzXqqEQcS"));
    }

}
