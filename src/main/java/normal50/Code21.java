package normal50;

import java.util.ArrayList;
import java.util.List;

/**
 * 1146. 快照数组
 * 算术评级: 7
 * 第 148 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1771
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 * <p>
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= length <= 50000
 * 题目最多进行50000 次set，snap，和 get的调用 。
 * 0 <= index < length
 * 0 <= snap_id < 我们调用 snap() 的总次数
 * 0 <= val <= 10^9
 */
public class Code21 {

    public Code21(int length) {
        this.indexNodeArr = new List[length];
    }

    private static class Node {

        //快照号
        private int snap_id;

        //值
        private int value;

        //初始化
        public Node(int snap_id, int value) {
            this.snap_id = snap_id;
            this.value = value;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "snap_id=" + snap_id +
                    ", value=" + value +
                    '}';
        }

    }

    //数组
    private List<Node>[] indexNodeArr;
    //快照号计数器
    private int snapCount = 0;

    public void set(int index, int val) {
        //初始化节点
        Node node = new Node(this.snapCount, val);
        //判空
        if (this.indexNodeArr[index] == null) {
            //初始化
            this.indexNodeArr[index] = new ArrayList<>();
        }
        //获取节点节点列表
        List<Node> nodeList = this.indexNodeArr[index];
        //如果上一个存在 and 快照相同
        if (nodeList.isEmpty() == false && nodeList.get(nodeList.size() - 1).snap_id == node.snap_id) {
            //覆盖
            nodeList.set(nodeList.size() - 1, node);
        } else {
            //新加
            nodeList.add(node);
        }
    }

    public int snap() {
        //获取并++
        return this.snapCount++;
    }

    public int get(int index, int snap_id) {
        //获取节点节点列表
        List<Node> nodeList = this.indexNodeArr[index];
        //判空
        if (nodeList == null) {
            //过
            return 0;
        }
        //判空
        if (nodeList.isEmpty()) {
            //过
            return 0;
        }
        //二分法实现
        return find(nodeList, snap_id, 0, nodeList.size() - 1);
    }

    //二分法实现
    private int find(List<Node> nodeList, int snap_id, int left, int right) {
        //索引
        int ansIndex = -1;
        //循环
        while (left <= right) {
            //获取中间
            int mid = left + (right - left) / 2;
            //如果找
            if (nodeList.get(mid).snap_id <= snap_id) {
                //记录最近命中
                ansIndex = mid;
                //向右
                left = mid + 1;
            } else {
                //向左
                right = mid - 1;
            }
        }
        //判空
        if (ansIndex == -1) {
            //过
            return 0;
        }
        //返回
        return nodeList.get(ansIndex).value;
    }

    public static void main(String[] args) {

        Code21 snapshotArr = new Code21(3);

        System.out.println("set(1,18)");
        snapshotArr.set(1, 18);

        System.out.println("set(1,4)");
        snapshotArr.set(1, 4);

        System.out.println("snap() -> " + snapshotArr.snap());

        System.out.println("get(0,0) -> " + snapshotArr.get(0, 0));

        System.out.println("set(0,20)");
        snapshotArr.set(0, 20);

        System.out.println("snap() -> " + snapshotArr.snap());

        System.out.println("set(0,2)");
        snapshotArr.set(0, 2);

        System.out.println("set(1,1)");
        snapshotArr.set(1, 1);

        System.out.println("get(1,1) -> " + snapshotArr.get(1, 1));

        System.out.println("get(1,0) -> " + snapshotArr.get(1, 0));
    }

}
