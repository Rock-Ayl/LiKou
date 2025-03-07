package easy10;

/**
 * @Author 安永亮
 * @Date 2021-07-05
 * @Description 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 */
public class Code5 {

    public int titleToNumber(String columnTitle) {
        //结果
        int sum = 0;
        //循环
        for (char c : columnTitle.toCharArray()) {
            //进位,并计算当前位
            sum = (sum * 26) + (c - '@');
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().titleToNumber("ZY"));
    }

}
