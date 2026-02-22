package normal50;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. 基于时间的键值存储
 * 算术评级: 7
 * 第 121 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1575
 * 相关标签
 * premium lock icon
 * 相关企业
 * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
 * <p>
 * 实现 TimeMap 类：
 * <p>
 * TimeMap() 初始化数据结构对象
 * void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
 * String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * 输出：
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 * <p>
 * 解释：
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
 * timeMap.get("foo", 1);         // 返回 "bar"
 * timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
 * timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
 * timeMap.get("foo", 4);         // 返回 "bar2"
 * timeMap.get("foo", 5);         // 返回 "bar2"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, value.length <= 100
 * key 和 value 由小写英文字母和数字组成
 * 1 <= timestamp <= 107
 * set 操作中的时间戳 timestamp 都是严格递增的
 * 最多调用 set 和 get 操作 2 * 105 次
 */
public class Code17 {

    public Code17() {

    }

    //缓存
    private Map<String, List<Pair<Integer, String>>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        //如果不存在
        if (this.map.containsKey(key) == false) {
            //初始化
            this.map.put(key, new ArrayList<>());
        }
        //记录
        this.map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        //获取
        List<Pair<Integer, String>> pairList = this.map.get(key);
        //如果不存在
        if (pairList == null) {
            //过
            return "";
        }
        //如果最小的比目标值都大
        if (pairList.get(0).getKey().compareTo(timestamp) > 0) {
            //过
            return "";
        }
        //如果最大的都比目标值小
        if (pairList.get(pairList.size() - 1).getKey().compareTo(timestamp) <= 0) {
            //返回目标值
            return pairList.get(pairList.size() - 1).getValue();
        }
        //二分实现
        return get(pairList, timestamp, 0, pairList.size() - 1);
    }

    //二分实现
    private String get(List<Pair<Integer, String>> pairList, int timestamp, int left, int right) {
        //到边界了
        if (left + 1 >= right) {
            //返回
            return pairList.get(left).getValue();
        }
        //计算中间索引
        int mid = (right - left) / 2 + left;
        //获取中间
        Pair<Integer, String> midPair = pairList.get(mid);
        //如果是目标
        if (midPair.getKey() == timestamp) {
            //返回
            return midPair.getValue();
        }
        //判断左右
        if (midPair.getKey().compareTo(timestamp) > 0) {
            //实现
            return get(pairList, timestamp, left, mid);
        } else {
            //实现
            return get(pairList, timestamp, mid, right);
        }
    }

    public static void main(String[] args) {


        Code17 timeMap = new Code17();

        // 对应：
        // ["TimeMap","set","set","set","get","get","get"]
        // [[],["foo","bar",5],["foo","bar2",10],["foo","bar3",14],["foo",4],["foo",6],["foo",11]]

        timeMap.set("foo", "bar", 5);
        timeMap.set("foo", "bar2", 10);
        timeMap.set("foo", "bar3", 14);

        //System.out.println(timeMap.get("foo", 4));   // 预期 ""
        //System.out.println(timeMap.get("foo", 6));   // 预期 "bar"
        System.out.println(timeMap.get("foo", 11));  // 预期 "bar2"

    }

}
