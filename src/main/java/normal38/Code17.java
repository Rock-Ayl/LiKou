package normal38;

/**
 * @Author ayl
 * @Date 2024-12-21
 * 729. 我的日程安排表 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * <p>
 * 日程可以用一对整数 startTime 和 endTime 表示，这里的时间是半开区间，即 [startTime, endTime), 实数 x 的范围为，  startTime <= x < endTime 。
 * <p>
 * 实现 MyCalendar 类：
 * <p>
 * MyCalendar() 初始化日历对象。
 * boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 * <p>
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= start < end <= 109
 * 每个测试用例，调用 book 方法的次数最多不超过 1000 次。
 */
public class Code17 {

    public Code17() {

    }

    /**
     * 实现个简单的链表
     */
    public static class Node {

        //开始
        private int start;

        //结束
        private int end;

        //下一个
        private Node next;

        //初始化
        public Node(int start, int endTime) {
            this.start = start;
            this.end = endTime;
        }

    }

    //初始化绝对的主节点
    private Node root = new Node(-1, -1);

    //常识预定
    public boolean book(int startTime, int endTime) {
        //获取链表头
        Node node = this.root;
        //如果需要换成下一个节点
        while (node.next != null && node.next.end <= startTime) {
            //替换
            node = node.next;
        }
        //如果后面有内容,判断一下后面的是否与当前的冲突
        if (node.next != null && node.next.start < endTime) {
            //不合法
            return false;
        }
        //初始化本次新节点
        Node newNode = new Node(startTime, endTime);
        //插入到链表
        newNode.next = node.next;
        node.next = newNode;
        //返回
        return true;
    }

}
