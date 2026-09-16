package normal57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 1169. 查询无效交易
 * 算术评级: 5
 * 第 151 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1659
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 如果出现下述两种情况，交易 可能无效：
 * <p>
 * 交易金额超过 $1000
 * 或者，它和 另一个城市 中 同名 的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 给定字符串数组交易清单 transaction 。每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * <p>
 * 返回 transactions，返回可能无效的交易列表。你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 * <p>
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 */
public class Code4 {

    private static class Node {

        //姓名
        private String name;
        //时间
        private int time;
        //金额
        private int amount;
        //城市
        private String city;

        //初始化
        public Node(String str) {
            //拆分
            String[] split = str.split(",");
            //组装
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }

        //调试
        @Override
        public String toString() {
            return String.format("%s,%d,%d,%s", name, time, amount, city);
        }

    }

    public List<String> invalidTransactions(String[] transactions) {
        //map
        Map<String, List<Node>> nameMap = new HashMap<>();
        //数组
        Node[] nodeArr = new Node[transactions.length];
        //循环
        for (int i = 0; i < transactions.length; i++) {
            //组装
            Node node = new Node(transactions[i]);
            //添加到数组
            nodeArr[i] = node;
            //如果不存在
            if (nameMap.containsKey(node.name) == false) {
                //添加
                nameMap.put(node.name, new java.util.ArrayList<>());
            }
            //添加到map
            nameMap.get(node.name).add(node);
        }
        //结果
        List<String> result = new ArrayList<>();
        //循环
        for (Node node : nodeArr) {
            //如果金额超过1000
            if (node.amount > 1000) {
                //添加到结果
                result.add(node.toString());
                //本轮过
                continue;
            }
            //获取同一个名称的其他加油
            List<Node> otherNodeList = nameMap.get(node.name);
            //循环
            for (Node other : otherNodeList) {
                //如果城市相同
                if (node.city.equals(other.city)) {
                    //本轮过
                    continue;
                }
                //如果时间差不超过60
                if (Math.abs(node.time - other.time) <= 60) {
                    //添加到结果
                    result.add(node.toString());
                    //跳出
                    break;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new Code4().invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing", "alice2,50,100,beijing"});
        System.out.println();
    }

}

