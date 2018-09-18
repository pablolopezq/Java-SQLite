import java.sql.*;
import org.sqlite.*;

public class F2C extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("F2C(fahrenheit): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            double fahrenheit = value_double(0);
            double celcius = ((5.0/9.0) * (fahrenheit - 32));

            result(celcius);
            System.out.println(celcius);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
