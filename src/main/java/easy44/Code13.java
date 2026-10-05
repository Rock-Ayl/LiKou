package easy44;

/**
 * 2201. 统计可以提取的工件
 * 算术评级: 3
 * 第 284 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1525
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，其中 artifacts[i] = [r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
 * <p>
 * (r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
 * (r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
 * 你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
 * <p>
 * 生成的测试用例满足：
 * <p>
 * 不存在重叠的两个工件。
 * 每个工件最多只覆盖 4 个单元格。
 * dig 中的元素互不相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1]]
 * 输出：1
 * 解释：
 * 不同颜色表示不同的工件。挖掘的单元格用 'D' 在网格中进行标记。
 * 有 1 个工件可以提取，即红色工件。
 * 蓝色工件在单元格 (1,1) 的部分尚未裸露出来，所以无法提取该工件。
 * 因此，返回 1 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1],[1,1]]
 * 输出：2
 * 解释：红色工件和蓝色工件的所有部分都裸露出来（用 'D' 标记），都可以提取。因此，返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 1 <= artifacts.length, dig.length <= min(n2, 105)
 * artifacts[i].length == 4
 * dig[i].length == 2
 * 0 <= r1i, c1i, r2i, c2i, ri, ci <= n - 1
 * r1i <= r2i
 * c1i <= c2i
 * 不存在重叠的两个工件
 * 每个工件 最多 只覆盖 4 个单元格
 * dig 中的元素互不相同
 */
public class Code13 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        //结果
        int count = 0;
        //矩阵
        int[][] nArr = new int[n][n];
        //工件分组计数器
        int[] groupArr = new int[artifacts.length + 1];
        //循环
        for (int i = 0; i < artifacts.length; i++) {
            //工件分组
            int group = i + 1;
            //工件坐标
            int[] artifact = artifacts[i];
            //拆解
            int startX = artifact[0];
            int startY = artifact[1];
            int endX = artifact[2];
            int endY = artifact[3];
            //循环1
            for (int j = startX; j <= endX; j++) {
                //循环2
                for (int k = startY; k <= endY; k++) {
                    //覆盖
                    nArr[j][k] = group;
                    //+1
                    groupArr[group]++;
                }
            }
        }
        //循环所有填充
        for (int[] ints : dig) {
            //挖掘坐标
            int ri = ints[0];
            int ci = ints[1];
            //挖掘单元格
            int group = nArr[ri][ci];
            //如果是没有内容
            if (group == 0) {
                //本轮过
                continue;
            }
            //挖取,如果最后一个
            if (--groupArr[group] == 0) {
                //结果+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().digArtifacts(2, new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}}, new int[][]{{0, 0}, {0, 1}}));
    }

}
