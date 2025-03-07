package normal34;

/**
 * @Author ayl
 * @Date 2024-08-09
 * 223. 矩形面积
 * 中等
 * 相关标签
 * 相关企业
 * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * <p>
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * <p>
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * Rectangle Area
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 * <p>
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 */
public class Code4 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //初始化两个矩形面积
        int aArea = (ax2 - ax1) * (ay2 - ay1);
        int bArea = (bx2 - bx1) * (by2 - by1);
        //共有矩形宽高
        int midX = 0;
        int midY = 0;
        //如果需要计算相交面积,即两个矩形都存在面积时
        if (aArea > 0 && bArea > 0) {
            //如果宽相交1
            if (ax1 <= bx1 && bx1 <= ax2) {
                //如果完全包住
                if (ax1 <= bx2 && bx2 <= ax2) {
                    //共有宽
                    midX = bx2 - bx1;
                } else {
                    //共有宽
                    midX = ax2 - bx1;
                }
            }
            //如果宽相交2
            if (bx1 <= ax1 && ax1 <= bx2) {
                //如果完全包住
                if (bx1 <= ax2 && ax2 <= bx2) {
                    //共有宽
                    midX = ax2 - ax1;
                } else {
                    //共有宽
                    midX = bx2 - ax1;
                }
            }
            //如果高度相交1
            if (ay1 <= by1 && by1 <= ay2) {
                //如果完全包住
                if (ay1 <= by2 && by2 <= ay2) {
                    //共有高
                    midY = by2 - by1;
                } else {
                    //共有高
                    midY = ay2 - by1;
                }
            }
            //如果高度相交2
            if (by1 <= ay1 && ay1 <= by2) {
                //如果完全包住
                if (by1 <= ay2 && ay2 <= by2) {
                    //共有高
                    midY = ay2 - ay1;
                } else {
                    //共有高
                    midY = by2 - ay1;
                }
            }
        }
        //计算共有面积
        int midAre = midX * midY;
        //最终结果
        return aArea + bArea - midAre;
    }

    public static void main(String[] args) {
        //System.out.println(new Code4().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        //System.out.println(new Code4().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        //System.out.println(new Code4().computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        System.out.println(new Code4().computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }

}
