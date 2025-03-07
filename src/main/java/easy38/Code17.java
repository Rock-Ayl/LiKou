package easy38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-10-08
 * LCP 40. 心算挑战
 * 简单
 * 相关标签
 * 相关企业
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cards = [1,2,8,9], cnt = 3
 * <p>
 * 输出：18
 * <p>
 * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 * <p>
 * 示例 2：
 * <p>
 * 输入：cards = [3,3,1], cnt = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：不存在获取有效得分的卡牌方案。
 * <p>
 * 提示：
 * <p>
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 */
public class Code17 {

    public int maximumScore(int[] cards, int cnt) {
        //初始化奇偶列表
        List<Integer> singleList = new ArrayList<>();
        List<Integer> doubleList = new ArrayList<>();
        //循环
        for (int card : cards) {
            //判断奇偶
            if (card % 2 == 0) {
                //加入
                doubleList.add(card);
            } else {
                //加入
                singleList.add(card);
            }
        }
        //排序
        Collections.sort(singleList);
        Collections.sort(doubleList);
        //奇偶列表指针
        int singleIndex = singleList.size() - 1;
        int doubleIndex = doubleList.size() - 1;
        //当前和
        int sum = 0;
        //如果可以优先选奇数的
        while (cnt > 1 && singleIndex > 0) {
            //叠加当前和
            sum += singleList.get(singleIndex--) + singleList.get(singleIndex--);
            //-2
            cnt -= 2;
        }
        //如果还不够,偶数来凑
        while (cnt > 0 && doubleIndex >= 0) {
            //叠加当前和,并位移
            sum += doubleList.get(doubleIndex--);
            //-1
            cnt--;
        }
        //如果不满足
        if (sum == 0 || cnt > 0) {
            //返回结果
            return 0;
        }
        //初始化最大和的情况
        int maxSum = sum;
        //如果可以用 奇数 换 偶数
        while (singleIndex + 2 < singleList.size() && doubleIndex > 0) {
            //删除奇数的
            sum -= singleList.get(++singleIndex) + singleList.get(++singleIndex);
            //叠加偶数的
            sum += doubleList.get(doubleIndex--) + doubleList.get(doubleIndex--);
            //刷新最大情况
            maxSum = Math.max(maxSum, sum);
        }
        //返回结果
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maximumScore(new int[]{1, 7, 1, 4, 4, 2, 7, 6}, 6));
    }

}
