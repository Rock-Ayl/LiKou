package normal31;

/**
 * @Author ayl
 * @Date 2024-05-05
 * LCP 03. 机器人大冒险
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 * <p>
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * <p>
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 * 示例 2：
 * <p>
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 * 示例 3：
 * <p>
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 */
public class Code10 {

    //根据指令,收集单词经过坐标
    private int[][] collectWalked(String command) {
        //初始化
        int[][] arr = new int[command.length()][2];
        //指针
        int x = 0;
        int y = 0;
        //循环
        for (int i = 0; i < command.length(); i++) {
            //当前字符
            char letter = command.charAt(i);
            //按照指令移动
            if (letter == 'U') {
                //+1
                ++y;
            } else {
                //+1
                ++x;
            }
            //记录本次落脚点
            arr[i] = new int[]{x, y};
        }
        //返回
        return arr;
    }

    //计算是否可以移动到这里,如果可以,返回轮次以及步数索引,不可以为-1
    private int[] move(int[][] collectWalked, int x, int y, int moveX, int moveY) {
        //循环
        for (int i = 0; i < collectWalked.length; i++) {
            //当前
            int[] waled = collectWalked[i];
            //当前坐标
            int thisX = waled[0];
            int thisY = waled[1];
            //删除二者之间固定值
            int left = x - thisX;
            int right = y - thisY;
            //如果无法正确移动对应比例
            if (left % moveX != 0 || right % moveY != 0) {
                //本轮过
                continue;
            }
            //如果移动比例相同,是为可以移动到目标节点
            if (left / moveX == right / moveY) {
                //返回轮次,具体位置
                return new int[]{left / moveX, i};
            }
        }
        //默认不可以
        return new int[]{-1, -1};
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        //step 1.收集一次移动的坐标
        int[][] collectWalked = collectWalked(command);
        //step 2.计算一次偏移的坐标
        int moveX = collectWalked[collectWalked.length - 1][0];
        int moveY = collectWalked[collectWalked.length - 1][1];
        //step 3.计算到达目标节点轮次
        int[] moveCountArr = move(collectWalked, x, y, moveX, moveY);
        //如果-1,是为没有可能到达
        if (moveCountArr[0] == -1) {
            //结束
            return false;
        }
        //step 4.循环、计算是否可以移动到阻碍点,如果可以,优先失败
        for (int[] obstacle : obstacles) {
            //计算轮次
            int[] obCountArr = move(collectWalked, obstacle[0], obstacle[1], moveX, moveY);
            //如果到不了该节点
            if (obCountArr[0] == -1) {
                //直接跳过
                continue;
            }
            //如果阻碍轮次,在目标节点轮次之前
            if (obCountArr[0] < moveCountArr[0]) {
                //肯定不可以
                return false;
            }
            //如果轮次相同,阻碍步数在目标节点之前
            if (obCountArr[0] == moveCountArr[0] && obCountArr[1] <= moveCountArr[1]) {
                //肯定不可以
                return false;
            }
        }
        //最终,是为可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().robot("URR", new int[][]{new int[]{4, 2}}, 3, 2));
    }

}
