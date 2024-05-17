/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAW114
 */
public class Grupo {

    int id;
    String codigo;
    int idCurso;
    int nAlumnos;
    boolean activo;

    public Grupo(int id, String codigo, int idcurso, int nAlumnos, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.idCurso = idcurso;
        this.nAlumnos = nAlumnos;
        this.activo = activo;
    }

    public Grupo(String codigo, int idCurso, int nAlumnos, boolean activo) {
        this.codigo = codigo;
        this.idCurso = idCurso;
        this.nAlumnos = nAlumnos;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdcurso(int idcurso) {
        this.idCurso = idcurso;
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
