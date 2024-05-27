/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import proyecto.proyecto.AccesoBaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW114
 */
public class MetodosBD {

    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    public String listarContraseña() {
        String contraseña = "";
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM profesor");) {
            while (rs.next()) {
                contraseña = rs.getString("contraseña");

            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return contraseña;
    }
    public String listarUsuario() {
        String usuario = "";
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM profesor");) {
            while (rs.next()) {
                usuario = rs.getString("correo_institucional");

            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
}
