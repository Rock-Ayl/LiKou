package easy6;

/**
 * Created By Rock-Ayl on 2021-02-02
 * 1716. 计算力扣银行的钱
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * <p>
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 * <p>
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code6 {

    public static int totalMoney(int n) {
        //存的钱
        int save = 0;
        //存在几个完整周
        int week;
        //剩余几天
        int otherDay;
        //如果是
        if (n > 7) {
            //几个完整周
            week = n / 7;
            //剩余几天
            otherDay = n % 7;
        } else {
            //不存在
            week = 0;
            //n就是剩余天数
            otherDay = n;
        }
        //第一天的钱
        int x = week + 1;
        //每周至少28元
        save += week * 28;
        //完整周递增的钱
        int add = 7;
        //递增
        while (week > 1) {
            //递增
            save += add;
            //+7
            add += 7;
            //-1
            week--;

        }
        //循环
        for (int i = 0; i < otherDay; i++) {
            //递增并且钱+1
            save += x++;
        }
        //返回
        return save;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
}
