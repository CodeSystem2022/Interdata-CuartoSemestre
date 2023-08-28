package UTN.conexion;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public  static Connection getConnection(){
        Connection conexion = null;
        //vatiables para conectarnos a la base de datos
        var baseDatos = "estudiantes2022";
        var url = "jdbc:mysql://localhost:3306/"+baseDatos;
        var usuario = "root";
        var password = "admin";

        //cargamos la clase de driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario,password);
        }catch (ClassNotFoundException | SQLException e ){
            System.out.println("ocurrio un error en la conexion "+e.getMessage());
        }//Fin catch
        return conexion;

    }

}
