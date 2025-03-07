package normal30;

/**
 * @Author ayl
 * @Date 2024-03-25
 * 911. 在线选举
 * 中等
 * 相关标签
 * 相关企业
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 * <p>
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 * <p>
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * <p>
 * 实现 TopVotedCandidate 类：
 * <p>
 * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 * <p>
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 109
 * times 是一个严格递增的有序数组
 * times[0] <= t <= 109
 * 每个测试用例最多调用 104 次 q
 */
public class Code4 {

    //每个时间段的优势候选人
    private int[] firstPerson;
    //时间段
    private int[] times;

    public Code4(int[] persons, int[] times) {
        //初始化结果
        int[] firstPerson = new int[persons.length];
        //选举人票数
        int[] personRank = new int[persons.length];
        //初始化第一次,开始时间优势的投票人
        firstPerson[0] = persons[0];
        //初始化第一次,投票
        personRank[persons[0]]++;
        //循环
        for (int i = 1; i < persons.length; i++) {
            //投票并记录,如果投完票比前任更强 or 最近投票
            if (++personRank[persons[i]] >= personRank[firstPerson[i - 1]]) {
                //记录新的最优势选举人
                firstPerson[i] = persons[i];
            } else {
                //默认前一个选举人最优势
                firstPerson[i] = firstPerson[i - 1];
            }
        }
        //记录所需结果
        this.firstPerson = firstPerson;
        this.times = times;
    }

    //寻找时间对应索引
    private int findIndex(int t, int mid, int left, int right) {
        //如果是目标索引
        if (this.times[mid] == t) {
            //返回
            return mid;
        }
        //如果范围到底了
        if (left + 1 == right) {
            //如果小于右边
            if (t < this.times[right]) {
                //返回
                return left;
            } else {
                //返回右边
                return right;
            }
        }
        //判断二分方向
        if (this.times[mid] > t) {
            //左
            return findIndex(t, left + ((mid - left) / 2), left, mid);
        } else {
            //右
            return findIndex(t, mid + ((right - mid) / 2), mid, right);
        }
    }

    public int q(int t) {
        //如果没人有优势
        if (t < this.times[0]) {
            //默认
            return -1;
        }
        //如果全部都包括
        if (t >= this.times[this.times.length - 1]) {
            //全部结果
            return this.firstPerson[this.firstPerson.length - 1];
        }
        //寻找对应索引
        int index = findIndex(t, times.length / 2, 0, this.times.length);
        //返回结果
        return this.firstPerson[index];
    }

    public static void main(String[] args) {
        Code4 code = new Code4(new int[]{0, 0, 1, 1, 2}, new int[]{0, 67, 69, 74, 87});
        System.out.println(code.q(100));
    }

}
