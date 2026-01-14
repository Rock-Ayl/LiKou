package difficult4;

import java.util.*;

/**
 * 1172. 餐盘栈
 * 算术评级: 8
 * 第 151 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2110
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 * 1  3
 * ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 * ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 * ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 */
public class Code19 {

    //初始化栈列表
    private List<Stack<Integer>> stackList;
    //每个栈大小
    private int capacity;
    //需要填充的索引队列
    private PriorityQueue<Integer> needFillIndexQueue;
    //有值的队列
    private PriorityQueue<Integer> hadIndexQueue;

    /**
     * 初始化
     *
     * @param capacity 单个栈的最大容量
     */
    public Code19(int capacity) {
        this.capacity = capacity;
        this.stackList = new ArrayList<>();
        //优先队列,索引越小越靠前
        this.needFillIndexQueue = new PriorityQueue<>(Integer::compareTo);
        this.hadIndexQueue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    //将给出的正整数 val 推入 从左往右第一个 没有满的栈
    public void push(int val) {
        //如果没有新的队列
        if (this.needFillIndexQueue.isEmpty()) {
            //初始化
            this.stackList.add(new Stack<>());
            //索引
            int index = this.stackList.size() - 1;
            //最新的索引,记录二者缓存
            this.needFillIndexQueue.add(index);
        }
        //索引
        Integer index = this.needFillIndexQueue.peek();
        //获取最左边,未满
        Stack<Integer> stack = this.stackList.get(index);
        //如果没有值
        if (stack.isEmpty()) {
            //记录有值
            this.hadIndexQueue.add(index);
        }
        //加入
        stack.add(val);
        //如果满了
        if (stack.size() == capacity) {
            //删除之
            this.needFillIndexQueue.poll();
        }
    }

    //返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1
    public int pop() {
        //如果最后的为空
        while (this.hadIndexQueue.isEmpty() == false && this.stackList.get(this.hadIndexQueue.peek()).isEmpty()) {
            //删除
            this.hadIndexQueue.poll();
        }
        //索引
        int index = this.hadIndexQueue.isEmpty() ? -1 : this.hadIndexQueue.peek();
        //实现
        return popAtStack(index);
    }

    //返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1
    public int popAtStack(int index) {
        //越界
        if (index >= this.stackList.size() || index < 0) {
            //过
            return -1;
        }
        //获取
        Stack<Integer> stack = this.stackList.get(index);
        //判空
        if (stack.isEmpty()) {
            //过
            return -1;
        }
        //如果是满的
        if (stack.size() == this.capacity) {
            //重新记录缓存
            this.needFillIndexQueue.add(index);
        }
        //拉取最近结果
        Integer pop = stack.pop();
        //返回
        return pop;
    }

}
