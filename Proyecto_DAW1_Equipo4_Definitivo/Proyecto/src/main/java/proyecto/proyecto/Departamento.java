/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

/**
 *
 * @author DAW114
 */
public class Departamento {

    int id;
    String nombre;
    int jefeDepartamento;
    String codigo;

    public Departamento(int id, String nombre, int jefeDepartamento, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.jefeDepartamento = jefeDepartamento;
        this.codigo = codigo;
    }

    public Departamento(String nombre, int jefeDepartamento, String codigo) {
        this.nombre = nombre;
        this.jefeDepartamento = jefeDepartamento;
        this.codigo = codigo;
    }

    public Departamento(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getJefeDepartamento() {
        return jefeDepartamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJefeDepartamento(int jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
