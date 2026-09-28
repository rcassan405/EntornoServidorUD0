import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculaNominas {

    private static void escribe(Empleado empleado) {
        System.out.println("Empleado: " + empleado + ", Sueldo: " + Nomina.sueldo(empleado));
    }

    public static void main(String[] args) {
        // 1. Pruebas iniciales de empleados
        try {
            Empleado e1 = new Empleado("James Gosling", "32000032G", "M", 4, 7);
            Empleado e2 = new Empleado("Ada Lovelace", "32000031R", "F");
            escribe(e1);
            escribe(e2);

            e2.incrAnyo();
            e1.setCategoria(9);

            escribe(e1);
            escribe(e2);
        } catch (DatosNoEncontradosException e) {
            System.out.println("Datos no encontrados: " + e.getMessage());
            System.exit(1);
        }

        // 2. Lectura del fichero empleados.txt
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                Empleado e = new Empleado(d[0], d[1], d[2], Integer.parseInt(d[3]), Integer.parseInt(d[4]));
                lista.add(e);
            }
        } catch (DatosNoEncontradosException | IOException e) {
            System.err.println("Aviso al leer empleados.txt: " + e.getMessage());
        }

        // 3. Operaciones en la base de datos con EmpleadoDAO
        try (Connection con = Conexion.getConexion()) {
            EmpleadoDAO dao = new EmpleadoDAO(con);

            Empleado e1 = new Empleado("James Gosling", "32000032G", "M", 4, 7);
            Empleado e2 = new Empleado("Ada Lovelace", "32000031R", "F");

            dao.insertaEmpleado(e1);
            dao.insertaEmpleado(e2);
            System.out.println("Datos insertados correctamente");

            Empleado nuevo = crearEmpleado();
            dao.altaEmpleado(nuevo);
            System.out.println("Nuevo empleado dado de alta correctamente");

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (DatosNoEncontradosException e) {
            System.out.println("Error al validar datos del empleado: " + e.getMessage());
        }
    }

    public static Empleado crearEmpleado() throws DatosNoEncontradosException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el dni del empleado: ");
        String dni = sc.nextLine();
        System.out.print("Introduce el sexo del empleado: ");
        String sexo = sc.nextLine();
        System.out.print("Introduce la categoria del empleado: ");
        int categoria = Integer.parseInt(sc.nextLine());
        System.out.print("Introduce los años trabajados del empleado: ");
        int anyos = Integer.parseInt(sc.nextLine());

        return new Empleado(nombre, dni, sexo, categoria, anyos);
    }
}