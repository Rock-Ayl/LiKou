package easy18;

/**
 * @Author ayl
 * @Date 2022-04-19
 * 1757. 可回收且低脂的产品
 * SQL架构
 * 表：Products
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | product_id  | int     |
 * | low_fats    | enum    |
 * | recyclable  | enum    |
 * +-------------+---------+
 * product_id 是这个表的主键。
 * low_fats 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品是低脂产品，'N' 表示不是低脂产品。
 * recyclable 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品可回收，而 'N' 表示不可回收。
 * <p>
 * <p>
 * 写出 SQL 语句，查找既是低脂又是可回收的产品编号。
 * <p>
 * 返回结果 无顺序要求 。
 * <p>
 * 查询结果格式如下例所示：
 * <p>
 * Products 表：
 * +-------------+----------+------------+
 * | product_id  | low_fats | recyclable |
 * +-------------+----------+------------+
 * | 0           | Y        | N          |
 * | 1           | Y        | Y          |
 * | 2           | N        | Y          |
 * | 3           | Y        | Y          |
 * | 4           | N        | N          |
 * +-------------+----------+------------+
 * Result 表：
 * +-------------+
 * | product_id  |
 * +-------------+
 * | 1           |
 * | 3           |
 * +-------------+
 * 只有产品 id 为 1 和 3 的产品，既是低脂又是可回收的产品。
 * 通过次数13,499提交次数15,037
 */
public class Code7 {

    public static void main(String[] args) {
        String sql = "select product_id from  Products where low_fats ='Y' and recyclable = 'Y'";
    }

}
