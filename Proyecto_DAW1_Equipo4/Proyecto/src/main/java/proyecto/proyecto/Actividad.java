/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import proyecto.proyecto.EstadoActividad;
import java.time.LocalDate;

/**
 *
 * @author DAW114
 */
public class Actividad extends Solicitud {

    Fotos[] fotos;

    public Actividad(Fotos[] fotos, int id, String idProfesorSolicitante, int idDepartamento, String titulo, boolean prevista, LocalDate fechaInicio, LocalDate fechaFin, int nAlumnos, Transporte[] transporte, boolean alojamiento, Profesor[] profesoresResponsables, Profesor[] profesoresParticipantes, String descripcion, EstadoActividad estado) {
        super(id, idProfesorSolicitante, idDepartamento, titulo, prevista, fechaInicio, fechaFin, nAlumnos, transporte, alojamiento, profesoresResponsables, profesoresParticipantes, descripcion, estado);
        this.fotos = fotos;
    }

    public Fotos[] getFotos() {
        return fotos;
    }

    public void setFotos(Fotos[] fotos) {
        this.fotos = fotos;
    }

}
