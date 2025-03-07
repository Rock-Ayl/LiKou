package normal24;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-09-21
 * LCR 130. 衣橱整理
 * 中等
 * 672
 * 相关企业
 * 家居整理师将待整理衣橱划分为 m x n 的二维矩阵 grid，其中 grid[i][j] 代表一个需要整理的格子。整理师自 grid[0][0] 开始 逐行逐列 地整理每个格子。
 * <p>
 * 整理规则为：在整理过程中，可以选择 向右移动一格 或 向下移动一格，但不能移动到衣柜之外。同时，不需要整理 i + j > cnt 的格子。
 * <p>
 * 请返回整理师 总共需要整理多少个格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 4, n = 7, cnt = 5
 * 输出：18
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= cnt <= 20
 */
public class Code9 {

    //递归
    private void next(int[][] arr, int x, int y, int cnt) {
        //越界
        if (x >= arr.length || y >= arr[0].length) {
            //过
            return;
        }
        //如果已经走过了
        if (arr[x][y] == 1) {
            //过
            return;
        }
        //准备改变xy
        int changeX = x;
        int changeY = y;
        //和
        int sum = 0;
        //循环
        while (changeX > 0) {
            //叠加
            sum += changeX % 10;
            //下一个
            changeX = changeX / 10;
        }//循环
        while (changeY > 0) {
            //叠加
            sum += changeY % 10;
            //下一个
            changeY = changeY / 10;
        }
        //走不过去
        if (sum > cnt) {
            //过
            return;
        }
        //置位1视为可以
        arr[x][y] = 1;
        //递归
        next(arr, x + 1, y, cnt);
        next(arr, x, y + 1, cnt);
    }

    public int wardrobeFinishing(int m, int n, int cnt) {
        //初始化矩阵
        int[][] arr = new int[m][n];
        //开始递归
        next(arr, 0, 0, cnt);
        //计算结果并返回
        return Arrays
                .stream(arr)
                //子列表求和
                .map(p -> Arrays.stream(p).sum())
                //拆箱
                .mapToInt(Integer::intValue)
                //统一求0
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new Code9().wardrobeFinishing(41, 29, 16));
    }

}
