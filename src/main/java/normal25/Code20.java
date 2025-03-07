package normal25;

/**
 * @Author ayl
 * @Date 2023-11-07
 * 1041. 困于环中的机器人
 * 提示
 * 中等
 * 256
 * 相关企业
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * <p>
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：instructions = "GGLLGG"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * “L”:逆时针旋转90度。位置:(0,2).方向:西。
 * “L”:逆时针旋转90度。位置:(0,2)方向:南。
 * “G”:移动一步。位置:(0,1)方向:南。
 * “G”:移动一步。位置:(0,0)方向:南。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(0,2)——>(0,1)——>(0,0)。
 * 在此基础上，我们返回true。
 * 示例 2：
 * <p>
 * 输入：instructions = "GG"
 * 输出：false
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * 重复这些指示，继续朝北前进，不会进入循环。
 * 在此基础上，返回false。
 * 示例 3：
 * <p>
 * 输入：instructions = "GL"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “L”:逆时针旋转90度。位置:(0,1).方向:西。
 * “G”:移动一步。位置:(- 1,1)方向:西。
 * “L”:逆时针旋转90度。位置:(- 1,1)方向:南。
 * “G”:移动一步。位置:(- 1,0)方向:南。
 * “L”:逆时针旋转90度。位置:(- 1,0)方向:东方。
 * “G”:移动一步。位置:(0,0)方向:东方。
 * “L”:逆时针旋转90度。位置:(0,0)方向:北。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(- 1,1)——>(- 1,0)——>(0,0)。
 * 在此基础上，我们返回true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] 仅包含 'G', 'L', 'R'
 */
public class Code20 {

    private boolean next(int x, int y, int direction, String instructions, int p, int count) {
        //如果走了4圈了
        if (count > 3) {
            //不过关
            return false;
        }
        //如果走完了一圈
        if (p >= instructions.length()) {
            //如果走过了
            if (x == 0 && y == 0) {
                //无限循环
                return true;
            }
            //重新走一圈
            return next(x, y, direction, instructions, 0, count + 1);
        }
        //当前命令,坐标+1
        char plan = instructions.charAt(p++);
        //根据命令处理
        switch (plan) {
            //直走
            case 'G':
                //根据方向走
                switch (direction) {
                    //北
                    case 1:
                        y++;
                        break;
                    //东
                    case 2:
                        x++;
                        break;
                    //南
                    case 3:
                        y--;
                        break;
                    //西
                    case 4:
                        x--;
                        break;
                }
                break;
            //左转
            case 'L':
                //左转,如果越界,重置
                if (--direction < 1) {
                    //重置
                    direction = 4;
                }
                break;
            //右转
            case 'R':
                //右转,如果越界,重置
                if (++direction > 4) {
                    //重置
                    direction = 1;
                }
                break;
        }
        //继续走
        return next(x, y, direction, instructions, p, count);
    }

    public boolean isRobotBounded(String instructions) {
        //默认
        return next(0, 0, 1, instructions, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code20().isRobotBounded("GG"));
    }

}
