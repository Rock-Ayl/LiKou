package normal39;

/**
 * @Author ayl
 * @Date 2025-01-21
 * 1535. 找出数组游戏的赢家
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * <p>
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * <p>
 * 返回赢得比赛的整数。
 * <p>
 * 题目数据 保证 游戏存在赢家。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 * <p>
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 * 示例 2：
 * <p>
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 * <p>
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9
 */
public class Code11 {

    //节点
    private static class Node {

        //数字
        private int num;

        //下一个节点
        private Node next;

        //胜利的次数
        private int win = 0;

        //初始化
        public Node(int num) {
            //记录
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s", this.num);
        }

    }

    public int getWinner(int[] arr, int k) {

        /**
         * 构造链表
         */

        //默认第一个节点
        Node root = new Node(-1);
        //当前节点
        Node head = root;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //初始化当前节点
            Node node = new Node(arr[i]);
            //关联
            head.next = node;
            //下一个
            head = node;
        }

        /**
         * 准备工作
         */

        //记录尾部节点
        Node tail = head;
        //更新最大k的情况
        k = Math.min(k, arr.length);

        /**
         * 开始模拟
         */

        //执行次数
        int count = 0;
        //循环
        while (root.next.win < k) {
            //如果当前节点，更大
            if (root.next.num > root.next.next.num) {
                //+1
                root.next.win++;
                //获取失败的节点
                Node failNode = root.next.next;
                //将比较失败的节点，移动到最后末尾
                tail.next = failNode;
                tail = failNode;
                root.next.next = failNode.next;
                failNode.next = null;
            }
            //如果当前节点，没比过
            else {
                //获取失败的节点
                Node failNode = root.next;
                //将失败节点移动到末尾
                tail.next = failNode;
                tail = failNode;
                root.next = failNode.next;
                failNode.next = null;
                //重置新的胜利场次
                root.next.win = 1;
            }
            //如果已经找到最大值了
            if (++count == arr.length) {
                //跳出
                break;
            }
        }
        //返回结果
        return root.next.num;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
    }

}
