/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAW114
 */
public class MetodosFicheros {

    private static Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }

    //Metodo que lee cursos.csv y los inserta en una lista
    public static List<Curso> leerCSVCursos() {
        List<Curso> lista = new ArrayList<>();
        File fichero = new File("D:\\Usuarios\\DAW114\\Documents\\Proyecto_DAW1_Equipo4\\cursos.csv");
        FileReader fr;
        String linea = "";
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int id = Integer.parseInt(datoslinea[0]);
                    String codigo = datoslinea[1];
                    String descripcion = datoslinea[2];
                    Etapa etapa = Etapa.valueOf(datoslinea[3]);
                    boolean activo = formateoBoolean(datoslinea[4]);

                    Curso c = new Curso(id, codigo, descripcion, etapa, activo);
                    lista.add(c);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }
    //Metodo que lee departamentos.csv y los inserta en una lista

    public static List<Departamento> leerCSVDepartamentos() {
        List<Departamento> lista = new ArrayList<>();
        File fichero = new File("D:\\Usuarios\\DAW114\\Documents\\Proyecto_DAW1_Equipo4\\departamentos.csv");
        FileReader fr;
        String linea = "";
        int idJefe = 15;
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int id = Integer.parseInt(datoslinea[0]);
                    String codigo = datoslinea[1];
                    String nombre = datoslinea[2];

                    Departamento d = new Departamento(id, nombre, null, codigo);
                    lista.add(d);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que lee profesores.csv y los inserta en una lista
    public static List<Profesor> leerCSVProfesores() {
        List<Profesor> lista = new ArrayList<>();
        File fichero = new File("D:\\Usuarios\\DAW114\\Documents\\Proyecto_DAW1_Equipo4\\profesores.csv");
        FileReader fr;
        String linea = "";
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    String apellidos = datoslinea[0];
                    String nombre = datoslinea[1];
                    String dni = datoslinea[2];
                    String correoElectronico = datoslinea[3];
                    int codigoDepartamento = Integer.parseInt(datoslinea[4]);
                    Profesor p = new Profesor(0, dni, apellidos, nombre, correoElectronico, codigoDepartamento, false, false, EstadoProfesor.Activo);
                    lista.add(p);

                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que lee grupos.csv y los inserta en una lista
    public static List<Grupo> leerCSVGrupos() {
        List<Grupo> lista = new ArrayList<>();
        File fichero = new File("D:\\Usuarios\\DAW114\\Documents\\Proyecto_DAW1_Equipo4\\grupos.csv");
        FileReader fr;
        String linea = "";
        try {
            if (fichero.exists()) {
                fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] datoslinea = linea.split(",");
                    int id = Integer.parseInt(datoslinea[0]);
                    String codigo = datoslinea[1];
                    int idCurso = Integer.parseInt(datoslinea[2]);
                    int nAlumnos = Integer.parseInt(datoslinea[3]);
                    boolean activo = formateoBoolean(datoslinea[4]);
                    Grupo g = new Grupo(id, codigo, idCurso, nAlumnos, activo);
                    lista.add(g);
                }
                fr.close();
            }

        } catch (NullPointerException n) {
            System.out.println(n.getMessage());
        } catch (FileNotFoundException f) {
            System.out.println("Error, el archivo no existe");
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
        return lista;
    }

    //Metodo que formatea los booleanos
    private static boolean formateoBoolean(String cad) {

        return Integer.parseInt(cad) == 1 ? true : false;
    }
}
