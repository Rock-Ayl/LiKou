package normal43;

/**
 * @Author ayl
 * @Date 2025-05-19
 * 1702. 修改后的最大二进制字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 * <p>
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * 示例 2：
 * <p>
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= binary.length <= 105
 * binary 仅包含 '0' 和 '1' 。
 */
public class Code4 {

    public String maximumBinaryString(String binary) {

        //组装结果
        StringBuilder str = new StringBuilder();
        //指针
        int index = 0;

        /**
         * step 1. 最开始,有连续1,则直接加入结果
         */

        //循环
        while (index < binary.length() && binary.charAt(index) == '1') {
            //+1
            index++;
            //直接组装
            str.append(1);
        }

        /**
         * step 2. 记录剩余的 1、0 数量
         */

        //缓存
        int[] arr = new int[2];
        //循环
        while (index < binary.length()) {
            //+1
            arr[binary.charAt(index++) - '0']++;
        }

        /**
         * step 3. 消耗0,这些都可以直接转为1,保留最后一个0,这个无法转换
         */

        //如果0至少有2个
        while (arr[0] > 1) {
            //-1
            arr[0]--;
            //组装1
            str.append(1);
        }
        //如果有最后一个0
        if (arr[0] == 1) {
            //组装0
            str.append(0);
        }

        /**
         * step 4. 消耗1
         */

        //如果还有1
        while (arr[1]-- > 0) {
            //组装
            str.append(1);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code4().maximumBinaryString("11"));
    }

}
