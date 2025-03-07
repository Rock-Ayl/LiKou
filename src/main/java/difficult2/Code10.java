package difficult2;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-04-17
 * 295. 数据流的中位数
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * <p>
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * <p>
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * 提示:
 * <p>
 * -105 <= num <= 105
 * 在调用 findMedian 之前，数据结构中至少有一个元素
 * 最多 5 * 104 次调用 addNum 和 findMedian
 */
public class Code10 {

    //用双优先队列挤压中间,时刻维护中间节点
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public Code10() {
        //初始化双优先队列
        this.left = new PriorityQueue<>((a, b) -> b - a);
        this.right = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        //如果是第一个
        if (left.isEmpty()) {
            //直接加入
            left.add(num);
            //过
            return;
        }
        //如果是第二个
        if (right.isEmpty()) {
            //拿出左边的
            Integer poll = left.poll();
            //对比大小
            Integer big = Math.max(poll, num);
            Integer small = Math.min(poll, num);
            //加入
            left.add(small);
            right.add(big);
            //过
            return;
        }
        //获取现在的中间值
        Integer mid = left.peek();
        //如果比中间值小
        if (mid.compareTo(num) >= 0) {
            //放在左边
            left.add(num);
        } else {
            //放在右边
            right.add(num);
        }
        //如果右边不够
        while (right.size() + 1 < left.size()) {
            //左边的最后一个给右边
            right.add(left.poll());
        }
        //如果左边不够了
        while (left.size() < right.size()) {
            //右边的给左边
            left.add(right.poll());
        }
    }

    public double findMedian() {
        //如果是偶数
        if ((right.size() + left.size()) % 2 == 0) {
            //求和
            double midSum = left.peek() + right.peek();
            //返回
            return midSum / 2D;
        } else {
            //直接返回
            return left.peek();
        }
    }

}
