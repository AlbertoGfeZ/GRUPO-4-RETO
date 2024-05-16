/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import proyecto.proyecto.EstadoActividad;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author DAW114
 */
public class Actividad extends Solicitud {

    public String comentario;
    public Actividad(String comentario, int id, int idDepartamento, String titulo, boolean prevista, LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, boolean alojamiento, String tipo, EstadoActividad estado) {
        super(id, idDepartamento, titulo, prevista, fechaInicio, fechaFin, horaInicio, horaFin, alojamiento, tipo, estado);
        this.comentario = comentario;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
