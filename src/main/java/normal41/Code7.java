package normal41;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ayl
 * @Date 2025-03-24
 * 1115. 交替打印 FooBar
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 * <p>
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code7 {

    //锁
    private ReentrantLock lock = new ReentrantLock();
    //左条件
    private Condition left = lock.newCondition();
    //有条件
    private Condition right = lock.newCondition();
    //计数器
    private volatile int count = 0;

    private int n;

    public Code7(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //锁
            lock.lock();
            //如果不是foo回合
            if (count == 1) {
                //等待
                left.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            //修改
            count = 1;
            //通知
            right.signal();
            //释放锁
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //锁
            lock.lock();
            //如果不是bar回合
            if (count == 0) {
                //等待
                right.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            //修改
            count = 0;
            //通知
            left.signal();
            //释放锁
            lock.unlock();
        }
    }

}
