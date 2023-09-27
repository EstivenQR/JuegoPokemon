

import java.sql.Connection; // representa una conexión física con la fuente de datos.
import java.sql.DriverManager; // DriverManager gestiona el conjunto de controladores Java Database Connectivity (JDBC)


public class Conexion {
     
//para leavntar la BD
    public static final String URL = "jdbc:mysql://localhost:3306/parqueo";

    public static final String USER = "root";

    public static final String PASS = "Memo2022+";
    


    public static Connection getConnection() {
        Connection con = null;
        try {
      
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }
    
}

