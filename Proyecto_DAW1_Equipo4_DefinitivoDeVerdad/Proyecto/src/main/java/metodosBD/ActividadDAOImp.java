/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosBD;

import metodosBD.AccesoBaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import clases.Actividad;
import Enums.EstadoActividad;
import clases.Solicitud;

/**
 *
 * @author Asier
 */
public class ActividadDAOImp implements Repositorio<Actividad> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    // recuperamos todos los registros de la bd
    @Override
    public List<Actividad> listar() {
        List<Actividad> actividades = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM actividad_programada");) {
            while (rs.next()) {
                Actividad actividad = crearActividad(rs);
                if (!actividades.add(actividad)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return actividades;
    }

    public SortedSet<Solicitud> listarOrdenado() {
        SortedSet<Solicitud> solicitudes = new TreeSet<>();
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
    public Actividad porId(int id) {
        Actividad actividad = null;
        String sql = "SELECT * FROM actividad_programada WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    actividad = crearActividad(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return actividad;
    }

    public boolean comprobarporId(int id) {
        boolean comprobar = false;
        Actividad actividad = null;
        String sql = "SELECT * FROM actividad_programada WHERE id_actividad=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                comprobar = true;
                if (rs.next()) {
                    actividad = crearActividad(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return comprobar;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    @Override
    public void guardar(Actividad actividad) {
        String sql = null;
        sql = "INSERT INTO actividad_programada(estado,id_actividad) VALUES (?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (actividad.getId() > 0) {
                stmt.setInt(2, actividad.getId());
            }
            stmt.setString(1, actividad.getEstado().toString());
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

        String sql = "DELETE FROM actividad_programada WHERE id_actividad=?";
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

    private Actividad crearActividad(final ResultSet rs) throws SQLException {
        return new Actividad(rs.getString("comentario_alojamiento"), rs.getInt("id"), rs.getInt("departamento"), rs.getString("titulo"), rs.getBoolean("prevista"), rs.getDate("f_ini").toLocalDate(), rs.getDate("f_fin").toLocalDate(), rs.getTime("h_ini").toLocalTime(), rs.getTime("h_fin").toLocalTime(), rs.getBoolean("alojamiento"), rs.getString("tipo"), EstadoActividad.Aprobada);
    }

    public List<Solicitud> listarSolicitud() {
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
    public Solicitud porIdSolicitud(int id) {
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

    public Solicitud porTituloSolicitud(String titulo) {
        Solicitud solicitud = null;
        String sql = "SELECT * FROM actividad_solicitada WHERE titulo=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setString(1, titulo);
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
    public void guardarSolicitud(Solicitud solicitud) {
        String sql = null;
        if (solicitud.getId() > 0) {
            sql = "UPDATE actividad_solicitada SET departamento=?,f_ini=?,f_fin=?,h_ini=?,h_ini=?,estado=?,prevista=?,tipo=?,titulo=?,alojamiento=? WHERE id=?";
        } else {
            sql = "INSERT INTO actividad_solicitada(departamento,f_ini,f_fin,h_ini,h_fin,estado,prevista,tipo,titulo,alojamiento) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (solicitud.getId() > 0) {
                stmt.setInt(11, solicitud.getId());
            }
            stmt.setInt(1, solicitud.getIdDepartamento());
            stmt.setDate(2, Date.valueOf(solicitud.getFechaInicio()));
            stmt.setDate(3, Date.valueOf(solicitud.getFechaFin()));
            stmt.setTime(4, Time.valueOf(solicitud.getHoraInicio()));
            stmt.setTime(5, Time.valueOf(solicitud.getHoraFin()));
            stmt.setString(6, solicitud.getEstado().toString());
            stmt.setBoolean(7, solicitud.isPrevista());
            stmt.setString(8, solicitud.getTipo());
            stmt.setString(9, solicitud.getTitulo());
            stmt.setBoolean(10, solicitud.isAlojamiento());
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
    public void eliminarSolicitud(int id) {

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

    public void modificarEstadoSolicitud(String estado, int id) {
        String sql = null;
        sql = "UPDATE actividad_solicitada SET estado=? WHERE id=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, estado);
            stmt.setInt(2, id);

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

    public void modificarComentario(String comentario, int id) {
        String sql = null;
        sql = "UPDATE actividad_programada SET comentario_alojamiento=? WHERE id_actividad=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, comentario);
            stmt.setInt(2, id);

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

    public void modificarEstado(String estado, int id) {
        String sql = null;
        sql = "UPDATE actividad_programada SET estado=? WHERE id_actividad=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, estado);
            stmt.setInt(2, id);

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

    public void completarActividad(int id) {
        String sql = null;
        sql = "UPDATE actividad_programada SET estado=? WHERE id_actividad=?";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, EstadoActividad.Realizada.toString());
            stmt.setInt(2, id);

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

    private Solicitud crearSolicitud(final ResultSet rs) throws SQLException {
        return new Solicitud(rs.getInt("id"), rs.getInt("departamento"), rs.getString("titulo"), rs.getBoolean("prevista"), rs.getDate("f_ini").toLocalDate(), rs.getDate("f_fin").toLocalDate(), rs.getTime("h_ini").toLocalTime(), rs.getTime("h_fin").toLocalTime(), rs.getBoolean("alojamiento"), rs.getString("tipo"), EstadoActividad.Solicitado);
    }
}
