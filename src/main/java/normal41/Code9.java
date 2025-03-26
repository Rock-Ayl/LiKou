package normal41;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author ayl
 * @Date 2025-03-26
 * 1116. 打印零与奇偶数
 * 中等
 * 相关标签
 * 相关企业
 * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
 * <p>
 * 例如，调用 printNumber(7) 将会输出 7 到控制台。
 * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
 * <p>
 * 线程 A：调用 zero() ，只输出 0
 * 线程 B：调用 even() ，只输出偶数
 * 线程 C：调用 odd() ，只输出奇数
 * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
 * <p>
 * 实现 ZeroEvenOdd 类：
 * <p>
 * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
 * void zero(printNumber) 调用 printNumber 以输出一个 0 。
 * void even(printNumber) 调用printNumber 以输出偶数。
 * void odd(printNumber) 调用 printNumber 以输出奇数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code9 {

    private int n;

    //锁
    private volatile ReentrantLock lock = new ReentrantLock(false);
    //初始化条件
    private volatile Condition zeroCon = lock.newCondition();
    private volatile Condition evenCon = lock.newCondition();
    private volatile Condition oddCon = lock.newCondition();
    //当前要输出的数字
    private volatile int outNumber = 1;
    //是否要输出0
    private volatile boolean outZero = true;

    public Code9(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        //获取
        lock.lock();
        //循环
        while (outNumber <= n) {
            //如果不输出0,死循环
            while (outZero == false) {
                //等待
                zeroCon.await();
            }
            //如果满足条件
            if (outNumber <= n) {
                //打印0
                printNumber.accept(0);
            }
            //不再输出0
            outZero = false;
            //判断通知
            if (outNumber % 2 == 0) {
                //通知
                evenCon.signal();
            } else {
                //通知
                oddCon.signal();
            }
        }
        //释放
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (outNumber <= n) {
            //如果输出0 or 如果是奇数,死循环
            while (outZero == true || outNumber % 2 != 0) {
                //等待
                evenCon.await();
            }
            //如果满足条件
            if (outNumber <= n) {
                //输出文字+1
                printNumber.accept(outNumber++);
            }
            //下一次先输出0
            outZero = true;
            //通知
            zeroCon.signal();
        }
        //释放锁
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (outNumber <= n) {
            //如果输出0 or 如果是偶数,死循环
            while (outZero == true || outNumber % 2 == 0) {
                //等待
                oddCon.await();
            }
            //如果满足条件
            if (outNumber <= n) {
                //输出文字+1
                printNumber.accept(outNumber++);
            }
            //下一次先输出0
            outZero = true;
            //通知
            zeroCon.signal();
        }
        //释放锁
        lock.unlock();
    }

}
