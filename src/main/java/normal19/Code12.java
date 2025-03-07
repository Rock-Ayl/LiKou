package normal19;

import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-03-21
 * 497. 非重叠矩形中的随机点
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * <p>
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 * <p>
 * 请注意 ，整数点是具有整数坐标的点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["Solution", "pick", "pick", "pick", "pick", "pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]], [], [], [], [], []]
 * 输出:
 * [null, [1, -2], [1, -1], [-1, -2], [-2, -2], [0, 0]]
 * <p>
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -109 <= ai < xi <= 109
 * -109 <= bi < yi <= 109
 * xi - ai <= 2000
 * yi - bi <= 2000
 * 所有的矩形不重叠。
 * pick 最多被调用 104 次。
 */
public class Code12 {

    //缓存
    private int[][] rects;
    //矩形面积缓存
    private int[] lengthArr;
    //总点数
    private int allCount;

    public Code12(int[][] rects) {
        //记录
        this.rects = rects;
        //重置总点数
        this.allCount = 0;
        //初始化面积
        this.lengthArr = new int[this.rects.length];
        //循环
        for (int i = 0; i < this.rects.length; i++) {
            //本次
            int[] rect = this.rects[i];
            //矩形点数(长度为3,点数其实为4,所以+1)
            int xLength = rect[2] - rect[0] + 1;
            int yLength = rect[3] - rect[1] + 1;
            //该矩形点数
            int count = xLength * yLength;
            //叠加总点数
            this.allCount += count;
            //记录该矩形面积
            this.lengthArr[i] = count;
        }
    }

    //随机选择一个矩形
    public int[] pickRect() {
        //根据总点数,随机一个点数
        int num = new Random().nextInt(this.allCount);
        //循环
        for (int i = 0; i < rects.length; i++) {
            //计算本次点数
            num -= this.lengthArr[i];
            //如果本次覆盖到了随机的点数,视为随机到该矩形
            if (num < 0) {
                //视为选中
                return this.rects[i];
            }
        }
        //默认(不可能的)
        return null;
    }

    //随机选择点
    public int[] pick() {
        //先随机选择一个矩形
        int[] rect = pickRect();
        //随机横纵坐标任意一个点(随机时要+1,原因同上)
        int xP = new Random().nextInt(rect[2] - rect[0] + 1);
        int yP = new Random().nextInt(rect[3] - rect[1] + 1);
        //返回本次结果
        return new int[]{rect[0] + xP, rect[1] + yP};
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12(new int[][]{
                new int[]{-2, -2, 1, 1},
                new int[]{2, 2, 4, 6}
        });
        System.out.println(code12.pick());
        System.out.println(code12.pick().toString());
        System.out.println(code12.pick().toString());
        System.out.println(code12.pick().toString());
        System.out.println(code12.pick().toString());
    }

}
