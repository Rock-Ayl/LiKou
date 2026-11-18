package normal59;

/**
 * 935. 骑士拨号器
 * 算术评级: 5
 * 第 109 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1690
 * 相关标签
 * premium lock icon
 * 相关企业
 * 象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
 * <p>
 * 象棋骑士可能的移动方式如下图所示:
 * <p>
 * <p>
 * <p>
 * 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
 * <p>
 * <p>
 * <p>
 * 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
 * <p>
 * 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
 * <p>
 * 因为答案可能很大，所以输出答案模 109 + 7.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：10
 * 解释：我们需要拨一个长度为1的数字，所以把骑士放在10个单元格中的任何一个数字单元格上都能满足条件。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：20
 * 解释：我们可以拨打的所有有效号码为[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * 示例 3：
 * <p>
 * 输入：n = 3131
 * 输出：136006598
 * 解释：注意取模
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5000
 */
public class Code3 {

    public int knightDialer(int n) {
        //特殊情况
        if (n == 1) {
            //返回
            return 10;
        }
        //初始化数组
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //递归
        arr = next(arr, n);
        //结果
        int sum = 0;
        //循环
        for (int num : arr) {
            //本次
            sum = (sum + num) % 1000000007;
        }
        //返回
        return sum;
    }

    //递归
    private int[] next(int[] arr, int n) {
        //如果到头了
        if (n <= 1) {
            //过
            return arr;
        }
        //下一个数组
        int[] nextArr = new int[10];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果没有
            if (arr[i] == 0) {
                //本轮过
                continue;
            }
            //根据最后一位推断后续
            switch (i) {
                case 0:
                    nextArr[4] = (nextArr[4] + arr[i]) % 1000000007;
                    nextArr[6] = (nextArr[6] + arr[i]) % 1000000007;
                    break;
                case 1:
                    nextArr[6] = (nextArr[6] + arr[i]) % 1000000007;
                    nextArr[8] = (nextArr[8] + arr[i]) % 1000000007;
                    break;
                case 2:
                    nextArr[7] = (nextArr[7] + arr[i]) % 1000000007;
                    nextArr[9] = (nextArr[9] + arr[i]) % 1000000007;
                    break;
                case 3:
                    nextArr[4] = (nextArr[4] + arr[i]) % 1000000007;
                    nextArr[8] = (nextArr[8] + arr[i]) % 1000000007;
                    break;
                case 4:
                    nextArr[3] = (nextArr[3] + arr[i]) % 1000000007;
                    nextArr[9] = (nextArr[9] + arr[i]) % 1000000007;
                    nextArr[0] = (nextArr[0] + arr[i]) % 1000000007;
                    break;
                case 5:
                    break;
                case 6:
                    nextArr[1] = (nextArr[1] + arr[i]) % 1000000007;
                    nextArr[7] = (nextArr[7] + arr[i]) % 1000000007;
                    nextArr[0] = (nextArr[0] + arr[i]) % 1000000007;
                    break;
                case 7:
                    nextArr[2] = (nextArr[2] + arr[i]) % 1000000007;
                    nextArr[6] = (nextArr[6] + arr[i]) % 1000000007;
                    break;
                case 8:
                    nextArr[1] = (nextArr[1] + arr[i]) % 1000000007;
                    nextArr[3] = (nextArr[3] + arr[i]) % 1000000007;
                    break;
                case 9:
                    nextArr[2] = (nextArr[2] + arr[i]) % 1000000007;
                    nextArr[4] = (nextArr[4] + arr[i]) % 1000000007;
                    break;
            }
        }
        //递归下一个
        return next(nextArr, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().knightDialer(2));
    }

}
