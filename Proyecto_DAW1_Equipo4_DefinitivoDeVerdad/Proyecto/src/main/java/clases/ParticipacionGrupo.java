/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Asier
 */
public class ParticipacionGrupo {
    int idGrupo;
    int idActividad;
    int nAlumnos;

    public ParticipacionGrupo(int idGrupo, int idActividad, int nAlumnos) {
        this.idGrupo = idGrupo;
        this.idActividad = idActividad;
        this.nAlumnos = nAlumnos;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }
    
}
