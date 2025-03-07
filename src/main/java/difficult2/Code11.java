package difficult2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-04-20
 */
public class Code11 {

    private double next(Map<Integer, Set<Integer>> walkMap, int time, Integer father, Integer key, Integer target, double roll) {
        //如果当前是目标结果
        if (time == 0 && key.equals(target)) {
            //返回
            return roll;
        }
        //如果时间不够
        if (time < 0) {
            //过
            return 0D;
        }
        //尝试获取
        Set<Integer> nextList = walkMap.get(key);
        //如果只有原路
        if (nextList.size() == 1) {
            //如果没有任何子节点、同时当前节点是目标节点
            if (key.equals(target)) {
                //返回
                return roll;
            }
            //过
            return 0D;
        }
        //下一步的概率
        double nextRoll = roll / (nextList.size() - 1);
        //循环
        for (Integer nextKey : nextList) {
            //如果是父亲
            if (nextKey.equals(father)) {
                //本轮过
                continue;
            }
            //递归
            double nextResult = next(walkMap, time - 1, key, nextKey, target, nextRoll);
            //如果是结果
            if (nextResult > 0D) {
                //返回结果
                return nextResult;
            }
        }
        //默认
        return 0D;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        //如果没有数量
        if (edges.length < 1) {
            //如果是特殊情况
            if (target == 1 && t == 1) {
                //返回
                return 1D;
            }
            //默认
            return 0D;
        }
        //缓存
        Map<Integer, Set<Integer>> walkMap = new HashMap<>();
        //循环
        for (int[] edge : edges) {
            //父亲
            Integer father = edge[0];
            Integer child = edge[1];
            //如果不存在
            if (walkMap.containsKey(father) == false) {
                //初始化
                walkMap.put(father, new HashSet<>());
            }
            //记录关系
            walkMap.get(father).add(child);
            //如果不存在
            if (walkMap.containsKey(child) == false) {
                //初始化
                walkMap.put(child, new HashSet<>());
            }
            //记录关系
            walkMap.get(child).add(father);
        }
        //获取首次
        Set<Integer> firstSet = walkMap.getOrDefault(1, new HashSet<>());
        //循环
        for (Integer key : firstSet) {
            //递归
            double result = next(walkMap, t - 1, 1, key, target, 1D / firstSet.size());
            //如果是
            if (result > 0D) {
                //返回
                return result;
            }
        }
        //默认
        return 0D;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().frogPosition(7, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 7},
                new int[]{2, 4},
                new int[]{2, 6},
                new int[]{3, 5}
        }, 20, 6));
    }

}
