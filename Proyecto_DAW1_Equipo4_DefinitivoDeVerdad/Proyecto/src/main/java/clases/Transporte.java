/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAW114
 */
public class Transporte {

    String tipo;
    int idEmpresa;
    double precio;
    String descripcion;
    int idActividad;

    public Transporte(String tipo, int idEmpresa, double precio, String descripcion, int idActividad) {
        this.tipo = tipo;
        this.idEmpresa = idEmpresa;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idActividad = idActividad;
    }

    public Transporte(String tipo, double precio, String descripcion, int idActividad) {
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idActividad = idActividad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

}
