package easy7;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-03-07
 * 929. 独特的电子邮件地址
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 * <p>
 * 示例：
 * <p>
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 */
public class Code11 {

    public static int numUniqueEmails(String[] emails) {
        //结果集
        Set<String> set = new HashSet<>();
        //循环
        for (String email : emails) {
            //分割
            String[] addressArr = email.split("@");
            //地址
            String address = addressArr[0];
            //解析后的地址
            StringBuffer realAddress = new StringBuffer();
            //标记
            io:
            //循环
            for (int i = 0; i < address.length(); i++) {
                //当前字符
                char x = address.charAt(i);
                //根据字符操作
                switch (x) {
                    case '.':
                        break;
                    case '+':
                        //跳出大循环
                        break io;
                    default:
                        //组装
                        realAddress.append(x);
                        break;
                }
            }
            //补全完整
            realAddress.append("@" + addressArr[1]);
            //记录
            set.add(realAddress.toString());
        }
        //返回
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
