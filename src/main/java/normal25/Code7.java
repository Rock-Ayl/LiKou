package normal25;

/**
 * @Author ayl
 * @Date 2023-10-18
 * 2326. 螺旋矩阵 IV
 * 提示
 * 中等
 * 23
 * 相关企业
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 * <p>
 * 另给你一个整数链表的头节点 head 。
 * <p>
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 1, n = 4, head = [0,1,2]
 * 输出：[[0,1,2,-1]]
 * 解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 链表中节点数目在范围 [1, m * n] 内
 * 0 <= Node.val <= 1000
 */
public class Code7 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //递归
    private void next(int[][] arr, int[][] walkArr, int x, int y, int count, int targetCount, ListNode head, int dir) {
        //本次填充的值
        int value;
        //如果有节点
        if (head != null) {
            //使用节点值
            value = head.val;
        } else {
            //默认
            value = -1;
        }
        //走当前位置
        arr[x][y] = value;
        //记录该节点走过
        walkArr[x][y] = 1;
        //右走过了一个节点
        count++;
        //如果此时填充满了
        if (count >= targetCount) {
            //过
            return;
        }
        //初始化下一个位置坐标
        int nextX = x;
        int nextY = y;
        //根据方向继续走
        switch (dir) {
            //右
            case 1:
                nextY++;
                break;
            //下
            case 2:
                nextX++;
                break;
            //左
            case 3:
                nextY--;
                break;
            //上/默认
            case 4:
                nextX--;
                break;
        }
        //如果 没越界 and 下一个位置没有被走过 视为可以行走
        if (nextX >= 0 && nextY >= 0 && nextX < arr.length && nextY < arr[0].length && walkArr[nextX][nextY] == 0) {
            //默认下一个节点
            ListNode nextHead = null;
            //如果当前节点还存在
            if (head != null) {
                //获取下一个节点
                nextHead = head.next;
            }
            //继续按照当前方向走
            next(arr, walkArr, nextX, nextY, count, targetCount, nextHead, dir);
            //过
            return;
        }
        //初始化下一个位置坐标
        nextX = x;
        nextY = y;
        //下一个方向
        int nextDir = dir;
        //根据方向换方向
        switch (dir) {
            //右
            case 1:
                nextX++;
                nextDir++;
                break;
            //下
            case 2:
                nextY--;
                nextDir++;
                break;
            //左
            case 3:
                nextX--;
                nextDir++;
                break;
            //上/默认
            case 4:
                nextY++;
                nextDir = 1;
                break;
        }
        //默认下一个节点
        ListNode nextHead = null;
        //如果当前节点还存在
        if (head != null) {
            //获取下一个节点
            nextHead = head.next;
        }
        //继续按照当前方向走
        next(arr, walkArr, nextX, nextY, count, targetCount, nextHead, nextDir);
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        //初始化
        int[][] arr = new int[m][n];
        int[][] walkArr = new int[m][n];
        //递归
        next(arr, walkArr, 0, 0, 0, m * n, head, 1);
        //返回
        return arr;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(4);
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;

        int[][] ints = new Code7().spiralMatrix(3, 5, node1);
        System.out.println();
    }

}
