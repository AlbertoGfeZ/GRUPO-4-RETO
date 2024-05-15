/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW114
 */
public class ProfesorDAOImp implements Repositorio<Profesor> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Profesor> listar() {
        List<Profesor> profesores = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM profesor");) {
            while (rs.next()) {
                Profesor profesor = crearProfesor(rs);
                if (!profesores.add(profesor)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return profesores;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Profesor porId(int id) {
        Profesor profesor = null;
        String sql = "SELECT * FROM profesor WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    profesor = crearProfesor(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return profesor;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Profesor profesor) {
        String sql = null;
        if (profesor.getId() > 0) {
            sql = "UPDATE profesor SET dni=?,apellidos=?,nombre=?,correo_institucional=?,cod_departamento=?,contraseña=?,activo=? WHERE id=?";
        } else {
            sql = "INSERT INTO profesor(dni,apellidos,nombre,correo_institucional,cod_departamento,contraseña,activo) VALUES (?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (profesor.getId() > 0) {
                stmt.setInt(8, profesor.getId());
            }
            stmt.setString(1, profesor.getDni());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getNombre());
            stmt.setString(4, profesor.getCorreoElectronico());
            stmt.setString(5, profesor.getCodigoDepartamento());
            stmt.setString(6, profesor.getContraseña());
            stmt.setString(7, profesor.getEstado().toString());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificarContraseña(String email, String contraseña) {
        String sql = null;
        sql = "UPDATE profesor SET contraseña=? WHERE correo_institucional=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, contraseña);
            stmt.setString(2, email);

            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // borrar en la base de datos por clave primaria
    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM profesor WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Profesor crearProfesor(final ResultSet rs) throws SQLException {
        return new Profesor(rs.getInt("id"), rs.getString("dni"), rs.getString("apellidos"), rs.getString("nombre"), rs.getString("correo_institucional"), rs.getString("contraseña"), rs.getString("cod_departamento"), false, false, EstadoProfesor.Activo);
    }
}
