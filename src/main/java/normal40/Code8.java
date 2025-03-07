package normal40;

/**
 * @Author ayl
 * @Date 2025-02-20
 * 957. N 天后的牢房
 * 中等
 * 相关标签
 * 相关企业
 * 监狱中 8 间牢房排成一排，每间牢房可能被占用或空置。
 * <p>
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行变更：
 * <p>
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * 注意：由于监狱中的牢房排成一行，所以行中的第一个和最后一个牢房不存在两个相邻的房间。
 * <p>
 * 给你一个整数数组 cells ，用于表示牢房的初始状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0 。另给你一个整数 n 。
 * <p>
 * 请你返回 n 天后监狱的状况（即，按上文描述进行 n 次变更）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cells = [0,1,0,1,1,0,0,1], n = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：下表总结了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * 示例 2：
 * <p>
 * 输入：cells = [1,0,0,1,0,0,1,0], n = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * cells.length == 8
 * cells[i] 为 0 或 1
 * 1 <= n <= 109
 */
public class Code8 {

    public int[] prisonAfterNDays(int[] cells, int n) {
        //删除循环
        n = (n % 14 == 0) ? 14 : n % 14;
        //循环
        while (n-- > 0) {
            //新数组
            int[] newCells = new int[cells.length];
            //循环
            for (int i = 0; i < cells.length; i++) {
                //变更
                newCells[i] = check(cells, i) == true ? 1 : 0;
            }
            //替换
            cells = newCells;
        }
        //返回
        return cells;
    }

    private boolean check(int[] cells, int index) {
        //如果是边界
        if (index == 0 || index + 1 == cells.length) {
            //过
            return false;
        }
        //返回
        return cells[index - 1] == cells[index + 1];
    }

    public static void main(String[] args) {
        int[] ints = new Code8().prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
        System.out.println();
    }

    private void print(int[] cells) {
        for (int cell : cells) {
            System.out.print(cell + ",");
        }
        System.out.println();
    }

}
