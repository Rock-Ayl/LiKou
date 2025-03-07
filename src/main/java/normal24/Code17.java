package normal24;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-10-08
 * 1418. 点菜展示表
 * 提示
 * 中等
 * 88
 * 相关企业
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 * <p>
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 * <p>
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * tableNumberi 是 1 到 500 范围内的整数。
 */
public class Code17 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        //获取菜品集合、去重、排序
        List<String> dishesList = orders
                .stream()
                .map(p -> p.get(2))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        //获取桌子集合、去重、排序
        List<String> tableList = orders
                .stream()
                .map(p -> p.get(1))
                .map(Integer::valueOf)
                .distinct()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.toList());
        //初始化结果
        List<List<String>> result = new ArrayList<>();
        //菜品坐标
        Map<String, Integer> dishesIndexMap = new HashMap<>();
        //桌子坐标
        Map<String, Integer> tableIndexMap = new HashMap<>();
        //初始化表头并组装
        List<String> resultFirstList = new ArrayList<>();
        result.add(resultFirstList);
        resultFirstList.add("Table");
        //循环
        for (String dishes : dishesList) {
            //记录坐标
            dishesIndexMap.put(dishes, resultFirstList.size());
            //组装菜品
            resultFirstList.add(dishes);
        }
        //循环
        for (String table : tableList) {
            //记录坐标
            tableIndexMap.put(table, result.size());
            //初始化桌子节点列表并组装
            List<String> tableNodeList = new ArrayList<>();
            result.add(tableNodeList);
            //初始化桌子信息
            tableNodeList.add(table);
            //循环
            for (String dishes : dishesList) {
                //默认数量
                tableNodeList.add("0");
            }
        }
        //循环订单
        for (List<String> order : orders) {
            //获取对应桌子数据
            List<String> tableDataList = result.get(tableIndexMap.get(order.get(1)));
            //获取菜品坐标
            Integer dishesIndex = dishesIndexMap.get(order.get(2));
            //计算新菜品count
            Integer newCount = Integer.valueOf(tableDataList.get(dishesIndex)) + 1;
            //覆盖
            tableDataList.set(dishesIndex, newCount.toString());
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new Code17().displayTable(Arrays.asList(
                Arrays.asList("David", "3", "Ceviche"),
                Arrays.asList("Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"),
                Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"),
                Arrays.asList("Rous", "3", "Ceviche")
        ));
        System.out.println();
    }

}
