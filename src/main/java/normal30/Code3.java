package normal30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-03-23
 * 1138. 字母板上的路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * <p>
 * <p>
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * （注意，字母板上只存在有字母的位置。）
 * <p>
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 */
public class Code3 {

    //字母版节点
    private class Node {

        //字符
        private char letter;

        //坐标
        private int x;
        private int y;

        //初始化
        public Node(char letter, int x, int y) {
            this.letter = letter;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.letter + ":" + x + "," + y;
        }

    }

    //初始化字母版
    private Map<Character, Node> initMap() {
        //初始化板子
        Map<Character, Node> result = new HashMap<>();
        //坐标
        int x = 0;
        int y = 0;
        //循环
        for (char i = 'a'; i <= 'z'; i++) {
            //初始化
            result.put(i, new Node(i, x, y));
            //如果需要换行
            if (y == 4) {
                //换行
                x++;
                y = 0;
            } else {
                //右移
                y++;
            }
        }
        //返回
        return result;
    }

    //移动并记录结果,优先级 上 左 下 右,可以保证不会越界
    private void move(StringBuilder str, Node start, Node end) {
        //开始
        int startX = start.x;
        int startY = start.y;
        //结束
        int endX = end.x;
        int endY = end.y;
        //如果需要往上走
        while (startX > endX) {
            //走
            startX--;
            str.append('U');
        }
        //如果需要往左走
        while (startY > endY) {
            //走
            startY--;
            str.append('L');
        }
        //如果需要往下走
        while (startX < endX) {
            //走
            startX++;
            str.append('D');
        }
        //如果需要往右走
        while (startY < endY) {
            //走
            startY++;
            str.append('R');
        }
        //添加答案
        str.append('!');
    }

    public String alphabetBoardPath(String target) {
        //初始化本次字母版
        Map<Character, Node> letterMap = initMap();
        //初始化结果
        StringBuilder result = new StringBuilder();
        //第一次移动
        move(result, letterMap.get('a'), letterMap.get(target.charAt(0)));
        //循环
        for (int i = 1; i < target.length(); i++) {
            //移动
            move(result, letterMap.get(target.charAt(i - 1)), letterMap.get(target.charAt(i )));
        }
        //返回结果
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code3().alphabetBoardPath("leet"));
    }

}
