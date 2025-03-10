package easy32;

/**
 * @Author ayl
 * @Date 2023-08-06
 * 6990. 取整购买后的账户余额
 * 一开始，你的银行账户里有 100 块钱。
 * <p>
 * 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。
 * <p>
 * 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，你实际会支付一个 非负 金额 roundedAmount ，满足 roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。
 * <p>
 * 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。
 * <p>
 * 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。
 * <p>
 * 注意： 0 也是 10 的倍数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：purchaseAmount = 9
 * 输出：90
 * 解释：这个例子中，最接近 9 的 10 的倍数是 10 。所以你的账户余额为 100 - 10 = 90 。
 * 示例 2：
 * <p>
 * 输入：purchaseAmount = 15
 * 输出：80
 * 解释：这个例子中，有 2 个最接近 15 的 10 的倍数：10 和 20，较大的数 20 是你的实际开销。
 * 所以你的账户余额为 100 - 20 = 80 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= purchaseAmount <= 100
 */
public class Code20 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        //钱默认100
        int money = 100;
        //如果太小
        if (purchaseAmount < 5) {
            //默认
            return money;
        }
        //如果是10的倍数
        if (purchaseAmount % 10 == 0) {
            //直接
            return money - purchaseAmount;
        }
        //十位数
        int ten = purchaseAmount / 10;
        //可能得俩数字
        int left = ten * 10;
        int right = (ten + 1) * 10;
        //如果离更大的更近
        if (right - purchaseAmount <= purchaseAmount - left) {
            //用更大的
            return money - right;
        } else {
            //用更小的
            return money - left;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code20().accountBalanceAfterPurchase(15));
    }

}
