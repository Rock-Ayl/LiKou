package normal23;

/**
 * @Author ayl
 * @Date 2023-08-13
 */
public class Code3 {

    public static void main(String[] args) {
        String sql="SELECT a.user_id,ROUND(a.confirmation_rate,2) as confirmation_rate FROM (SELECT user_id,0  as confirmation_rate FROM Signups WHERE user_id not IN (SELECT user_id FROM Confirmations) UNION SELECT a.user_id,(sum(a.confirmed) / count(*)) as confirmation_rate FROM (SELECT user_id,IF(action ='confirmed',1,0) as confirmed FROM Confirmations) a GROUP BY a.user_id) a ";
    }
}
