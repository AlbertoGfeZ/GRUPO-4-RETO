/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosBD;

import metodosBD.AccesoBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import clases.ParticipacionProfesor;

/**
 *
 * @author Asier
 */
public class ParticipacionProfesorDAOImp implements Repositorio<ParticipacionProfesor> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<ParticipacionProfesor> listar() {
        List<ParticipacionProfesor> participacionprofesores = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM participacion_profesores");) {
            while (rs.next()) {
                ParticipacionProfesor participacionprofesor = crearParticipacionProfesor(rs);
                if (!participacionprofesores.add(participacionprofesor)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return participacionprofesores;
    }

    // recuperamos objeto por clave primaria
    @Override
    public ParticipacionProfesor porId(int id) {
        ParticipacionProfesor participacionprofesor = null;
        String sql = "SELECT * FROM participacion_profesores WHERE id_prof=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    participacionprofesor = crearParticipacionProfesor(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return participacionprofesor;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(ParticipacionProfesor participacionprofesor) {
        String sql = null;
        if (participacionprofesor.getIdProfesor() > 0) {
            sql = "UPDATE participacion_profesores SET id_actividad=?,rol=? WHERE id_prof=?";
        } else {
            sql = "INSERT INTO participacion_grupo(id_actividad,rol,id_prof) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (participacionprofesor.getIdProfesor() > 0) {
                stmt.setInt(3, participacionprofesor.getIdProfesor());
            }
            stmt.setInt(1, participacionprofesor.getIdActividad());
            stmt.setString(2, participacionprofesor.getRol());
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

        String sql = "DELETE FROM participacion_profesores WHERE id_prof=?";
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

    private ParticipacionProfesor crearParticipacionProfesor(final ResultSet rs) throws SQLException {
        return new ParticipacionProfesor(rs.getInt("id_actividad"), rs.getInt("id_prof"), rs.getString("rol"));
    }

}
