import java.sql.*;
import org.sqlite.*;

public class COMPARESTRING extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 2) {
            throw new SQLException("COMPARESTRING(string1, string2): Invalid argument count. Expected 2, but found " + args());
        }
        try{

            String string1 = value_text(0);
            String string2 = value_text(1);

            int compare = string1.compareTo(string2);
            int result = 0;

            if(compare > 0) {
                result = -1;
            }
            else if(compare < 0) {
                result = 1;
            }

            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
