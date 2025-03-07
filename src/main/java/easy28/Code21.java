package easy28;

/**
 * @Author ayl
 * @Date 2023-03-07
 * 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * <p>
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= columnNumber <= 231 - 1
 */
public class Code21 {

    public String convertToTitle(int columnNumber) {
        //结果
        StringBuilder str = new StringBuilder();
        //如果还有数字
        while (columnNumber > 0) {
            //计算当前余数
            int thisNum = columnNumber % 26;
            //如果是0
            if (thisNum == 0) {
                //视为Z
                thisNum = 26;
            }
            //转化为字母并组装
            str.append((char) (64 + thisNum));
            //准备下一个数字
            columnNumber = (columnNumber - thisNum) / 26;
        }
        //反转并返回结果
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code21().convertToTitle(52));
    }

}
