import java.sql.*;
import org.sqlite.*;

public class DEC2HEX extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("DEC2HEX(int): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            int num = value_int(0);
            String result = Integer.toHexString(num);

            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
