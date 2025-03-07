package normal32;

/**
 * @Author ayl
 * @Date 2024-05-29
 * 2069. 模拟行走机器人 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方向为 "East" 。
 * <p>
 * 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。
 * <p>
 * 沿着当前方向尝试 往前一步 。
 * 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
 * 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。
 * <p>
 * 请你实现 Robot 类：
 * <p>
 * Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
 * void step(int num) 给机器人下达前进 num 步的指令。
 * int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
 * String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * example-1
 * <p>
 * 输入：
 * ["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
 * [[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
 * 输出：
 * [null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
 * <p>
 * 解释：
 * Robot robot = new Robot(6, 3); // 初始化网格图，机器人在 (0, 0) ，朝东。
 * robot.step(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
 * robot.step(2);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
 * robot.getPos(); // 返回 [4, 0]
 * robot.getDir(); // 返回 "East"
 * robot.step(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
 * // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
 * // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
 * robot.step(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
 * robot.step(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
 * // 然后，移动 4 步到 (1, 2) ，并朝西。
 * robot.getPos(); // 返回 [1, 2]
 * robot.getDir(); // 返回 "West"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= width, height <= 100
 * 1 <= num <= 105
 * step ，getPos 和 getDir 总共 调用次数不超过 104 次。
 */
public class Code7 {

    //初始化
    public Code7(int width, int height) {
        this.width = width;
        this.height = height;
        //计算走一圈的步数
        this.circle = (this.width + this.height - 2) * 2;
    }

    //矩阵宽高
    private int width;
    private int height;
    private int circle;

    //人物位置,默认0,0
    private int x = 0;
    private int y = 0;
    //人物当前方向,默认东
    private int dirIndex = 0;

    //方向数组[东北西南], 0是方向str的索引,1是x偏移量,2是y偏移量
    private int[][] dirArr = new int[][]{
            new int[]{0, 1, 0},
            new int[]{1, 0, 1},
            new int[]{2, -1, 0},
            new int[]{3, 0, -1}
    };
    //方向str数组[东北西南]
    private String[] dirStrArr = new String[]{"East", "North", "West", "South"};

    //判断不改变方向,是否可以走
    private boolean canWalk() {
        //获取当前方向
        int[] dir = this.dirArr[this.dirIndex];
        //计算下一个位置的坐标
        int nextX = this.x + dir[1];
        int nextY = this.y + dir[2];
        //如果越界
        if (nextX < 0 || nextY < 0 || nextX >= this.width || nextY >= this.height) {
            //不可以走
            return false;
        }
        //默认可以走
        return true;
    }

    //判断当前是否为某个角
    private boolean corner() {
        //如果是
        if (this.x == 0 && this.y == 0) {
            //是
            return true;
        }
        //如果是
        if (this.x == 0 && this.y == this.height - 1) {
            //是
            return true;
        }
        //如果是
        if (this.x == this.width - 1 && this.y == this.height - 1) {
            //是
            return true;
        }
        //如果是
        if (this.x == this.width - 1 && this.y == 0) {
            //是
            return true;
        }
        //默认不是
        return false;
    }

    //换上一个方向
    private void lastDir() {
        //-1
        if (--this.dirIndex < 0) {
            //方向索引重制
            this.dirIndex += this.dirArr.length;
        }
    }

    //换下一个方向
    private void nextDir() {
        //+1
        if (++this.dirIndex >= this.dirArr.length) {
            //方向索引重制
            this.dirIndex -= this.dirArr.length;
        }
    }

    //移动一次
    public void step() {
        //获取当前方向
        int[] dir = this.dirArr[this.dirIndex];
        //计算下一个位置的坐标
        int nextX = this.x + dir[1];
        int nextY = this.y + dir[2];
        //如果越界
        if (nextX < 0 || nextY < 0 || nextX >= this.width || nextY >= this.height) {
            //换个方向
            nextDir();
            //重新移动一次
            step();
            //过
            return;
        }
        //记录坐标
        this.x = nextX;
        this.y = nextY;
    }

    //移动n次
    public void step(int num) {
        //如果当前已经在角落了 and 同时可以走一周
        if (num >= this.circle) {
            //剔除一圈
            num = num % this.circle;
            //如果此时恰好是个角 and 如果不改变方向可以走的话
            if (corner() == true && canWalk() == true) {
                //上一个方向
                lastDir();
            }
        }
        //如果还可以走
        while (--num >= 0) {
            //走一步
            step();
        }
    }

    //返回当前人物坐标
    public int[] getPos() {
        return new int[]{this.x, this.y};
    }

    //返回方向
    public String getDir() {
        return this.dirStrArr[this.dirArr[this.dirIndex][0]];
    }

    public static void main(String[] args) {
        Code7 code7 = new Code7(97, 98);

        print(code7);
        code7.step(66392);
        print(code7);


    }

    private static void print(Code7 code7) {
        System.out.println(code7.getPos()[0] + "," + code7.getPos()[1] + "[" + code7.getDir() + "]");
    }

}
