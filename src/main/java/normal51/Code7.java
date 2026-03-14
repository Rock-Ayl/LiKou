package normal51;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 1268. 搜索推荐系统
 * 尝试过
 * 算术评级: 6
 * 第 164 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1573
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 * <p>
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * <p>
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 * <p>
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 * <p>
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 * <p>
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * products[i] 中所有的字符都是小写英文字母。
 * 1 <= searchWord.length <= 1000
 * searchWord 中所有字符都是小写英文字母。
 */
public class Code7 {

    private static class TrieNode {

        //子节点map
        private TrieNode[] children = new TrieNode[26];
        //本节点单词集合
        private List<String> productList = new ArrayList<>();

    }

    //初始化主节点
    private TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        /**
         * 构建节点
         */

        //循环
        for (String product : products) {
            //构建
            build(this.root, product, 0);
        }

        /**
         * 计算结果
         */

        //初始化结果
        List<List<String>> result = new ArrayList<>();
        //默认接待您
        TrieNode node = this.root;
        //循环
        for (int i = 0; i < searchWord.length(); i++) {
            //判空
            if (node == null) {
                //默认结果
                result.add(new ArrayList<>());
                //本轮过
                continue;
            }
            //计算本次key
            int key = searchWord.charAt(i) - 'a';
            //获取
            TrieNode nextNode = node.children[key];
            //判空
            if (nextNode == null) {
                //默认结果
                result.add(new ArrayList<>());
            } else {
                //记录本次结果
                result.add(nextNode.productList.stream().sorted(String::compareTo).limit(3).collect(Collectors.toList()));
            }
            //下一个节点
            node = nextNode;
        }
        //返回
        return result;
    }

    //构建
    private void build(TrieNode father, String product, int index) {
        //越界
        if (index >= product.length()) {
            //过
            return;
        }
        //key
        int key = product.charAt(index) - 'a';
        //判空
        if (father.children[key] == null) {
            //初始化
            father.children[key] = new TrieNode();
        }
        //获取节点
        TrieNode node = father.children[key];
        //记录单词
        node.productList.add(product);
        //递归
        build(node, product, index + 1);
    }

    public static void main(String[] args) {
        new Code7().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
    }

}
