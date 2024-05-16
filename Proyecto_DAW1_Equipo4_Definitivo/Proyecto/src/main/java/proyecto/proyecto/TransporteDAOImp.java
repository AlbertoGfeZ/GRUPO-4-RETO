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
public class TransporteDAOImp implements Repositorio<Transporte> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Transporte> listar() {
        List<Transporte> transportes = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM transporte");) {
            while (rs.next()) {
                Transporte transporte = crearTransporte(rs);
                if (!transportes.add(transporte)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return transportes;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Transporte porId(int id) {
        Transporte transporte = null;
        String sql = "SELECT * FROM transporte WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    transporte = crearTransporte(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return transporte;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Transporte transporte) {
        String sql = null;
        if (transporte.getIdActividad() > 0) {
            sql = "UPDATE transporte SET id_empresa=?,tipo=?,comentarios=?,importe=? WHERE id_actividad=?";
        } else {
            sql = "INSERT INTO transporte(id_empresa,tipo,comentarios,importe,id_actividad) VALUES (?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (transporte.getIdActividad() > 0) {
                stmt.setInt(4, transporte.getIdActividad());
            }
            stmt.setInt(1, transporte.getIdEmpresa());
            stmt.setString(2, transporte.getTipo());
            stmt.setString(3, transporte.getDescripcion());
            stmt.setDouble(4, transporte.getPrecio());
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

        String sql = "DELETE FROM trasnporte WHERE id_actividad=?";
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

    private Transporte crearTransporte(final ResultSet rs) throws SQLException {
        return new Transporte(rs.getString("tipo"), rs.getInt("id_empresa"), rs.getDouble("importe"), rs.getString("descripcion"), rs.getInt("id_actividad"));
    }
}
