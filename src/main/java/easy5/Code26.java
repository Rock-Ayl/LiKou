package easy5;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-01-26
 * 面试题 16.15. 珠玑妙算
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * <p>
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 示例：
 * <p>
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 * 提示：
 * <p>
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 */
public class Code26 {

    public static int[] masterMind(String solution, String guess) {
        //初始化结果
        int[] result = new int[2];
        //长度
        int size = solution.length();
        //完全猜中
        int all = 0;
        //缓存1
        Map<Character, Integer> map1 = new HashMap<>();
        //缓存1
        Map<Character, Integer> map2 = new HashMap<>();
        //缓存3
        Set<Character> set = new HashSet<>();
        //循环
        for (int i = 0; i < size; i++) {
            //获取当前位置对应字符
            char a = solution.charAt(i), b = guess.charAt(i);
            //如果完全一致
            if (a == b) {
                //递增
                all++;
            } else {
                //如果存在
                if (map1.containsKey(a)) {
                    //+1
                    map1.put(a, map1.get(a) + 1);
                } else {
                    //初始
                    map1.put(a, 1);
                }
                //如果存在
                if (map2.containsKey(b)) {
                    //+1
                    map2.put(b, map2.get(b) + 1);
                } else {
                    //初始
                    map2.put(b, 1);
                }
                //记录缓存3
                set.add(a);
                set.add(b);
            }
        }
        //记录全对结果
        result[0] = all;
        //半对
        int half = 0;
        //循环
        for (Character character : set) {
            //如果同时存在
            if (map1.containsKey(character) && map2.containsKey(character)) {
                //获取该字符猜对了几次
                int num = Math.min(map1.get(character), map2.get(character));
                //叠加
                half += num;
            }
        }
        //记录半对结果
        result[1] = half;
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        for (int i : masterMind("RGBY", "GGRR")) {
            System.out.println(i);
        }
    }
}
