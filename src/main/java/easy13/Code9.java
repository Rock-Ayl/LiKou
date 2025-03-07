package easy13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-10-22
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * 通过次数29,418提交次数56,302
 */
public class Code9 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        //缓存
        Map<String, Integer> map = new HashMap<>(list1.length);
        //循环
        for (int i = 0; i < list1.length; i++) {
            //组装
            map.put(list1[i], i);
        }
        //结果
        List<String> list = new ArrayList<>();
        //最小的索引
        int min = Integer.MAX_VALUE;
        //循环2
        for (int i = 0; i < list2.length; i++) {
            //当前
            String value = list2[i];
            //如果存在
            if (map.containsKey(value)) {
                //获取索引
                int index = map.get(value) + i;
                //如果比之前的大
                if (index > min) {
                    //过
                    continue;
                } else if (index == min) {
                    //记录结果
                    list.add(value);
                } else {
                    //记录最小索引
                    min = index;
                    //清空结果
                    list.clear();
                    //记录
                    list.add(value);
                }
            }
        }
        //初始化
        String[] result = new String[list.size()];
        //循环
        for (int i = 0; i < list.size(); i++) {
            //组装
            result[i] = list.get(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {

    }

}
