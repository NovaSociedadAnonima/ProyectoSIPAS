package proyectofinal2;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProyectoFinal2 {

    public static int UsuarioAdmin = 1234;
    public static int ContraseñaAdmin = 1234;
    public static int UsuarioGeneralDocente = 1234;
    public static int ContraseñaUsuario = 1234;
    public static Scanner Tl = new Scanner(System.in);

    public static Alumno AlumnoN = new Alumno("santiago", "soto", 1234);
    public static Profesor ProfesorN = new Profesor("s", "s", 1);
    public static Materia MateriaN = new Materia("a", ProfesorN, 1);
    public static Curso CursoN = new Curso(123, "Informatica", 2);

    public static ArrayList<Curso> Cursos = new ArrayList<>();
    public static ArrayList<Alumno> Alumnos = new ArrayList<>();
    public static ArrayList<Profesor> Profesores = new ArrayList<>();
    public static ArrayList<Materia> Materias = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, AWTException {
        //Mini datos de prueba
        IngresoDatosPrueba();

        MenuPrincipal();

    }

    public static void MenuPrincipal() {
        System.out.println("[1]Para ingresar al modo admin");
        System.out.println("[2]Para ingresar al modo docente");
        switch (Tl.nextInt()) {
            case 1:
                IngresoDeAdmin();
                break;
            case 2:
                IngresoDeDocente();
                break;
        }

    }

    public static void IngresoDeAdmin() {
        int user;
        int pass;

        System.out.println("Ingrese el usuario de admin");
        user = Tl.nextInt();
        if (user == UsuarioAdmin) {
            System.out.println("Usuario correcto");

            System.out.println("Ingrese el contraseña de admin");
            pass = Tl.nextInt();
            if (pass == ContraseñaAdmin) {
                System.out.println("Contraseña correcta");

                Admin();

            }
            if (pass != ContraseñaAdmin) {
                System.out.println("Contraseña Incorrecta");
                IngresoDeAdmin();

            }

        }
        if (user != UsuarioAdmin) {
            System.out.println("Usuario incorrecto");
            IngresoDeAdmin();

        }

    }

    public static void IngresoDeDocente() {

        int user;
        int pass;

        System.out.println("Ingrese el usuario de docente");
        user = Tl.nextInt();
        if (UsuarioGeneralDocente == user) {
            System.out.println("Usuario correcto");

            System.out.println("Ingrese el Contraseña de docente");

            pass = Tl.nextInt();

            if (pass == ContraseñaUsuario) {
                System.out.println("Contraseña correcta");

            }
            if (pass != ContraseñaUsuario) {
                System.out.println("contraseña incorrecta");

            }
        }
        if (UsuarioGeneralDocente != user) {
            System.out.println("Usuario incorrecto");

        }

        MenuDocente();

    }

    public static void Admin() {
        MenuAdmin();
    }

    public static void MostrandoAlumnos(int ID) {
        int a = 0;
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getIdCurso() == ID) {
                a = i;
            }
        }
        for (int i = 0; i < Cursos.get(a).getMaterias().size(); i++) {
            System.out.println("Nombre:" + Cursos.get(a).getAlumnos().get(i).getNombre() + " Apellido:" + Cursos.get(a).getAlumnos().get(i).getApellido() + " #CI:" + Cursos.get(a).getAlumnos().get(i).getCI());
        }
    }

    public static void MenuDocente() {
        System.out.println("Para pasar lista ingrese [1]");
        System.out.println("Para mostrar lista de alumnos completa ingrese [2]");
        System.out.println("Para volver al menu principal [3]");
        switch (Tl.nextInt()) {
            case 1:
                PasandoLista();
                break;
            case 2:
                MostrandoListaCompleta();
                break;
            case 3:
                MenuPrincipal();
        }
    }

    public static void PasandoLista() {
        int cc = 0;
        MostrandoCursos();
        System.out.println("Ingrese ID de lista a pasar");
        int Ing;
        Ing = Tl.nextInt();
        //Busco la posicion del curso
        int LCurso = 0;
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getIdCurso() == Ing) {
                LCurso = i;
            }
        }
        MostrandoMaterias(LCurso);
        String NombreMateria;
        System.out.println("Ingrese el nombre de la materia a pasar lista");
        NombreMateria = Tl.next();
        int cortador = 1;

        //Busco la materia a la que quiere pasarse la lista
        int LMateria = 0;
        for (int i = 0; i < Cursos.get(LCurso).getMaterias().size(); i++) {
            if (Cursos.get(LCurso).getMaterias().get(i).getNombre().equals(NombreMateria)) {
                LMateria = i;
            }
        }
        ArrayList NoPresentes2 = new ArrayList();
        String alumFalt;
        while (cortador == 1) {
            for (int i = 0; i < Cursos.get(LCurso).getMaterias().size(); i++) {
                System.out.println("Nombre:" + Cursos.get(LCurso).getAlumnos().get(i).getNombre() + " Apellido:" + Cursos.get(LCurso).getAlumnos().get(i).getApellido() + " #CI:" + Cursos.get(LCurso).getAlumnos().get(i).getCI());
            }
            System.out.println("Ingrese la nombre del alumno faltante");
            alumFalt = Tl.next();
            int LAlmunF = 0;
            for (int i = 0; i < Alumnos.size(); i++) {
                if (Alumnos.get(i).getNombre().equals(alumFalt)) {
                    LAlmunF = i;
                }
            }
            System.out.println("Si desea ingresar ingresar otro alumno faltante ingrese 1 y si no quiere ingrese 2");
            switch (Tl.nextInt()) {
                case 1:
                    Cursos.get(LCurso).getMaterias().get(LMateria).getAlumnosFaltantes().add(Alumnos.get(LAlmunF));
                    break;
                case 2:
                    cortador++;
                    Cursos.get(LCurso).getMaterias().get(LMateria).getAlumnosFaltantes().add(Alumnos.get(LAlmunF));
                    break;
            }

        }
        System.out.println("Todas las faltas de los alumnos faltantes fueron ingresadas con exito");
        System.out.println("##################");
        MenuDocente();
    }

    public static void MostrandoCursos() {
        System.out.println("#################");
        System.out.println("Lista de cursos");
        System.out.println("#################");
        for (int i = 0; i < Cursos.size(); i++) {
            System.out.println("Nombre de curso:" + Cursos.get(i).getNombreCurso() + "  #####ID:" + Cursos.get(i).getIdCurso());

        }
    }

    public static void MostrandoListaCompleta() {
        MostrandoCursos();
        System.out.println("Ingrese ID de lista a mostrar");
        int Ing;
        Ing = Tl.nextInt();
        int DireccionCurs = 0;
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getIdCurso() == Ing) {
                DireccionCurs = i;

            }
        }
        System.out.println("#################");
        System.out.println("Alumnos en el curso");
        System.out.println("#################");
        for (int i = 0; i < Cursos.get(DireccionCurs).getAlumnos().size(); i++) {
            System.out.println("Nombre: " + Cursos.get(DireccionCurs).getAlumnos().get(i).getNombre() + " #Apellido: " + Cursos.get(DireccionCurs).getAlumnos().get(i).getApellido());
        }
        System.out.println("##################");
        MenuDocente();
    }

    public static void MenuAdmin() {

        System.out.println("Para ingresar alumnos ingrese [1]");
        System.out.println("Para ingresar Profesor ingrese [2]");
        System.out.println("Para agregar un nuevo curso desde cero ingrese [3]");
        System.out.println("Para volver al menu principal [5]");
        switch (Tl.nextInt()) {
            case 1:
                IngresandoAlumnos();
                break;
            case 2:
                IngresandoProfesores();
                break;
            case 3:
                IngresandoCurso();
                break;
            case 4:
                IngresandoMateria();
            case 5:
                MenuPrincipal();
        }
    }

    public static void IngresandoMateria() {
        String a;
        System.out.println("Ingrese el nombre de la materia");
        MateriaN.setNombre(Tl.next());
        System.out.println("Ingrese nombre del profesor que la va a dar(Si el profesor es nuevo ingrese 1 y si  ya existe ingrese 0");
        switch (Tl.nextInt()) {
            case 1:
                System.out.println("Ingrese el nombre del Profesor a ingresar");
                ProfesorN.setNombre(Tl.next());
                System.out.println("Ingrese el apellido del Profesor a ingresar");
                ProfesorN.setApellido(Tl.next());
                System.out.println("Ingrese la cedula del Profesor a ingresar");
                ProfesorN.setCi(Tl.nextInt());
                Profesores.add(ProfesorN);
                MateriaN.setProfesorE(ProfesorN);
                break;
            case 2:
                System.out.println("Ingrese el nombre del profesor que quiere ingresar");
                a = Tl.next();
                for (int i = 0; i < Profesores.size(); i++) {
                    if (Profesores.get(i).getNombre().equals(a)) {
                        MateriaN.setProfesorE(Profesores.get(i));
                    }
                }
                break;
        }
        System.out.println("Ingrese el id del curso al cual pertenece");
        MostrandoCursos();
        MateriaN.setIdCurso(Tl.nextInt());
        System.out.println("####################");
        MenuAdmin();
    }

    public static void IngresandoAlumnos() {
        System.out.println("Ingrese el nombre del alumno a ingresar");
        AlumnoN.setNombre(Tl.next());
        System.out.println("Ingrese el apellido del alumno a ingresar");
        AlumnoN.setApellido(Tl.next());
        System.out.println("Ingrese la cedula del alumno a ingresar");
        AlumnoN.setCI(Tl.nextInt());
        int d = 0;

        System.out.println("Ingrese el Id del curso donde desea ingresarlo");
        d = Tl.nextInt();
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getIdCurso() == d) {
                Cursos.get(i).getAlumnos().add(AlumnoN);
                System.out.println("El alumno fue ingresado con exito al curso");
            }
        }
        System.out.println("##################");
        MenuAdmin();
    }

    public static void MostrandoMaterias(int IdCurso) {
        for (int i = 0; i < Cursos.get(IdCurso).getMaterias().size(); i++) {
            System.out.println("Nombre de materia: " + Cursos.get(IdCurso).getMaterias().get(i).getNombre());
        }
    }

    public static void IngresandoProfesores() {

        System.out.println("Ingrese el nombre del Profesor a ingresar");
        ProfesorN.setNombre(Tl.next());
        System.out.println("Ingrese el apellido del Profesor a ingresar");
        ProfesorN.setApellido(Tl.next());
        System.out.println("Ingrese la cedula del Profesor a ingresar");
        ProfesorN.setCi(Tl.nextInt());
        for (int i = 0; i < Materias.size(); i++) {
            System.out.println("Nombre de materia" + Materias.get(i).getNombre());
        }
        String g = "s";
        System.out.println("Ingrese el nombre de la materia que va a dar");
        g = Tl.next();
        for (int i = 0; i < Materias.size(); i++) {
            if (Materias.get(i).getNombre().equals(g)) {
                Materias.get(i).setProfesorE(ProfesorN);
            }
        }
        System.out.println("El docente con su respectiva materia fue ingresado correctamente");

        System.out.println("################");
        MenuAdmin();

    }

    public static void IngresandoCurso() {
        int cortador = 1;
        while (cortador == 1) {
            System.out.println("ingrese el nombre del curso");
            CursoN.setNombreCurso(Tl.next());
            System.out.println("ingrese GCurso");
            CursoN.setGradoCurso(Tl.nextInt());

            System.out.println("Para ingresar mas Cursos ingrese 1 y para no ingresar mas ingrese 0");
            if (Tl.nextInt() == 1) {
                Cursos.add(CursoN);

                MenuAdmin();
            } else if (Tl.nextInt() == 0) {
                Cursos.add(CursoN);
                cortador++;
            }
        }
        System.out.println("################");
        MenuAdmin();
    }

    public static void IngresoDatosPrueba() {
        //Alumnos
        Alumno Alumn = new Alumno("Esteban", "Quito", 5439);
        Alumno Alumn2 = new Alumno("Paula", "Soto", 17653);
        Alumno Alumn3 = new Alumno("Julieta", "Garcia", 7223);
        Alumno Alumn4 = new Alumno("Yuumi", "Morales", 1543);
        Alumno Alumn5 = new Alumno("kevin", "Sosa", 1673);
        Alumno Alumn6 = new Alumno("Manuel", "Soso", 12293);
        Alumnos.add(Alumn);
        Alumnos.add(Alumn2);
        Alumnos.add(Alumn3);
        Alumnos.add(Alumn4);
        Alumnos.add(Alumn5);
        Alumnos.add(Alumn6);
        Alumnos.add(AlumnoN);
        //Cursos
        Curso Curso3 = new Curso(124, "Deporte(Monos)", 3);
        Cursos.add(CursoN);
        Cursos.add(Curso3);
        Cursos.get(0).setAlumnos(Alumnos);
        //Profesores
        Profesor NewProfe = new Profesor("Sebastian", "Torres", 1553);
        Profesor NewProfe2 = new Profesor("Natalia", "Torres", 5131);
        Profesor NewProfe3 = new Profesor("Gaston", "Gonzales", 1213);

        //Materias
        Materia NewMateria = new Materia("Programacion", NewProfe, 123);
        Materia NewMateria2 = new Materia("Sistemas Operativos", NewProfe2, 123);
        Materia NewMateria3 = new Materia("EduFisica", NewProfe3, 124);
        Cursos.get(0).getMaterias().add(NewMateria);
        Cursos.get(0).getMaterias().add(NewMateria2);
        Cursos.get(1).getMaterias().add(NewMateria3);
    }
}
