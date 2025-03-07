package difficult3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author ayl
 * @Date 2024-12-22
 * 732. 我的日程安排表 III
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 当 k 个日程存在一些非空交集时（即, k 个日程包含了一些相同时间），就会产生 k 次预订。
 * <p>
 * 给你一些日程安排 [startTime, endTime) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * <p>
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 * <p>
 * MyCalendarThree() 初始化对象。
 * int book(int startTime, int endTime) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 * <p>
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= startTime < endTime <= 109
 * 每个测试用例，调用 book 函数最多不超过 400次
 */
public class Code3 {

    public Code3() {

    }

    //简单的链表实现
    private static class Node {

        //时间
        private int time;

        //增加、删除数量
        private int count;

        //下一个节点
        private Node next;

        //初始化
        public Node(int time, int count) {
            this.time = time;
            this.count = count;
        }

    }

    //结对的主节点
    private Node root = new Node(-1, 0);

    //预定并统计
    public int book(int startTime, int endTime) {

        /**
         * 结果集、当前差分的k值
         */

        //最大可能,默认1
        int max = 1;
        //当前k
        int k = 0;

        /**
         * 处理 开始时间
         */

        //获取首节点
        Node node = this.root;
        //如果 存在下一个节点 && 下一个节点比当前更小
        while (node.next != null && node.next.time < startTime) {
            //下一个
            node = node.next;
            //叠加
            k += node.count;
            //刷新最大
            max = Math.max(k, max);
        }
        //两种情况 相同 or 不同
        if (node.next != null && node.next.time == startTime) {
            //直接记录
            node.next.count++;
        } else {
            //初始化新开始节点
            Node startNode = new Node(startTime, 1);
            //插入该节点
            startNode.next = node.next;
            node.next = startNode;
        }

        /**
         * 处理 结束时间
         */

        //如果下一个节点更小
        while (node.next != null && node.next.time < endTime) {
            //下一个
            node = node.next;
            //叠加
            k += node.count;
            //刷新最大
            max = Math.max(k, max);
        }
        //两种情况 相同 or 不同
        if (node.next != null && node.next.time == endTime) {
            //直接记录
            node.next.count--;
        } else {
            //初始化新结束节点
            Node endNode = new Node(endTime, -1);
            //插入该节点
            endNode.next = node.next;
            node.next = endNode;
        }

        /**
         * 处理 剩余节点
         */

        //如果下一个节点更小
        while (node.next != null) {
            //下一个
            node = node.next;
            //叠加
            k += node.count;
            //刷新最大
            max = Math.max(k, max);
        }

        //返回最大结果
        return max;
    }

    public static void main(String[] args) {


        new Thread(new FutureTask<>(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("张三");
                return "张三";
            }
        })).start();

        Code3 code3 = new Code3();
        System.out.println(code3.book(10, 20));
        System.out.println(code3.book(50, 60));
        System.out.println(code3.book(10, 40));
        System.out.println(code3.book(5, 15));

        System.out.println(code3.book(5, 10));

        System.out.println(code3.book(25, 55));

    }


}
