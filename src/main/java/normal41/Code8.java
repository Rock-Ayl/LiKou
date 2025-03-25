package normal41;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ayl
 * @Date 2025-03-25
 * 1117. H2O 生成
 * 中等
 * 相关标签
 * 相关企业
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: water = "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 * <p>
 * 输入: water = "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 * n == water.length
 * 1 <= n <= 20
 * water[i] == 'O' or 'H'
 * 输入字符串 water 中的 'H' 总数将会是 2 * n 。
 * 输入字符串 water 中的 'O' 总数将会是 n 。
 */
public class Code8 {

    //锁
    private ReentrantLock lock = new ReentrantLock(false);
    //条件
    private Condition left = lock.newCondition();
    private Condition right = lock.newCondition();
    //计数
    private volatile int hInt = 0;
    private volatile int oInt = 0;

    public Code8() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        lock.lock();

        //如果满了
        while (hInt >= 2) {
            //等待
            left.await();
        }

        hInt++;

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        //如果是一组
        if (hInt >= 2 && oInt >= 1) {
            //删除
            hInt -= 2;
            oInt -= 1;
        }
        //如果可以通知
        if(oInt<1){
            //通知
            right.signal();
        }

        lock.unlock();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        lock.lock();

        //如果满了
        while (oInt >= 1) {
            //等待
            right.await();
        }

        oInt++;

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();

        //如果是一组
        if (hInt >= 2 && oInt >= 1) {
            //删除
            hInt -= 2;
            oInt -= 1;
        }
        //如果可以通知
        if (hInt < 2) {
            //通知
            left.signal();
        }

        lock.unlock();

    }

}
