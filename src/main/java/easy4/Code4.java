package easy4;

/**
 * Created By Rock-Ayl on 2020-12-04
 * 627. 变更性别
 * SQL架构
 * 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
 * <p>
 * 注意，您必只能写一个 Update 语句，请不要编写任何 Select 语句。
 * <p>
 * 例如：
 * <p>
 * | id | name | sex | salary |
 * |----|------|-----|--------|
 * | 1  | A    | m   | 2500   |
 * | 2  | B    | f   | 1500   |
 * | 3  | C    | m   | 5500   |
 * | 4  | D    | f   | 500    |
 * 运行你所编写的更新语句之后，将会得到以下表:
 * <p>
 * | id | name | sex | salary |
 * |----|------|-----|--------|
 * | 1  | A    | f   | 2500   |
 * | 2  | B    | m   | 1500   |
 * | 3  | C    | f   | 5500   |
 * | 4  | D    | m   | 500    |
 */
public class Code4 {

    public static void main(String[] args) {
        String sql = "UPDATE salary SET sex = IF(sex='m','f','m') ";
    }
}
