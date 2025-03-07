package normal8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-09-16
 * 1222. 可以攻击国王的皇后
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * <p>
 * 「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
 * <p>
 * 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
 * <p>
 * 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 */
public class Code4 {

    //皇后缓存
    Set<String> set;
    //初始化结果,最多8个
    List<List<Integer>> result = new ArrayList<>(8);

    public void findN(int x, int y) {
        //如果未越界
        if (++y < 8) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findN(x, y);
            }
        }
    }

    public void findS(int x, int y) {
        //如果未越界
        if (--y >= 0) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findS(x, y);
            }
        }
    }

    public void findE(int x, int y) {
        //如果未越界
        if (++x < 8) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findE(x, y);
            }
        }
    }

    public void findEN(int x, int y) {
        //如果未越界
        if (++x < 8 && ++y < 8) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findEN(x, y);
            }
        }
    }

    public void findES(int x, int y) {
        //如果未越界
        if (++x < 8 && --y >= 0) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findES(x, y);
            }
        }
    }

    public void findW(int x, int y) {
        //如果未越界
        if (--x >= 0) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findW(x, y);
            }
        }
    }

    public void findWS(int x, int y) {
        //如果未越界
        if (--x >= 0 && --y >= 0) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findWS(x, y);
            }
        }
    }

    public void findWN(int x, int y) {
        //如果未越界
        if (--x >= 0 && ++y < 8) {
            //坐标
            String str = x + "," + y;
            //如果是皇后
            if (set.contains(str)) {
                //记录
                List<Integer> list = new ArrayList<>(2);
                list.add(x);
                list.add(y);
                result.add(list);
            } else {
                //下一步
                findWN(x, y);
            }
        }
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        //初始化
        set = new HashSet<>(queens.length);
        //循环
        for (int[] queen : queens) {
            //记录
            set.add(queen[0] + "," + queen[1]);
        }
        //国王坐标
        int x = king[0];
        int y = king[1];
        //发现
        findN(x, y);
        findS(x, y);
        findE(x, y);
        findW(x, y);
        findWS(x, y);
        findWN(x, y);
        findES(x, y);
        findEN(x, y);
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code4().queensAttacktheKing(new int[][]{
                new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 2},
                new int[]{3, 4}, new int[]{3, 5}, new int[]{4, 4}, new int[]{4, 5},
        }, new int[]{3, 3});
    }

}
