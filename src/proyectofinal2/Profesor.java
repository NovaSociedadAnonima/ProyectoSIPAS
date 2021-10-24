
package proyectofinal2;

public class Profesor {

    private String Nombre;
    private String Apellido;
    private int Ci;

    public Profesor(String Nombre, String Apellido, int Ci) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Ci = Ci;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getCi() {
        return Ci;
    }

    public void setCi(int Ci) {
        this.Ci = Ci;
    }
}
