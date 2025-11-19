package normal48;

/**
 * @Author ayl
 * @Date 2025-11-19
 * 3484. 设计电子表格
 * 算术评级: 4
 * 第 152 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1524
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 电子表格是一个网格，它有 26 列（从 'A' 到 'Z'）和指定数量的 rows。每个单元格可以存储一个 0 到 105 之间的整数值。
 * <p>
 * 请你实现一个 Spreadsheet 类：
 * <p>
 * Spreadsheet(int rows) 初始化一个具有 26 列（从 'A' 到 'Z'）和指定行数的电子表格。所有单元格最初的值都为 0 。
 * void setCell(String cell, int value) 设置指定单元格的值。单元格引用以 "AX" 的格式提供（例如，"A1"，"B10"），其中字母表示列（从 'A' 到 'Z'），数字表示从 1 开始的行号。
 * void resetCell(String cell) 重置指定单元格的值为 0 。
 * int getValue(String formula) 计算一个公式的值，格式为 "=X+Y"，其中 X 和 Y 要么 是单元格引用，要么非负整数，返回计算的和。
 * 注意： 如果 getValue 引用一个未通过 setCell 明确设置的单元格，则该单元格的值默认为 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
 * [[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]
 * <p>
 * 输出：
 * [null, 12, null, 16, null, 25, null, 15]
 * <p>
 * 解释
 * <p>
 * Spreadsheet spreadsheet = new Spreadsheet(3); // 初始化一个具有 3 行和 26 列的电子表格
 * spreadsheet.getValue("=5+7"); // 返回 12 (5+7)
 * spreadsheet.setCell("A1", 10); // 设置 A1 为 10
 * spreadsheet.getValue("=A1+6"); // 返回 16 (10+6)
 * spreadsheet.setCell("B2", 15); // 设置 B2 为 15
 * spreadsheet.getValue("=A1+B2"); // 返回 25 (10+15)
 * spreadsheet.resetCell("A1"); // 重置 A1 为 0
 * spreadsheet.getValue("=A1+B2"); // 返回 15 (0+15)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rows <= 103
 * 0 <= value <= 105
 * 公式保证采用 "=X+Y" 格式，其中 X 和 Y 要么是有效的单元格引用，要么是小于等于 105 的 非负 整数。
 * 每个单元格引用由一个大写字母 'A' 到 'Z' 和一个介于 1 和 rows 之间的行号组成。
 * 总共 最多会对 setCell、resetCell 和 getValue 调用 104 次。
 */
public class Code3 {

    //缓存
    private int[][] arr;

    public Code3(int rows) {
        //初始化
        this.arr = new int[26][rows + 1];
    }

    public void setCell(String cell, int value) {
        //覆盖
        this.arr[cell.charAt(0) - 'A'][Integer.valueOf(cell.substring(1))] = value;
    }

    public void resetCell(String cell) {
        //覆盖
        this.arr[cell.charAt(0) - 'A'][Integer.valueOf(cell.substring(1))] = 0;
    }

    public int getValue(String formula) {
        //拆分
        String[] split = formula.substring(1).split("\\+");
        //计算并返回
        return get(split[0]) + get(split[1]);
    }

    //获取数字 or 字符
    private int get(String word) {
        //获取数字
        char c = word.charAt(0);
        //如果是单元格
        if (c >= 'A' && c <= 'Z') {
            //获取,默认0
            return this.arr[word.charAt(0) - 'A'][Integer.valueOf(word.substring(1))];
        } else {
            //返回数字
            return Integer.valueOf(word);
        }
    }

}
