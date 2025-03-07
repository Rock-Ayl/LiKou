package normal34;

/**
 * @Author ayl
 * @Date 2024-09-10
 * 1010. 总持续时间可被 60 整除的歌曲
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 */
public class Code25 {

    private int thirtyOrSixty(int count) {
        //计算最后的数字
        int last = Math.max(count - 1, 0);
        //如果不够
        if (last < 1) {
            //过
            return 0;
        }
        //返回
        return (1 + last) * (last / 2) + (last % 2 != 0 ? ((1 + last) / 2) : 0);
    }

    public int numPairsDivisibleBy60(int[] time) {
        //所有情况存放在数组
        int[] arr = new int[61];
        //循环
        for (int i : time) {
            //计算对应的数字
            arr[i % 60]++;
        }
        //目标结果和
        int result = 0;
        //循环
        for (int i = 1; i < 30; i++) {
            //与另一伴的索引,计算并叠加
            result += arr[i] * arr[60 - i];
        }
        //计算并返回结果
        return result + thirtyOrSixty(arr[0]) + thirtyOrSixty(arr[30]);
    }

    public static void main(String[] args) {
        System.out.println(new Code25().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

}
