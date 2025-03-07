package normal19;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-03-18
 * 519. 随机翻转矩阵
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * <p>
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "flip", "flip", "flip", "reset", "flip"]
 * [[3, 1], [], [], [], [], []]
 * 输出
 * [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]
 * <p>
 * 解释
 * Solution solution = new Solution(3, 1);
 * solution.flip();  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * solution.flip();  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
 * solution.flip();  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
 * solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
 * solution.flip();  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 104
 * 每次调用flip 时，矩阵中至少存在一个值为 0 的格子。
 * 最多调用 1000 次 flip 和 reset 方法。
 */
public class Code11 {

   /* //已经选中的内容
    private Set<String> hadSet;
    //矩阵
    private int m;
    private int n;

    public Code11(int m, int n) {
        //初始化
        this.hadSet = new HashSet<>();
        this.m = m;
        this.n = n;
    }

    //随机
    public int[] flip() {
        //随机坐标
        int thisM = new Random().nextInt(this.m);
        int thisN = new Random().nextInt(this.n);
        //唯一key
        String key = thisM + "," + thisN;
        //如果存在
        if (hadSet.contains(key)) {
            //继续走
            return flip();
        } else {
            //记录
            hadSet.add(key);
            //返回结果
            return new int[]{thisM, thisN};
        }
    }

    //重置所有
    public void reset() {
        //删除原有
        this.hadSet.clear();
    }*/

    Map<Integer, Integer> map = new HashMap<>();
    int m, n, total;
    Random rand = new Random();

    public Code11(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int x = rand.nextInt(total--);
        // 查找位置 x 对应的映射
        int idx = map.getOrDefault(x, x);
        // 将位置 x 对应的映射设置为位置 total 对应的映射
        map.put(x, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }

    public static void main(String[] args) {
        //初始化
        Code11 code11 = new Code11(3, 3);
        int[] one = code11.flip();
        int[] two = code11.flip();
        int[] three = code11.flip();
        code11.reset();
        int[] four = code11.flip();
        int[] five = code11.flip();
        int[] six = code11.flip();
        System.out.println();
    }

}
