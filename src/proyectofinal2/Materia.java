package proyectofinal2;

import java.util.ArrayList;

public class Materia {

    
    private int IdCurso;
    private String Nombre;
    private Profesor ProfesorE;

    private ArrayList<Integer> NoPresentes = new ArrayList();

    public Materia(String Nombre, Profesor ProfesorE, int IdCurso) {
        this.Nombre = Nombre;
        this.ProfesorE = ProfesorE;
        this.IdCurso = IdCurso;
    }
public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
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
