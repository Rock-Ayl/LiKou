package easy32;

/**
 * @Author ayl
 * @Date 2023-06-20
 * 2739. 总行驶距离
 * 卡车有两个油箱。给你两个整数，mainTank 表示主油箱中的燃料（以升为单位），additionalTank 表示副油箱中的燃料（以升为单位）。
 * <p>
 * 该卡车每耗费 1 升燃料都可以行驶 10 km。每当主油箱使用了 5 升燃料时，如果副油箱至少有 1 升燃料，则会将 1 升燃料从副油箱转移到主油箱。
 * <p>
 * 返回卡车可以行驶的最大距离。
 * <p>
 * 注意：从副油箱向主油箱注入燃料不是连续行为。这一事件会在每消耗 5 升燃料时突然且立即发生。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mainTank = 5, additionalTank = 10
 * 输出：60
 * 解释：
 * 在用掉 5 升燃料后，主油箱中燃料还剩下 (5 - 5 + 1) = 1 升，行驶距离为 50km 。
 * 在用掉剩下的 1 升燃料后，没有新的燃料注入到主油箱中，主油箱变为空。
 * 总行驶距离为 60km 。
 * 示例 2：
 * <p>
 * 输入：mainTank = 1, additionalTank = 2
 * 输出：10
 * 解释：
 * 在用掉 1 升燃料后，主油箱变为空。
 * 总行驶距离为 10km 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= mainTank, additionalTank <= 100
 */
public class Code2 {

    public int distanceTraveled(int mainTank, int additionalTank) {
        //上次加的油,默认0
        int lastTank = 0;
        //循环
        while (true) {
            //计算本次可以叠加的油
            int addTank = Math.min(mainTank / 5, additionalTank);
            //如果和上次一样,视为无法继续加油了
            if (lastTank == addTank) {
                //跳出
                break;
            }
            //给主油箱加油,删除差值
            mainTank = mainTank + addTank - lastTank;
            //记录本次加的油
            lastTank = addTank;
        }
        //计算结果
        return mainTank * 10;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().distanceTraveled(9, 2));
    }

}
