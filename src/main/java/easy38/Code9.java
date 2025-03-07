package easy38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-09-05
 * 401. 二进制手表
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 例如，下面的二进制手表读取 "4:51" 。
 * <p>
 * <p>
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 示例 2：
 * <p>
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= turnedOn <= 10
 */
public class Code9 {

    //可选项可能
    private int[] changeArr = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    //可选项中间线,左边是小时,右边是分钟
    private int midIndex = 3;
    //小时最大情况
    private int hourMax = 11;
    private int minuteMax = 59;

    public List<String> readBinaryWatch(int turnedOn) {
        //如果不可能
        if (turnedOn > 8) {
            //直接返回
            return new ArrayList<>();
        }
        //如果是特殊可能
        if (turnedOn == 0) {
            //返回
            return Arrays.asList("0:00");
        }
        //初始化目标结果
        List<String> resultList = new ArrayList<>();
        //递归实现
        next(resultList, 0, 0, 0, 0, turnedOn);
        //返回
        return resultList;
    }

    //递归实现
    private void next(List<String> resultList, int index, int hour, int minute, int count, int turnedOn) {
        //如果越界
        if (index >= changeArr.length) {
            //过
            return;
        }
        //先不选这个直接递归的可能
        next(resultList, index + 1, hour, minute, count, turnedOn);
        //判断本次是 小时 or 分钟
        if (index <= this.midIndex) {
            //如果小时超过了
            if (hour + this.changeArr[index] > this.hourMax) {
                //结束
                return;
            }
            //增加小时
            hour += this.changeArr[index];
        } else {
            //如果分钟超过了
            if (minute + this.changeArr[index] > this.minuteMax) {
                //结束
                return;
            }
            //增加分钟
            minute += this.changeArr[index];
        }
        //叠加次数,并判断是否满足目标次数
        if (++count == turnedOn) {
            //记录本次结果
            resultList.add(hour + ":" + (minute > 9 ? Integer.toString(minute) : ("0" + minute)));
        } else {
            //递归下一级
            next(resultList, index + 1, hour, minute, count, turnedOn);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Code9().readBinaryWatch(1);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
