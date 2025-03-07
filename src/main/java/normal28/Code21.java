package normal28;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-02-07
 * 2225. 找出输掉零场或一场比赛的玩家
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * <p>
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * <p>
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * 示例 2：
 * <p>
 * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * 输出：[[1,2,5,6],[]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * 所有 matches[i] 互不相同
 */
public class Code21 {

    public List<List<Integer>> findWinners(int[][] matches) {
        //结果
        List<List<Integer>> result = new ArrayList<>();
        //输赢map
        Map<Integer, Set<Integer>> winMap = new HashMap<>();
        Map<Integer, Set<Integer>> loseMap = new HashMap<>();
        //循环
        for (int[] match : matches) {
            //如果不存在
            if (winMap.containsKey(match[0]) == false) {
                //初始化
                winMap.put(match[0], new HashSet<>());
            }
            //记录
            winMap.get(match[0]).add(match[1]);
            //如果不存在
            if (loseMap.containsKey(match[1]) == false) {
                //初始化
                loseMap.put(match[1], new HashSet<>());
            }
            //记录
            loseMap.get(match[1]).add(match[0]);
        }
        //初始化所有玩家
        Set<Integer> allUserSet = new HashSet<>();
        //加入
        allUserSet.addAll(winMap.keySet());
        allUserSet.addAll(loseMap.keySet());
        //复制一个没有输掉任何比赛的玩家集合
        HashSet<Integer> noLoseSet = new HashSet<>(allUserSet);
        //删除输掉的人员
        noLoseSet.removeAll(loseMap.keySet());
        //排序,记录本次结果
        result.add(new ArrayList<>(noLoseSet).stream().sorted().collect(Collectors.toList()));
        //计算只输掉一场的玩家,排序
        result.add(new ArrayList<>(loseMap.entrySet().stream().filter(p->p.getValue().size()==1).map(Map.Entry::getKey).sorted().collect(Collectors.toList())));
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> winners = new Code21().findWinners(new int[][]{
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 6},
                new int[]{5, 6},
                new int[]{5, 7},
                new int[]{4, 5},
                new int[]{4, 8},
                new int[]{4, 9},
                new int[]{10, 4},
                new int[]{10, 9}
        });
        System.out.println();
    }

}
