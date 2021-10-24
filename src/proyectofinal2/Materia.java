package proyectofinal2;

import java.util.ArrayList;

public class Materia {

    private String Nombre;
    private Profesor ProfesorE;

    private ArrayList NoPresentes = new ArrayList();

    public Materia(String Nombre, Profesor ProfesorE) {
        this.Nombre = Nombre;
        this.ProfesorE = ProfesorE;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Profesor getProfesorE() {
        return ProfesorE;
    }

    public void setProfesorE(Profesor ProfesorE) {
        this.ProfesorE = ProfesorE;
    }

    public ArrayList getNoPresentes() {
        return NoPresentes;
    }

    public void setNoPresentes(ArrayList NoPresentes) {
        this.NoPresentes = NoPresentes;
    }

}
