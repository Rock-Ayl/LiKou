package normal7;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-09-08
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime 格式为 "HH:MM" 。
 * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
 * 1 <= keyName[i].length <= 10
 * keyName[i] 只包含小写英文字母。
 */
public class Code10 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        //缓存
        Map<String, List<Integer>> map = new HashMap<>();
        //循环
        for (int i = 0; i < keyName.length; i++) {
            //当前key
            String name = keyName[i];
            //时间需要拆分
            String[] arr = keyTime[i].split(":");
            //将时间计算为分钟
            int sum = Integer.valueOf(arr[1]) + Integer.valueOf(arr[0]) * 60;
            //获取/初始化列表
            List<Integer> list = map.getOrDefault(name, new ArrayList<>());
            //组装
            list.add(sum);
            //组装回去
            map.put(name, list);
        }
        //结果
        List<String> result = new ArrayList<>();
        //跳出开关
        io:
        //循环,滑动窗口
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            //获取列表
            List<Integer> list = entry.getValue();
            //先排序
            Collections.sort(list);
            //循环
            for (int i = 0; i < list.size() - 2; i++) {
                //如果三次间隔小于60
                if ((list.get(i + 2) - list.get(i)) <= 60) {
                    //记录
                    result.add(entry.getKey());
                    //过
                    continue io;
                }
            }
        }
        //排序,字典顺序
        Collections.sort(result);
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String alertName : new Code10().alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"})) {
            System.out.println(alertName);
        }
    }

}
