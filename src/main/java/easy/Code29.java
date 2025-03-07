package easy;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-09-06
 * 1436. 旅行终点站
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * <p>
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 * <p>
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 * <p>
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 * <p>
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 */
public class Code29 {

    public static String destCity(List<List<String>> paths) {
        //初始化缓存1
        Set<String> cacheX = new HashSet<>();
        //初始化缓存2
        List<String> cacheY = new ArrayList<>();
        //初始化缓存3
        List<String> cacheZ = new ArrayList<>();
        //循环1
        for (List<String> path : paths) {
            //循环2
            for (int i = 0; i < path.size(); i++) {
                //获取当前值
                String thisValue = path.get(i);
                //如果缓存1已存在
                if (cacheX.contains(thisValue)) {
                    //记录到缓存2
                    cacheY.add(thisValue);
                } else {
                    //记录到缓存1
                    cacheX.add(thisValue);
                }
                //如果是第一个头
                if (i == 0) {
                    //无论如何,记录到缓存3中
                    cacheZ.add(thisValue);
                }
            }
        }
        //删除所有存在2次的(中间节点)
        cacheX.removeIf(x -> cacheY.contains(x));
        //删除开始节点
        cacheX.removeIf(y -> cacheZ.contains(y));
        //取出最后一个并返回
        return (String) cacheX.toArray()[0];
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("B");
        List<String> b = new ArrayList<>();
        b.add("B");
        b.add("C");
        List<String> c = new ArrayList<>();
        c.add("C");
        c.add("D");
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(destCity(list));
    }
}
