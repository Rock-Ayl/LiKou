package normal27;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2023-12-18
 * LCR 184. 设计自助结算系统
 * 中等
 * 522
 * 相关企业
 * 请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有：
 * <p>
 * get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1
 * add(value)：将价格为 value 的商品加入待结算商品队列的尾部
 * remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1
 * 注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1)
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Checkout","add","add","get_max","remove","get_max"]
 * [[],[4],[7],[],[],[]]
 * <p>
 * 输出: [null,null,null,7,4,7]
 * 示例 2：
 * <p>
 * 输入:
 * ["Checkout","remove","get_max"]
 * [[],[],[]]
 * <p>
 * 输出: [null,-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= get_max, add, remove 的总操作数 <= 10000
 * 1 <= value <= 10^5
 */
public class Code5 {

    //队列
    private ArrayDeque<Integer> queue;
    //最大情况
    private Integer max = null;

    public Code5() {
        //初始化
        this.queue = new ArrayDeque<>();
    }

    public int get_max() {
        //判空
        if (this.queue.isEmpty()) {
            //默认
            return -1;
        }
        //如果没有计算过
        if (this.max == null) {
            //计算
            resetMax();
        }
        //返回
        return this.max;
    }

    //刷新最大
    private void resetMax() {
        //判空
        if (this.queue.isEmpty()) {
            //过
            return;
        }
        //重新计算
        this.max = queue.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public void add(int value) {
        //插入
        this.queue.addLast(value);
        //如果有
        if (this.max != null) {
            //刷新最大
            this.max = Math.max(this.max, value);
        }
    }

    public int remove() {
        //判空
        if (this.queue.isEmpty()) {
            //默认
            return -1;
        }
        //删除
        Integer removeNum = this.queue.removeFirst();
        //如果有 and 是最大值
        if (this.max != null && this.max.equals(removeNum)) {
            //置空
            this.max = null;
        }
        //返回
        return removeNum;
    }

}
