public class CalculaNominas {
    private static void escribe(Empleado empleado){
        System.out.println("Empleado: +"+empleado+", Sueldo: "+Nomina.sueldo(empleado));
    }

    public static void main(String [] args){
        Empleado e1=new Empleado("James Cosling", "32000032G", 'M', 4, 7);
        Empleado e2=new Empleado("Ada Lovelace", "32000031R", 'F');
        escribe(e1);
        escribe(e2);

        e2.incrAnyo();
        e1.setCategoria(9);

        escribe(e1);
        escribe(e2);
    }
}
