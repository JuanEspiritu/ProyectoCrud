package pe.edu.upeu.oracle.config;

/**
 *
 * @author Docente
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conexion;

    public static Connection getConexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            if(conexion==null){
                   conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##proyecto", "123456");
            }
            
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println("Error1: " + cnfe);
        }
        return conexion;
    }
    
}
