package normal7;

/**
 * @Author ayl
 * @Date 2021-09-05
 * 831. 隐藏个人信息
 * 给你一条个人信息字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码 。
 * <p>
 * 我们将隐藏它的隐私信息，通过如下规则:
 * <p>
 * <p>
 * <p>
 * 1. 电子邮箱
 * <p>
 * 定义名称 name 是长度大于等于 2 （length ≥ 2），并且只包含小写字母 a-z 和大写字母 A-Z 的字符串。
 * <p>
 * 电子邮箱地址由名称 name 开头，紧接着是符号 '@'，后面接着一个名称 name，再接着一个点号 '.'，然后是一个名称 name。
 * <p>
 * 电子邮箱地址确定为有效的，并且格式是 "name1@name2.name3"。
 * <p>
 * 为了隐藏电子邮箱，所有的名称 name 必须被转换成小写的，并且第一个名称 name 的第一个字母和最后一个字母的中间的所有字母由 5 个 '*' 代替。
 * <p>
 * <p>
 * <p>
 * 2. 电话号码
 * <p>
 * 电话号码是一串包括数字 0-9，以及 {'+', '-', '(', ')', ' '} 这几个字符的字符串。你可以假设电话号码包含 10 到 13 个数字。
 * <p>
 * 电话号码的最后 10 个数字组成本地号码，在这之前的数字组成国际号码。注意，国际号码是可选的。我们只暴露最后 4 个数字并隐藏所有其他数字。
 * <p>
 * 本地号码是有格式的，并且如 "***-***-1111" 这样显示，这里的 1 表示暴露的数字。
 * <p>
 * 为了隐藏有国际号码的电话号码，像 "+111 111 111 1111"，我们以 "+***-***-***-1111" 的格式来显示。在本地号码前面的 '+' 号和第一个 '-' 号仅当电话号码中包含国际号码时存在。例如，一个 12 位的电话号码应当以 "+**-" 开头进行显示。
 * <p>
 * 注意：像 "("，")"，" " 这样的不相干的字符以及不符合上述格式的额外的减号或者加号都应当被删除。
 * <p>
 * <p>
 * <p>
 * 最后，将提供的信息正确隐藏后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "LeetCode@LeetCode.com"
 * 输出: "l*****e@leetcode.com"
 * 解释：
 * 所有的名称转换成小写, 第一个名称的第一个字符和最后一个字符中间由 5 个星号代替。
 * 因此，"leetcode" -> "l*****e"。
 * 示例 2：
 * <p>
 * 输入: "AB@qq.com"
 * 输出: "a*****b@qq.com"
 * 解释:
 * 第一个名称"ab"的第一个字符和最后一个字符的中间必须有 5 个星号
 * 因此，"ab" -> "a*****b"。
 * 示例 3：
 * <p>
 * 输入: "1(234)567-890"
 * 输出: "***-***-7890"
 * 解释:
 * 10 个数字的电话号码，那意味着所有的数字都是本地号码。
 * 示例 4：
 * <p>
 * 输入: "86-(10)1234 5678"
 * 输出: "+**-***-***-5678"
 * 解释:
 * 12 位数字，2 个数字是国际号码另外 10 个数字是本地号码 。
 * <p>
 * <p>
 * 注意:
 * <p>
 * S.length <= 40。
 * 邮箱的长度至少是 8。
 * 电话号码的长度至少是 10。
 * 通过次数7,230提交次数17,916
 */
public class Code7 {

    public String maskPII(String s) {
        //如果是邮箱
        if (s.contains("@") && s.contains(".")) {
            //拆分
            String[] arr = s.split("@");
            //如果长度正好是2
            if (arr.length == 2) {
                //继续拆分
                String[] arr2 = arr[1].split("\\.");
                //如果长度正好还是2
                if (arr2.length == 2) {
                    //三断
                    String name1 = arr[0];
                    String name2 = arr2[0];
                    String name3 = arr2[1];
                    //隐藏后
                    String address = name1.charAt(0) + "*****" + name1.charAt(name1.length() - 1) + "@" + name2 + "." + name3;
                    //转换小写、返回
                    return address.toLowerCase();
                }
            }
        } else {
            //字符串
            StringBuffer num = new StringBuffer();
            //转化为str
            char[] arr = s.toCharArray();
            //指针
            int p = 0;
            //循环
            for (int i = arr.length - 1; i >= 0; i--) {
                //当前
                int x = arr[i] - '0';
                //如果是数字
                if (x < 10 && x > -1) {
                    //组装
                    num.append(x);
                }
                //如果非隐藏的出来了
                if (num.length() == 4) {
                    //记录分段符
                    num.append('-');
                    //记录位置
                    p = i - 1;
                    //结束
                    break;
                }
            }
            //隐藏数字的数量
            int size = 0;
            //循环2
            for (int i = p; i >= 0; i--) {
                //当前
                int x = arr[i] - '0';
                //如果是数字
                if (x < 10 && x > -1) {
                    //组装
                    num.append("*");
                    //记录
                    size++;
                    //如果满足3了
                    if (size % 3 == 0) {
                        //额外
                        num.append('-');
                    }
                }
            }
            //如果以-结尾
            if (num.charAt(num.length() - 1) == '-') {
                //减除
                num.deleteCharAt(num.length() - 1);
            }
            //如果有国际号码
            if (size > 6) {
                //组装
                num.append("+");
            }
            //翻转
            String str = num.reverse().toString();
            //返回
            return str;
        }
        //默认
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maskPII("86-(10)12345678"));
    }
}
