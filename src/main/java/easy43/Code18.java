package easy43;

/**
 * 3963. 构造恰好一条路径的网格
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数 m 和 n，分别表示网格的行数和列数。
 * <p>
 * 请你构造 任意 一个只包含字符 '.' 和 '#' 的 m x n 网格，其中：
 * <p>
 * '.' 表示空单元格。
 * '#' 表示障碍物单元格。
 * 有效路径 是满足以下条件的空单元格序列：
 * <p>
 * 从左上角单元格 (0, 0) 开始。
 * 在右下角单元格 (m - 1, n - 1) 结束。
 * 只能向：
 * 右移动，从 (i, j) 到 (i, j + 1)，或者
 * 下移动，从 (i, j) 到 (i + 1, j)。
 * 返回任意一个从左上角到右下角 恰好只有一条有效路径 的网格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： m = 2, n = 3
 * <p>
 * 输出： ["..#","#.."]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 唯一的有效路径是：(0,0) → (0,1) → (1,1) → (1,2)
 * <p>
 * 示例 2：
 * <p>
 * 输入： m = 3, n = 3
 * <p>
 * 输出： ["..#","#..","##."]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 唯一的有效路径是：(0,0) → (0,1) → (1,1) → (1,2) → (2,2)
 * <p>
 * 示例 3：
 * <p>
 * 输入： m = 1, n = 4
 * <p>
 * 输出： ["...."]
 * <p>
 * 解释：
 * <p>
 * 唯一的有效路径是：(0,0) → (0,1) → (0,2) → (0,3)
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 25
 */
public class Code18 {

    public String[] createGrid(int m, int n) {
        //初始化
        String[] arr = new String[m];
        //第一行
        StringBuilder firstStr = new StringBuilder();
        //循环
        for (int i = 0; i < n; i++) {
            //组装本次
            firstStr.append('.');
        }
        //第一行
        arr[0] = firstStr.toString();
        //循环
        for (int i = 1; i < arr.length; i++) {
            //本行
            StringBuilder str = new StringBuilder();
            //循环
            for (int j = 0; j < n - 1; j++) {
                //障碍
                str.append('#');
            }
            //路径
            str.append('.');
            //本行
            arr[i] = str.toString();
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        new Code18().createGrid(2, 3);
    }

}
