import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/RepasoServidor1";
        String usuario = "root";
        String password = "usuario";


        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            if (conexion != null) {
                System.out.println("¡Conexión exitosa a MariaDB!");
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}