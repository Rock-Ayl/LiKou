package easy29;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ayl
 * @Date 2023-03-12
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class Code3 {

    //一个队列
    private Queue<Integer> queue;
    private Queue<Integer> queue2;

    public Code3() {
        //初始化
        this.queue = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    //将元素 x 压入栈顶
    public void push(int x) {
        //直接记录
        this.queue.add(x);
    }

    //返回站定元素并删除
    public int pop() {
        //目标值
        int target = -1;
        //如果不存在
        while (this.queue.isEmpty() == false) {
            //当前
            int thisNum = this.queue.poll();
            //如果是最后一个
            if (this.queue.isEmpty()) {
                //记录
                target = thisNum;
            } else {
                //给2
                this.queue2.add(thisNum);
            }
        }
        //如果不存在
        while (this.queue2.isEmpty() == false) {
            //装回去
            this.queue.add(this.queue2.poll());
        }
        //返回目标
        return target;
    }

    //返回栈顶元素
    public int top() {
        //目标值
        int target = -1;
        //如果不存在
        while (this.queue.isEmpty() == false) {
            //当前
            int thisNum = this.queue.poll();
            //给2
            this.queue2.add(thisNum);
            //如果是最后一个
            if (this.queue.isEmpty()) {
                //记录
                target = thisNum;
            }
        }
        //如果不存在
        while (this.queue2.isEmpty() == false) {
            //装回去
            this.queue.add(this.queue2.poll());
        }
        //返回目标
        return target;
    }

    //是否为空
    public boolean empty() {
        //实现
        return this.queue.isEmpty();
    }

    public static void main(String[] args) {
        Code3 code3 = new Code3();
        code3.push(1);
        code3.push(2);
        code3.push(3);
        code3.push(4);
        System.out.println(code3.top());
        System.out.println(code3.pop());
        System.out.println(code3.empty());
    }

}
