package normal41;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author ayl
 * @Date 2025-03-27
 * 1195. 交替打印字符串
 * 中等
 * 相关标签
 * 相关企业
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。
 */
public class Code10 {

    private int n;

    //全局锁
    private volatile ReentrantLock lock = new ReentrantLock(false);
    //条件
    private volatile Condition fizzCon = lock.newCondition();
    private volatile Condition buzzCon = lock.newCondition();
    private volatile Condition fizzbuzzCon = lock.newCondition();
    private volatile Condition numberCon = lock.newCondition();
    //当前数字
    private volatile int number = 1;

    public Code10(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (number <= n) {
            //如果状态不为1
            while (state() != 1 && state() != 5) {
                //等待
                fizzCon.await();
            }
            //如果满足
            if (number <= n) {
                //输出
                printFizz.run();
            }
            //+1
            number++;
            //根据状态唤醒
            switch (state()) {
                case 1:
                    //通知
                    fizzCon.signalAll();
                    break;
                case 2:
                    //通知
                    buzzCon.signalAll();
                    break;
                case 3:
                    //通知
                    fizzbuzzCon.signalAll();
                    break;
                case 4:
                    //通知
                    numberCon.signalAll();
                    break;
                case 5:
                    fizzCon.signalAll();
                    buzzCon.signalAll();
                    fizzbuzzCon.signalAll();
                    numberCon.signalAll();
                    break;
            }
        }
        //释放锁
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (number <= n) {
            //如果状态不为2
            while (state() != 2 && state() != 5) {
                //等待
                buzzCon.await();
            }
            //如果满足
            if (number <= n) {
                //输出
                printBuzz.run();
            }
            //+1
            number++;
            //根据状态唤醒
            switch (state()) {
                case 1:
                    //通知
                    fizzCon.signalAll();
                    break;
                case 2:
                    //通知
                    buzzCon.signalAll();
                    break;
                case 3:
                    //通知
                    fizzbuzzCon.signalAll();
                    break;
                case 4:
                    //通知
                    numberCon.signalAll();
                    break;
                case 5:
                    fizzCon.signalAll();
                    buzzCon.signalAll();
                    fizzbuzzCon.signalAll();
                    numberCon.signalAll();
                    break;
            }
        }
        //释放锁
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (number <= n) {
            //如果状态不为3
            while (state() != 3 && state() != 5) {
                //等待
                fizzbuzzCon.await();
            }
            //如果满足
            if (number <= n) {
                //输出
                printFizzBuzz.run();
            }
            //+1
            number++;
            //根据状态唤醒
            switch (state()) {
                case 1:
                    //通知
                    fizzCon.signalAll();
                    break;
                case 2:
                    //通知
                    buzzCon.signalAll();
                    break;
                case 3:
                    //通知
                    fizzbuzzCon.signalAll();
                    break;
                case 4:
                    //通知
                    numberCon.signalAll();
                    break;
                case 5:
                    fizzCon.signalAll();
                    buzzCon.signalAll();
                    fizzbuzzCon.signalAll();
                    numberCon.signalAll();
                    break;
            }
        }
        //释放锁
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        //获取锁
        lock.lock();
        //循环
        while (number <= n) {
            //如果状态不为1
            while (state() != 4 && state() != 5) {
                //等待
                numberCon.await();
            }
            //如果满足
            if (number <= n) {
                //输出
                printNumber.accept(number);
            }
            //+1
            number++;
            //根据状态唤醒
            switch (state()) {
                case 1:
                    //通知
                    fizzCon.signalAll();
                    break;
                case 2:
                    //通知
                    buzzCon.signalAll();
                    break;
                case 3:
                    //通知
                    fizzbuzzCon.signalAll();
                    break;
                case 4:
                    //通知
                    numberCon.signalAll();
                    break;
                case 5:
                    fizzCon.signalAll();
                    buzzCon.signalAll();
                    fizzbuzzCon.signalAll();
                    numberCon.signalAll();
                    break;
            }
        }
        //释放锁
        lock.unlock();
    }

    /**
     * 判断当前状态
     *
     * @return
     */
    private int state() {
        //如果过了
        if (number > n) {
            //返回
            return 5;
        }
        //判断
        if (number % 3 == 0 && number % 5 == 0) {
            //返回
            return 3;
        }
        //判断
        if (number % 3 == 0) {
            //返回
            return 1;
        }
        //判断
        if (number % 5 == 0) {
            //返回
            return 2;
        }
        //默认
        return 4;
    }

}
