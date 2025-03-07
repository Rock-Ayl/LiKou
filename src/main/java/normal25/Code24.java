package normal25;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-11-13
 * LCR 107. 01 矩阵
 * 中等
 * 60
 * 相关企业
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0
 * <p>
 * <p>
 * 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/
 */
public class Code24 {

    public int[][] updateMatrix(int[][] mat) {
        //目标次数
        int targetCount = mat.length * mat[0].length;
        //初始化结果
        int[][] result = new int[mat.length][mat[0].length];
        //当前列表
        Set<String> thisSet = new HashSet<>();
        //已经计算过的列表
        Set<String> allSet = new HashSet<>();
        //循环1
        for (int i = 0; i < mat.length; i++) {
            //循环2
            for (int j = 0; j < mat[0].length; j++) {
                //如果是0
                if (mat[i][j] == 0) {
                    //组装key
                    String key = setKey(i, j);
                    //收集0的key和结果
                    thisSet.add(key);
                    allSet.add(key);
                }
            }
        }
        //距离
        int link = 1;
        //如果还有点没处理过
        while (allSet.size() < targetCount) {
            //下一个集合
            Set<String> nextSet = new HashSet<>();
            //循环
            for (String key : thisSet) {
                //拆分
                String[] arr = key.split(",");
                //拆分为坐标
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[1]);
                //如果未越界
                if (x > 0) {
                    //下一步
                    nextSet.add(setKey(x - 1, y));
                }
                //如果未越界
                if (y > 0) {
                    //下一步
                    nextSet.add(setKey(x, y - 1));
                }
                //如果未越界
                if (x < mat.length - 1) {
                    //下一步
                    nextSet.add(setKey(x + 1, y));
                }
                //如果未越界
                if (y < mat[0].length - 1) {
                    //下一步
                    nextSet.add(setKey(x, y + 1));
                }
            }
            //删除所有已走过的
            nextSet.removeAll(allSet);
            //如果没有了
            if (nextSet.isEmpty()) {
                //跳出
                break;
            }
            //循环
            for (String key : nextSet) {
                //拆分
                String[] arr = key.split(",");
                //拆分为坐标
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[1]);
                //记录本次结果
                result[x][y] = link;
            }
            //记录结果
            allSet.addAll(nextSet);
            //下一组
            thisSet = nextSet;
            link++;
        }
        //返回
        return result;
    }

    //坐标转化为key
    private String setKey(int x, int y) {
        //实现
        return x + "," + y;
    }

    public static void main(String[] args) {
        int[][] ints = new Code24().updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{1, 1, 1}
        });
        System.out.println();
    }

}
