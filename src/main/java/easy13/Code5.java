package easy13;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-10-18
 * 5885. 使每位学生都有座位的最少移动次数
 * 一个房间里有 n 个座位和 n 名学生，房间用一个数轴表示。给你一个长度为 n 的数组 seats ，其中 seats[i] 是第 i 个座位的位置。同时给你一个长度为 n 的数组 students ，其中 students[j] 是第 j 位学生的位置。
 * <p>
 * 你可以执行以下操作任意次：
 * <p>
 * 增加或者减少第 i 位学生的位置，每次变化量为 1 （也就是将第 i 位学生从位置 x 移动到 x + 1 或者 x - 1）
 * 请你返回使所有学生都有座位坐的 最少移动次数 ，并确保没有两位学生的座位相同。
 * <p>
 * 请注意，初始时有可能有多个座位或者多位学生在 同一 位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：seats = [3,1,5], students = [2,7,4]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 2 移动到位置 1 ，移动 1 次。
 * - 第二位学生从位置 7 移动到位置 5 ，移动 2 次。
 * - 第三位学生从位置 4 移动到位置 3 ，移动 1 次。
 * 总共 1 + 2 + 1 = 4 次移动。
 * 示例 2：
 * <p>
 * 输入：seats = [4,1,5,9], students = [1,3,2,6]
 * 输出：7
 * 解释：学生移动方式如下：
 * - 第一位学生不移动。
 * - 第二位学生从位置 3 移动到位置 4 ，移动 1 次。
 * - 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
 * - 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
 * 总共 0 + 1 + 3 + 3 = 7 次移动。
 * 示例 3：
 * <p>
 * 输入：seats = [2,2,6,6], students = [1,3,2,6]
 * 输出：4
 * 解释：学生移动方式如下：
 * - 第一位学生从位置 1 移动到位置 2 ，移动 1 次。
 * - 第二位学生从位置 3 移动到位置 6 ，移动 3 次。
 * - 第三位学生不移动。
 * - 第四位学生不移动。
 * 总共 1 + 3 + 0 + 0 = 4 次移动。
 */
public class Code5 {

    public int minMovesToSeat(int[] seats, int[] students) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环1
        for (int seat : seats) {
            //记录
            map.put(seat, map.getOrDefault(seat, 0) + 1);
        }
        //没座位的人
        List<Integer> studentList = new ArrayList<>();
        //循环2
        for (int student : students) {
            //如果已经做到了
            if (map.containsKey(student)) {
                //获取并减少
                int count = map.get(student) - 1;
                //如果没了
                if (count == 0) {
                    //删除
                    map.remove(student);
                } else {
                    //记录
                    map.put(student, count);
                }
            } else {
                //记录需要移动的人
                studentList.add(student);
            }
        }
        //排序
        Collections.sort(studentList);
        //剩余位置
        List<Integer> seatList = new ArrayList<>();
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //次数
            int value = entry.getValue();
            //循环
            while (value > 0) {
                //组装
                seatList.add(entry.getKey());
                value--;
            }
        }
        //排序
        Collections.sort(seatList);
        //结果
        int sum = 0;
        //循环
        for (int i = 0; i < seatList.size(); i++) {
            //计算
            int abs = Math.abs(seatList.get(i) - studentList.get(i));
            sum += abs;
        }
        //结果返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));
    }
}
