/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package proyecto.proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DAW114
 */
public class Proyecto {

    public static void main(String[] args) {
        try (Connection conn = AccesoBaseDatos.getInstance().getConn()) {

            Repositorio<Grupo> repositorio = new GrupoDAOImp();
            List<Grupo> lista = repositorio.listar();
            if (lista.isEmpty()) {
                System.out.println("Todavia no hay datos..");
            } else {
                for (Grupo grupo : lista) {
                    System.out.println(grupo.toString());
                }
            }
        } catch (SQLException ex) {
            System.out.println("error sql" + ex.getMessage());
        }

    }
}
