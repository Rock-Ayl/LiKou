package normal47;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-10-14
 * 3508. 设计路由器
 * 算术评级: 6
 * 第 444 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1851
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 请你设计一个数据结构来高效管理网络路由器中的数据包。每个数据包包含以下属性：
 * <p>
 * source：生成该数据包的机器的唯一标识符。
 * destination：目标机器的唯一标识符。
 * timestamp：该数据包到达路由器的时间戳。
 * 实现 Router 类：
 * <p>
 * Router(int memoryLimit)：初始化路由器对象，并设置固定的内存限制。
 * <p>
 * memoryLimit 是路由器在任意时间点可以存储的 最大 数据包数量。
 * 如果添加一个新数据包会超过这个限制，则必须移除 最旧的 数据包以腾出空间。
 * bool addPacket(int source, int destination, int timestamp)：将具有给定属性的数据包添加到路由器。
 * <p>
 * 如果路由器中已经存在一个具有相同 source、destination 和 timestamp 的数据包，则视为重复数据包。
 * 如果数据包成功添加（即不是重复数据包），返回 true；否则返回 false。
 * int[] forwardPacket()：以 FIFO（先进先出）顺序转发下一个数据包。
 * <p>
 * 从存储中移除该数据包。
 * 以数组 [source, destination, timestamp] 的形式返回该数据包。
 * 如果没有数据包可以转发，则返回空数组。
 * int getCount(int destination, int startTime, int endTime)：
 * <p>
 * 返回当前存储在路由器中（即尚未转发）的，且目标地址为指定 destination 且时间戳在范围 [startTime, endTime]（包括两端）内的数据包数量。
 * 注意：对于 addPacket 的查询会按照 timestamp 的非递减顺序进行。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
 * [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]
 * <p>
 * 输出：
 * [null, true, true, false, true, true, [2, 5, 90], true, 1]
 * <p>
 * 解释：
 * <p>
 * Router router = new Router(3); // 初始化路由器，内存限制为 3。
 * router.addPacket(1, 4, 90); // 数据包被添加，返回 True。
 * router.addPacket(2, 5, 90); // 数据包被添加，返回 True。
 * router.addPacket(1, 4, 90); // 这是一个重复数据包，返回 False。
 * router.addPacket(3, 5, 95); // 数据包被添加，返回 True。
 * router.addPacket(4, 5, 105); // 数据包被添加，[1, 4, 90] 被移除，因为数据包数量超过限制，返回 True。
 * router.forwardPacket(); // 转发数据包 [2, 5, 90] 并将其从路由器中移除。
 * router.addPacket(5, 2, 110); // 数据包被添加，返回 True。
 * router.getCount(5, 100, 110); // 唯一目标地址为 5 且时间在 [100, 110] 范围内的数据包是 [4, 5, 105]，返回 1。
 * 示例 2：
 * <p>
 * 输入：
 * ["Router", "addPacket", "forwardPacket", "forwardPacket"]
 * [[2], [7, 4, 90], [], []]
 * <p>
 * 输出：
 * [null, true, [7, 4, 90], []]
 * <p>
 * 解释：
 * <p>
 * Router router = new Router(2); // 初始化路由器，内存限制为 2。
 * router.addPacket(7, 4, 90); // 返回 True。
 * router.forwardPacket(); // 返回 [7, 4, 90]。
 * router.forwardPacket(); // 没有数据包可以转发，返回 []。
 */
public class Code1 {

    public Code1(int memoryLimit) {
        //记录
        this.memoryLimit = memoryLimit;
    }

    //双端队列
    private ArrayDeque<Packet> arrayDeque = new ArrayDeque<>();
    //唯一性缓存
    private Set<Packet> packetSet = new HashSet<>();
    //唯一识别码缓存
    private Map<Integer, List<Packet>> destinationMap = new HashMap<>();
    //内存最大长度
    private int memoryLimit;

    //包实体
    private static class Packet {

        //生成该数据包的机器的唯一标识符
        private int source;

        //目标机器的唯一标识符
        private int destination;

        //该数据包到达路由器的时间戳
        private int timestamp;

        //初始化
        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        //hash
        @Override
        public int hashCode() {
            //简单实现
            return this.source + destination + timestamp;
        }

