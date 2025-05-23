package easy3;

/**
 * Created By Rock-Ayl on 2020-10-29
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 * <p>
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * 提示：
 * <p>
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20
 */
public class Code9 {

    public static boolean lemonadeChange(int[] bills) {
        //10块钱零钱数量
        int ten = 0;
        //5块钱零钱数量
        int five = 0;
        //循环
        for (int bill : bills) {
            //判断零钱
            switch (bill) {
                case 5:
                    //5元+1
                    five++;
                    break;
                case 10:
                    //如果没有零钱
                    if (five == 0) {
                        //找不开
                        return false;
                    }
                    //5元零钱减少
                    five--;
                    //10元零钱增加
                    ten++;
                    break;
                case 20:
                    //如果有10元零钱
                    if (ten > 0) {
                        //如果没有5元零钱
                        if (five < 1) {
                            //找不开
                            return false;
                        } else {
                            //找零
                            ten--;
                            five--;
                        }
                    }
                    //没有10元零钱
                    else {
                        //如果有3个5元零钱
                        if (five < 3) {
                            //找不开
                            return false;
                        } else {
                            //找零
                            five = five - 3;
                        }
                    }
                    break;
            }
        }
        //返回
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
