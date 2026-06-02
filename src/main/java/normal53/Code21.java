package normal53;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. 设计地铁系统
 * 算术评级: 6
 * 第 182 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1465
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 地铁系统跟踪不同车站之间的乘客出行时间，并使用这一数据来计算从一站到另一站的平均时间。
 * <p>
 * 实现 UndergroundSystem 类：
 * <p>
 * void checkIn(int id, string stationName, int t)
 * 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站进入
 * 乘客一次只能从一个站进入
 * void checkOut(int id, string stationName, int t)
 * 通行卡 ID 等于 id 的乘客，在时间 t ，从 stationName 站离开
 * double getAverageTime(string startStation, string endStation)
 * 返回从 startStation 站到 endStation 站的平均时间
 * 平均时间会根据截至目前所有从 startStation 站 直接 到达 endStation 站的行程进行计算，也就是从 startStation 站进入并从 endStation 离开的行程
 * 从 startStation 到 endStation 的行程时间与从 endStation 到 startStation 的行程时间可能不同
 * 在调用 getAverageTime 之前，至少有一名乘客从 startStation 站到达 endStation 站
 * 你可以假设对 checkIn 和 checkOut 方法的所有调用都是符合逻辑的。如果一名乘客在时间 t1 进站、时间 t2 出站，那么 t1 < t2 。所有时间都按时间顺序发生。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
 * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
 * <p>
 * 输出
 * [null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
 * <p>
 * 解释
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(45, "Leyton", 3);
 * undergroundSystem.checkIn(32, "Paradise", 8);
 * undergroundSystem.checkIn(27, "Leyton", 10);
 * undergroundSystem.checkOut(45, "Waterloo", 15);  // 乘客 45 "Leyton" -> "Waterloo" ，用时 15-3 = 12
 * undergroundSystem.checkOut(27, "Waterloo", 20);  // 乘客 27 "Leyton" -> "Waterloo" ，用时 20-10 = 10
 * undergroundSystem.checkOut(32, "Cambridge", 22); // 乘客 32 "Paradise" -> "Cambridge" ，用时 22-8 = 14
 * undergroundSystem.getAverageTime("Paradise", "Cambridge"); // 返回 14.00000 。只有一个 "Paradise" -> "Cambridge" 的行程，(14) / 1 = 14
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 11.00000 。有两个 "Leyton" -> "Waterloo" 的行程，(10 + 12) / 2 = 11
 * undergroundSystem.checkIn(10, "Leyton", 24);
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 11.00000
 * undergroundSystem.checkOut(10, "Waterloo", 38);  // 乘客 10 "Leyton" -> "Waterloo" ，用时 38-24 = 14
 * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // 返回 12.00000 。有三个 "Leyton" -> "Waterloo" 的行程，(10 + 12 + 14) / 3 = 12
 * 示例 2：
 * <p>
 * 输入
 * ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
 * [[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]
 * <p>
 * 输出
 * [null,null,null,5.00000,null,null,5.50000,null,null,6.66667]
 * <p>
 * 解释
 * UndergroundSystem undergroundSystem = new UndergroundSystem();
 * undergroundSystem.checkIn(10, "Leyton", 3);
 * undergroundSystem.checkOut(10, "Paradise", 8); // 乘客 10 "Leyton" -> "Paradise" ，用时 8-3 = 5
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 5.00000 ，(5) / 1 = 5
 * undergroundSystem.checkIn(5, "Leyton", 10);
 * undergroundSystem.checkOut(5, "Paradise", 16); // 乘客 5 "Leyton" -> "Paradise" ，用时 16-10 = 6
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 5.50000 ，(5 + 6) / 2 = 5.5
 * undergroundSystem.checkIn(2, "Leyton", 21);
 * undergroundSystem.checkOut(2, "Paradise", 30); // 乘客 2 "Leyton" -> "Paradise" ，用时 30-21 = 9
 * undergroundSystem.getAverageTime("Leyton", "Paradise"); // 返回 6.66667 ，(5 + 6 + 9) / 3 = 6.66667
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= id, t <= 106
 * 1 <= stationName.length, startStation.length, endStation.length <= 10
 * 所有字符串由大小写英文字母与数字组成
 * 总共最多调用 checkIn、checkOut 和 getAverageTime 方法 2 * 104 次
 * 与标准答案误差在 10-5 以内的结果都被视为正确结果
 */
public class Code21 {

    private static class UserNode {

        //乘客id
        private Integer id;

        //开始地点
        private String start;

        //开始时间
        private Integer startTime;

        //结束地点
        private String end;

        //结束时间
        private Integer endTime;

        //初始化
        public UserNode(Integer id) {
            this.id = id;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("UserNode{id=%d, start='%s', startTime=%d, end='%s', endTime=%d}", id, start, startTime, end, endTime);
        }

    }

    private static class StationNode {

        //地铁唯一key
        private String key;

        //总次数
        private Integer countSum;

        //总时间
        private Integer timeSum;

        //初始化
        public StationNode(String key) {
            this.key = key;
            this.countSum = 0;
            this.timeSum = 0;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("StationNode{key='%s', countSum=%d, timeSum=%d}", key, countSum, timeSum);
        }

    }

    //节点缓存
    private Map<Integer, UserNode> userNodeMap = new HashMap<>();
    //地铁缓存
    private Map<String, StationNode> stationNodeMap = new HashMap<>();

    public Code21() {

    }

    public void checkIn(int id, String stationName, int t) {
        //如果不存在
        if (this.userNodeMap.containsKey(id) == false) {
            //初始化
            this.userNodeMap.put(id, new UserNode(id));
        }
        //获取节点
        UserNode node = this.userNodeMap.get(id);
        //记录开始
        node.start = stationName;
        node.startTime = t;
    }

    public void checkOut(int id, String stationName, int t) {
        //获取节点
        UserNode node = this.userNodeMap.get(id);
        //记录结束
        node.end = stationName;
        node.endTime = t;
        //记录日志
        addLog(node);
    }

    public double getAverageTime(String startStation, String endStation) {
        //唯一key
        String key = startStation + "_" + endStation;
        //获取
        StationNode stationNode = this.stationNodeMap.get(key);
        //返回平均时间
        return (double) stationNode.timeSum / stationNode.countSum;
    }

    //记录本次出行日志
    private void addLog(UserNode node) {
        //唯一key
        String key = node.start + "_" + node.end;
        //如果不存在
        if (this.stationNodeMap.containsKey(key) == false) {
            //初始化
            this.stationNodeMap.put(key, new StationNode(key));
        }
        //获取
        StationNode stationNode = this.stationNodeMap.get(key);
        //记录
        stationNode.countSum++;
        stationNode.timeSum += node.endTime - node.startTime;
    }

}
