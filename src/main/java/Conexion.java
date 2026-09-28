import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexion {

        private static final String URL = "jdbc:mariadb://localhost:3306/RepasoServidor1";
        private static final String USUARIO = "root";
        private static final String PASSWORD = "usuario";

        public static Connection getConexion() throws SQLException {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }

        public static void main(String[] args) {
            try (Connection conexion = getConexion()) {
                if (conexion != null) {
                    System.out.println("¡Conexión exitosa a MariaDB!");
                }
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos:");
                e.printStackTrace();
            }
        }
    }