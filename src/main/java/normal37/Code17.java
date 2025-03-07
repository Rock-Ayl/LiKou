package normal37;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-11-21
 * 1792. 最大平均通过率
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 * <p>
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 * <p>
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 * <p>
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * 输出：0.78333
 * 解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
 * 示例 2：
 * <p>
 * 输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * 输出：0.53485
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 */
public class Code17 {

    private static class Node {

        //可以通过的人数
        private int pass;

        //总人数
        private int total;

        //增加一个人，增加的分数
        private Double addUserAddRank;

        //初始化
        public Node(int pass, int total) {
            this.pass = pass - 1;
            this.total = total - 1;
            //计算
            addUser(1);
        }

        //加入人
        public void addUser(int count) {
            //旧的通过率
            double oldRank = (double) this.pass / this.total;
            //加人
            this.pass += count;
            this.total += count;
            //新的通过率
            double newRank = (double) this.pass / this.total;
            //计算将增加的分数z
            this.addUserAddRank = newRank - oldRank;
        }

        //比较优先级
        public int compareTo(Node another) {
            return another.addUserAddRank.compareTo(this.addUserAddRank);
        }

        //调试
        @Override
        public String toString() {
            return String.format("pass=%s,total=%s,addUserAddRank=%s", pass, total, addUserAddRank);
        }

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);
        //转化为对象，加入队列
        queue.addAll(Arrays
                .stream(classes)
                .map(p -> new Node(p[0], p[1]))
                .filter(p -> p.pass != p.total)
                .collect(Collectors.toList())
        );
        //循环
        while (--extraStudents >= 0 && queue.isEmpty() == false) {
            //获取优先级最低的
            Node poll = queue.poll();
            //优秀学生进入班级
            poll.addUser(1);
            //装进去
            queue.add(poll);
        }
        //结果,默认是所有全班通过的情况
        double sumRatio = classes.length - queue.size();
        //循环
        for (Node node : queue) {
            //计算本次
            sumRatio += (double) node.pass / (double) node.total;
        }
        //计算平均
        return sumRatio / classes.length;
    }

    public static void main(String[] args) {

        /*System.out.println(new Code17().maxAverageRatio(new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{2, 2}
        }, 2));*/

        System.out.println(new Code17().maxAverageRatio(new int[][]{
                new int[]{2, 4},
                new int[]{3, 9},
                new int[]{4, 5},
                new int[]{2, 10}
        }, 4));

    }

}
