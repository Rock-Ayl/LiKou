package normal24;

/**
 * @Author ayl
 * @Date 2023-10-09
 * 2424. 最长上传前缀
 * 提示
 * 中等
 * 15
 * 相关企业
 * 给你一个 n 个视频的上传序列，每个视频编号为 1 到 n 之间的 不同 数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 最长上传前缀 。
 * <p>
 * 如果 闭区间 1 到 i 之间的视频全部都已经被上传到服务器，那么我们称 i 是上传前缀。最长上传前缀指的是符合定义的 i 中的 最大值 。
 * <p>
 * 请你实现 LUPrefix 类：
 * <p>
 * LUPrefix(int n) 初始化一个 n 个视频的流对象。
 * void upload(int video) 上传 video 到服务器。
 * int longest() 返回上述定义的 最长上传前缀 的长度。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["LUPrefix", "upload", "longest", "upload", "longest", "upload", "longest"]
 * [[4], [3], [], [1], [], [2], []]
 * 输出：
 * [null, null, 0, null, 1, null, 3]
 * <p>
 * 解释：
 * LUPrefix server = new LUPrefix(4);   // 初始化 4个视频的上传流
 * server.upload(3);                    // 上传视频 3 。
 * server.longest();                    // 由于视频 1 还没有被上传，最长上传前缀是 0 。
 * server.upload(1);                    // 上传视频 1 。
 * server.longest();                    // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
 * server.upload(2);                    // 上传视频 2 。
 * server.longest();                    // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= video <= 105
 * video 中所有值 互不相同 。
 * upload 和 longest 总调用 次数至多不超过 2 * 105 次。
 * 至少会调用 longest 一次。
 */
public class Code18 {

    //视频数组
    private int[] arr;
    //当前最长前缀
    private int lastLongest;

    //初始化
    public Code18(int n) {
        //初始化数组
        this.arr = new int[n + 1];
        //默认当前最长前缀为0
        this.lastLongest = 0;
    }

    public void upload(int video) {
        //上传
        this.arr[video] = 1;
        //获取当前最长前缀索引,偏移1位
        int p = this.lastLongest + 1;
        //如果满足
        while (p < this.arr.length && this.arr[p] == 1) {
            //进位
            p++;
        }
        //覆盖最长前缀
        this.lastLongest = p - 1;
    }

    public int longest() {
        //直接返回结果
        return this.lastLongest;
    }

}
