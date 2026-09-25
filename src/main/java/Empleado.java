public class Empleado extends Persona{

    /**
     * Creo la clase empleado heredando los atributos de la clase main.Persona, ademas, creo los atributos categoria y anyosTrabajados. Tambien creo un metodo para imprimir los datos
     */
    private int categoria;
    public int anyosTrabajados;

    public Empleado(String nombre, String dni, String sexo, int categoria, int anyosTrabajados) throws DatosNoEncontradosException{
        super(nombre, dni, sexo);
        if(categoria>0&&categoria<10){
            this.categoria=categoria;
        }else{
            categoria=1;
        }
        if(anyosTrabajados>0){
            this.anyosTrabajados=anyosTrabajados;
        }else{
            anyosTrabajados=0;
        }
    }

    public Empleado(String nombre, String dni, String sexo) throws DatosNoEncontradosException{
        super(nombre, dni, sexo);
        categoria=1;
        anyosTrabajados=0;
    }

    public void setCategoria(int categoria){
        this.categoria=categoria;
    }
    public int getCategoria(){
        return categoria;
    }

    public void incrAnyo(){
        anyosTrabajados++;
    }

    public void imprime(){
        System.out.println("Nombre: "+nombre+", DNI: "+dni+", Sexo: "+sexo+", Categoria: "+categoria+", Años trabajados: "+anyosTrabajados);
    }

    @Override
    public String toString() {
        return "main.java.Empleado{" +
                "categoria=" + categoria +
                ", anyosTrabajados=" + anyosTrabajados +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
