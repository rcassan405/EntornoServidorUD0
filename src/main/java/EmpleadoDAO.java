import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDAO {

    private Connection con;

    public EmpleadoDAO(Connection con) {
        this.con = con;
    }

    public void insertaEmpleado(Empleado e) throws SQLException {
        String sqlEmp = "insert into empleados(dni, nombre, sexo, categoria, anyosTrabajados) values (?, ?, ?, ?, ?)";
        String sqlNom = "insert into nominas(dni, sueldo) values (?, ?) on duplicate key update sueldo = ?";

        try (PreparedStatement psEmp = con.prepareStatement(sqlEmp)) {
            psEmp.setString(1, e.dni);
            psEmp.setString(2, e.nombre);
            psEmp.setString(3, String.valueOf(e.sexo));
            psEmp.setInt(4, e.getCategoria());
            psEmp.setInt(5, e.anyosTrabajados);
            psEmp.executeUpdate();
        }

        try (PreparedStatement psNom = con.prepareStatement(sqlNom)) {
            double sueldo = Nomina.sueldo(e);
            psNom.setString(1, e.dni);
            psNom.setDouble(2, sueldo);
            psNom.setDouble(3, sueldo);
            psNom.executeUpdate();
        }
    }

    public void altaEmpleado(Empleado e) throws SQLException {
        String sqlEmp = "insert into empleados(dni, nombre, sexo, categoria, anyosTrabajados) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sqlEmp)) {
            ps.setString(1, e.dni);
            ps.setString(2, e.nombre);
            ps.setString(3, String.valueOf(e.sexo));
            ps.setInt(4, e.getCategoria());
            ps.setInt(5, e.anyosTrabajados);
            ps.executeUpdate();
        }
    }
}