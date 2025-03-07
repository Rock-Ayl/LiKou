package normal;

/**
 * Created By Rock-Ayl on 2021-03-31
 * 904. 水果成篮
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * <p>
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * <p>
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * <p>
 * 用这个程序你能收集的水果树的最大总量是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 * <p>
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 示例 3：
 * <p>
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2]
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 示例 4：
 * <p>
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2]
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */
public class Code24 {

    public static int totalFruit(int[] tree) {
        //最大数量初始化
        int maxSize = 1;
        //第一个水果类型初始化
        int a = tree[0];
        //第二个水果类型(未实现)
        int b = -1;
        //实现水果b的位置
        int p = 1;
        //循环
        for (int i = p; i < tree.length; i++) {
            //首先记录p
            p = i;
            //更新水果
            maxSize++;
            //如果是第二种水果了
            if (tree[i] != a) {
                //记录b
                b = tree[i];
                //结束
                break;
            }
        }
        //如果确定b完事时已经是最后一个水果了
        if (p == tree.length - 1) {
            //包圆了
            return maxSize;
        }
        //当前水果数量(默认是最大值)
        int thisNum = maxSize;
        //循环
        for (int i = p + 1; i < tree.length; i++) {
            //当前水果类型
            int apple = tree[i];
            //如果是之前的水果
            if (apple == a || apple == b) {
                //叠加
                thisNum++;
            } else {
                //如果之前的已经是最新数量了
                if (thisNum > maxSize) {
                    //更新
                    maxSize = thisNum;
                }
                //更新 a, b
                a = tree[i - 1];
                b = tree[i];
                //新水果的基本水果数量
                thisNum = 2;
                //更之前的水果c位置
                int cp = i - 2;
                //越界
                if (cp >= 0) {
                    //更之前的水果c
                    int c = tree[cp];
                    //如果是和a一样
                    while (c == a) {
                        //叠加
                        thisNum++;
                        //递减
                        cp--;
                        //如果越界了
                        if (cp < 0) {
                            //结束
                            break;
                        }
                        //更新c
                        c = tree[cp];
                    }
                }
            }
        }
        //最后一次验证
        if (thisNum > maxSize) {
            //返回
            return thisNum;
        } else {
            //返回
            return maxSize;
        }
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 3, 3, 3}));
    }
}
