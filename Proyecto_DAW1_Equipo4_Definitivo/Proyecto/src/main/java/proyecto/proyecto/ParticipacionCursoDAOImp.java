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
 * @author Asier
 */
public class ParticipacionCursoDAOImp implements Repositorio<ParticipacionCurso> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<ParticipacionCurso> listar() {
        List<ParticipacionCurso> participacioncursos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM participacion_curso");) {
            while (rs.next()) {
                ParticipacionCurso participacioncurso = crearParticipacionCurso(rs);
                if (!participacioncursos.add(participacioncurso)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return participacioncursos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public ParticipacionCurso porId(int id) {
        ParticipacionCurso participacioncurso = null;
        String sql = "SELECT * FROM participacion_curso WHERE id_curso=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    participacioncurso = crearParticipacionCurso(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return participacioncurso;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(ParticipacionCurso participacioncurso) {
        String sql = null;
        if (participacioncurso.getIdCurso() > 0) {
            sql = "UPDATE participacion_curso SET id_actividad=?,alumnos_participantes=? WHERE id_curso=?";
        } else {
            sql = "INSERT INTO participacion_curso(id_actividad,alumnos_participantes,id_curso) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (participacioncurso.getIdCurso() > 0) {
                stmt.setInt(3, participacioncurso.getIdCurso());
            }
            stmt.setInt(1, participacioncurso.getIdActividad());
            stmt.setInt(2, participacioncurso.getnAlumnos());
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

        String sql = "DELETE FROM participacion_curso WHERE id_curso=?";
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

    private ParticipacionCurso crearParticipacionCurso(final ResultSet rs) throws SQLException {
        return new ParticipacionCurso(rs.getInt("id_curso"), rs.getInt("id_actividad"), rs.getInt("alumnos_participantes"));
    }
    
}
