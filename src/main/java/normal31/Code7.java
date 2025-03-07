package normal31;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-04-27
 * 2115. 从给定原材料中找到所有可以做出的菜
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
 * <p>
 * 同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
 * <p>
 * 请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
 * <p>
 * 注意两道菜在它们的原材料中可能互相包含。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
 * 输出：["bread"]
 * 解释：
 * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
 * 示例 2：
 * <p>
 * 输入：recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
 * 输出：["bread","sandwich"]
 * 解释：
 * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
 * 我们可以做出 "sandwich" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 。
 * 示例 3：
 * <p>
 * 输入：recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
 * 输出：["bread","sandwich","burger"]
 * 解释：
 * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
 * 我们可以做出 "sandwich" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 。
 * 我们可以做出 "burger" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 和 "sandwich" 。
 * 示例 4：
 * <p>
 * 输入：recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast"]
 * 输出：[]
 * 解释：
 * 我们没法做出任何菜，因为我们只有原材料 "yeast" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == recipes.length == ingredients.length
 * 1 <= n <= 100
 * 1 <= ingredients[i].length, supplies.length <= 100
 * 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
 * recipes[i], ingredients[i][j] 和 supplies[k] 只包含小写英文字母。
 * 所有 recipes 和 supplies 中的值互不相同。
 * ingredients[i] 中的字符串互不相同。
 */
public class Code7 {

    //食物节点
    private static class Food {

        //食物
        private String value;

        //该食物所需食材数量
        private int suppliesCount = 0;

        //该食物可以组合为的食物
        private List<Food> nextNodeList = new ArrayList<>();

        //初始化
        public Food(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

    }

    //目标结果
    private List<String> resultList = new ArrayList<>();

    //构建食物节点
    private void buildFood(Map<String, Food> foodMap, String food) {
        //如果存在
        if (foodMap.containsKey(food)) {
            //过
            return;
        }
        //初始化食物节点
        foodMap.put(food, new Food(food));
    }

    //递归计算每种食物是佛可以被制作
    private void next(Food food) {
        //计算食材
        if (--food.suppliesCount > 0) {
            //过
            return;
        }
        //记录该食物可以被制作
        this.resultList.add(food.value);
        //循环
        for (Food nextFood : food.nextNodeList) {
            //继续
            next(nextFood);
        }
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        /**
         * 构建食物节点
         */

        //初始化食物、材料节点
        Map<String, Food> foodMap = new HashMap<>();
        //循环
        for (String food : recipes) {
            //初始化
            buildFood(foodMap, food);
        }
        //循环1
        for (List<String> ingredient : ingredients) {
            //循环2
            for (String food : ingredient) {
                //初始化
                buildFood(foodMap, food);
            }
        }
        //循环1
        for (String food : supplies) {
            //初始化
            buildFood(foodMap, food);
        }

        /**
         * 构建食物树
         */

        for (int i = 0; i < recipes.length; i++) {
            //获取食谱节点
            Food recipeNode = foodMap.get(recipes[i]);
            //循环食材
            for (String ingredient : ingredients.get(i)) {
                //获取食材节点
                Food ingredientNode = foodMap.get(ingredient);
                //记录食材数+1
                recipeNode.suppliesCount++;
                //记录父子关系
                ingredientNode.nextNodeList.add(recipeNode);
            }
        }

        /**
         * 递归计算结果
         */

        //从默认拥有的食材开始递归
        for (String supply : supplies) {
            //获取该食材节点
            Food food = foodMap.get(supply);
            //循环
            for (Food nextFood : food.nextNodeList) {
                //开始递归
                next(nextFood);
            }
        }

        //返回结果
        return this.resultList;
    }

    public static void main(String[] args) {
        List<String> allRecipes = new Code7().findAllRecipes(
                new String[]{"bread", "sandwich", "burger"},
                Arrays.asList(
                        Arrays.asList("yeast", "flour"),
                        Arrays.asList("bread", "meat"),
                        Arrays.asList("sandwich", "meat", "bread")
                ),
                new String[]{"yeast", "flour", "meat"});
        System.out.println();
    }


}
