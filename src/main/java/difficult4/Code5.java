package difficult4;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-08-27
 * 1298. 你能从盒子里获得的最大糖果数
 * 算术评级: 7
 * 第 168 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1825
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
 * <p>
 * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
 * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
 * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
 * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
 * 给你一个整数数组 initialBoxes，包含你最初拥有的盒子。你可以拿走每个 已打开盒子 里的所有糖果，并且可以使用其中的钥匙去开启新的盒子，并且可以使用在其中发现的其他盒子。
 * <p>
 * 请你按照上述规则，返回可以获得糖果的 最大数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
 * 输出：16
 * 解释：
 * 一开始你有盒子 0 。你将获得它里面的 7 个糖果和盒子 1 和 2。
 * 盒子 1 目前状态是关闭的，而且你还没有对应它的钥匙。所以你将会打开盒子 2 ，并得到里面的 4 个糖果和盒子 1 的钥匙。
 * 在盒子 1 中，你会获得 5 个糖果和盒子 3 ，但是你没法获得盒子 3 的钥匙所以盒子 3 会保持关闭状态。
 * 你总共可以获得的糖果数目 = 7 + 4 + 5 = 16 个。
 * 示例 2：
 * <p>
 * 输入：status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0]
 * 输出：6
 * 解释：
 * 你一开始拥有盒子 0 。打开它你可以找到盒子 1,2,3,4,5 和它们对应的钥匙。
 * 打开这些盒子，你将获得所有盒子的糖果，所以总糖果数为 6 个。
 * 示例 3：
 * <p>
 * 输入：status = [1,1,1], candies = [100,1,100], keys = [[],[0,2],[]], containedBoxes = [[],[],[]], initialBoxes = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：status = [1], candies = [100], keys = [[]], containedBoxes = [[]], initialBoxes = []
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：status = [1,1,1], candies = [2,3,2], keys = [[],[],[]], containedBoxes = [[],[],[]], initialBoxes = [2,1,0]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= status.length <= 1000
 * status.length == candies.length == keys.length == containedBoxes.length == n
 * status[i] 要么是 0 要么是 1 。
 * 1 <= candies[i] <= 1000
 * 0 <= keys[i].length <= status.length
 * 0 <= keys[i][j] < status.length
 * keys[i] 中的值都是互不相同的。
 * 0 <= containedBoxes[i].length <= status.length
 * 0 <= containedBoxes[i][j] < status.length
 * containedBoxes[i] 中的值都是互不相同的。
 * 每个盒子最多被一个盒子包含。
 * 0 <= initialBoxes.length <= status.length
 * 0 <= initialBoxes[i] < status.length
 */
public class Code5 {

    //盒子实体
    private static class Box {

        //是否开启
        private boolean open;

        //糖果数量
        private int candy;

        //里面的钥匙
        private int[] keyArr;

        //里面的盒子
        private int[] boxArr;

        //初始化
        public Box(boolean open, int candy, int[] keyArr, int[] boxArr) {
            this.open = open;
            this.candy = candy;
            this.keyArr = keyArr;
            this.boxArr = boxArr;
        }

        //调试
        @Override
        public String toString() {
            return String.format("open=%s,candy=%s,key=%s,box=%s", this.open, this.candy, this.keyArr.length, this.boxArr.length);
        }

    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        /**
         * 构建盒子数组
         */

        //盒子数量
        int n = status.length;
        //初始化盒子数组
        Box[] boxArr = new Box[n];
        //循环
        for (int i = 0; i < n; i++) {
            //初始化盒子
            boxArr[i] = new Box(status[i] == 1, candies[i], keys[i], containedBoxes[i]);
        }

        /**
         * 递归计算
         */

        //拥有的盒子的对垒
        ArrayDeque<Box> hadBoxArrayDeque = new ArrayDeque<>();
        //循环
        for (int initialBox : initialBoxes) {
            //加入队列
            hadBoxArrayDeque.addLast(boxArr[initialBox]);
        }
        //递归并返回
        return findAndOpenBox(boxArr, hadBoxArrayDeque, new HashSet<>(), new HashSet<>());
    }

    //递归开启盒子
    private int findAndOpenBox(Box[] boxArr, ArrayDeque<Box> hadBoxArrayDeque, Set<Box> hadLockBoxSet, Set<Box> hadKeySet) {
        //糖果总数
        int candySum = 0;
        //如果还有拥有的盒子
        while (hadBoxArrayDeque.isEmpty() == false) {
            //拉取一个
            Box hadBox = hadBoxArrayDeque.pollFirst();
            //判断是否可以开启
            if (hadBox.open == true) {
                //开启
                candySum += openBox(boxArr, hadBoxArrayDeque, hadLockBoxSet, hadKeySet, hadBox);
            } else {
                //如果存在钥匙
                if (hadKeySet.contains(hadBox)) {
                    //使用钥匙
                    hadKeySet.remove(hadBox);
                    //开启
                    candySum += openBox(boxArr, hadBoxArrayDeque, hadLockBoxSet, hadKeySet, hadBox);
                } else {
                    //先加入锁定的盒子集合
                    hadLockBoxSet.add(hadBox);
                }
            }
        }
        //返回结果
        return candySum;
    }

    //开启盒子
    private int openBox(Box[] boxArr, ArrayDeque<Box> hadBoxArrayDeque, Set<Box> hadLockBoxSet, Set<Box> hadKeySet, Box hadBox) {

        //糖果总数
        int candySum = 0;

        /**
         * 结算糖果
         */

        //叠加糖果数量
        candySum += hadBox.candy;

        /**
         * 钥匙去找盒子
         */

        //循环钥匙
        for (int key : hadBox.keyArr) {
            //获取钥匙
            Box keyBox = boxArr[key];
            //如果存在对应锁住的盒子
            if (hadLockBoxSet.contains(keyBox)) {
                //使用钥匙
                hadLockBoxSet.remove(keyBox);
                hadBox.open = true;
                //开启盒子
                candySum += openBox(boxArr, hadBoxArrayDeque, hadLockBoxSet, hadKeySet, keyBox);
            } else {
                //记录拥有的钥匙
                hadKeySet.add(keyBox);
            }
        }

        /**
         * 新盒子
         */

        //循环拥有的盒子
        for (int boxIndex : hadBox.boxArr) {
            //加入队列
            hadBoxArrayDeque.addLast(boxArr[boxIndex]);
        }

        //返回
        return candySum;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().maxCandies(
                new int[]{1, 0, 1, 0},
                new int[]{7, 5, 4, 100},
                new int[][]{
                        new int[]{},
                        new int[]{},
                        new int[]{1},
                        new int[]{}
                },
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3},
                        new int[]{},
                        new int[]{}
                },
                new int[]{0}
        ));
    }

}