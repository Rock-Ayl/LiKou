package normal4;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-22
 * 面试题 16.10. 生存人数
 * 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
 * <p>
 * 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
 * <p>
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 * 通过次数8,336提交次数12,180
 */
public class Code8 {

    /**
     * 暴力
     *
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {
        //已经记录过的年
        Set<Integer> set = new HashSet<>();
        //最多人数
        int people = 0;
        //人数最多的年
        int minYear = 1899;
        //排序
        Arrays.sort(birth);
        Arrays.sort(death);
        //循环1
        for (int i : birth) {
            //如果走过了
            if (set.contains(i)) {
                //下一个
                continue;
            }
            //当年活的人数
            int thisPeople = 0;
            //循环
            for (int j = 0; j < birth.length; j++) {
                //如果这年还活着
                if (birth[j] <= i && death[j] >= i) {
                    //记录
                    thisPeople++;
                }
            }
            //如果比之前的要多
            if (thisPeople > people) {
                //更新
                people = thisPeople;
                minYear = i;
            }
            //记录
            set.add(i);
        }
        //循环2
        for (int i : death) {
            //如果走过了
            if (set.contains(i)) {
                //下一个
                continue;
            }
            //当年活的人数
            int thisPeople = 0;
            //循环
            for (int j = 0; j < birth.length; j++) {
                //如果这年还活着
                if (birth[j] <= i && death[j] >= i) {
                    //记录
                    thisPeople++;
                }
            }
            //如果比之前的要多
            if (thisPeople > people) {
                //更新
                people = thisPeople;
                minYear = i;
            }
            //记录
            set.add(i);
        }
        //返回结果
        return minYear;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxAliveYear(new int[]{1900, 1901, 1950}, new int[]{1948, 1951, 2000}));
    }

}
