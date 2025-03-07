package easy31;

/**
 * @Author ayl
 * @Date 2023-06-02
 */
public class Code11 {

    public static void main(String[] args) {
        String sql="select employee_id,department_id from Employee where employee_id not in(select employee_id from Employee where primary_flag = 'Y') or primary_flag = 'Y'";
    }
}
