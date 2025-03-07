package normal38;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-27
 * 2353. 设计食物评分系统
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 设计一个支持下述操作的食物评分系统：
 * <p>
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 * <p>
 * 解释
 * FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // 返回 "kimchi"
 * // "kimchi" 是分数最高的韩式料理，评分为 9 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "ramen" 是分数最高的日式料理，评分为 14 。
 * foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "sushi"
 * // "sushi" 是分数最高的日式料理，评分为 16 。
 * foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "sushi" 和 "ramen" 的评分都是 16 。
 * // 但是，"ramen" 的字典序比 "sushi" 更小。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 104
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 108
 * foods 中的所有字符串 互不相同
 * 在对 changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
 * 最多调用 changeRating 和 highestRated 总计 2 * 104 次
 */
public class Code1 {

    private static class Node {

        //名字
        private String food;

        //烹饪方式
        private String cuisine;

        //评分
        private Integer rating;

        //是否生效,默认生效
        private boolean effect = true;

        //初始化实例
        public Node(String food, String cuisine, Integer rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        /**
         * 自定义比较
         *
         * @param another
         * @return
         */
        public int compareTo(Node another) {
            //如果分数不同
            if (this.rating.compareTo(another.rating) != 0) {
                //按照分数比较
                return another.rating.compareTo(this.rating);
            } else {
                //按照名称字典序
                return this.food.compareTo(another.food);
            }
        }

        /**
         * 根据新评分,克隆出新节点
         *
         * @param newRating 新评分
         * @return
         */
        public Node cloneNewNode(Integer newRating) {
            //初始化新节点并返回
            return new Node(this.food, this.cuisine, newRating);
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("food=%s,cuisine=%s,rating=%s", food, cuisine, rating);
        }

    }

    //节点缓存map
    private Map<String, Node> nodeMap = new HashMap<>();
    //不同烹饪方式的优先队列map
    private Map<String, PriorityQueue<Node>> cuisineQueueMap = new HashMap<>();

    public Code1(String[] foods, String[] cuisines, int[] ratings) {
        //循环
        for (int i = 0; i < foods.length; i++) {
            //初始化当前食物节点
            Node node = new Node(foods[i], cuisines[i], ratings[i]);
            //记录节点缓存
            this.nodeMap.put(node.food, node);
            //如果不存在该烹饪方式
            if (this.cuisineQueueMap.containsKey(node.cuisine) == false) {
                //初始化优先队列并加入
                this.cuisineQueueMap.put(node.cuisine, new PriorityQueue<>(Node::compareTo));
            }
            //将节点加入优先队列
            this.cuisineQueueMap.get(node.cuisine).add(node);
        }
    }

    /**
     * 改变已有节点分数
     *
     * @param food
     * @param newRating
     */
    public void changeRating(String food, int newRating) {
        //获取老节点
        Node oldNode = this.nodeMap.get(food);
        //克隆出新节点
        Node newNode = oldNode.cloneNewNode(newRating);
        //老节点标记失效
        oldNode.effect = false;
        //记录新节点缓存
        this.nodeMap.put(newNode.food, newNode);
        //加入对应方式下的优先队列
        this.cuisineQueueMap.get(newNode.cuisine).add(newNode);
    }

    /**
     * 当前方式最高分
     *
     * @param cuisine
     * @return
     */
    public String highestRated(String cuisine) {
        //获取对应优先队列
        PriorityQueue<Node> queue = this.cuisineQueueMap.get(cuisine);
        //如果有节点
        while (queue.isEmpty() == false) {
            //如果生效中
            if (queue.peek().effect == true) {
                //返回结果
                return queue.peek().food;
            }
            //删除失效并继续
            queue.poll();
        }
        //默认
        return null;
    }

}
