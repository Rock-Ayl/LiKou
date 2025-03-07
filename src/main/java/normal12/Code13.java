package normal12;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-03-02
 * 692. 前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 * <p>
 * <p>
 * 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class Code13 {

    public List<String> topKFrequent(String[] words, int k) {
        //缓存1
        Map<String, Integer> keyMap = new HashMap<>();
        //循环
        for (String word : words) {
            //+1
            keyMap.put(word, keyMap.getOrDefault(word, 0) + 1);
        }
        //缓存2
        Map<Integer, List<String>> countMap = new HashMap<>();
        //缓存3
        Set<Integer> countSet = new HashSet<>();
        //循环
        for (Map.Entry<String, Integer> entry : keyMap.entrySet()) {
            //个数key
            int key = entry.getValue();
            //记录长度
            countSet.add(key);
            //列表
            List<String> list = countMap.getOrDefault(key, new ArrayList<>());
            //组装
            list.add(entry.getKey());
            countMap.put(key, list);
        }
        //sort
        List<Integer> sort = new ArrayList<>(countSet);
        //排序
        Collections.sort(sort);
        //初始化结果
        List<String> result = new ArrayList<>();
        //key的位置P,只会越来越小
        int keyP = sort.size();
        //key
        int key;
        //如果结果不够,不断从最大的拿
        while (result.size() < k) {
            //刷新key
            key = sort.get(--keyP);
            //获取当前次数个word列表
            List<String> list = countMap.get(key);
            //字典排序
            Collections.sort(list);
            //list指针
            int i = 0;
            //循环,防止越界
            while (result.size() < k && i < list.size()) {
                //不断组装
                result.add(list.get(i++));
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code13().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
    }

}
