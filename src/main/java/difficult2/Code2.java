package difficult2;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-05-10
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。
 * <p>
 * 实现 RandomizedCollection 类:
 * <p>
 * RandomizedCollection()初始化空的 RandomizedCollection 对象。
 * bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true ，否则返回 false 。
 * bool remove(int val) 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true ，否则返回 false 。注意，如果 val 在集合中出现多次，我们只删除其中一个。
 * int getRandom() 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含的相同值的数量 线性相关 。
 * 您必须实现类的函数，使每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 * 注意：生成测试用例时，只有在 RandomizedCollection 中 至少有一项 时，才会调用 getRandom 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入
 * ["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
 * [[], [1], [1], [2], [], [1], []]
 * 输出
 * [null, true, false, true, 2, true, 1]
 * <p>
 * 解释
 * RandomizedCollection collection = new RandomizedCollection();// 初始化一个空的集合。
 * collection.insert(1);   // 返回 true，因为集合不包含 1。
 * // 将 1 插入到集合中。
 * collection.insert(1);   // 返回 false，因为集合包含 1。
 * // 将另一个 1 插入到集合中。集合现在包含 [1,1]。
 * collection.insert(2);   // 返回 true，因为集合不包含 2。
 * // 将 2 插入到集合中。集合现在包含 [1,1,2]。
 * collection.getRandom(); // getRandom 应当:
 * // 有 2/3 的概率返回 1,
 * // 1/3 的概率返回 2。
 * collection.remove(1);   // 返回 true，因为集合包含 1。
 * // 从集合中移除 1。集合现在包含 [1,2]。
 * collection.getRandom(); // getRandom 应该返回 1 或 2，两者的可能性相同。
 * <p>
 * <p>
 * 提示:
 * <p>
 * -231 <= val <= 231 - 1
 * insert, remove 和 getRandom 最多 总共 被调用 2 * 105 次
 * 当调用 getRandom 时，数据结构中 至少有一个 元素
 */
public class Code2 {

    //变长数组
    private List<Integer> list;
    //当前真实的数量
    private int size;
    //记录每个数字的坐标
    private Map<Integer, LinkedList<Integer>> map;

    public Code2() {
        //初始化所有
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.size = 0;
    }

    public boolean insert(int val) {

        //如果没有任何删除的内容
        if (this.size == this.list.size()) {
            //直接加入
            this.list.add(val);
        } else {
            //设置
            this.list.set(this.size, val);
        }

        //本次加入的数字索引列表
        LinkedList<Integer> indexList;
        //如果不存在
        if (map.containsKey(val) == false) {
            //初始化
            indexList = new LinkedList<>();
            //组装
            this.map.put(val, indexList);
        } else {
            //获取
            indexList = this.map.get(val);
        }

        //记录坐标并+1
        indexList.add(size++);

        //如果只有1个,返回true,多个,false
        return indexList.size() == 1;
    }

    public boolean remove(int val) {

        //如果不存在
        if (this.map.containsKey(val) == false) {
            //过
            return false;
        }
        //获取索引列表
        LinkedList<Integer> indexList = this.map.get(val);
        //判空
        if (indexList.isEmpty()) {
            //过
            return false;
        }

        //被交换的位置
        Integer changeIndex = this.size - 1;
        //获取被交换的数字对象
        Integer changeVal = this.list.get(changeIndex);
        //如果是同一个数字
        if (changeVal.equals(val)) {
            //直接删除最后那个索引
            indexList.remove(changeIndex);
            //-1
            size--;
            //成功
            return true;
        }

        //获取并删除第一个索引
        int valIndex = indexList.pollFirst();

        //获取被交换数字的索引列表
        LinkedList<Integer> changeValIndexList = this.map.get(changeVal);
        //寻找对应位置,并交换换位置
        changeValIndexList.set(changeValIndexList.indexOf(changeIndex), valIndex);

        //在页面同步更换
        this.list.set(valIndex, changeVal);

        //-1
        size--;

        //成功
        return true;
    }

    public int getRandom() {
        //根据真实数量随机并返回
        return this.list.get(new Random().nextInt(this.size));
    }

    public static void main(String[] args) {
        Code2 code2 = new Code2();
        code2.insert(1);
        code2.insert(1);
        code2.insert(2);
        System.out.println(code2.getRandom());
        code2.remove(1);
        System.out.println(code2.getRandom());
    }

}
