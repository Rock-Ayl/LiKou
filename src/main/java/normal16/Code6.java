package normal16;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-08-28
 * 677. 键值映射
 * 设计一个 map ，满足以下几点:
 * <p>
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // 返回 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 */
public class Code6 {

    //缓存
    private Map<String, Integer> map;

    public Code6() {
        //初始化
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        //初始化
        map.put(key, val);
    }

    public int sum(String prefix) {
        //和
        int result = 0;
        //循环
        for (String key : map.keySet()) {
            //如果是
            if (key.startsWith(prefix)) {
                //直接获取
                result += map.get(key);
            }
        }
        //返回结果
        return result;
    }

}
