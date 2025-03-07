package easy29;

/**
 * @Author ayl
 * @Date 2023-03-19
 * 6323. 将钱分给最多的儿童
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * <p>
 * 你需要按照如下规则分配：
 * <p>
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * 示例 2：
 * <p>
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= money <= 200
 * 2 <= children <= 30
 */
public class Code5 {

    public int distMoney(int money, int children) {
        //钱不够人分
        if (money < children) {
            //过
            return -1;
        }
        //钱不够出结果
        if (money < 8) {
            //没有
            return 0;
        }
        //先保证每人先分1块钱
        money -= children;
        //满足8的结果
        int count = 0;
        //如果可以制造结果,就先制造满足条件的结果
        while (money >= 7 && children > 0) {
            //分7
            money -= 7;
            //多一个结果
            count++;
            //人少一个
            children--;
        }
        //钱还在,人只有一个,正好为不可处理情况
        if (money == 3 && children == 1) {
            //少一个
            count--;
        }
        //钱还在,但人没了
        if (money > 0 && children == 0) {
            //少一个
            count--;
        }
        //返回结果,最小0
        return Math.max(0, count);
    }

    public static void main(String[] args) {
        System.out.println(new Code5().distMoney(19, 2));
    }

}
