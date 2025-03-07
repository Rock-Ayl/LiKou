package normal5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-08-01
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 */
public class Code17 {

    //已经走过的路
    Set<Integer> already;
    List<List<Integer>> rooms;

    public void dfs(int p) {
        //如果已经走过
        if (already.contains(p)) {
            //结束
            return;
        }
        //记录下已经走过了
        already.add(p);
        //如果未越界
        if (p >= 0 && p < rooms.size()) {
            //获取当前
            List<Integer> list = rooms.get(p);
            //循环
            for (Integer integer : list) {
                //下一步
                dfs(integer);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //开始计算
        this.already = new HashSet<>(rooms.size());
        this.rooms = rooms;
        //不断下一步
        dfs(0);
        //从1开始check
        int p = 1;
        //循环
        while (p < rooms.size()) {
            //如果不存在
            if (!already.contains(p++)) {
                //直接返回不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.println(new Code17().canVisitAllRooms(rooms));
    }

}
