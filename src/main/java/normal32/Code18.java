package normal32;

/**
 * @Author ayl
 * @Date 2024-06-13
 * 2241. 设计一个 ATM 机器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM 机是空的。用户可以用它存或者取任意数目的钱。
 * <p>
 * 取款时，机器会优先取 较大 数额的钱。
 * <p>
 * 比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和 $200 的钞票。
 * 但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500 的钞票，然后无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。
 * 请你实现 ATM 类：
 * <p>
 * ATM() 初始化 ATM 对象。
 * void deposit(int[] banknotesCount) 分别存入 $20 ，$50，$100，$200 和 $500 钞票的数目。
 * int[] withdraw(int amount) 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和 $500 钞票的数目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1] （这种情况下 不 取出任何钞票）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
 * [[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
 * 输出：
 * [null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]
 * <p>
 * 解释：
 * ATM atm = new ATM();
 * atm.deposit([0,0,1,2,1]); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
 * atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
 * atm.deposit([0,1,0,1,1]); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
 * // 机器中剩余钞票数量为 [0,1,0,3,1] 。
 * atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100 ，所以取款请求会被拒绝。
 * // 由于请求被拒绝，机器中钞票的数量不会发生改变。
 * atm.withdraw(550);        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500 的钞票。
 * <p>
 * <p>
 * 提示：
 * <p>
 * banknotesCount.length == 5
 * 0 <= banknotesCount[i] <= 109
 * 1 <= amount <= 109
 * 总共 最多有 5000 次 withdraw 和 deposit 的调用。
 * 函数 withdraw 和 deposit 至少各有 一次 调用。
 */
public class Code18 {

    //每种钱的面值
    private int[] money;
    //每种钱的数量
    private long[] moneyCount;

    public Code18() {
        //初始化
        this.money = new int[]{20, 50, 100, 200, 500};
        this.moneyCount = new long[5];
    }

    //存钱
    public void deposit(int[] banknotesCount) {
        //循环
        for (int i = 0; i < banknotesCount.length; i++) {
            //叠加
            this.moneyCount[i] += banknotesCount[i];
        }
    }

    //取钱
    public int[] withdraw(int amount) {
        //初始化结果
        int[] result = new int[5];
        //从500的开始
        int p = this.moneyCount.length - 1;
        //如果有内容
        while (amount > 0 && p >= 0) {
            //如果不能取这个金额
            if (amount < this.money[p]) {
                //下一位
                --p;
                //本轮过
                continue;
            }
            //当前可支付额度
            long thisMoneySum = this.moneyCount[p] * this.money[p];
            //如果正好完全相同
            if (thisMoneySum == amount) {
                //记录本次结果
                result[p] = (int) this.moneyCount[p];
                //减去本次金额
                amount -= thisMoneySum;
            } else if (thisMoneySum < amount) {
                //记录本次结果
                result[p] = (int) this.moneyCount[p];
                //减去本次金额
                amount -= thisMoneySum;
                //下一位
                --p;
            } else {
                //记录本次结果
                result[p] = amount / this.money[p];
                //减去本次金额
                amount -= result[p] * this.money[p];
            }
        }
        //如果钱不够
        if (amount > 0) {
            //无法取钱
            return new int[]{-1};
        }
        //循环,结算
        for (int i = 0; i < result.length; i++) {
            //扣除取钱数量
            this.moneyCount[i] -= result[i];
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        Code18 code18 = new Code18();
        code18.deposit(new int[]{0, 10, 0, 3, 0});
        print(code18.withdraw(500));
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
