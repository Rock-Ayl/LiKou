package normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-03-30
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 */
public class Code23 {

    public static int findClosest(String[] words, String word1, String word2) {
        //位置缓存
        List<Integer> p1 = new ArrayList<>(), p2 = new ArrayList<>();
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前单词
            String word = words[i];
            //操作
            if (word1.equals(word)) {
                //记录
                p1.add(i);
            } else if (word2.equals(word)) {
                //记录
                p2.add(i);
            }
        }
        //距离
        int away = Integer.MAX_VALUE;
        //循环
        for (Integer a : p1) {
            //循环2
            for (Integer b : p2) {
                //如果相等
                if (a == b) {
                    //结果
                    return 0;
                }
                //绝对值
                int abc = Math.abs(a - b);
                //对比
                if (abc < away) {
                    //更新
                    away = abc;
                }
            }
        }
        //返回
        return away;
    }

    public static void main(String[] args) {
        System.out.println(findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }

}
