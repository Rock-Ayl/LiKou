package normal23;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-09-01
 * 735. 行星碰撞
 * 提示
 * 中等
 * 436
 * 相关企业
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
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
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class Code16 {

    public int[] asteroidCollision(int[] asteroids) {
        //栈
        Stack<Integer> stack = new Stack<>();
        //跳出标记,用做当前陨石粉碎后直接下一次判定
        out:
        //循环
        for (int asteroid : asteroids) {
            //如果后面有
            while (stack.isEmpty() == false) {
                //如果无法相撞
                if ((stack.peek() > 0 && asteroid > 0) || (stack.peek() < 0 && asteroid < 0) || (stack.peek() < 0 && asteroid > 0)) {
                    //跳出本次循环,等待本次陨石加入
                    break;
                }
                //如果新的更大
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    //左边被撞碎
                    stack.pop();
                    //继续判定左边
                    continue;
                }
                //如果二者相同
                if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    //左边陨石被撞碎
                    stack.pop();
                    //本轮陨石被撞碎
                    continue out;
                }
                //本轮陨石直接被撞碎
                continue out;
            }
            //到这里,新的陨石存活,加入队列等待后续判定
            stack.push(asteroid);
        }
        //返回结果
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] ints = new Code16().asteroidCollision(new int[]{8, -8});
        System.out.println();
    }

}
