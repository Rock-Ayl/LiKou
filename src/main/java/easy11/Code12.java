package easy11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-09-24
 * 1773. 统计匹配检索规则的物品数量
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * <p>
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * <p>
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * <p>
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * 示例 2：
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= items.length <= 104
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 */
public class Code12 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //次数
        int size = 0;
        //指针
        int p;
        //根据操作
        switch (ruleKey) {
            //类型
            case "type":
                p = 0;
                break;
            //颜色
            case "color":
                p = 1;
                break;
            //名称
            case "name":
                p = 2;
                break;
            //默认
            default:
                //直接返回
                return size;
        }
        //循环
        for (List<String> item : items) {
            //获取对应值
            String value = item.get(p);
            //如果相同
            if (value.equals(ruleValue)) {
                //+1
                size++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {

    }

}
