/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal2;

/**
 *
 * @author Santi
 */
public class Profesor {
     private String Nombre;
    private String Apellido;
    private int Ci;

public  Profesor(){}

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
