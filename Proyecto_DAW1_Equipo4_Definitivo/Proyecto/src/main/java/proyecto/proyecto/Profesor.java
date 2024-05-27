/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import proyecto.proyecto.EstadoProfesor;

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
    String contraseña;
    String codigoDepartamento;
    EstadoProfesor estado;

    public Profesor(int id, String dni, String apellidos, String nombre, String correoElectronico, String contraseña, String codigoDepartamento, EstadoProfesor estado) {
        this.id = id;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.codigoDepartamento = codigoDepartamento;
        this.estado = estado;
    }

    public Profesor(String dni, String apellidos, String nombre, String correoElectronico, String contraseña, String codigoDepartamento, EstadoProfesor estado) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.codigoDepartamento = codigoDepartamento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public EstadoProfesor getEstado() {
        return estado;
    }

    public void setEstado(EstadoProfesor estado) {
        this.estado = estado;
    }

}
