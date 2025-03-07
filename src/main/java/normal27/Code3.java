package normal27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-12-15
 * 1993. 树上的操作
 * 提示
 * 中等
 * 79
 * 相关企业
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 * <p>
 * 数据结构需要支持如下函数：
 * <p>
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * 请你实现 LockingTree 类：
 * <p>
 * LockingTree(int[] parent) 用父节点数组初始化数据结构。
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 * unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
 * upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
 * [[[-1, 0, 0, 1, 1, 2, 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
 * 输出：
 * [null, true, false, true, true, true, false]
 * <p>
 * 解释：
 * LockingTree lockingTree = new LockingTree([-1, 0, 0, 1, 1, 2, 2]);
 * lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
 * // 节点 2 被用户 2 上锁。
 * lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
 * lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
 * // 节点 2 现在变为未上锁状态。
 * lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
 * // 节点 4 被用户 5 上锁。
 * lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
 * // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
 * lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == parent.length
 * 2 <= n <= 2000
 * 对于 i != 0 ，满足 0 <= parent[i] <= n - 1
 * parent[0] == -1
 * 0 <= num <= n - 1
 * 1 <= user <= 104
 * parent 表示一棵合法的树。
 * lock ，unlock 和 upgrade 的调用 总共 不超过 2000 次。
 */
public class Code3 {

    private class Node {

        //当前节点数字
        private int num;

        //是否锁定
        private boolean locked;

        //锁定用户
        private int lockedUser;

        //父亲
        private Node father;

        //孩子列表
        private List<Node> children;

        //初始化
        public Node(int num) {
            this.num = num;
            this.children = new ArrayList<>();
            //默认不是锁
            this.locked = false;
        }

    }

    //主节点
    private Node root;
    //节点缓存
    private Map<Integer, Node> nodeMap;

    public Code3(int[] parent) {
        //缓存
        this.nodeMap = new HashMap<>();
        //初始化主节点
        this.root = new Node(0);
        //记录主节点
        this.nodeMap.put(this.root.num, this.root);
        //循环1
        for (int i = 1; i < parent.length; i++) {
            //初始化当前节点
            Node child = new Node(i);
            //记录
            this.nodeMap.put(child.num, child);
        }
        //循环2
        for (int i = 1; i < parent.length; i++) {
            //获取其父亲
            Node father = this.nodeMap.get(parent[i]);
            //获取孩子
            Node child = this.nodeMap.get(i);
            //绑定关系
            father.children.add(child);
            child.father = father;
        }
    }

    //上锁
    public boolean lock(int num, int user) {
        //获取节点
        Node node = this.nodeMap.get(num);
        //如果上锁了
        if (node.locked == true) {
            //过
            return false;
        }
        //上锁
        node.locked = true;
        node.lockedUser = user;
        //返回
        return true;
    }

    //解锁
    public boolean unlock(int num, int user) {
        //获取节点
        Node node = this.nodeMap.get(num);
        //如果没锁了 or 上锁的不是他
        if (node.locked == false || node.lockedUser != user) {
            //过
            return false;
        }
        //解锁
        unlock(node);
        //返回
        return true;
    }

    //强行解锁
    private void unlock(Node node) {
        //解锁
        node.locked = false;
    }

    //强行解锁节点和其所有子节点
    private void unlockAndChild(Node node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //解锁
        unlock(node);
        //循环子节点
        for (Node child : node.children) {
            //解锁子节点
            unlockAndChild(child);
        }
    }

    //升级
    public boolean upgrade(int num, int user) {
        //获取节点
        Node node = this.nodeMap.get(num);
        //如果上锁了
        if (node.locked == true) {
            //过
            return false;
        }
        //如果没有上锁的子节点
        if (checkChildLock(node) == false) {
            //过
            return false;
        }
        //如果父级有上锁的情况
        if (checkFatherLock(node) == true) {
            //过
            return false;
        }
        //给当前节点上锁
        lock(num, user);
        //循环所有子节点
        for (Node child : node.children) {
            //解锁所有子节点ø
            unlockAndChild(child);
        }
        //成功
        return true;
    }

    //检查子节点是否有上锁的节点,一个就够
    private boolean checkChildLock(Node node) {
        //判空
        if (node == null) {
            //不是
            return false;
        }
        //如果当前上锁了
        if (node.locked) {
            //是
            return true;
        }
        //循环子节点
        for (Node child : node.children) {
            //如果有子节点锁了
            if (checkChildLock(child)) {
                //是
                return true;
            }
        }
        //默认不是
        return false;
    }

    //检查父节点是否有上锁的节点,一个就够
    private boolean checkFatherLock(Node node) {
        //判空
        if (node == null) {
            //不是
            return false;
        }
        //如果当前上锁了
        if (node.locked) {
            //是
            return true;
        }
        //返回父级的
        return checkFatherLock(node.father);
    }

}
