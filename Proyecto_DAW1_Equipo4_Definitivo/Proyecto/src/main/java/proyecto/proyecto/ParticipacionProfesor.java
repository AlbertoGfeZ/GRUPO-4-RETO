/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

/**
 *
 * @author Asier
 */
public class ParticipacionProfesor {

    int idActividad;
    int idProfesor;
    String rol;

    public ParticipacionProfesor(int idActividad, int idProfesor, String rol) {
        this.idActividad = idActividad;
        this.idProfesor = idProfesor;
        this.rol = rol;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
