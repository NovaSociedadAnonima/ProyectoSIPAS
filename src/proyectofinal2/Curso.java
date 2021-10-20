package proyectofinal2;

import java.util.ArrayList;

class Curso {

    private int IdCurso;
    private String NombreCurso;
    private int GradoCurso;
    private ArrayList<Alumno> Alumnos = new ArrayList<>();

    public Curso(int IdCurso, String NombreCurso, int GradoCurso) {
        this.IdCurso = IdCurso;
        this.NombreCurso = NombreCurso;
        this.GradoCurso = GradoCurso;

    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public int getGradoCurso() {
        return GradoCurso;
    }

    public void setGradoCurso(int GradoCurso) {
        this.GradoCurso = GradoCurso;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public ArrayList<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> Alumnos) {
        this.Alumnos = Alumnos;
    }

}
