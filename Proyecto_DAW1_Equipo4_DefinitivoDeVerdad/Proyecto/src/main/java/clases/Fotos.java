/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author DAW114
 */
public class Fotos {

    String url;
    String descripcion;
    int id_actividad;

    public Fotos(String url, String descripcion, int id_actividad) {
        this.url = url;
        this.descripcion = descripcion;
        this.id_actividad= id_actividad;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }
    
}
