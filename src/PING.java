import java.sql.*;
import org.sqlite.*;
import java.io.*;
import java.net.*;

public class PING extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 1) {
            throw new SQLException("PING(ip): Invalid argument count. Expected 1, but found " + args());
        }
        try{

            InetAddress ip = InetAddress.getByName(value_text(0));

            if(ip.isReachable(5000)) {
                System.out.println(1);
                result(1);
            } else {
                result(0);
                System.out.println(0);
            }

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
