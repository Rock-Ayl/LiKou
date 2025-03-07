package normal38;

/**
 * @Author ayl
 * @Date 2024-12-15
 * 535. TinyURL 的加密与解密
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * <p>
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 * <p>
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= url.length <= 104
 * 题目数据保证 url 是一个有效的 URL
 */
public class Code15 {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //初始化字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < longUrl.length(); i++) {
            //字符串
            char letter = longUrl.charAt(i);
            //判断是否需要加密
            if (i > 5 && smallLetter(letter)) {
                //加密
                str.append(next(letter, 15));
            } else {
                //非加密
                str.append(letter);
            }
        }
        //返回
        return str.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //初始化字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < shortUrl.length(); i++) {
            //字符串
            char letter = shortUrl.charAt(i);
            //判断是否需要加密
            if (i > 5 && smallLetter(letter)) {
                //加密
                str.append(next(letter, -15));
            } else {
                //非加密
                str.append(letter);
            }
        }
        //返回
        return str.toString();
    }

    //加密
    private char next(char letter, int walk) {
        //转为数字、移动
        int num = letter - 'a' + walk;
        //如果越界
        if (num >= 26) {
            //移动
            num -= 26;
        }
        //如果越界
        if (num < 0) {
            //移动
            num += 26;
        }
        //返回
        return (char) (num + 'a');
    }

    //判断是否为小写字母
    private boolean smallLetter(char letter) {
        //判断
        return letter >= 'a' && letter <= 'z';
    }

    public static void main(String[] args) {
        String str = "https://leetcode.com/problems/design-tinyurl";
        String str2 = new Code15().encode(str);
        String str3 = new Code15().decode(str2);
        System.out.println(str2);
        System.out.println(str3);
    }

}
