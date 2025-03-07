package normal22;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-07-31
 * 剑指 Offer II 037. 小行星碰撞
 * 中等
 * 70
 * 相关企业
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * 示例 4：
 * <p>
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * <p>
 * 注意：本题与主站 735 题相同： https://leetcode-cn.com/problems/asteroid-collision/
 */
public class Code15 {

    public int[] asteroidCollision(int[] asteroids) {
        //栈
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int asteroid : asteroids) {
            //如果不存在
            if (stack.isEmpty()) {
                //永远存在
                stack.push(asteroid);
                //本轮过
                continue;
            }
            //装箱,当前陨石
            Integer space = asteroid;
            //如果当前陨石存在
            while (space != null) {
                //如果没有了
                if (stack.isEmpty()) {
                    //直接跳出
                    break;
                }
                //偷窥到上一个
                Integer lastSpace = stack.peek();
                //如果 二者方向同时向右 or 同时向左 or 完全相反
                if ((space > 0 && lastSpace > 0) || (space < 0 && lastSpace < 0) || (lastSpace < 0 && space > 0)) {
                    //直接跳出
                    break;
                }
                //这里开始肯定碰撞了,先判断二者大小一样，再判断那边大,并做处理
                if (Math.abs(lastSpace) == Math.abs(space)) {
                    //二者均不存了
                    stack.pop();
                    space = null;
                    //直接跳出
                    break;
                } else if (Math.abs(lastSpace) > Math.abs(space)) {
                    //删除右边的
                    space = null;
                    //跳出
                    break;
                } else {
                    //删除左边的
                    stack.pop();
                    //本轮过,继续判定
                    continue;
                }
            }
            //如果此时陨石还存在
            if (space != null) {
                //那么存入栈,为以后做准备
                stack.push(space);
            }
        }
        //返回结果
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = new Code15().asteroidCollision(new int[]{10, 2, -5});
        System.out.println();
    }

}
