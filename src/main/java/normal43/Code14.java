package normal43;

/**
 * @Author ayl
 * @Date 2025-06-01
 * LCR 058. 我的日程安排表 I
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * ["MyCalendar","book","book","book"]
 * [[],[10,20],[15,25],[20,30]]
 * 输出: [null,true,false,true]
 * 解释:
 * MyCalendar myCalendar = new MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
 * MyCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
 *
 *
 *
 *
 * 提示：
 *
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
 * 0 <= start < end <= 109
 *
 *
 * 注意：本题与主站 729 题相同： https://leetcode-cn.com/problems/my-calendar-i/
 */
public class Code14 {

    public Code14() {

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
