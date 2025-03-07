package normal25;

/**
 * @Author ayl
 * @Date 2023-11-08
 * 97. 交错字符串
 * 中等
 * 942
 * 相关企业
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * <p>
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 */
public class Code21 {

    //动态规划
    public boolean isInterleave(String s1, String s2, String s3) {
        //判空
        if (s1.length() + s2.length() != s3.length()) {
            //过
            return false;
        }
        //如果左边是空
        if ("".equals(s1)) {
            //发那会
            return s2.equals(s3);
        }
        //如果右边边是空
        if ("".equals(s2)) {
            //发那会
            return s1.equals(s3);
        }
        //初始化缓存
        boolean cacheArr[][] = new boolean[s1.length() + 1][s2.length() + 1];
        //默认,这里是代表从来没有
        cacheArr[0][0] = true;
        //循环所有都是s1的可能
        for (int i = 1; i < s1.length() + 1; i++) {
            //当前
            cacheArr[i][0] = cacheArr[i - 1][0] == true && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        //循环所有都是s2的可能
        for (int j = 1; j < s2.length() + 1; j++) {
            //当前
            cacheArr[0][j] = cacheArr[0][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        //循环所有都是s1的可能
        for (int i = 1; i < s1.length() + 1; i++) {
            //循环所有都是s2的可能
            for (int j = 1; j < s2.length() + 1; j++) {
                //当前目标字符
                char s3Char = s3.charAt(i + j - 1);

                boolean left = (cacheArr[i - 1][j] == true && s1.charAt(i - 1) == s3Char);
                boolean up = (cacheArr[i][j - 1] == true && s2.charAt(j - 1) == s3Char);
                //当前节点: 两种情况 从左边来 or 从 上面来 分别处理
                cacheArr[i][j] = left || up;
            }
        }
        //输出
        print(cacheArr);
        //返回
        return cacheArr[cacheArr.length - 1][cacheArr[0].length - 1];
    }

    //打印
    private void print(boolean cacheArr[][]) {
        for (boolean[] booleans : cacheArr) {
            for (boolean aBoolean : booleans) {
                System.out.print((aBoolean == true ? 1 : 0) + ",");
            }
            System.out.println();
        }
        System.out.println("##########");
    }

    public static void main(String[] args) {
        boolean interleave = new Code21().isInterleave("a", "b", "ab");
        System.out.println(interleave);
    }

}
