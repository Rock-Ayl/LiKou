package normal38;

/**
 * @Author ayl
 * @Date 2024-12-23
 * 731. 我的日程安排表 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现一个程序来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生 三重预订。
 * <p>
 * 事件能够用一对整数 startTime 和 endTime 表示，在一个半开区间的时间 [startTime, endTime) 上预定。实数 x 的范围为  startTime <= x < endTime。
 * <p>
 * 实现 MyCalendarTwo 类：
 * <p>
 * MyCalendarTwo() 初始化日历对象。
 * boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, true, true, true, false, true, true]
 * <p>
 * 解释：
 * MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 * myCalendarTwo.book(10, 20); // 返回 True，能够预定该日程。
 * myCalendarTwo.book(50, 60); // 返回 True，能够预定该日程。
 * myCalendarTwo.book(10, 40); // 返回 True，该日程能够被重复预定。
 * myCalendarTwo.book(5, 15);  // 返回 False，该日程导致了三重预定，所以不能预定。
 * myCalendarTwo.book(5, 10); // 返回 True，能够预定该日程，因为它不使用已经双重预订的时间 10。
 * myCalendarTwo.book(25, 55); // 返回 True，能够预定该日程，因为时间段 [25, 40) 将被第三个日程重复预定，时间段 [40, 50) 将被单独预定，而时间段 [50, 55) 将被第二个日程重复预定。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= start < end <= 109
 * 最多调用 book 1000 次。
 */
public class Code18 {

    public Code18() {

    }

    //链表节点
    private static class Node {

        //时间
        private int time;

        //变更记录次数
        private int count;

        //下一个节点
        private Node next;

        //初始化节点
        public Node(int time, int count) {
            this.time = time;
            this.count = count;
        }

    }

    //绝对的主节点
    private Node root = new Node(-1, 0);
    //允许的最大共存目标值
    private final static int TARGET = 2;

    public boolean book(int startTime, int endTime) {

        //当前和
        int sum = 0;
        //获取顶级节点
        Node node = this.root;

        /**
         * 处理 start
         */

        //如果可以跳过
        while (node.next != null && node.next.time < startTime) {
            //下一个
            node = node.next;
            //计算数量
            sum += node.count;
        }
        //判断是 计算原有 or 插入
        if (node.next != null && node.next.time == startTime) {
            //+1
            node.next.count++;
        } else {
            //初始化
            Node start = new Node(startTime, 1);
            //插入链表
            start.next = node.next;
            node.next = start;
        }
        //记录开始节点
        Node start = node.next;

        /**
         * 处理 end
         */

        //如果可以跳过
        while (node.next != null && node.next.time < endTime) {
            //下一个
            node = node.next;
            //计算数量
            sum += node.count;
            //如果超了
            if (sum > TARGET) {
                //回滚
                start.count--;
                //失败
                return false;
            }
        }
        //判断是 计算原有 or 插入
        if (node.next != null && node.next.time == endTime) {
            //-1
            node.next.count--;
        } else {
            //初始化
            Node end = new Node(endTime, -1);
            //插入链表
            end.next = node.next;
            node.next = end;
        }

        //默认可以
        return true;
    }

    public static void main(String[] args) {


        Code18 code18 = new Code18();
        System.out.println(code18.book(24, 40));
        System.out.println(code18.book(43, 50));
        System.out.println(code18.book(27, 43));
        System.out.println(code18.book(5, 21));
        System.out.println(code18.book(30, 40));
        System.out.println(code18.book(14, 29));
    }

}
