/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

/**
 *
 * @author DAW114
 */
public class Grupo {

    String codigo;
    int nAlumnos;
    boolean activo;

    public Grupo(String codigo, int nAlumnos, boolean activo) {
        this.codigo = codigo;
        this.nAlumnos = nAlumnos;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
