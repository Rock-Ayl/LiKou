package normal25;

/**
 * @Author ayl
 * @Date 2023-11-01
 * 面试题 03.01. 三合一
 * 提示
 * 简单
 * 73
 * 相关企业
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= stackNum <= 2
 */
public class Code15 {

    //栈数量,本题为3
    private static final int STACK_COUNT = 3;
    //栈大小
    private int stackSize;
    //缓存栈
    private int[] arr;
    //数量缓存
    private int[] countArr;
    //坐标缓存
    private int[] indexArr;

    //初始化
    public Code15(int stackSize) {
        this.stackSize = stackSize;
        this.arr = new int[stackSize * STACK_COUNT];
        this.countArr = new int[STACK_COUNT];
        this.indexArr = new int[STACK_COUNT];
    }

    public void push(int stackNum, int value) {
        //如果满了
        if (this.countArr[stackNum] == this.stackSize) {
            //过
            return;
        }
        //维护该栈的数量
        this.countArr[stackNum]++;
        //push 并且 位置+1
        this.arr[stackNum * this.stackSize + this.indexArr[stackNum]++] = value;
    }

    public int pop(int stackNum) {
        //判空
        if (isEmpty(stackNum)) {
            //过
            return -1;
        }
        //维护该栈的数量
        this.countArr[stackNum]--;
        //返回本次目标 并且 未知-1
        return this.arr[stackNum * this.stackSize + --this.indexArr[stackNum]];
    }

    public int peek(int stackNum) {
        //判空
        if (isEmpty(stackNum)) {
            //过
            return -1;
        }
        //返回本次目标
        return this.arr[stackNum * this.stackSize + this.indexArr[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        //返回对应栈是否为空
        return this.countArr[stackNum] == 0;
    }

    //1, -1, -1
    public static void main(String[] args) {
        Code15 code15 = new Code15(3);

        code15.push(0, 1);
        code15.push(0, 2);
        code15.push(0, 3);
        code15.push(1, 4);
        code15.push(1, 5);
        code15.push(1, 6);
        code15.push(2, 7);
        code15.push(2, 8);
        code15.push(2, 9);

        System.out.println(code15.peek(0));
        System.out.println(code15.pop(0));
        System.out.println(code15.peek(0));
        System.out.println(code15.pop(0));
        System.out.println(code15.peek(0));
        System.out.println(code15.pop(0));
        System.out.println(code15.peek(0));

        System.out.println();

    }

}
