import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculaNominas {
    private static void escribe(Empleado empleado){
        System.out.println("Empleado: +"+empleado+", Sueldo: "+Nomina.sueldo(empleado));
    }

     public static void main(String [] args){
        try {
            /**
             * Creo el main con 2 empleados, imprimo sus datos y luego cambio atributos, seguidamente
             * los vuelvo a imprimir
             */
            Empleado e1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
            Empleado e2 = new Empleado("Ada Lovelace", "32000031R", 'F');
            escribe(e1);
            escribe(e2);

            e2.incrAnyo();
            e1.setCategoria(9);

            escribe(e1);
            escribe(e2);
        }catch(DatosNoEncontradosException e){
            System.out.println("Datos no encontrados");
            System.exit(1);
        }

        List<Empleado> lista=new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader("empleados.txt"))){
            String linea;
            while((linea = br.readLine())!=null){
                String[] d= linea.split(";");
                Empleado e= new Empleado(d[0], d[1], d[2].charAt(0), Integer.parseInt(d[3]), Integer.parseInt(d[4]));
                lista.add(e);
            }
        } catch (DatosNoEncontradosException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

     }
}
