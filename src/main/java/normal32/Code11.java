package normal32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-06-03
 * 2671. 频率跟踪器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 * <p>
 * 实现 FrequencyTracker 类：
 * <p>
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * 输出
 * [null, null, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
 * frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * 示例 2：
 * <p>
 * 输入
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * 输出
 * [null, null, null, false]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 []
 * frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * 示例 3：
 * <p>
 * 输入
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * 输出
 * [null, false, null, true]
 * <p>
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= number <= 105
 * 1 <= frequency <= 105
 * 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 105 次
 */
public class Code11 {

    //数字数量map
    private Map<Integer, Integer> numberCountMap;
    //数量集合
    private Map<Integer, Set<Integer>> frequencyMap;

    public Code11() {
        //初始化
        this.numberCountMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    //擦灰姑娘是增加某个count下的数字
    private void addMap(Integer key, Integer value) {
        //如果不存在
        if (this.frequencyMap.containsKey(key) == false) {
            //初始化
            this.frequencyMap.put(key, new HashSet<>());
        }
        //加入
        this.frequencyMap.get(key).add(value);
    }

    //尝试删除某个count下的某个数字
    private void deleteMap(Integer key, Integer value) {
        //如果不存在
        if (this.frequencyMap.containsKey(key) == false) {
            //过
            return;
        }
        //删除之
        this.frequencyMap.get(key).remove(value);
    }

    public void add(int number) {
        //获取当前count
        Integer count = this.numberCountMap.getOrDefault(number, 0);
        //尝试删除
        deleteMap(count, number);
        //+1,并记录新的
        addMap(++count, number);
        //覆盖
        this.numberCountMap.put(number, count);
    }

    public void deleteOne(int number) {
        //获取当前count
        Integer count = this.numberCountMap.getOrDefault(number, 0);
        //如果没有
        if (count < 1) {
            //过
            return;
        }
        //尝试删除
        deleteMap(count, number);
        //-1,并记录新的
        addMap(--count, number);
        //覆盖
        this.numberCountMap.put(number, count);
    }

    public boolean hasFrequency(int frequency) {
        //实现
        return this.frequencyMap.getOrDefault(frequency, new HashSet<>()).size() > 0;
    }

}
