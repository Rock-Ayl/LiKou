package normal32;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-05-28
 * 1286. 字母组合迭代器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个迭代器类 CombinationIterator ，包括以下内容：
 * <p>
 * CombinationIterator(string characters, int combinationLength) 一个构造函数，输入参数包括：用一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 true
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [["abc", 2], [], [], [], [], [], []]
 * 输出：
 * [null, "ab", true, "ac", true, "bc", false]
 * 解释：
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= combinationLength <= characters.length <= 15
 * characters 中每个字符都 不同
 * 每组测试数据最多对 next 和 hasNext 调用 104次
 * 题目保证每次调用函数 next 时都存在下一个字母组合。
 */
public class Code6 {

    //坐标
    private String characters;
    //长度
    private int combinationLength;
    //栈
    private Stack<Integer> stack;

    public Code6(String characters, int combinationLength) {
        //初始化
        this.characters = characters;
        this.combinationLength = combinationLength;
        this.stack = new Stack<>();
        //循环
        for (int i = 0; i < combinationLength; i++) {
            //默认
            this.stack.push(i);
        }
    }

    private void nextWord(int deep) {
        //获取最后一个
        Integer index = this.stack.pop();
        //如果彻底结束了
        if (this.stack.isEmpty() && index + this.combinationLength >= characters.length()) {
            //过
            return;
        }
        //如果可以直接移动
        if (index + 1 + deep < this.characters.length()) {
            //直接顺延
            this.stack.add(index + 1);
        } else {
            //计算下一个
            nextWord(deep + 1);
            //如果彻底结束
            if (this.stack.isEmpty()) {
                //过
                return;
            }
            //顺延
            this.stack.add(this.stack.peek() + 1);
        }
    }

    private String toWord() {
        //当前字符
        StringBuilder str = new StringBuilder();
        //循环
        for (Integer index : stack) {
            //获取字符并组装
            str.append(this.characters.charAt(index));
        }
        //返回
        return str.toString();
    }

    public String next() {
        //输出当前
        String word = toWord();
        //计算下一个
        nextWord(0);
        //返回
        return word;
    }

    public boolean hasNext() {
        //判定
        return this.stack.isEmpty() == false;
    }

    public static void main(String[] args) {
        Code6 code6 = new Code6("fiklnuy", 3);
        while (code6.hasNext()) {
            print(code6.stack);
            code6.next();
        }
        System.out.println();
    }

    private static void print(Stack<Integer> stack) {

        for (Integer integer : stack) {
            System.out.print(integer + ",");
        }
        System.out.println();
    }

}
