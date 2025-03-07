package easy3;

/**
 * Created By Rock-Ayl on 2020-11-11
 * 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "PPALLL"
 * 输出: False
 * 通过次数20,588提交次数39,618
 */
public class Code19 {

    public static boolean checkRecord(String s) {
        //缺勤次数
        int aNum = 0;
        //迟到连续次数
        int lNum = 0;
        //循环
        for (char c : s.toCharArray()) {
            //判定
            switch (c + "") {
                //缺勤
                case "A":
                    //记录
                    aNum++;
                    //如果超过1次缺勤
                    if (aNum > 1) {
                        //不被奖赏
                        return false;
                    }
                    //归零
                    lNum = 0;
                    break;
                //迟到
                case "L":
                    //如果前两次都是迟到
                    if (lNum == 2) {
                        //不被奖赏
                        return false;
                    }
                    //记录
                    lNum++;
                    break;
                //到场
                case "P":
                    //归零
                    lNum = 0;
                    break;
            }
        }
        //默认会被奖赏
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
    }
}
