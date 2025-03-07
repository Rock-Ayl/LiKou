package normal8;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-09-18
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * 示例 3：
 * <p>
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 * 示例 4：
 * <p>
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 5：
 * <p>
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 */
public class Code5 {

    public String replaceWords(List<String> dictionary, String sentence) {
        //缓存
        Map<Integer, Set<String>> map = new HashMap<>(dictionary.size());
        //循环
        for (String s : dictionary) {
            //长度
            int size = s.length();
            //获取set
            Set<String> set = map.getOrDefault(size, new HashSet<>());
            //组装
            set.add(s);
            //记录
            map.put(size, set);
        }
        //初始化长度
        List<Integer> list = new ArrayList<>(map.size());
        //循环
        for (Integer integer : map.keySet()) {
            //记录
            list.add(integer);
        }
        //排个序
        Collections.sort(list);
        //结果
        StringBuilder str = new StringBuilder();
        //拆分
        String[] arr = sentence.split(" ");
        //锚点
        io:
        //循环
        for (String s : arr) {
            //循环
            for (Integer sizeKey : list) {
                //如果长度超了
                if (sizeKey > s.length()) {
                    //按照原来的组装
                    str.append(s + " ");
                    //结束本次
                    continue io;
                }
                //获取
                Set<String> set = map.get(sizeKey);
                //切割
                String space = s.substring(0, sizeKey);
                //如果存在
                if (set.contains(space)) {
                    //按照词根组装
                    str.append(space + " ");
                    //结束本次
                    continue io;
                }
            }
            //默认按照原来的组装
            str.append(s + " ");
            //结束本次
            continue io;
        }
        //删除最后一个空格
        str.deleteCharAt(str.length() - 1);
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code5().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
