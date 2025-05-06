package normal42;

/**
 * @Author ayl
 * @Date 2025-05-06
 * 2288. 价格减免
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
 * <p>
 * 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
 * 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * <p>
 * 返回表示修改后句子的字符串。
 * <p>
 * 注意：所有价格 最多 为 10 位数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
 * 输出："there are $0.50 $1.00 and 5$ candies in the shop"
 * 解释：
 * 表示价格的单词是 "$1" 和 "$2" 。
 * - "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
 * - "$2" 减免 50% 为 "$1" ，所以 "$2" 替换为 "$1.00" 。
 * 示例 2：
 * <p>
 * 输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
 * 输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
 * 解释：
 * 任何价格减免 100% 都会得到 0 。
 * 表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
 * 每个单词都替换为 "$0.00"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 105
 * sentence 由小写英文字母、数字、' ' 和 '$' 组成
 * sentence 不含前导和尾随空格
 * sentence 的所有单词都用单个空格分隔
 * 所有价格都是 正 整数且不含前导零
 * 所有价格 最多 为  10 位数字
 * 0 <= discount <= 100
 */
public class Code17 {

    public String discountPrices(String sentence, int discount) {
        //计算出比例
        double count = (100D - discount) / 100D;
        //初始化结果
        StringBuilder str = new StringBuilder();
        //指针
        int index = 0;
        //循环
        while (index < sentence.length()) {

            /**
             * 直接组装普通值
             */

            //如果不是可能的价格
            if (sentence.charAt(index) != '$') {
                //组装
                str.append(sentence.charAt(index++));
                //本轮过
                continue;
            }
            //如果不是开头 or 空格
            if (index > 0 && sentence.charAt(index - 1) != ' ') {
                //组装
                str.append(sentence.charAt(index++));
                //本轮过
                continue;
            }

            /**
             * 判断当前是否满足目标价格
             */

            //检查价格,并返回价格和索引
            long[] numberArr = find(sentence, index);
            //如果价格索引=-1
            if (numberArr[1] == -1L) {
                //组装
                str.append(sentence.charAt(index++));
                //本轮过
                continue;
            }

            /**
             * 组装新结果
             */

            //如果免费
            if (discount == 100) {
                //组装价格
                str.append("$0.00");
            } else {
                //组装价格
                str.append(String.format("$%.2f", numberArr[0] * count));
            }
            //变更索引
            index = (int) numberArr[1] + 1;

        }
        //返回
        return str.toString();
    }

    //判断是否为价格,并返回截取价格
    private long[] find(String sentence, int start) {
        //如果越界
        if (start + 1 >= sentence.length()) {
            //默认
            return new long[]{-1, -1};
        }
        //获取第一个数字
        long number = sentence.charAt(++start) - '0';
        //如果不是数字
        if (number < 0 || number > 9) {
            //默认
            return new long[]{-1, -1};
        }
        //如果还是数字
        while (start + 1 < sentence.length() && sentence.charAt(start + 1) - '0' >= 0 && sentence.charAt(start + 1) - '0' <= 9) {
            //叠加
            number = number * 10 + (sentence.charAt(++start) - '0');
        }
        //如果是 结束 or 空格分割
        if (start == sentence.length() - 1 || sentence.charAt(start + 1) == ' ') {
            //返回
            return new long[]{number, start};
        }
        //默认
        return new long[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(new Code17().discountPrices("$7651913186", 28));
    }

}
