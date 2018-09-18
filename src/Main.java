import java.sql.*;
import org.sqlite.*;

public class Main {

    public static void main(String[] args) throws SQLException{
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:");

            Function.create(connection, "PING", new PING());
            connection.createStatement().execute("select PING('google.com')");

            Function.create(connection, "PMT", new PMT());
            connection.createStatement().execute("select PMT(0.05, 5, 50000)");

            Function.create(connection, "BIN2DEC", new BIN2DEC());
            connection.createStatement().execute("select BIN2DEC('111')");

            Function.create(connection, "DEC2BIN", new DEC2BIN());
            connection.createStatement().execute("select DEC2BIN(7)");

            Function.create(connection, "F2C", new F2C());
            connection.createStatement().execute("select F2C(212)");

            Function.create(connection, "C2F", new C2F());
            connection.createStatement().execute("select C2F(100)");

            Function.create(connection, "FACTORIAL", new FACTORIAL());
            connection.createStatement().execute("select FACTORIAL(5)");

            Function.create(connection, "HEX2DEC", new HEX2DEC());
            connection.createStatement().execute("select HEX2DEC('FF')");

            Function.create(connection, "DEC2HEX", new DEC2HEX());
            connection.createStatement().execute("select DEC2HEX(255)");

            Function.create(connection, "COMPARESTRING", new COMPARESTRING());
            connection.createStatement().execute("select COMPARESTRING('tres', 'cinco')");

            Function.create(connection, "TRIM", new TRIM());
            connection.createStatement().execute("select TRIM('alpha', 'a')");

            Function.create(connection, "REPEAT", new REPEAT());
            connection.createStatement().execute("select REPEAT('cinco', 5)");

            connection.close();

        } catch(Exception e){
            throw new SQLException(e.getMessage());
        }
    }
}
