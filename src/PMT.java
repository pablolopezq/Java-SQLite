import java.sql.*;
import org.sqlite.*;
import java.lang.*;

public class PMT extends Function{

    @Override
    protected void xFunc() throws SQLException {
        if(args() != 3) {
            throw new SQLException("PMT(tasa, periodos, valor): Invalid argument count. Expected 3, but found " + args());
        }
        try{

            double tasa = value_double(0)/12;
            double periodos = value_double(1)*12;
            double valor = value_double(2);
            double resultado = (tasa*valor)/(1-(Math.pow((1+tasa), (-periodos))));

            result(resultado);
            System.out.println(resultado);

        } catch (Exception e) {
            throw new SQLException("Invalid argument: " + e.getLocalizedMessage());
        }
    }
}
