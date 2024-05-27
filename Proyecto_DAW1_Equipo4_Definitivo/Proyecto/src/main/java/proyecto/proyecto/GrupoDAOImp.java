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
public class GrupoDAOImp implements Repositorio<Grupo> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Grupo> listar() {
        List<Grupo> grupos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM grupo");) {
            while (rs.next()) {
                Grupo grupo = crearGrupo(rs);
                if (!grupos.add(grupo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return grupos;
    }

    // recuperamos objeto por clave primaria
    @Override
    public Grupo porId(int id) {
        Grupo grupo = null;
        String sql = "SELECT * FROM grupo WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    grupo = crearGrupo(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return grupo;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Grupo grupo) {
        String sql = null;
        if (grupo.getId() > 0) {
            sql = "UPDATE grupo SET activo=?,alumnos=?,cod_grupo=?,id_curso=? WHERE id=?";
        } else {
            sql = "INSERT INTO grupo(activo,alumnos,cod_grupo,id_curso) VALUES (?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (grupo.getId() > 0) {
                stmt.setInt(5, grupo.getId());
            }
            stmt.setBoolean(1, grupo.isActivo());
            stmt.setInt(2, grupo.getnAlumnos());
            stmt.setString(3, grupo.getCodigo());
            stmt.setInt(4, grupo.getIdCurso());
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

        String sql = "DELETE FROM grupo WHERE id=?";
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

    public void modificarNAlumnos(int nAlumnos, String codGrupo) {
        String sql = null;
        sql = "UPDATE profesor SET alumnos=? WHERE cod_grupo=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setInt(1, nAlumnos);
            stmt.setString(2, codGrupo);

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

    public void deshabilitar(String codGrupo) {
        String sql = null;
        sql = "UPDATE profesor SET activo=? WHERE cod_grupo=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setBoolean(1, false);
            stmt.setString(2, codGrupo);

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

    public void habilitar(String codGrupo) {
        String sql = null;
        sql = "UPDATE profesor SET activo=? WHERE cod_grupo=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setBoolean(1, true);
            stmt.setString(2, codGrupo);

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

    public void eliminar(String codGrupo) {

        String sql = "DELETE FROM grupo WHERE cod_grupo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, codGrupo);
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

    private Grupo crearGrupo(final ResultSet rs) throws SQLException {
        return new Grupo(rs.getInt("id"), rs.getString("cod_grupo"), rs.getInt("id_curso"), rs.getInt("alumnos"), rs.getBoolean("activo"));
    }

}
