/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto.proyecto;

import java.util.List;

/**
 *
 * @author DAW114
 */
// definir una interfaz genérica 
//La interfaz nos define métodos como create, read, update y delete (CRUD)
public interface Repositorio<T> {
    // método para listar todos los objetos T
    // para listar todos los registros de una tabla

    public List<T> listar();
    // método para recuperar un objeto por su ID
    // nos recupera un registro de la base de datos por clave primaria

    public T porId(int id);
    // método en este caso puede ser tanto para realizar la inserción o modificación de un objeto
    // aunque también se pueden crear un método para añadir un objeto y otro para modificar
    // inserta un registro en la tabla o bien lo modifica

    public void guardar(T t);
    // método para borrar un objeto por su ID
    // nos permite borrar un registro de la base de datos por clave primaria

    public void eliminar(int id);
}
