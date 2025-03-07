package normal17;

/**
 * @Author ayl
 * @Date 2022-12-06
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Code15 {

    //长度相同的对比
    public boolean countSame(String first, String second) {
        //共同的长度
        int length = first.length();
        //右边边界
        int maxP = length - 1;
        //如果头不同
        if (first.charAt(0) != second.charAt(0)) {
            //掐头判断其余
            return first.substring(1).equals(second.substring(1));
        }
        //如果尾不同
        if (first.charAt(maxP) != second.charAt(maxP)) {
            //去尾,判断其余
            return first.substring(0, maxP).equals(second.substring(0, maxP));
        }
        //中间不同判定
        int left = 0;
        //循环
        while (left < length) {
            //如果找到不同了
            if (first.charAt(++left) != second.charAt(left)) {
                //跳出
                break;
            }
        }
        //右边
        int right = maxP;
        //循环
        while (right > 0) {
            //如果找到不同了
            if (first.charAt(--right) != second.charAt(right)) {
                //跳出
                break;
            }
        }
        //返回结果
        return left == right;
    }

    //长度不相同的对比
    public boolean countNotSame(String first, String second) {
        //大的和小的
        String big;
        String small;
        //判断长度
        if (first.length() > second.length()) {
            //初始化
            big = first;
            small = second;
        } else {
            //初始化
            big = second;
            small = first;
        }
        //如果头不同
        if (big.charAt(0) != small.charAt(0)) {
            //大的掐头判断其余
            return big.substring(1).equals(small);
        }
        //如果尾不同
        if (big.charAt(big.length() - 1) != small.charAt(small.length() - 1)) {
            //大的去尾,判断其余
            return big.substring(0, small.length()).equals(small);
        }
        //中间不同判定
        int left = 0;
        //循环
        while (left < small.length()) {
            //如果找到不同了
            if (first.charAt(++left) != second.charAt(left)) {
                //跳出
                break;
            }
        }
        //右边
        int right = small.length() - 1;
        //循环
        while (right > 0) {
            //如果找到不同了
            if (big.charAt(right) != small.charAt(--right)) {
                //跳出
                break;
            }
        }
        //返回结果
        return left == right + 1;
    }

    public boolean oneEditAway(String first, String second) {
        //如果二者完全一样
        if (first.equals(second) == true) {
            //是
            return true;
        }
        //长度差
        int lengthMin = Math.abs(first.length() - second.length());
        //如果长度差距大于1
        if (lengthMin > 1) {
            //不行
            return false;
        }
        //如果有长度为0的
        if (first.length() == 0 || second.length() == 0) {
            //可以
            return true;
        }
        //如果长度相同
        if (lengthMin == 0) {
            //长度相同的对比
            return countSame(first, second);
        } else {
            //长度不同的对比
            return countNotSame(first, second);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().oneEditAway("abcd", "abd"));
    }

}
