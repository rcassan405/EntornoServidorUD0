import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDAO {

    private static Connection con;
    public EmpleadoDAO(Connection con) {
        this.con=con;
    }

    public static void insertaEmpleado(Empleado e)throws SQLException {
        String sqlEmp="insert into empleados(dni, nombre, sexo, categoria, anyos) values ?, ?, ?, ?, ?";
        String sqlNom="insert into nominas(dni, sueldo) values (?, ?) on duplicate key update sueldo = ?";

        try(PreparedStatement ps= con.prepareStatement(sqlEmp)){
            ps.setString(1, e.dni);
            ps.setString(2, e.nombre);
            ps.setString(3, String.valueOf(e.sexo));
            ps.setInt(4, e.getCategoria());
            ps.setInt(5, e.anyosTrabajados);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar al empleado");
        }finally{
            con.close();
        }
        try(PreparedStatement ps = con.prepareStatement(sqlNom)){
            ps.setString(1, e.dni);
            ps.setDouble(2, Nomina.sueldo(e));
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar la nomina");
        }finally{
            con.close();
        }
    }

    public static void altaEmpleado(Empleado e) throws SQLException{
        String sqlEmp="insert into empleados(dni, nombre, sexo, categoria, anyos) values ?, ?, ?, ?, ?";
        try(PreparedStatement ps= con.prepareStatement(sqlEmp)){
            ps.setString(1, e.dni);
            ps.setString(2, e.nombre);
            ps.setString(3, String.valueOf(e.sexo));
            ps.setInt(4, e.getCategoria());
            ps.setInt(5, e.anyosTrabajados);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al insertar al empleado");
        }finally{
            con.close();
        }
    }

}
