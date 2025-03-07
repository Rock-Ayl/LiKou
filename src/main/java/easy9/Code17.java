package easy9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-30
 * @Description 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class Code17 {

    List<Integer> list = new ArrayList();

    public void appendTail(int value) {
        list.add(0, value);
    }

    public int deleteHead() {
        if (list.size() == 0) {
            return -1;
        } else {
            int result = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return result;
        }
    }

}
