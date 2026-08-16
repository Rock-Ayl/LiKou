package normal56;

/**
 * 4020. 电梯请求 I
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示一栋楼房的楼层数，楼层编号从 0 到 n - 1 。
 * <p>
 * 同时给你一个整数数组 requests ，其中 requests 表示楼层请求的序列。
 * <p>
 * 一部电梯初始在 0 层，遵循以下规则：
 * <p>
 * 电梯每秒移动一层。
 * 电梯按给定的顺序处理请求。
 * 如果电梯已经在请求的楼层，则不需要移动。
 * 处理完一个请求后，电梯立即开始向下一个请求的楼层移动。
 * 返回处理所有请求所需的 总时间 （以秒为单位）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5, requests = [2,1,4,3]
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * requests[0] = 2：从 0 层移动到 2 层需要 2 秒。
 * requests[1] = 1：从 2 层移动到 1 层需要 1 秒。
 * requests[2] = 4：从 1 层移动到 4 层需要 3 秒。
 * requests[3] = 3：从 4 层移动到 3 层需要 1 秒。
 * 所需的总时间是 2 + 1 + 3 + 1 = 7 秒。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 3, requests = [2,0,0]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * requests[0] = 2：从 0 层移动到 2 层需要 2 秒。
 * requests[1] = 0：从 2 层移动到 0 层需要 2 秒。
 * requests[2] = 0：不需要移动。
 * 所需的总时间是 2 + 2 + 0 = 4 秒。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 1 <= requests.length <= 100
 * 0 <= requests[i] <= n - 1
 */
public class Code7 {

    public int elevatorRequests(int n, int[] requests) {
        //和
        int sum = requests[0];
        //循环
        for (int i = 1; i < requests.length; i++) {
            //叠加
            sum += Math.abs(requests[i] - requests[i - 1]);
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().elevatorRequests(5, new int[]{2, 1, 4, 3}));
    }

}
