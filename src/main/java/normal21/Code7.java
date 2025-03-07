package normal21;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-06-21
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * <p>
 * <p>
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的
 * <p>
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 注意：不允许重建树。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: preorder = "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: preorder = "9,#,#,1"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 104
 * preorder 由以逗号 “，” 分隔的 [0,100] 范围内的整数和 “#” 组成
 */
public class Code7 {

    //清算
    public boolean set(Stack<String> stack, String space) {
        // 是正常节点 or 尺寸太小 or 上一个不是空位
        if ("#".equals(space) == false || stack.size() < 2 || "#".equals(stack.peek()) == false) {
            //直接插入
            stack.push(space);
            //过
            return true;
        }
        //删除上一个
        stack.pop();
        //如果是节点
        if ("#".equals(stack.peek()) == false) {
            stack.pop();
            //三者替换为#
            return set(stack, "#");
        }
        //默认
        return true;
    }

    public boolean isValidSerialization(String preorder) {
        //拆分
        String[] arr = preorder.split(",");
        //栈
        Stack<String> stack = new Stack<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //插入
            set(stack, arr[i]);
        }
        //结果
        return stack.size() == 1 && "#".equals(stack.peek());
    }

    public static void main(String[] args) {
        System.out.println(new Code7().isValidSerialization("9,#,92,#,#"));
    }

}
