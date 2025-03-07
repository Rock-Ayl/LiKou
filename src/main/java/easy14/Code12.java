package easy14;

/**
 * @Author ayl
 * @Date 2021-11-12
 */
public class Code12 {

    public int bitwiseComplement(int n) {
        //转为2进制
        String s = Integer.toBinaryString(n);
        //初始化
        StringBuilder str = new StringBuilder();
        //循环
        for (char c : s.toCharArray()) {
            //如果是0
            if (c == '0') {
                //写1
                str.append(1);
            } else {
                //写0
                str.append(0);
            }
        }
        //转为10
        return Integer.parseInt(str.toString(), 2);
    }

    public static void main(String[] args) {
        new Code12().bitwiseComplement(7);
    }
}
