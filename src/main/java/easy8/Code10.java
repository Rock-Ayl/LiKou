package easy8;

/**
 * @Author 安永亮
 * @Date 2021-06-06
 * @Description 1854. 人口最多的年份
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * <p>
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * <p>
 * 返回 人口最多 且 最早 的年份。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 * <p>
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class Code10 {

    public int maximumPopulation(int[][] logs) {
        //桶
        int[] arr = new int[101];
        //循环
        for (int[] log : logs) {
            //开始结束
            int start = log[0] - 1950, end = log[1] - 1950;
            //循环
            while (start < end) {
                //递增
                arr[start]++;
                start++;
            }
        }
        //指针
        int p = -1;
        //人数
        int size = 0;
        //循环对比
        for (int i = 0; i < arr.length; i++) {
            //如果存在更大的数量
            if (arr[i] > size) {
                //刷新纪录
                size = arr[i];
                p = i;
            }
        }
        //结果
        return p + 1950;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().maximumPopulation(new int[][]{
                new int[]{1950, 1961},
                new int[]{1960, 1971},
                new int[]{1970, 1981}
        }));
    }

}
