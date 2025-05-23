package easy30;

/**
 * @Author ayl
 * @Date 2023-05-18
 * 2682. 找出转圈游戏输家
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 * <p>
 * 游戏规则如下：
 * <p>
 * 第 1 个朋友接球。
 * <p>
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 * <p>
 * 当某个朋友第 2 次接到球时，游戏结束。
 * <p>
 * 在整场游戏中没有接到过球的朋友是 输家 。
 * <p>
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, k = 2
 * 输出：[4,5]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 2 步的玩家 —— 第 3 个朋友。
 * 2）第 3 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 2 个朋友。
 * 3）第 2 个朋友将球传给距离他顺时针方向 6 步的玩家 —— 第 3 个朋友。
 * 4）第 3 个朋友接到两次球，游戏结束。
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 4
 * 输出：[2,3,4]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 1 个朋友。
 * 2）第 1 个朋友接到两次球，游戏结束。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 50
 */
public class Code22 {

    public int[] circularGameLosers(int n, int k) {
        //初始化人传球
        int[] arr = new int[n];
        //次数
        int count = 1;
        //坐标
        int p = 0;
        //第一个默认球
        arr[p] = 1;
        //循环
        while (true) {
            //传球,并记录次数,轮回则回到队首
            p = (p + count++ * k) % n;
            //记录传球,并判断是否多了,如果有人接到第二个球,跳出
            if (++arr[p] > 1) {
                //跳出
                break;
            }
        }
        //初始化结果,结果定长
        int[] result = new int[n - count + 1];
        //指针
        int q = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果没有接过球,视为结果
            if (arr[i] == 0) {
                //记录
                result[q++] = i + 1;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code22().circularGameLosers(5, 2);
    }

}
