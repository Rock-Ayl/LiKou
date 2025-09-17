package difficult4;

/**
 * @Author ayl
 * @Date 2025-09-17
 * 2296. 设计一个文本编辑器
 * 算术评级: 4
 * 第 296 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1912
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * <p>
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * <p>
 * 请你实现 TextEditor 类：
 * <p>
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
 * [[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
 * 输出：
 * [null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
 * <p>
 * 解释：
 * TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
 * textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
 * textEditor.deleteText(4); // 返回 4
 * // 当前文本为 "leet|" 。
 * // 删除了 4 个字符。
 * textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
 * textEditor.cursorRight(3); // 返回 "etpractice"
 * // 当前文本为 "leetpractice|".
 * // 光标无法移动到文本以外，所以无法移动。
 * // "etpractice" 是光标左边的 10 个字符。
 * textEditor.cursorLeft(8); // 返回 "leet"
 * // 当前文本为 "leet|practice" 。
 * // "leet" 是光标左边的 min(10, 4) = 4 个字符。
 * textEditor.deleteText(10); // 返回 4
 * // 当前文本为 "|practice" 。
 * // 只有 4 个字符被删除了。
 * textEditor.cursorLeft(2); // 返回 ""
 * // 当前文本为 "|practice" 。
 * // 光标无法移动到文本以外，所以无法移动。
 * // "" 是光标左边的 min(10, 0) = 0 个字符。
 * textEditor.cursorRight(6); // 返回 "practi"
 * // 当前文本为 "practi|ce" 。
 * // "practi" 是光标左边的 min(10, 6) = 6 个字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length, k <= 40
 * text 只含有小写英文字母。
 * 调用 addText ，deleteText ，cursorLeft 和 cursorRight 的 总 次数不超过 2 * 104 次。
 * <p>
 * <p>
 * 进阶：你能设计并实现一个每次调用时间复杂度为 O(k) 的解决方案吗？
 */
public class Code8 {

    public Code8() {
        //初始化
        this.str = new StringBuilder();
        //光标
        this.str.append('|');
    }

    //字符串
    private StringBuilder str;
    //光标索引
    private int index = 0;

    public void addText(String text) {
        //插入
        this.str.insert(this.index, text);
        //处理光标
        this.index += text.length();
    }

    public int deleteText(int k) {
        //最大允许
        k = Math.min(this.index, k);
        //如果不需要动
        if (k == 0) {
            //返回
            return k;
        }
        //删除
        this.str.delete(this.index - k, this.index);
        //处理光标
        this.index -= k;
        //返回
        return k;
    }

    public String cursorLeft(int k) {
        //最大允许
        k = Math.min(this.index, k);
        //如果不需要动
        if (k == 0) {
            //返回
            return toResultString();
        }
        //删除现有光标
        this.str.deleteCharAt(this.index);
        //移动光标
        this.index -= k;
        //插入光标
        this.str.insert(this.index, '|');
        //返回
        return toResultString();
    }

    public String cursorRight(int k) {
        //最大允许
        k = (this.index + k > this.str.length() - 1) ? this.str.length() - 1 - this.index : k;
        //如果不需要动
        if (k == 0) {
            //返回
            return toResultString();
        }
        //删除现有光标
        this.str.deleteCharAt(this.index);
        //移动光标
        this.index += k;
        //插入光标
        this.str.insert(this.index, '|');
        //返回
        return toResultString();
    }

    //返回结果
    private String toResultString() {
        //实现
        return this.str.substring(Math.max(0, this.index - 10), this.index);
    }

    public static void main(String[] args) {


        //初始化
        /*Code8 code8 = new Code8();
        code8.addText("leetcode");
        code8.deleteText(4);
        code8.addText("practice");
        System.out.println(code8.cursorRight(3));
        System.out.println(code8.cursorLeft(8));
        code8.deleteText(10);

        System.out.println(code8.cursorLeft(2));
        System.out.println(code8.cursorRight(6));
        System.out.println();*/





        /*//初始化
        Code8 code8 = new Code8();


        code8.addText("bxyackuncqzcqo");
        System.out.println(code8.cursorLeft(12));
        code8.deleteText(3);
        System.out.println(code8.cursorLeft(5));

        code8.addText("osdhyvqxf");
        System.out.println(code8.cursorRight(10));
        System.out.println();*/


        Code8 code8 = new Code8();
        System.out.println(code8.cursorLeft(14));
        code8.addText("soxqep");
        System.out.println(code8.cursorLeft(7));
        code8.addText("rfdrotsyeoy");
        System.out.println(code8.cursorRight(19));
        System.out.println();

    }

}
