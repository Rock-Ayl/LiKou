package normal42;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-05-08
 * LCP 73. 探险营地
 * 中等
 * 相关企业
 * 探险家小扣的行动轨迹，都将保存在记录仪中。expeditions[i] 表示小扣第 i 次探险记录，用一个字符串数组表示。其中的每个「营地」由大小写字母组成，通过子串 -> 连接。
 * <p>
 * 例："Leet->code->Campsite"，表示到访了 "Leet"、"code"、"Campsite" 三个营地。
 * <p>
 * expeditions[0] 包含了初始小扣已知的所有营地；对于之后的第 i 次探险(即 expeditions[i] 且 i > 0)，如果记录中包含了之前均没出现的营地，则表示小扣 新发现 的营地。
 * <p>
 * 请你找出小扣发现新营地最多且索引最小的那次探险，并返回对应的记录索引。如果所有探险记录都没有发现新的营地，返回 -1
 * <p>
 * 注意：
 * <p>
 * 大小写不同的营地视为不同的营地；
 * 营地的名称长度均大于 0。
 * 示例 1：
 * <p>
 * 输入：expeditions = ["leet->code","leet->code->Campsite->Leet","leet->code->leet->courier"]
 * <p>
 * 输出：1
 * <p>
 * 解释： 初始已知的所有营地为 "leet" 和 "code" 第 1 次，到访了 "leet"、"code"、"Campsite"、"Leet"，新发现营地 2 处："Campsite"、"Leet" 第 2 次，到访了 "leet"、"code"、"courier"，新发现营地 1 处："courier" 第 1 次探险发现的新营地数量最多，因此返回 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：expeditions = ["Alice->Dex","","Dex"]
 * <p>
 * 输出：-1
 * <p>
 * 解释： 初始已知的所有营地为 "Alice" 和 "Dex" 第 1 次，未到访任何营地； 第 2 次，到访了 "Dex"，未新发现营地； 因为两次探险均未发现新的营地，返回 -1
 * <p>
 * 示例 3：
 * <p>
 * 输入：expeditions = ["","Gryffindor->Slytherin->Gryffindor","Hogwarts->Hufflepuff->Ravenclaw"]
 * <p>
 * 输出：2
 * <p>
 * 解释： 初始未发现任何营地； 第 1 次，到访 "Gryffindor"、"Slytherin" 营地，其中重复到访 "Gryffindor" 两次， 因此新发现营地为 2 处："Gryffindor"、"Slytherin" 第 2 次，到访 "Hogwarts"、"Hufflepuff"、"Ravenclaw" 营地； 新发现营地 3 处："Hogwarts"、"Hufflepuff"、"Ravenclaw"； 第 2 次探险发现的新营地数量最多，因此返回 2
 * <p>
 * 提示：
 * <p>
 * 1 <= expeditions.length <= 1000
 * 0 <= expeditions[i].length <= 1000
 * 探险记录中只包含大小写字母和子串"->"
 */
public class Code19 {

    public int adventureCamp(String[] expeditions) {
        //已知营地
        Set<String> knowSet = Arrays.stream(expeditions[0].split("->")).collect(Collectors.toSet());
        //特殊情况
        knowSet.add("");
        //结果,默认-1
        int result = -1;
        //结果所发现的营地
        int count = 0;
        //循环
        for (int i = 1; i < expeditions.length; i++) {
            //获取
            String expedition = expeditions[i];
            //本次结果
            int thisCount = 0;
            //循环
            for (String word : expedition.split("->")) {
                //如果没发现过
                if (knowSet.contains(word) == false) {
                    //发现
                    thisCount++;
                    //记录
                    knowSet.add(word);
                }
            }
            //如果更大
            if (thisCount > count) {
                //更新结果
                result = i;
                count = thisCount;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().adventureCamp(new String[]{
                "xO->xO->xO",
                "xO->BKbWDH", "xO->BKbWDH", "BKbWDH->mWXW", "LSAYWW->LSAYWW",
                "oAibBvPdJ", "LSAYWW->u", "LSAYWW->LSAYWW"
        }));
    }

}
