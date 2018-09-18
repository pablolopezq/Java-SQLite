import java.sql.*;
import org.sqlite.*;

public class REPEAT extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 2) {
            throw new SQLException("TRIM(string, number): Invalid argument count. Expected 2, but found " + args());
        }
        try{

            String string = value_text(0);
            int repeat = value_int(1);
            String result = "";

            for (int i = 0; i < repeat; i++) {
                result = result.concat(string);
            }

            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
