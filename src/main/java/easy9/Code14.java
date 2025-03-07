package easy9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 安永亮
 * @Date 2021-06-26
 * @Description 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 *  
 * <p>
 * 提示：
 * <p>
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 */
public class Code14 {

    //填充过的缓存
    Set<String> set = new HashSet<>();
    int[][] image;
    int color;
    int newColor;

    public void update(int sr, int sc) {
        //如果未越界
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length) {
            //str
            String str = sr + "," + sc;
            //如果不是墙壁,同时符合条件
            if (!set.contains(str) && image[sr][sc] == color) {
                //填充颜色
                image[sr][sc] = newColor;
                //记录已填充过
                set.add(str);
                //上下左右
                update(sr + 1, sc);
                update(sr, sc + 1);
                update(sr - 1, sc);
                update(sr, sc - 1);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //全局
        this.image = image;
        this.color = this.image[sr][sc];
        this.newColor = newColor;
        //改变颜色
        update(sr, sc);
        //返回结果
        return this.image;
    }

    public static void main(String[] args) {
        int[][] arr = new Code14().floodFill(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 0, 1}
        }, 1, 1, 2);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }
}
