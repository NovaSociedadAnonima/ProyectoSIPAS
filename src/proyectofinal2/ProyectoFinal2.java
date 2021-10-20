/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public static Profesor ProfesorN = new Profesor();

    public static Curso CursoN = new Curso(123, "Informatica", 2);

    public static ArrayList<Curso> Cursos = new ArrayList<>();
    public static ArrayList<Alumno> Alumnos = new ArrayList<>();
    public static ArrayList<Profesor> Profesores = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, AWTException {
        //Mini datos de prueba
        Alumno Alumn = new Alumno("Nacho", "Ghan", 123);
        Alumnos.add(Alumn);
        Alumnos.add(AlumnoN);
        Curso Curso3 = new Curso(124, "Deporte(Monos)", 3);
        Cursos.add(CursoN);
        Cursos.add(Curso3);
        Cursos.get(0).setAlumnos(Alumnos);
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
        int cortador1 = 0;
        int cortador2 = 0;

        while (cortador1 == 0) {
            System.out.println("Ingrese el usuario de admin");
            if (Tl.nextInt() == UsuarioAdmin) {
                System.out.println("Usuario correcto");
                cortador1++;

            }
            if (Tl.nextInt() != UsuarioAdmin) {
                System.out.println("Usuario incorrecto");

            }

        }
        while (cortador2 == 0) {
            System.out.println("Ingrese el contraseña de admin");
            if (Tl.nextInt() == ContraseñaAdmin) {
                System.out.println("contraseña correcto");
                cortador2++;

            }
            if (Tl.nextInt() != ContraseñaAdmin) {
                System.out.println("contraseña incorrecto");

            }

        }
        Admin();
    }

    public static void IngresoDeDocente() {
        int cortador1 = 0;
        int cortador2 = 0;

        while (cortador1 == 0) {
            System.out.println("Ingrese el usuario de docente");

            if (UsuarioGeneralDocente == Tl.nextInt()) {
                System.out.println("Usuario correcto");
                cortador1++;

            }
            if (UsuarioGeneralDocente != Tl.nextInt()) {
                System.out.println("contraseña incorrecto");

            }
        }

        while (cortador2 == 0) {
            System.out.println("Ingrese el Contraseña de docente");
            if (Tl.nextInt() == ContraseñaUsuario) {
                System.out.println("Contraseña correcta");
                cortador2++;
            }
            if (Tl.nextInt() != ContraseñaUsuario) {
                System.out.println("contraseña incorrecta");

            }

        }
        MenuDocente();
    }

    public static void Admin() {
        MenuAdmin();
    }

    public static void MenuDocente() {
        System.out.println("Para pasar lista ingrese [1]");
        System.out.println("Para mostrar lista de alumnos completa ingrese [2]");
        switch (Tl.nextInt()) {
            case 1:
                PasandoLista();
                break;
            case 2:
                MostrandoListaCompleta();
                break;
        }
    }

    public static void PasandoLista() {

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
            System.out.println("Nombre: "+Cursos.get(DireccionCurs).getAlumnos().get(i).getNombre()+" #Apellido: "+Cursos.get(DireccionCurs).getAlumnos().get(i).getApellido());
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
        System.out.println("Desearia ingresarlo en un curso ya creado[1],ingresarlo en un nuevo cursos[2] o no ingresarlo en ningun curso");
//        switch(Tl.nextInt()){
//           // case 1:IngresandoAluCursoCreado();
//            break;
//            case 2:NuevoCursoIngresandoAlum();
//            break;
//            case 3:System.out.println("Alumno registrado en alumnos globales");Admin();
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

}
