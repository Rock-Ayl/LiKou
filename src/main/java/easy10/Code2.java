package easy10;

/**
 * @Author 安永亮
 * @Date 2021-07-02
 * @Description 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 * <p>
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class Code2 {

    public int[][] flipAndInvertImage(int[][] image) {
        //循环
        for (int i = 0; i < image.length; i++) {
            //新的
            int[] newInts = new int[image[i].length];
            //指针
            int p = newInts.length - 1;
            //循环
            for (int j = 0; j < image[i].length; j++) {
                //翻转并组装
                newInts[p--] = image[i][j] == 0 ? 1 : 0;
            }
            //给与
            image[i] = newInts;
        }
        //返回结果
        return image;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().flipAndInvertImage(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
        }));
    }

}
