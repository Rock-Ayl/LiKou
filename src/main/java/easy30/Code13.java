package easy30;

import java.util.LinkedList;

/**
 * @Author ayl
 * @Date 2023-04-28
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * 最多调用 next 方法 104 次
 */
public class Code13 {

    //列表
    private LinkedList<Integer> linkedList;
    private int size;
    //和
    private double sum;

    /**
     * Initialize your data structure here.
     */
    public Code13(int size) {
        //初始化
        this.linkedList = new LinkedList();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        //组装
        this.linkedList.addLast(val);
        //记录
        sum += val;
        //如果多了
        if (this.linkedList.size() > size) {
            //删除第一个
            int delete = this.linkedList.removeFirst();
            //删除
            sum -= delete;
        }
        //计算
        return sum / this.linkedList.size();
    }

}
