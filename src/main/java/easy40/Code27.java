package easy40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-07-20
 * 3606. 优惠券校验器
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你三个长度为 n 的数组，分别描述 n 个优惠券的属性：code、businessLine 和 isActive。其中，第 i 个优惠券具有以下属性：
 * <p>
 * code[i]：一个 字符串，表示优惠券的标识符。
 * businessLine[i]：一个 字符串，表示优惠券所属的业务类别。
 * isActive[i]：一个 布尔值，表示优惠券是否当前有效。
 * 当以下所有条件都满足时，优惠券被认为是 有效的 ：
 * <p>
 * code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
 * businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
 * isActive[i] 为 true 。
 * 返回所有 有效优惠券的标识符 组成的数组，按照以下规则排序：
 * <p>
 * 先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。
 * 在每个类别内，再按照 标识符的字典序（升序）排序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]
 * <p>
 * 输出： ["PHARMA5","SAVE20"]
 * <p>
 * 解释：
 * <p>
 * 第一个优惠券有效。
 * 第二个优惠券的标识符为空（无效）。
 * 第三个优惠券有效。
 * 第四个优惠券的标识符包含特殊字符 @（无效）。
 * 示例 2：
 * <p>
 * 输入： code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]
 * <p>
 * 输出： ["ELECTRONICS_50"]
 * <p>
 * 解释：
 * <p>
 * 第一个优惠券无效，因为它未激活。
 * 第二个优惠券有效。
 * 第三个优惠券无效，因为其业务类别无效。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == code.length == businessLine.length == isActive.length
 * 1 <= n <= 100
 * 0 <= code[i].length, businessLine[i].length <= 100
 * code[i] 和 businessLine[i] 由可打印的 ASCII 字符组成。
 * isActive[i] 的值为 true 或 false。
 */
public class Code27 {

    private static class Node {

        //编码
        private String code;

        //标识标识
        private Integer bus;

        //初始化
        public Node(String code, Integer bus) {
            this.code = code;
            this.bus = bus;
        }

        //排序
        public int campareTo(Node another) {
            //如果不同
            if (this.bus.equals(another.bus) == false) {
                //按照分组
                return this.bus - another.bus;
            }
            //默认按照
            return this.code.compareTo(another.code);
        }

        //输出结果
        @Override
        public String toString() {
            return this.code;
        }

    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        //分组排序缓存
        Map<String, Integer> groupSortMap = new HashMap<>();
        //组装
        groupSortMap.put("electronics", 1);
        groupSortMap.put("grocery", 2);
        groupSortMap.put("pharmacy", 3);
        groupSortMap.put("restaurant", 4);
        //初始化结果
        List<Node> result = new ArrayList<>();
        //循环
        for (int i = 0; i < isActive.length; i++) {
            //如果无效
            if (isActive[i] != true) {
                //本轮过
                continue;
            }
            //如果不存在
            if (groupSortMap.containsKey(businessLine[i]) == false) {
                //本轮过
                continue;
            }
            //如果不符合目标
            if (code[i] == null || code[i].length() == 0 || code[i].matches("^[a-zA-Z0-9_]+$") == false) {
                //本轮过
                continue;
            }
            //组装结果
            result.add(new Node(code[i], groupSortMap.get(businessLine[i])));
        }
        //排序、拆箱
        return result.stream().sorted(Node::campareTo).map(Node::toString).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = new Code27().validateCoupons(
                new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"},
                new String[]{"restaurant", "grocery", "pharmacy", "restaurant"},
                new boolean[]{true, true, true, true});
        System.out.println();
    }

}
