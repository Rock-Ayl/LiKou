package difficult3;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-01-16
 * 面试题 17.20. 连续中值
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class Code9 {

    //双队列挤压中间值
    private PriorityQueue<Integer> leftQueue = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> rightQueue = new PriorityQueue<>((a, b) -> a - b);

    public Code9() {

    }

    public void addNum(int num) {
        //如果左边最大的都小于
        if (this.leftQueue.isEmpty() == false && this.leftQueue.peek() < num) {
            //加入右边
            this.rightQueue.add(num);
        } else {
            //加入左边
            this.leftQueue.add(num);
        }
        //循环
        if (this.leftQueue.size() - 1 > this.rightQueue.size()) {
            //左边最大的,加入到右边
            this.rightQueue.add(this.leftQueue.poll());
        }
        //循环
        if (this.leftQueue.size() < this.rightQueue.size()) {
            //右边最小的,加入到左边
            this.leftQueue.add(this.rightQueue.poll());
        }
    }

    public double findMedian() {
        //如果是奇数
        if (this.leftQueue.size() > this.rightQueue.size()) {
            //直接返回
            return this.leftQueue.peek();
        } else {
            //计算并返回
            return (double) (this.leftQueue.peek() + this.rightQueue.peek()) / 2D;
        }
    }

    public static void main(String[] args) {
        Code9 code9 = new Code9();
        code9.addNum(1);
        System.out.println(code9.findMedian());
        code9.addNum(2);
        System.out.println(code9.findMedian());
        code9.addNum(3);
        System.out.println(code9.findMedian());
    }

}
