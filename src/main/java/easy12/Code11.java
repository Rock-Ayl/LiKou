package easy12;

/**
 * @Author ayl
 * @Date 2021-10-10
 * 482. 密钥格式化
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 * <p>
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 * <p>
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * 注意，两个额外的破折号需要删掉。
 * 示例 2：
 * <p>
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 * <p>
 * <p>
 * 提示:
 * <p>
 * S 的长度可能很长，请按需分配大小。K 为正整数。
 * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 * S 非空
 */
public class Code11 {

    public String licenseKeyFormatting(String s, int k) {
        //初始化
        StringBuilder str = new StringBuilder();
        //转化为char组
        char[] arr = s.toCharArray();
        //次数
        int size = 0;
        //循环
        for (int i = arr.length - 1; i >= 0; i--) {
            //当前
            char x = arr[i];
            //如果是-
            if (x == '-') {
                //过
                continue;
            }
            //组装
            str.append(x);
            //如果到了分割的长度
            if (++size == k) {
                //切割
                str.append('-');
                //重置
                size = 0;
            }
        }
        //如果存在长度,并且最后一个是-(多余的)
        if (str.length() > 0 && str.charAt(str.length() - 1) == '-') {
            //删除
            str = str.deleteCharAt(str.length() - 1);
        }
        //转换大写并返回
        return str.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().licenseKeyFormatting("2-5g-3-J", 2));
    }
}
