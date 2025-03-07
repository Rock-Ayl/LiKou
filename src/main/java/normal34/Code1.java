package normal34;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-08-03
 * 1670. 设计前中后队列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * <p>
 * 请你完成 FrontMiddleBack 类：
 * <p>
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 * <p>
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 * <p>
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= val <= 109
 * 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。
 */
public class Code1 {

    //左右双端队列
    private ArrayDeque<Integer> leftQueue = new ArrayDeque<>();
    private ArrayDeque<Integer> rightQueue = new ArrayDeque<>();

    public Code1() {

    }

    public void pushFront(int val) {
        //如果左右都是空
        if (this.leftQueue.isEmpty() && this.rightQueue.isEmpty()) {
            //加入右边队列
            this.rightQueue.add(val);
            //过
            return;
        }
        //如果左边存在 and 左边数量大于等于右边数量
        if (this.leftQueue.isEmpty() == false && this.leftQueue.size() >= this.rightQueue.size()) {
            //左边最后的移动到右边一开始
            this.rightQueue.addFirst(this.leftQueue.pollLast());
        }
        //加入左边
        this.leftQueue.addFirst(val);
    }

    public void pushMiddle(int val) {
        //判断是加入左边 or 右边
        if (this.leftQueue.size() < this.rightQueue.size()) {
            //加入左边最后
            this.leftQueue.addLast(val);
        } else {
            //加入右边最左
            this.rightQueue.addFirst(val);
        }
    }

    public void pushBack(int val) {
        //如果右边存在 and 右边数量大于左边数量
        if (this.rightQueue.isEmpty() == false && this.leftQueue.size() < this.rightQueue.size()) {
            //右边的一个移动到左边
            this.leftQueue.addLast(this.rightQueue.pollFirst());
        }
        //加入右边
        this.rightQueue.addLast(val);
    }

    public int popFront() {
        //如果为空
        if (this.leftQueue.isEmpty() && this.rightQueue.isEmpty()) {
            //过
            return -1;
        }
        //如果左边原本比右边小
        if (this.leftQueue.size() < this.rightQueue.size()) {
            //右边的一个加入左边
            this.leftQueue.addLast(this.rightQueue.pollFirst());
        }
        //弹出左边
        return this.leftQueue.pollFirst();
    }

    public int popMiddle() {
        //如果为空
        if (this.leftQueue.isEmpty() && this.rightQueue.isEmpty()) {
            //过
            return -1;
        }
        //判断弹出那边
        if (this.leftQueue.size() >= this.rightQueue.size()) {
            //弹出左边的
            return this.leftQueue.pollLast();
        } else {
            //弹出右边的
            return this.rightQueue.pollFirst();
        }
    }

    public int popBack() {
        //如果为空
        if (this.leftQueue.isEmpty() && this.rightQueue.isEmpty()) {
            //过
            return -1;
        }
        //如果右边的原本比左边的小
        if (this.leftQueue.size() >= this.rightQueue.size()) {
            //左边的一个加入右边
            this.rightQueue.addFirst(this.leftQueue.pollLast());
        }
        //弹出右边的
        return this.rightQueue.pollLast();
    }

    public static void main(String[] args) {
        //初始化
        Code1 code = new Code1();
        code.pushFront(753523);
        code.pushMiddle(677444);
        code.pushMiddle(431158);
        System.out.println(code.popMiddle());
        System.out.println(code.popMiddle());
        code.pushBack(47949);
        System.out.println(code.popMiddle());

    }

}
