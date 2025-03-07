package easy23;

/**
 * @Author ayl
 * @Date 2022-09-16
 * 2303. 计算应缴税款总额
 * 给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，表示第 i 个税级的上限是 upperi ，征收的税率为 percenti 。税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upperi-1 < upperi）。
 * <p>
 * 税款计算方式如下：
 * <p>
 * 不超过 upper0 的收入按税率 percent0 缴纳
 * 接着 upper1 - upper0 的部分按税率 percent1 缴纳
 * 然后 upper2 - upper1 的部分按税率 percent2 缴纳
 * 以此类推
 * 给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10-5 的结果将被视作正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：brackets = [[3,50],[7,10],[12,25]], income = 10
 * 输出：2.65000
 * 解释：
 * 前 $3 的税率为 50% 。需要支付税款 $3 * 50% = $1.50 。
 * 接下来 $7 - $3 = $4 的税率为 10% 。需要支付税款 $4 * 10% = $0.40 。
 * 最后 $10 - $7 = $3 的税率为 25% 。需要支付税款 $3 * 25% = $0.75 。
 * 需要支付的税款总计 $1.50 + $0.40 + $0.75 = $2.65 。
 * 示例 2：
 * <p>
 * 输入：brackets = [[1,0],[4,25],[5,50]], income = 2
 * 输出：0.25000
 * 解释：
 * 前 $1 的税率为 0% 。需要支付税款 $1 * 0% = $0 。
 * 剩下 $1 的税率为 25% 。需要支付税款 $1 * 25% = $0.25 。
 * 需要支付的税款总计 $0 + $0.25 = $0.25 。
 * 示例 3：
 * <p>
 * 输入：brackets = [[2,50]], income = 0
 * 输出：0.00000
 * 解释：
 * 没有收入，无需纳税，需要支付的税款总计 $0 。
 */
public class Code2 {

    public double calculateTax(int[][] brackets, int income) {
        //最终交税
        double real = 0;
        //上次的额度上限(本次的下限）
        double lastMax = 0;
        //循环
        for (int[] bracket : brackets) {
            //判断本次上限是否拉满
            if (bracket[0] <= income) {
                //计算当前交税钱数
                double count = bracket[0] - lastMax;
                //计算出本次税,并叠加
                real += count / 100 * bracket[1];
                //更换上次额度
                lastMax = bracket[0];
            } else {
                //计算当前交税钱数
                double count = bracket[0] - lastMax - bracket[0] + income;
                //计算出本次税,并叠加
                real += count / 100 * bracket[1];
                //彻底结束计算
                break;
            }
        }
        //返回最终交税
        return real;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().calculateTax(new int[][]{
                new int[]{1, 0},
                new int[]{4, 25},
                new int[]{5, 50}
        }, 2));
    }

}
