package ProyectoFinAño;

import java.awt.AWTException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProyectoFinAño {

    public static int UsuarioAdmin = 1234;
    public static int ContraseñaAdmin = 1234;
    public static int UsuarioGeneralDocente = 1234;
    public static int ContraseñaUsuario = 1234;
    public static Scanner Tl = new Scanner(System.in);

    public static Alumno AlumnoN = new Alumno("santiago", "soto", 1234);
    public static Profesor ProfesorN = new Profesor("s", "s", 1);

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

    public static void MenuDocente() {
        System.out.println("Para pasar lista ingrese [1]");
        System.out.println("Para mostrar lista de alumnos completa ingrese [2]");
        System.out.println("Ingresar llegada tarde de alumno");
        switch (Tl.nextInt()) {
            case 1:
                PasandoLista();
                break;
            case 2:
                MostrandoListaCompleta();
                break;
            case 3:
                IngresoLlegadaTarde();
                break;
        }
    }

    public static void IngresoLlegadaTarde() {
        String MateriaTarde;
        int AluLlegoTarde;
        int Lm;
        System.out.println("Ingrese el nombre de la materia a la que se llego tarde");
        MateriaTarde = Tl.next();
        System.out.println("Ingrese la Ci del alumno que llego tarde ");
        AluLlegoTarde = Tl.nextInt();
        for (int i = 0; i < Materias.size(); i++) {
            if (Materias.get(i).getNombre().equals(MateriaTarde)) {
                Lm = i;
            }
        }
//        for (int i = 0; i < Materias.size(); i++) {
//            for (int j = 0; j < Materias.size(); j++) {
//                 if(Materias.get(i).getNoPresentes().get(j)==MateriaTarde){
//                     Materias.get(i).getNoPresentes().get(j)
//                 }
//            }
//           
//        }

//Lo sigo cuando llegue a casa
    }

    public static void PasandoLista() {
        System.out.println("#################");
        System.out.println("Lista de cursos");
        System.out.println("#################");
        for (int i = 0; i < Cursos.size(); i++) {
            System.out.println("Nombre de curso:" + Cursos.get(i).getNombreCurso() + "  #####ID:" + Cursos.get(i).getIdCurso());

        }
        System.out.println("Ingrese ID de lista a pasar");
        int Ing;
        Ing = Tl.nextInt();
        int DireccionCurs = 0;
        for (int i = 0; i < Cursos.size(); i++) {
            if (Cursos.get(i).getIdCurso() == Ing) {
                DireccionCurs = i;

            }

        }
        String MateriaP;
        System.out.println("Ingrese nombre de materia a pasar lista");
        MateriaP = Tl.next();
        int DireMateriaC = 0;
        int DireMateriaM = 0;

        for (int i = 0; i < Cursos.size(); i++) {
            for (int j = 0; j < Cursos.get(i).getMaterias().size(); j++) {
                if (Cursos.get(i).getMaterias().get(j).getNombre().equals(MateriaP)) {
                    DireMateriaC = i;
                    DireMateriaM = j;
                }
            }

        }

        System.out.println("#################");
        System.out.println("Alumnos en el curso");
        System.out.println("#################");
        for (int i = 0; i < Cursos.get(DireccionCurs).getAlumnos().size(); i++) {
            System.out.println("Nombre: " + Cursos.get(DireccionCurs).getAlumnos().get(i).getNombre() + " #Apellido: " + Cursos.get(DireccionCurs).getAlumnos().get(i).getApellido() + " ###CI:" + Cursos.get(DireccionCurs).getAlumnos().get(i).getCI());

        }
        int cortador = 1;
        int p;
        System.out.println("Si estan todos presentes ingrese 1 y si faltan ingrese 2");
        p = Tl.nextInt();

        if (p == 2) {
            while (cortador == 1) {
                System.out.println("Ingrese Ci de los alumnos que no estan presentes");
                Ing = Tl.nextInt();
////                Cursos.get(DireMateriaC).getMaterias().get(DireMateriaM).getNoPresentes().add(Ing);   //Se como arreglarlo pero estoy probando otra cosa,luego lo cambio
                System.out.println("Si quiere ingresar mas alumnos faltantes ingrese 1 y si no ingrese 0");
                Ing = Tl.nextInt();
                if (Ing == 0) {
                    cortador++;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(Cursos.get(DireMateriaC).getMaterias().get(DireMateriaM).getNoPresentes().get(i));
            System.out.println("s");
        }
        System.out.println("#################");
        System.out.println("Alumnos faltantes");
        System.out.println("#################");
        for (int i = 0; i < Cursos.get(DireMateriaC).getMaterias().get(DireMateriaM).getNoPresentes().size(); i++) {

            //if (Cursos.get(DireMateriaC).getMaterias().get(DireMateriaM).getNoPresentes().get(i).equals(121)) {
            //  }
        }
    }

    public static void MostrandoListaCompleta() {
        System.out.println("#################");
        System.out.println("Lista de cursos");
        System.out.println("#################");
        for (int i = 0; i < Cursos.size(); i++) {
            System.out.println("Nombre de curso:" + Cursos.get(i).getNombreCurso() + "  #####ID:" + Cursos.get(i).getIdCurso());

        }
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
    }

    public static void MenuAdmin() {

        System.out.println("Para ingresar alumnos ingrese 1");
        System.out.println("Para ingresar Profesor ingrese 2");
        System.out.println("Para agregar un nuevo curso desde cero ingrese 3");
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
        }
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

    }

    public static void IngresandoProfesores() {
        int cortador = 1;
        while (cortador == 1) {
            System.out.println("Ingrese el nombre del alumno a ingresar");
            ProfesorN.setNombre(Tl.next());
            System.out.println("Ingrese el apellido del alumno a ingresar");
            ProfesorN.setApellido(Tl.next());
            System.out.println("Ingrese la cedula del alumno a ingresar");
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
            System.out.println("Para ingresar mas profesor ingrese 1 y para no ingresar mas ingrese 0");
            if (Tl.nextInt() == 1) {
                Profesores.add(ProfesorN);
                cortador++;
                MenuAdmin();
            } else if (Tl.nextInt() == 0) {
                Profesores.add(ProfesorN);
            }
        }
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
                cortador++;
                MenuAdmin();
            } else if (Tl.nextInt() == 0) {
                Cursos.add(CursoN);
            }
        }

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

