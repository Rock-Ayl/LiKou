package normal7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-09-04
 * 846. 一手顺子
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * <p>
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * <p>
 * 如果她可以完成分组就返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class Code6 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        //如果不能整除
        if (hand.length % groupSize != 0) {
            //肯定不行
            return false;
        }
        //排序
        Arrays.sort(hand);
        //缓存初始化
        List<Integer> list = new ArrayList<>(hand.length);
        //循环
        for (int i : hand) {
            //组装
            list.add(i);
        }
        //循环
        for (int i = 1; i < hand.length; i++) {
            //如果还存在
            while (list.isEmpty() == false) {
                //初始化
                int time = 0;
                //第一个
                int first = list.get(0);
                //循环
                while (time++ < groupSize) {
                    //删除
                    boolean isSuccess = list.remove(new Integer(first++));
                    //如果失败了
                    if (isSuccess == false) {
                        //返回
                        return false;
                    }
                }
            }
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().isNStraightHand(new int[]{9, 13, 15, 23, 22, 25, 4, 4, 29, 15, 8, 23, 12, 19, 24, 17, 18, 11, 22, 24, 17, 17, 10, 23, 21, 18, 14, 18, 7, 6, 3, 6, 19, 11, 16, 11, 12, 13, 8, 26, 17, 20, 13, 19, 22, 21, 27, 9, 20, 15, 20, 27, 8, 13, 25, 23, 22, 15, 9, 14, 20, 10, 6, 5, 14, 12, 7, 16, 21, 18, 21, 24, 23, 10, 21, 16, 18, 16, 18, 5, 20, 19, 20, 10, 14, 26, 2, 9, 19, 12, 28, 17, 5, 7, 25, 22, 16, 17, 21, 11}, 10));
    }
}
