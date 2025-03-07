package normal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-04
 * 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * <p>
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * 示例 4：
 * <p>
 * 输入：croakOfFrogs = "croakcroa"
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 10^5
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 */
public class Code3 {

    public static int minNumberOfFrogs(String croakOfFrogs) {
        //长度
        int length = croakOfFrogs.length();
        //如果长度不符
        if (length == 0 || length % 5 != 0) {
            //默认
            return -1;
        }
        //同一时间段最大青蛙数量
        int max = 0;
        //已完成的青蛙
        int finish = 0;
        //同一时间段青蛙组
        List<Integer> list = new ArrayList<>();
        //当前所需的位置
        int thisP;
        //最新鸣叫的青蛙的位置的队列
        List<Integer> rp = new ArrayList<>(), op = new ArrayList<>(), ap = new ArrayList<>(), kp = new ArrayList<>();
        //跳转符
        next:
        //循环
        for (int i = 0; i < length; i++) {
            //根据字符操作上一级鸣叫
            switch (croakOfFrogs.charAt(i)) {
                case 'c':
                    //更新下一级
                    rp.add(list.size());
                    //新建一个青蛙鸣叫
                    list.add(1);
                    //当前数量
                    int thisNum = list.size() - finish;
                    //如果当前数量刷新了最大数量
                    if (thisNum > max) {
                        //更新
                        max = thisNum;
                    }
                    //下一个
                    continue next;
                case 'r':
                    //判空
                    if (rp.size() == 0) {
                        //返回
                        return -1;
                    }
                    //获取当前的
                    thisP = rp.get(0);
                    //删除最新的
                    rp.remove(0);
                    //更新下一级
                    op.add(thisP);
                    break;
                case 'o':
                    //判空
                    if (op.size() == 0) {
                        //返回
                        return -1;
                    }
                    //获取当前的
                    thisP = op.get(0);
                    //删除最新的
                    op.remove(0);
                    //更新下一级
                    ap.add(thisP);
                    break;
                case 'a':
                    //判空
                    if (ap.size() == 0) {
                        //返回
                        return -1;
                    }
                    //获取当前的
                    thisP = ap.get(0);
                    //删除最新的
                    ap.remove(0);
                    //更新下一级
                    kp.add(thisP);
                    break;
                case 'k':
                    //判空
                    if (kp.size() == 0) {
                        //返回
                        return -1;
                    }
                    //获取当前的
                    thisP = kp.get(0);
                    //删除最新的
                    kp.remove(0);
                    //记录一只完成的青蛙
                    finish++;
                    break;
                default:
                    //不满足条条件
                    return -1;
            }
            //当前青蛙鸣叫的位置+1,并更新
            list.set(thisP, (list.get(thisP) + 1));
            //当前数量
            int thisNum = list.size() - finish;
            //如果当前数量刷新了最大数量
            if (thisNum > max) {
                //更新
                max = thisNum;
            }
            //下一个
            continue next;
        }
        //如果还有没对上的
        if (list.size() - finish > 0) {
            //不满足
            return -1;
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcroccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcrarooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakcokkkrrokkkkaoakckakokkocaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkrkoak"));
    }
}
