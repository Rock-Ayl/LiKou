package normal20;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-05-11
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 * getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出: [null, true, false, true, 2, true, false, 2]
 * 解释:
 * RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
 * <p>
 * randomSet.remove(2); // 返回 false，表示集合中不存在 2
 * <p>
 * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
 * <p>
 * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
 * <p>
 * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
 * <p>
 * randomSet.insert(2); // 2 已在集合中，所以返回 false
 * <p>
 * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * 最多进行 2 * 105 次 insert ， remove 和 getRandom 方法调用
 * 当调用 getRandom 方法时，集合中至少有一个元素
 * <p>
 * <p>
 * 注意：本题与主站 380 题相同：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
public class Code9 {

    //列表
    private List<Integer> list;
    //集合,用来存储存储的集合及对应list中的索引
    private Map<Integer, Integer> map;
    //随机对象
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public Code9() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        //装箱
        Integer objectVal = val;
        //如果有了
        if (this.map.containsKey(objectVal)) {
            //过
            return false;
        }
        //当前要设置的位置
        int targetIndex = this.map.size();
        //如果是正常插入
        if (targetIndex == this.list.size()) {
            //记录
            this.map.put(objectVal, targetIndex);
            this.list.add(objectVal);
            //成功
            return true;
        }
        //记录
        this.map.put(objectVal, targetIndex);
        this.list.set(targetIndex, objectVal);
        //默认
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        //装箱
        Integer objectVal = val;
        //如果没有
        if (this.map.containsKey(objectVal) == false) {
            //过
            return false;
        }
        //本次要替换的索引
        Integer lastIndex = this.map.size() - 1;
        //当前最后一个
        Integer lastValue = this.list.get(lastIndex);
        //如果正好是目标
        if (lastValue.equals(objectVal)) {
            //直接删除即可
            this.map.remove(lastValue);
            //成功
            return true;
        }
        //获取被删除的值的位置
        Integer objectValueIndex = this.map.get(objectVal);
        //替换对应节点和索引
        this.list.set(objectValueIndex, lastValue);
        this.map.put(lastValue, objectValueIndex);
        //删除本次索引
        this.map.remove(objectVal);
        //成功
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        //根据set随机list拿取
        return this.list.get(this.random.nextInt(this.map.size()));
    }

    public static void main(String[] args) {
        Code9 code9 = new Code9();
        System.out.println(code9.insert(0));
        System.out.println(code9.remove(0));
        System.out.println(code9.insert(-1));
        System.out.println(code9.remove(0));

        System.out.println(code9.getRandom());
    }

}
