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
public class SolicitudesDAOImp implements Repositorio<Solicitud> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Solicitud> listar() {
        List<Solicitud> solicitudes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM actividad_solicitada");) {
            while (rs.next()) {
                Solicitud solicitud = crearSolicitud(rs);
                if (!solicitudes.add(solicitud)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return solicitudes;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Solicitud porId(int id) {
        Solicitud solicitud = null;
        String sql = "SELECT * FROM actividad_solicitada WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    solicitud = crearSolicitud(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return solicitud;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Solicitud solicitud) {
        String sql = null;
        if (solicitud.getId() > 0) {
            sql = "UPDATE actividad_solicitada SET activo=?,numero_alumnos=?,codigo=?,idcurso=? WHERE id=?";
        } else {
            sql = "INSERT INTO actividad_solicitada(activo,numero_alumnos,codigo,idcurso) VALUES (?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (solicitud.getId() > 0) {
                stmt.setInt(5, solicitud.getId());
            }
            stmt.setBoolean(1, solicitud.isActivo());
            stmt.setInt(2, solicitud.getnAlumnos());
            stmt.setString(3, solicitud.getCodigo());
            stmt.setInt(4, solicitud.getIdCurso());
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

        String sql = "DELETE FROM actividad_solicitada WHERE id=?";
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

    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
        return new Solicitud(rs.getInt("id"), rs.getString("codigo"), rs.getInt("idcurso"), rs.getInt("numero_alumnos"), rs.getBoolean("activo"));
    }
}
