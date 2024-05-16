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
public class ParticipacionGrupoDAOImp implements Repositorio<ParticipacionGrupo> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<ParticipacionGrupo> listar() {
        List<ParticipacionGrupo> participaciongrupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM participacion_grupo");) {
            while (rs.next()) {
                ParticipacionGrupo participaciongrupo = crearParticipacionGrupo(rs);
                if (!participaciongrupos.add(participaciongrupo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return participaciongrupos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public ParticipacionGrupo porId(int id) {
        ParticipacionGrupo participaciongrupo = null;
        String sql = "SELECT * FROM participacion_grupo WHERE id_grupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    participaciongrupo = crearParticipacionGrupo(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return participaciongrupo;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(ParticipacionGrupo participaciongrupo) {
        String sql = null;
        if (participaciongrupo.getIdGrupo() > 0) {
            sql = "UPDATE participacion_grupo SET id_actividad=?,alumnos_participantes=? WHERE id_grupo=?";
        } else {
            sql = "INSERT INTO participacion_grupo(id_actividad,alumnos_participantes,id_grupo) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (participaciongrupo.getIdGrupo() > 0) {
                stmt.setInt(3, participaciongrupo.getIdGrupo());
            }
            stmt.setInt(1, participaciongrupo.getIdActividad());
            stmt.setInt(2, participaciongrupo.getnAlumnos());
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

        String sql = "DELETE FROM participacion_grupo WHERE id_curso=?";
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

    private ParticipacionGrupo crearParticipacionGrupo(final ResultSet rs) throws SQLException {
        return new ParticipacionGrupo(rs.getInt("id_grupo"), rs.getInt("id_actividad"), rs.getInt("alumnos_participantes"));
    }
    
}
