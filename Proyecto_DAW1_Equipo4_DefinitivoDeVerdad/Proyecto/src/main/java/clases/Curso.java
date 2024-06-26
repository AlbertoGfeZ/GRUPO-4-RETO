/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enums.Etapa;
import Enums.Etapa;

/**
 *
 * @author DAW114
 */
public class Curso {

    int id;
    String codigo;
    String descripcion;
    Etapa etapa;
    boolean activo;

    /**
     * Constructor que pasa todos los parametros
     * @param id
     * @param codigo
     * @param descripcion
     * @param etapa
     * @param activo 
     */
    
    public Curso(int id, String codigo, String descripcion, Etapa etapa, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }

    public Curso(String codigo, String descripcion, Etapa etapa, boolean activo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.etapa = etapa;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
