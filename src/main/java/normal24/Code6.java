package normal24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-09-18
 * 547. 省份数量
 * 中等
 * 1K
 * 相关企业
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Code6 {

    public int findCircleNum(int[][] isConnected) {
        //城市关联关系
        Map<Integer, Set<Integer>> relationshipMap = new HashMap<>();
        //循环1
        for (int i = 0; i < isConnected.length; i++) {
            //循环2
            for (int j = 0; j < isConnected[0].length; j++) {
                //如果相连 and 不是同一个城市
                if (isConnected[i][j] == 1 && i != j) {
                    //获取当前
                    Set<Integer> oneSet = relationshipMap.getOrDefault(i, new HashSet<>());
                    Set<Integer> twoSet = relationshipMap.getOrDefault(j, new HashSet<>());
                    //记录
                    oneSet.add(j);
                    twoSet.add(i);
                    //记录关系
                    relationshipMap.put(i, oneSet);
                    relationshipMap.put(j, twoSet);
                }
            }
        }
        //所有城市集合
        Set<Integer> citySet = new HashSet<>();
        //城市索引
        int p = 0;
        //循环
        while (p < isConnected.length) {
            //记录城市
            citySet.add(p++);
        }
        //独立省份数量
        int count = 0;
        //如果还有城市
        while (citySet.size() > 0) {
            //当前省份的所有城市集合
            Set<Integer> provinceSet = new HashSet<>();
            //当前城市集合
            Set<Integer> thisCitySet = new HashSet<>();
            //随机抽取一个城市
            thisCitySet.add(citySet.stream().findFirst().get());
            //加入到省份里
            provinceSet.addAll(thisCitySet);
            //如果城市
            while (thisCitySet.size() > 0) {
                //下一批当前城市集合
                Set<Integer> nextThisCitySet = new HashSet<>();
                //循环
                for (Integer city : thisCitySet) {
                    //如果不存在关系
                    if (relationshipMap.containsKey(city) == false) {
                        //本轮过
                        continue;
                    }
                    //获取下一批城市集合
                    Set<Integer> nextCitySet = relationshipMap.get(city);
                    //循环
                    for (Integer nextCity : nextCitySet) {
                        //如果不存在于可选项
                        if (citySet.contains(nextCity) == false) {
                            //本轮过
                            continue;
                        }
                        //如果存在于当前省份了
                        if (provinceSet.contains(nextCity)) {
                            //本轮过
                            continue;
                        }
                        //记录
                        nextThisCitySet.add(nextCity);
                    }
                }
                //记录本次所有城市至省份
                provinceSet.addAll(nextThisCitySet);
                //换下一批
                thisCitySet = nextThisCitySet;
            }
            //剔除本次组合一起的省份
            citySet.removeAll(provinceSet);
            //结果+1
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().findCircleNum(new int[][]{
                new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 0},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 1}
        }));
    }
}
