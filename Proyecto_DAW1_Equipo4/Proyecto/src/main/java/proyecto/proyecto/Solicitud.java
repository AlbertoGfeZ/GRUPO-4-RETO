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
public class Solicitud {

    int id;
    String idProfesorSolicitante;
    int idDepartamento;
    String titulo;
    boolean prevista;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    int nAlumnos;
    Transporte[] transporte;
    boolean alojamiento;
    Profesor[] profesoresResponsables;
    Profesor[] profesoresParticipantes;
    String descripcion;
    EstadoActividad estado;

    public Solicitud(int id, String idProfesorSolicitante, int idDepartamento, String titulo, boolean prevista, LocalDate fechaInicio, LocalDate fechaFin, int nAlumnos, Transporte[] transporte, boolean alojamiento, Profesor[] profesoresResponsables, Profesor[] profesoresParticipantes, String descripcion, EstadoActividad estado) {
        this.id = id;
        this.idProfesorSolicitante = idProfesorSolicitante;
        this.idDepartamento = idDepartamento;
        this.titulo = titulo;
        this.prevista = prevista;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nAlumnos = nAlumnos;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.profesoresResponsables = profesoresResponsables;
        this.profesoresParticipantes = profesoresParticipantes;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getIdProfesorSolicitante() {
        return idProfesorSolicitante;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrevista() {
        return prevista;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public Transporte[] getTransporte() {
        return transporte;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public Profesor[] getProfesoresResponsables() {
        return profesoresResponsables;
    }

    public Profesor[] getProfesoresParticipantes() {
        return profesoresParticipantes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProfesorSolicitante(String idProfesorSolicitante) {
        this.idProfesorSolicitante = idProfesorSolicitante;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrevista(boolean prevista) {
        this.prevista = prevista;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public void setTransporte(Transporte[] transporte) {
        this.transporte = transporte;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public void setProfesoresResponsables(Profesor[] profesoresResponsables) {
        this.profesoresResponsables = profesoresResponsables;
    }

    public void setProfesoresParticipantes(Profesor[] profesoresParticipantes) {
        this.profesoresParticipantes = profesoresParticipantes;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }
    
}
