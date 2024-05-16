/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

/**
 *
 * @author Asier
 */
public class ParticipacionCurso {
    int idCurso;
    int idActividad;
    int nAlumnos;

    public ParticipacionCurso(int idCurso, int idActividad, int nAlumnos) {
        this.idCurso = idCurso;
        this.idActividad = idActividad;
        this.nAlumnos = nAlumnos;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
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
