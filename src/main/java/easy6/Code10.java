package easy6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-02-07
 * 1496. 判断路径是否相交
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * <p>
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * <p>
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 * <p>
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 * <p>
 * 提示：
 * <p>
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 */
public class Code10 {

    public static boolean isPathCrossing(String path) {
        //初始化缓存
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //点坐标
        int x = 0, y = 0;
        //初始化
        Set<Integer> first = new HashSet<>();
        //记录
        first.add(y);
        //记录
        map.put(x, first);
        //循环
        for (int i = 0; i < path.toCharArray().length; i++) {
            //获取当前
            char word = path.charAt(i);
            //根据类型操作
            switch (word) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            //如果存在x坐标
            if (map.containsKey(x)) {
                //获取里面的缓存
                Set<Integer> set = map.get(x);
                //如果y坐标
                if (set.contains(y)) {
                    //有了交点
                    return true;
                } else {
                    //更新
                    set.add(y);
                    //更新
                    map.put(x, set);
                }
            } else {
                //初始化
                Set<Integer> set = new HashSet<>();
                //记录
                set.add(y);
                //记录
                map.put(x, set);
            }
        }
        //默认不相交
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NESWW"));
    }
}
