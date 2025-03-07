package easy37;

/**
 * @Author ayl
 * @Date 2024-06-22
 * LCP 51. 烹饪料理
 * 简单
 * 相关标签
 * 相关企业
 * 欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
 * <p>
 * 勇者背包内共有编号为 0 ~ 4 的五种食材，其中 materials[j] 表示第 j 种食材的数量。通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量，而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
 * <p>
 * 在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
 * <p>
 * 注意：
 * <p>
 * 每种料理只能制作一次。
 * 示例 1：
 * <p>
 * 输入：materials = [3,2,4,1,2] cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]] attribute = [[3,2],[2,4],[7,6]] limit = 5
 * <p>
 * 输出：7
 * <p>
 * 解释： 食材数量可以满足以下两种方案： 方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2 方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7 因此在满足饱腹感的要求下，可获得最高美味度 7
 * <p>
 * 示例 2：
 * <p>
 * 输入：materials = [10,10,10,10,10] cookbooks = [[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]] attribute = [[5,5],[6,6],[10,10]] limit = 1
 * <p>
 * 输出：11
 * <p>
 * 解释：通过制作料理 0 和 1，可满足饱腹感，并获得最高美味度 11
 * <p>
 * 提示：
 * <p>
 * materials.length == 5
 * 1 <= cookbooks.length == attribute.length <= 8
 * cookbooks[i].length == 5
 * attribute[i].length == 2
 * 0 <= materials[i], cookbooks[i][j], attribute[i][j] <= 20
 * 1 <= limit <= 100
 */
public class Code12 {

    //最大美味度
    private int maxResult = -1;

    //判断目前食材是否可以做当前料理
    private boolean canCookie(int[] cookbook, int[] materials) {
        //循环
        for (int i = 0; i < cookbook.length; i++) {
            //如果不够扣减的
            if (materials[i] - cookbook[i] < 0) {
                //不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    //制作料理
    private void cookie(int[] cookbook, int[] materials) {
        //循环
        for (int i = 0; i < cookbook.length; i++) {
            //叠加
            materials[i] -= cookbook[i];
        }
    }

    //将料理的材料装回去
    private void setCookie(int[] cookbook, int[] materials) {
        //循环
        for (int i = 0; i < cookbook.length; i++) {
            //叠加
            materials[i] += cookbook[i];
        }
    }

    /**
     * 递归
     *
     * @param p          当前要做的料理的坐标
     * @param materials  当前拥有的食材
     * @param cookbooks  料理数组
     * @param attributes 料理属性
     * @param x          当前拥有的美味度
     * @param y          当前拥有的饱腹感
     */
    private void next(int p, int[] materials, int[][] cookbooks, int[][] attributes, int limit, int x, int y) {
        //如果做不了料理了
        if (p >= cookbooks.length) {
            //过
            return;
        }
        //第一种情况,不做当前料理
        next(p + 1, materials, cookbooks, attributes, limit, x, y);
        //当前要做的料理
        int[] cookbook = cookbooks[p];
        //获取料理属性
        int[] attribute = attributes[p];
        //如果不可以做该料理
        if (canCookie(cookbook, materials) == false) {
            //过
            return;
        }
        //消耗料理
        cookie(cookbook, materials);
        //计算美味度、饱腹度
        int nextX = x + attribute[0];
        int nextY = y + attribute[1];
        //如果饱腹感满足
        if (nextY >= limit) {
            //刷新最大美味度
            this.maxResult = Math.max(this.maxResult, nextX);
        }
        //递归下一个
        next(p + 1, materials, cookbooks, attributes, limit, nextX, nextY);
        //回溯-将消耗掉的料理材料回滚
        setCookie(cookbook, materials);
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        //开始递归
        next(0, materials, cookbooks, attribute, limit, 0, 0);
        //返回结果
        return this.maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().perfectMenu(new int[]{3, 2, 4, 1, 2},
                new int[][]{
                        new int[]{1, 1, 0, 1, 2},
                        new int[]{2, 1, 4, 0, 0},
                        new int[]{3, 2, 4, 1, 0}
                },
                new int[][]{
                        new int[]{3, 2},
                        new int[]{2, 4},
                        new int[]{7, 6}
                },
                5));
    }

}
