/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

/**
 *
 * @author DAW114
 */
public class Profesor {

    int id;
    String dni;
    String apellidos;
    String nombre;
    String correoElectronico;
    int codigoDepartamento;
    boolean equipoDirectivo;
    boolean administrador;
    EstadoProfesor estado;

    public Profesor(int id, String dni, String apellidos, String nombre, String correoElectronico, int codigoDepartamento, boolean equipoDirectivo, boolean administrador, EstadoProfesor estado) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.codigoDepartamento = codigoDepartamento;
        this.equipoDirectivo = equipoDirectivo;
        this.administrador = administrador;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public boolean isEquipoDirectivo() {
        return equipoDirectivo;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public EstadoProfesor getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public void setEquipoDirectivo(boolean equipoDirectivo) {
        this.equipoDirectivo = equipoDirectivo;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public void setEstado(EstadoProfesor estado) {
        this.estado = estado;
    }
    
}