        //对比
        @Override
        public boolean equals(Object obj) {
            //转为目标实体
            Packet other = (Packet) obj;
            //对比
            return other.source == this.source
                    && other.destination == this.destination
                    && other.timestamp == this.timestamp;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("source=%s,destination=%s,timestamp=%s", this.source, this.destination, this.timestamp);
        }

    }

    public boolean addPacket(int source, int destination, int timestamp) {
        //初始化
        Packet packet = new Packet(source, destination, timestamp);
        //如果已经添加了
        if (this.packetSet.contains(packet)) {
            //过
            return false;
        }
        //加入最后
        addList(packet);
        //如果超出限制
        if (this.arrayDeque.size() > this.memoryLimit) {
            //拉取第一个
            pollFirst();
        }
        //返回结果
        return true;
    }

    public int[] forwardPacket() {
        //如果没有
        if (this.arrayDeque.isEmpty()) {
            //过
            return new int[]{};
        }
        //拉取第一个
        Packet first = pollFirst();
        //返回
        return new int[]{first.source, first.destination, first.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        //如果不存在
        if (this.destinationMap.containsKey(destination) == false) {
            //过
            return 0;
        }
        //获取列表
        List<Packet> packetList = this.destinationMap.get(destination);
        //如果为空
        if (packetList.isEmpty()) {
            //过
            return 0;
        }
        //二分
        return count(packetList, startTime, endTime);
    }

    /**
     * 加入最后
     */
    private void addList(Packet packet) {
        //加入
        this.arrayDeque.addLast(packet);
        this.packetSet.add(packet);
        this.destinationMap.putIfAbsent(packet.destination, new ArrayList<>());
        this.destinationMap.get(packet.destination).add(packet);
    }

    /**
     * 拉取第一个,并返回
     */
    private Packet pollFirst() {
        //拉取第一个
        Packet first = this.arrayDeque.pollFirst();
        //删除缓存
        this.packetSet.remove(first);
        this.destinationMap.get(first.destination).remove(0);
        //返回
        return first;
    }

    /**
     * 计算同一机器,时间区间count
     */
    private int count(List<Packet> packetList, int startTime, int endTime) {
        //寻找左右
        int left = findLeft(packetList, startTime);
        //如果无效
        if (left == -1) {
            //过
            return 0;
        }
        int right = findRight(packetList, endTime);
        //如果无效
        if (right == -1) {
            //过
            return 0;
        }
        //如果没有任何考试
        if (left > right) {
            //过
            return 0;
        }
        //结果
        return right - left + 1;
    }

    //寻找左边边界
    private int findLeft(List<Packet> packetList, int startTime) {
        //如果是最左边
        if (startTime <= packetList.get(0).timestamp) {
            //直接返回
            return 0;
        }
        //如果超过边界
        if (startTime > packetList.get(packetList.size() - 1).timestamp) {
            //无效
            return -1;
        }
        //实现
        return findLeft(packetList, startTime, 0, packetList.size() - 1);
    }

    //寻找左边边界递归
    private int findLeft(List<Packet> packetList, int startTime, int start, int end) {
        //如果只有一个
        if (start + 1 == end) {
            //判断左右
            if (startTime <= packetList.get(start).timestamp) {
                //如果还有相同数字
                while (start - 1 >= 0 && startTime <= packetList.get(start - 1).timestamp) {
                    //-1
                    start--;
                }
                //返回
                return start;
            } else {
                //返回
                return end;
            }
        }
        //中间索引
        int mid = (end - start) / 2 + start;
        //判断方向
        if (startTime < packetList.get(mid).timestamp) {
            //递归
            return findLeft(packetList, startTime, start, mid);
        } else {
            //递归
            return findLeft(packetList, startTime, mid, end);
        }
    }

    //寻找右边边界
    private int findRight(List<Packet> packetList, int endTime) {
        //如果是最右边
        if (endTime >= packetList.get(packetList.size() - 1).timestamp) {
            //直接返回
            return packetList.size() - 1;
        }
        //如果超过边界
        if (endTime < packetList.get(0).timestamp) {
            //无效
            return -1;
        }
        //实现
        return findRight(packetList, endTime, 0, packetList.size() - 1);
    }

    //寻找右边边界递归
    private int findRight(List<Packet> packetList, int endTime, int start, int end) {
        //如果只有一个
        if (start + 1 == end) {
            //endTime
            if (endTime >= packetList.get(end).timestamp) {
                //如果还有相同数字
                while (end + 1 < packetList.size() && endTime >= packetList.get(end + 1).timestamp) {
                    //+1
                    end++;
                }
                //返回
                return end;
            } else {
                //返回
                return start;
            }
        }
        //中间索引
        int mid = (end - start) / 2 + start;
        //判断方向
        if (endTime < packetList.get(mid).timestamp) {
            //递归
            return findRight(packetList, endTime, start, mid);
        } else {
            //递归
            return findRight(packetList, endTime, mid, end);
        }
    }

    public static void main(String[] args) {
        Code1 router = new Code1(49);
        router.addPacket(4, 1, 1);  // 操作1
        System.out.println(router.getCount(1, 1, 1));  // 操作2，预期输出: 1
        router.addPacket(2, 3, 1);  // 操作3
        router.addPacket(3, 1, 2);  // 操作4
        System.out.println(router.getCount(1, 1, 1));  // 操作5，预期输出: 1
        router.addPacket(1, 4, 2);  // 操作6
        router.addPacket(2, 4, 2);  // 操作7
        System.out.println(router.getCount(3, 2, 2));  // 操作8，预期输出: 0
        router.addPacket(2, 1, 2);  // 操作9
        System.out.println(router.forwardPacket());  // 操作10，预期输出: [4,1,1]
        router.addPacket(2, 3, 2);  // 操作11
        System.out.println(router.getCount(3, 1, 1));  // 操作12，预期输出: 1
        router.addPacket(4, 5, 2);  // 操作13
        System.out.println(router.forwardPacket());  // 操作14，预期输出: [2,3,1]
        router.addPacket(1, 4, 2);  // 操作15，预期输出: false
        router.addPacket(3, 2, 7);  // 操作16
        System.out.println(router.getCount(1, 7, 7));  // 操作17，预期输出: 0
        System.out.println(router.getCount(4, 3, 7));  // 操作18，预期输出: 0
        System.out.println(router.getCount(5, 1, 1));  // 操作19，预期输出: 0
        System.out.println(router.getCount(1, 5, 6));  // 操作20，预期输出: 0
        System.out.println(router.getCount(3, 6, 7));  // 操作21，预期输出: 0
        System.out.println(router.getCount(3, 4, 4));  // 操作22，预期输出: 0
        router.addPacket(3, 4, 11);  // 操作23
        router.addPacket(2, 5, 11);  // 操作24
        System.out.println(router.getCount(5, 6, 9));  // 操作25，预期输出: 0
        router.addPacket(1, 3, 14);  // 操作26
        router.addPacket(2, 4, 14);  // 操作27
        router.addPacket(3, 2, 16);  // 操作28
        System.out.println(router.forwardPacket());  // 操作29，预期输出: [3,1,2]
        router.addPacket(2, 1, 16);  // 操作30
        System.out.println(router.forwardPacket());  // 操作31，预期输出: [1,4,2]
        System.out.println(router.getCount(5, 8, 8));  // 操作32，预期输出: 0
        router.addPacket(3, 2, 16);  // 操作33，预期输出: false
        router.addPacket(1, 2, 16);  // 操作34
        System.out.println(router.forwardPacket());  // 操作35，预期输出: [2,4,2]
        router.addPacket(4, 2, 16);  // 操作36
        router.addPacket(2, 4, 16);  // 操作37
        router.addPacket(2, 3, 16);  // 操作38
        System.out.println(router.getCount(3, 10, 12));  // 操作39，预期输出: 0
        System.out.println(router.forwardPacket());  // 操作40，预期输出: [2,1,2]
        System.out.println(router.getCount(5, 11, 13));  // 操作41，预期输出: 1
        System.out.println(router.forwardPacket());  // 操作42，预期输出: [2,3,2]
        System.out.println(router.forwardPacket());  // 操作43，预期输出: [4,5,2]
        System.out.println(router.getCount(5, 7, 13));  // 操作44，预期输出: 1
        router.addPacket(1, 4, 16);  // 操作45
        router.addPacket(4, 5, 16);  // 操作46
        System.out.println(router.getCount(1, 5, 8));  // 操作47，预期输出: 0
        System.out.println(router.getCount(5, 15, 15));  // 操作48，预期输出: 0
        System.out.println(router.forwardPacket());  // 操作49，预期输出: [3,2,7]
        router.addPacket(5, 3, 16);  // 操作50
        System.out.println(router.getCount(3, 16, 16));  // 操作51，预期输出: 2（你的输出是1，这里出现错误）
    }

}
