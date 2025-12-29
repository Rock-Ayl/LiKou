package difficult4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @Author ayl
 * @Date 2025-12-29
 * 895. 最大频率栈
 * 算术评级: 7
 * 第 99 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2028
 * 相关标签
 * premium lock icon
 * 相关企业
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * <p>
 * 实现 FreqStack 类:
 * <p>
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * FreqStack = new FreqStack();
 * freqStack.push (5);//堆栈为 [5]
 * freqStack.push (7);//堆栈是 [5,7]
 * freqStack.push (5);//堆栈是 [5,7,5]
 * freqStack.push (7);//堆栈是 [5,7,5,7]
 * freqStack.push (4);//堆栈是 [5,7,5,7,4]
 * freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
 * freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
 * freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= val <= 109
 * push 和 pop 的操作数不大于 2 * 104。
 * 输入保证在调用 pop 之前堆栈中至少有一个元素。
 */
public class Code18 {

    public Code18() {

    }

    //节点
    private static class Node {

        //数字
        private int num;

        //索引栈
        private Stack<Integer> indexStack;

        //数量
        private Integer count;

        //初始化
        public Node(int num) {
            this.num = num;
            this.indexStack = new Stack<>();
            this.count = 0;
        }

        //增加索引
        public void push(int index) {
            //组装
            this.count++;
            this.indexStack.push(index);
        }

        //删除最后索引
        public int pop() {
            this.count--;
            return this.indexStack.pop();
        }

        //排序
        public int compareTo(Node another) {
            //计算频率
            int count = another.count.compareTo(this.count);
            //如果不同
            if (count != 0) {
                //返回
                return count;
            }
            //按照最后一个索引排序
            return another.indexStack.peek().compareTo(this.indexStack.peek());
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,indexSize=%s", this.num, this.indexStack.size());
        }

    }

    //节点缓存
    private Map<Integer, Node> nodeMap = new HashMap<>();
    //优先队列树
    private TreeSet<Node> treeSet = new TreeSet<>(Node::compareTo);
    //所有节点索引数量
    private int totalIndex = 0;

    public void push(int val) {
        //尝试获取节点
        Node node = this.nodeMap.get(val);
        //如果不存在
        if (node == null) {
            //初始化
            node = new Node(val);
            //加入缓存
            this.nodeMap.put(val, node);
        } else {
            //删除树
            this.treeSet.remove(node);
        }
        //记录本次索引
        node.push(this.totalIndex++);
        //加入树
        this.treeSet.add(node);
    }

    public int pop() {
        //拉取最优
        Node node = this.treeSet.pollFirst();
        //删除以后一个
        node.pop();
        //本次目标
        int target = node.num;
        //如果还有
        if (node.count > 0) {
            //重新加入
            this.treeSet.add(node);
        }
        //返回
        return target;
    }

    public static void main(String[] args) {
        Code18 stack = new Code18();

        // 测试数据
        int[] pushes = {5, 7, 5, 7, 4, 5};
        System.out.println("Push sequence: ");
        for (int val : pushes) {
            stack.push(val);
            System.out.println("Pushed: " + val);
        }

        // 预期弹出顺序：5, 7, 5, 4, 7, 5
        System.out.println("\nPop sequence: ");
        for (int i = 0; i < pushes.length; i++) {
            int popped = stack.pop();
            System.out.println("Popped index: " + popped);
        }

    }

}
