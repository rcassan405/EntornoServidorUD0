public class Persona{
    /**
     * Creo la clase persona y le doy atributos
     */
    public String nombre, dni, sexo;


    public Persona(String nombre, String dni, String sexo){
        this.nombre=nombre;
        this.dni=dni;
        this.sexo=sexo;
    }
    public Persona(String nombre, String sexo){
        this.nombre=nombre;
        this.sexo=sexo;
    }

    public void setDni(String dni){
        this.dni=dni;
    }

    public void imprimeNombreDNI(){
        System.out.println("Nombre: "+nombre+" , DNI: "+dni);
    }


}