package normal32;

import java.util.Random;

/**
 * @Author ayl
 * @Date 2024-05-22
 * 478. 在圆内随机生成点
 * 中等
 * 相关标签
 * 相关企业
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < radius <= 108
 * -107 <= x_center, y_center <= 107
 * randPoint 最多被调用 3 * 104 次
 */
public class Code2 {

    private double radius;
    private double x_center;
    private double y_center;

    public Code2(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        //先按照正方形随机
        double x = new Random().nextDouble() * this.radius * 2;
        double y = new Random().nextDouble() * this.radius * 2;
        //优化为正负数
        x -= this.radius;
        y -= this.radius;
        //如果不是圆内
        if (x * x + y * y >= this.radius * this.radius) {
            //重新随机
            return randPoint();
        }
        //根据方向,返回结果
        return new double[]{x + this.x_center, y + this.y_center};
    }

    public static void main(String[] args) {
        Code2 code2 = new Code2(100, 10, -10);
        for (int i = 0; i < 10001111; i++) {
            print(code2, code2.randPoint());
        }
    }

    private static void print(Code2 code2, double[] randPoint) {
        randPoint[0] -= code2.x_center;
        randPoint[1] -= code2.y_center;
        double sum = (randPoint[0] * 2 + randPoint[1] * 2) / 2;
        System.out.println(randPoint[0] + "," + randPoint[1] + "=" + sum);

        if (sum >= code2.radius * 2) {
        }
    }
}
