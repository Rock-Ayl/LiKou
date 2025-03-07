package normal16;

import java.util.Random;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-10-04
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 */
public class Code14 {

    //缓存
    private Stack<Integer> stack;

    public Code14() {
        //初始化
        this.stack = new Stack<>();
    }

    public boolean insert(int val) {
        //如果存在
        if (stack.contains(val)) {
            //过
            return false;
        }
        //组装
        stack.push(val);
        //ø
        return true;
    }

    public boolean remove(int val) {
        //如果不存在
        if (stack.contains(val) == false) {
            //过
            return false;
        }
        //删除对象
        stack.remove(Integer.valueOf(val));
        //结束
        return true;
    }

    public int getRandom() {
        //根据长度随机一个坐标
        int ranDom = new Random().nextInt(stack.size());
        //返回
        return stack.get(ranDom);
    }

    public static void main(String[] args) {
        Code14 code14 = new Code14();
        code14.insert(1);
        code14.insert(2);
        code14.insert(3);
        code14.remove(2);
        System.out.println();
    }

}
