package normal34;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-08-16
 * 3169. 无需开会的工作日
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
 * <p>
 * 返回员工可工作且没有安排会议的天数。
 * <p>
 * 注意：会议时间可能会有重叠。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 第 4 天和第 8 天没有安排会议。
 * <p>
 * 示例 2：
 * <p>
 * 输入：days = 5, meetings = [[2,4],[1,3]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 第 5 天没有安排会议。
 * <p>
 * 示例 3：
 * <p>
 * 输入：days = 6, meetings = [[1,6]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 所有工作日都安排了会议。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= 109
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 1 <= meetings[i][0] <= meetings[i][1] <= days
 */
public class Code9 {

    public int countDays(int days, int[][] meetings) {
        //排序
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //没有会议的日志
        int result = 0;
        //当前时间
        int day = 0;
        //循环
        for (int[] meeting : meetings) {
            //如果中间有时间
            if (day < meeting[0]) {
                //计算出没有会议的时间
                result += meeting[0] - day;
            }
            //如果会议超了当前时间
            if (day <= meeting[1]) {
                //刷新当前时间
                day = meeting[1] + 1;
            }
        }
        //计算结果
        return result + (days - day);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countDays(10, new int[][]{
                new int[]{5, 7},
                new int[]{1, 3},
                new int[]{9, 10}
        }));
    }

}
