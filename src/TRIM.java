import java.sql.*;
import org.sqlite.*;

public class TRIM extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 2) {
            throw new SQLException("TRIM(string1, string2): Invalid argument count. Expected 2, but found " + args());
        }
        try{

            String string = value_text(0);
            String character = value_text(1);
            char stringChar = character.charAt(0);

            boolean cont = true;
            String temp = "";
            String result = "";

            for(int i = 0; i<string.length(); i++){
                if(cont && string.charAt(i)== stringChar)
                    continue;
                temp += string.charAt(i);
                cont=false;
            }
            result=temp;

            for(int x = temp.length()-1; x >= 0; x--){
                if(temp.charAt(x)==stringChar){
                    result = result.substring(0,x);
                    continue;
                }
                break;
            }
            result(result);
            System.out.println(result);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
