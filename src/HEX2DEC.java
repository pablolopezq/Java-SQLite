import java.sql.*;
import org.sqlite.*;

public class HEX2DEC extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("HEC2DEC(hex): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            String hex = value_text(0);
            int result = Integer.parseInt(hex,16);

            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
