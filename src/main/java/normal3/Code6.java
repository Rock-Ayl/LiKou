package normal3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-28
 * 468. 验证IP地址
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * <p>
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * <p>
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 * <p>
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * <p>
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * <p>
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：IP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 * <p>
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 示例 3：
 * <p>
 * 输入：IP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 * 示例 4：
 * <p>
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 * 输出："Neither"
 * 示例 5：
 * <p>
 * 输入：IP = "1e1.4.5.6"
 * 输出："Neither"
 * <p>
 * <p>
 * 提示：
 * <p>
 * IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
 */
public class Code6 {

    public String validIPAddress(String IP) {
        //判断是4还是6
        if (IP.contains(".")) {
            //组
            List<String> list = new ArrayList<>();
            //字符组
            StringBuffer str = new StringBuffer();
            //.个数
            int size = 0;
            //循环
            for (int i = 0; i < IP.length(); i++) {
                //当前字符
                char thisChar = IP.charAt(i);
                //如果是分割
                if (thisChar == '.') {
                    //如果还没有新的
                    if (str.length() == 0) {
                        //不是
                        return "Neither";
                    }
                    //组装
                    list.add(str.toString());
                    //重置
                    str = new StringBuffer();
                    //记录
                    size++;
                } else {
                    //组装
                    str.append(thisChar);
                }
            }
            //如果最后有字符
            if (str.length() > 0) {
                //记录
                list.add(str.toString());
            }
            //如果个数不对
            if (size != 3) {
                //不是
                return "Neither";
            }
            //如果结构不对
            if (list.size() != 4) {
                //不是
                return "Neither";
            }
            //循环
            for (String s : list) {
                //如果首位是0并且长度大于1
                if (s.charAt(0) == '0' && s.length() > 1) {
                    //不是
                    return "Neither";
                }
                //如果有越界
                if (s.length() > 3) {
                    //不是
                    return "Neither";
                }
                //循环
                for (char c : s.toCharArray()) {
                    //转化
                    int cN = c - '0';
                    //如果越界
                    if (cN < 0 || cN > 9) {
                        //不是
                        return "Neither";
                    }
                }
                //数
                int num = Integer.parseInt(s);
                //如果越界了
                if (num > 255) {
                    //不是
                    return "Neither";
                }
            }
            //结果
            return "IPv4";
        } else if (IP.contains(":")) {
            //组
            List<String> list = new ArrayList<>();
            //字符组
            StringBuffer str = new StringBuffer();
            //:个数
            int size = 0;
            //循环
            for (int i = 0; i < IP.length(); i++) {
                //当前字符
                char thisChar = IP.charAt(i);
                //如果是分割
                if (thisChar == ':') {
                    //如果还没有新的
                    if (str.length() == 0) {
                        //不是
                        return "Neither";
                    }
                    //组装
                    list.add(str.toString());
                    //重置
                    str = new StringBuffer();
                    //记录
                    size++;
                } else {
                    //组装
                    str.append(thisChar);
                }
            }
            //如果最后有字符
            if (str.length() > 0) {
                //记录
                list.add(str.toString());
            }
            //如果符号数量不符
            if (size != 7) {
                //不是
                return "Neither";
            }
            //如果结构不对
            if (list.size() != 8) {
                //不是
                return "Neither";
            }
            //循环
            for (String s : list) {
                //如果过长
                if (s.length() > 4) {
                    //不是
                    return "Neither";
                }
                //循环
                for (char c : s.toCharArray()) {
                    //如果不是a-f
                    if (c < 97 || c > 102) {
                        //如果不是a-f
                        if (c < 65 || c > 70) {
                            //如果不是0-9
                            if (c < 48 || c > 57) {
                                //不是
                                return "Neither";
                            }
                        }
                    }
                }
            }
            //结果
            return "IPv6";
        } else {
            //不是
            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code6().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
