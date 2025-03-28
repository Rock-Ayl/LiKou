package easy40;

/**
 * @Author ayl
 * @Date 2025-03-28
 * 405. 数字转换为十六进制数
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
 * <p>
 * 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 26
 * 输出："1a"
 * 示例 2：
 * <p>
 * 输入：num = -1
 * 输出："ffffffff"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= num <= 231 - 1
 */
public class Code10 {

    /**
     * 10=a
     * 11=b
     * 12=c
     * 13=d
     * 14=e
     * 15=f
     */
    public String toHex(int num) {
        //大于0
        if (num >= 0) {
            //正数实现
            return right(num);
        }
        //小于0
        else {
            //复数实现
            return left(num);
        }
    }

    //正数实现
    private String right(int num) {
        //对应字符
        char[] arr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        //数字长度
        int index = 0;
        //长度
        int lengthNum = 1;
        //如果长度继续
        while (lengthNum * 16 <= num && lengthNum * 16 > 0) {
            //进位
            lengthNum = lengthNum * 16;
            //+1
            index++;
        }
        //字符串
        StringBuilder str = new StringBuilder();
        //循环正序
        while (index >= 0) {
            //计算位置
            int count = num / lengthNum;
            //组装本次
            str.append(arr[count]);
            //下一个
            index--;
            num -= lengthNum * count;
            lengthNum = lengthNum / 16;
        }
        //返回
        return str.toString();
    }

    //负数实现
    private String left(int num) {
        //转换,取反+1
        long longNum = Math.abs((num + 1));
        //对应字符
        char[] arr = new char[]{'f', 'e', 'd', 'c', 'b', 'a', '9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
        //数字长度
        int index = 7;
        //长度
        long lengthNum = (16L * 16L * 16L * 16L * 16L * 16L * 16L);
        //字符串
        StringBuilder str = new StringBuilder();
        //循环倒序
        while (index >= 0) {
            //计算位置
            int count = (int) (longNum / lengthNum);
            //组装本次
            str.append(arr[count]);
            //下一个
            index--;
            longNum -= lengthNum * count;
            lengthNum = lengthNum / 16;
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < 500; i++) {
            System.out.println(Integer.toHexString(-i));
        }*/
        System.out.println(new Code10().toHex(-100000));
    }

}
