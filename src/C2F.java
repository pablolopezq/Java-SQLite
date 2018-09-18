import java.sql.*;
import org.sqlite.*;

public class C2F extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("C2F(celsius): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            double celsius = value_double(0);
            double fahrenheit = ((9.0/5.0) * celsius + 32);

            result(fahrenheit);
            System.out.println(fahrenheit);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
