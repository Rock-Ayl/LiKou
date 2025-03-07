package easy20;

/**
 * @Author ayl
 * @Date 2022-06-29
 * 733. 图像渲染
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 * <p>
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 * <p>
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
 * <p>
 * 最后返回 经过上色渲染后的图像 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 示例 2:
 * <p>
 * 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出: [[2,2,2],[2,2,2]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 * 通过次数117,412提交次数201,909
 */
public class Code14 {

    //记录走过的位置,默认0,大于0视为走过
    int[][] arr;

    //上色
    public void paint(int[][] image, int target, int sr, int sc, int color) {
        //如果越界 或 如果走过了 或 如果当前不是
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || arr[sr][sc] > 0 || image[sr][sc] != target) {
            //过
            return;
        }
        //无论是不是,都记录已经走过了
        arr[sr][sc]++;
        //当前格子染色
        image[sr][sc] = color;
        //尝试往四周走
        paint(image, target, sr + 1, sc, color);
        paint(image, target, sr - 1, sc, color);
        paint(image, target, sr, sc + 1, color);
        paint(image, target, sr, sc - 1, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //初始化走过的位置
        this.arr = new int[image.length][image[0].length];
        //当前目标
        int target = image[sr][sc];
        //开始上色
        paint(image, target, sr, sc, color);
        //返回
        return image;
    }

}
