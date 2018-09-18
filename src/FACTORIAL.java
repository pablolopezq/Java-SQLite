import java.sql.*;
import org.sqlite.*;

public class FACTORIAL extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("FACTORIAL(int): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            int number = value_int(0);
            int fact = 1;

            for (int i = 1; i <= number; i++) {
                fact = fact*i;
            }

            result(fact);
            System.out.println(fact);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
