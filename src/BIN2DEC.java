import java.sql.*;
import org.sqlite.*;

public class BIN2DEC extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("BIN2DEC(bin): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            String bin = value_text(0);
            int result = Integer.parseInt(bin,2);

            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
