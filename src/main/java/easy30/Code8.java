package easy30;

/**
 * @Author ayl
 * @Date 2023-04-21
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 字符串长度在 [0, 500000] 范围内。
 */
public class Code8 {

    public String replaceSpaces(String S, int length) {
        //字符数组
        char[] arr = new char[S.length()];
        //数量
        int count = 0;
        //指针
        int p = 0;
        int q = 0;
        //如果还需要
        while (count < length) {
            //当前
            char space = S.charAt(q++);
            //如果是
            if (space == ' ') {
                //组装
                arr[p++] = '%';
                arr[p++] = '2';
                arr[p++] = '0';
            } else {
                //直接组装当前
                arr[p++] = space;
            }
            //记录
            count++;
        }
        //返回结果
        return new String(arr, 0, p);
    }

    public static void main(String[] args) {

        String result = new Code8().replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        System.out.println();
    }
}
