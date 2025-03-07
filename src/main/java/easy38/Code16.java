package easy38;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-10-07
 * 2423. 删除字符使频率相同
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母：word 变成 "abc" 且每个字母出现频率都为 1 。
 * 示例 2：
 * <p>
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 */
public class Code16 {

    public boolean equalFrequency(String word) {
        //缓存
        Map<Character, Integer> cacheMap = new HashMap<>();
        //循环
        for (Character c : word.toCharArray()) {
            //记录
            cacheMap.put(c, cacheMap.getOrDefault(c, 0) + 1);
        }
        //转化为出现count次数分组列表
        Map<Integer, Long> countMap = cacheMap.values().stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        //如果只有一种情况
        if (countMap.size() == 1) {
            //如果是1,可以,否则不可以
            return countMap.containsKey(1) || countMap.values().stream().findFirst().get() == 1;
        }
        //如果不是2种情况
        if (countMap.size() != 2) {
            //不可以
            return false;
        }
        //如果只有一个1
        if (countMap.getOrDefault(1, 0L) == 1L) {
            //可以
            return true;
        }
        //获取key
        List<Integer> keyList = new ArrayList<>(countMap.keySet());
        //排序
        Collections.sort(keyList);
        //获取key
        int bigKey = keyList.get(1);
        int smallKey = keyList.get(0);
        //如果key相差太大
        if (smallKey + 1 != bigKey) {
            //不可以
            return false;
        }
        //获取
        long bigCount = countMap.get(bigKey);
        long smallCount = countMap.get(smallKey);
        //如果大的只有一个
        if (bigCount == 1) {
            //可以
            return true;
        }
        //都是1的情况
        if (smallCount == bigCount && smallCount == 1) {
            //可以
            return true;
        }
        //如果1多并且2只有一个
        if (smallKey == 1 && bigCount == 1) {
            //可以
            return true;
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().equalFrequency("bcaebda"));
    }

}
