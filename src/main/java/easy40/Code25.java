package easy40;

/**
 * @Author ayl
 * @Date 2025-07-06
 * 3602. 十六进制和三十六进制转化
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 返回 n2 的 十六进制表示 和 n3 的 三十六进制表示 拼接成的字符串。
 * <p>
 * 十六进制 数定义为使用数字 0 – 9 和大写字母 A - F 表示 0 到 15 的值。
 * <p>
 * 三十六进制 数定义为使用数字 0 – 9 和大写字母 A - Z 表示 0 到 35 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * <p>
 * 输出： "A91P1"
 * <p>
 * 解释：
 * <p>
 * n2 = 13 * 13 = 169。在十六进制中，它转换为 (10 * 16) + 9 = 169，对应于 "A9"。
 * n3 = 13 * 13 * 13 = 2197。在三十六进制中，它转换为 (1 * 362) + (25 * 36) + 1 = 2197，对应于 "1P1"。
 * 连接两个结果得到 "A9" + "1P1" = "A91P1"。
 * 示例 2：
 * <p>
 * 输入：n = 36
 * <p>
 * 输出："5101000"
 * <p>
 * 解释：
 * <p>
 * n2 = 36 * 36 = 1296。在十六进制中，它转换为 (5 * 162) + (1 * 16) + 0 = 1296，对应于 "510"。
 * n3 = 36 * 36 * 36 = 46656。在三十六进制中，它转换为 (1 * 363) + (0 * 362) + (0 * 36) + 0 = 46656，对应于 "1000"。
 * 连接两个结果得到 "510" + "1000" = "5101000"。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 1000
 */
public class Code25 {

    public String concatHex36(int n) {
        //实现
        return two(n) + three(n);
    }

    //16进制
    private String two(int n) {
        //对应字符
        char[] arr = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        //平方
        long num = n * n;
        //如果只有一位
        if (num < arr.length) {
            //返回
            return Character.valueOf(arr[(int) num]).toString();
        }
        //字符串
        StringBuilder str = new StringBuilder();
        //立方
        long count = 16L;
        int size = 1;
        //如果可以升级
        while (count * 16 > 0 && count * 16 <= num) {
            //升级
            count = count * 16;
            size++;
        }
        //循环
        while (size >= 0) {
            //本次
            int index = (int) (num / count);
            //记录本次结果
            str.append(arr[index]);
            //删除
            num = num - index * count;
            //下一个
            count = count / 16;
            size--;
        }
        //返回
        return str.toString();
    }

    //36进制
    private String three(int n) {
        //对应字符
        char[] arr = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        //平方
        long num = n * n * n;
        //如果只有一位
        if (num < arr.length) {
            //返回
            return Character.valueOf(arr[(int) num]).toString();
        }
        //字符串
        StringBuilder str = new StringBuilder();
        //立方
        long count = 36;
        int size = 1;
        //如果可以升级
        while (count * 36 > 0 && count * 36 <= num) {
            //升级
            count = count * 36;
            size++;
        }
        //循环
        while (size >= 0) {
            //本次
            int index = (int) (num / count);
            //记录本次结果
            str.append(arr[index]);
            //删除
            num = num - index * count;
            //下一个
            count = count / 36;
            size--;
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code25().concatHex36(13));
    }

}
