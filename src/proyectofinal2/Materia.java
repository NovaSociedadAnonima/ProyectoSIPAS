package proyectofinal2;

import java.util.ArrayList;

public class Materia {

    private String Nombre;
    private Profesor ProfesorE;

    private ArrayList<Alumno> NoPresentes = new ArrayList<>(); //FIXED (creo) después decime -Fabri

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

    public ArrayList<Alumno> getNoPresentes() {
        return NoPresentes;
    }

    public void setNoPresentes(ArrayList<Alumno> NoPresentes) {
        this.NoPresentes = NoPresentes;
    }

}
