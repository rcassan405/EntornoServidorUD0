public class Nomina {
    private static final int SUELDO_BASE[]={50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

    public static double sueldo(Empleado empleado){
        int categoria=empleado.getCategoria()-1;
        double sueldoBase=SUELDO_BASE[categoria];
        double sueldo = sueldoBase +5000*empleado.anyosTrabajados;
        return sueldo;
    }
}
