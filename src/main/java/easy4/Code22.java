package easy4;

/**
 * Created By Rock-Ayl on 2020-12-27
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class Code22 {

    public static int countSegments(String s) {
        //次数
        int size = 0;
        //当前单词
        StringBuffer word = new StringBuffer();
        //循环
        for (char c : s.toCharArray()) {
            //判断类型
            switch (c) {
                //分割符号
                case ' ':
                    //如果有单词
                    if (word.length() > 0) {
                        //叠加
                        size++;
                        //初始化单词
                        word = new StringBuffer();
                    }
                    break;
                default:
                    //组装
                    word.append(c);
                    break;
            }
        }
        //结束判定
        if (word.length() > 0) {
            //叠加
            size++;
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
