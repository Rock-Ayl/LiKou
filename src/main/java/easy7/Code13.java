package easy7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-03-09
 * 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 */
public class Code13 {

    public static String[] findRelativeRanks(int[] score) {
        //初始化结果
        String[] result = new String[score.length];
        //缓存1,记录成绩对应位置
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i = 0; i < score.length; i++) {
            //记录成绩+位置
            map.put(score[i], i);
        }
        //排序
        Arrays.sort(score);
        //名次
        int num = 1;
        //名次对应写入
        String numStr;
        //倒叙
        for (int i = score.length - 1; i >= 0; i--) {
            //获取当前最高的
            int grade = score[i];
            //获取对应位置
            int p = map.get(grade);
            //根据名次写入
            switch (num) {
                case 1:
                    //金牌
                    numStr = "Gold Medal";
                    break;
                case 2:
                    //铜牌
                    numStr = "Silver Medal";
                    break;
                case 3:
                    //铜牌
                    numStr = "Bronze Medal";
                    break;
                default:
                    //写入名次
                    numStr = num + "";
                    break;
            }
            //写入名次
            result[p] = numStr;
            //名次递增
            num++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String relativeRank : findRelativeRanks(new int[]{4, 5, 2, 3, 1})) {
            System.out.println(relativeRank);
        }
    }
}
