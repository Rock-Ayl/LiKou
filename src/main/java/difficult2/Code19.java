package difficult2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author ayl
 * @Date 2024-08-14
 * LCR 160. 数据流中的中位数
 * 困难
 * 相关标签
 * 相关企业
 * 中位数 是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class Code19 {

    //双优先队列
    private PriorityQueue<Integer> leftQueue;
    private PriorityQueue<Integer> rightQueue;

    //初始化
    public Code19() {
        this.leftQueue = new PriorityQueue<>((a, b) -> b - a);
        this.rightQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    //加入数字
    public void addNum(int num) {
        //如果左边空
        if (this.leftQueue.isEmpty()) {
            //直接加入
            this.leftQueue.add(num);
            //过
            return;
        }
        //判断当前数字要加入那边
        if (num <= this.leftQueue.peek()) {
            //加入左边
            this.leftQueue.add(num);
        } else {
            //加入右边
            this.rightQueue.add(num);
        }
        //平衡左右
        while (this.leftQueue.size() < this.rightQueue.size()) {
            //移动
            this.leftQueue.add(this.rightQueue.poll());
        }
        while (this.leftQueue.size() - 1 > this.rightQueue.size()) {
            //移动
            this.rightQueue.add(this.leftQueue.poll());
        }
    }

    //寻找
    public double findMedian() {
        //如果左边更多
        if (this.leftQueue.size() > this.rightQueue.size()) {
            //直接返回
            return this.leftQueue.peek();
        } else {
            //计算
            return ((double) (this.leftQueue.peek() + this.rightQueue.peek())) / 2D;
        }
    }

    public static void main(String[] args) {
        Code19 code19 = new Code19();
        //循环
        for (int i = 0; i < 100; i++) {
            //随机并加入
            code19.addNum(new Random().nextInt(100));
            System.out.println();
        }
        System.out.println();
    }

}
