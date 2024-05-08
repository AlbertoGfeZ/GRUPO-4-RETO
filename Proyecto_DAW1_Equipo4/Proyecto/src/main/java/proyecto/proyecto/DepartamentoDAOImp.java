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
public class DepartamentoDAOImp implements Repositorio<Departamento> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM departamento");) {
            while (rs.next()) {
                Departamento departamento = crearDepartamento(rs);
                if (!departamentos.add(departamento)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return departamentos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Departamento porId(int id) {
        Departamento departamento = null;
        String sql = "SELECT * FROM departamento WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return departamento;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Departamento departamento) {
        String sql = null;
        if (departamento.getId() > 0) {
            sql = "UPDATE departamento SET nombre=?,jefedepartamento=?,codigo=? WHERE id=?";
        } else {
            sql = "INSERT INTO departamento(nombre,jefedepartamento,codigo) VALUES (?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (departamento.getId() > 0) {
                stmt.setInt(4, departamento.getId());
            }
            stmt.setString(1, departamento.getNombre());
            stmt.setString(2, departamento.getJefeDepartamento());
            stmt.setString(3, departamento.getCodigo());
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

        String sql = "DELETE FROM departamento WHERE id=?";
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

    private Departamento crearDepartamento(final ResultSet rs) throws SQLException {
        return new Departamento(rs.getInt("id"), rs.getString("nombre"), rs.getString("jefedepartamento"), rs.getString("codigo"));
    }
}
