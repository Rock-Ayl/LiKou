package normal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-11
 * 1276. 不浪费原料的汉堡制作方案
 * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
 * <p>
 * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
 * <p>
 * 巨无霸汉堡：4 片番茄和 1 片奶酪
 * 小皇堡：2 片番茄和 1 片奶酪
 * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 * <p>
 * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 * <p>
 * 示例 1：
 * <p>
 * 输入：tomatoSlices = 16, cheeseSlices = 7
 * 输出：[1,6]
 * 解释：制作 1 个巨无霸汉堡和 6 个小皇堡需要 4*1 + 2*6 = 16 片番茄和 1 + 6 = 7 片奶酪。不会剩下原料。
 * 示例 2：
 * <p>
 * 输入：tomatoSlices = 17, cheeseSlices = 4
 * 输出：[]
 * 解释：只制作小皇堡和巨无霸汉堡无法用光全部原料。
 * 示例 3：
 * <p>
 * 输入：tomatoSlices = 4, cheeseSlices = 17
 * 输出：[]
 * 解释：制作 1 个巨无霸汉堡会剩下 16 片奶酪，制作 2 个小皇堡会剩下 15 片奶酪。
 * 示例 4：
 * <p>
 * 输入：tomatoSlices = 0, cheeseSlices = 0
 * 输出：[0,0]
 * 示例 5：
 * <p>
 * 输入：tomatoSlices = 2, cheeseSlices = 1
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= tomatoSlices <= 10^7
 * 0 <= cheeseSlices <= 10^7
 */
public class Code10 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        //初始化
        List<Integer> result = new ArrayList<>();
        //如果不存在
        if (tomatoSlices < 1 || cheeseSlices < 1) {
            //如果都不存在
            if (tomatoSlices == 0 && cheeseSlices == 0) {
                //组装
                result.add(0);
                result.add(0);
            }
            //返回
            return result;
        }
        //奶酪先翻倍
        int twoCheese = cheeseSlices * 2;
        //如果 最大、最小组合不能满足
        if (tomatoSlices < twoCheese || tomatoSlices > (twoCheese * 2)) {
            //返回
            return result;
        }
        //计算二者的差
        int from = tomatoSlices - twoCheese;
        //如果差是奇数
        if (from % 2 != 0) {
            //返回
            return result;
        }
        //巨无霸个数
        int bigSize = from / 2;
        //小汉堡个数
        int smallSize = cheeseSlices - bigSize;
        //记录
        result.add(bigSize);
        result.add(smallSize);
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().numOfBurgers(16, 7));
    }
}
