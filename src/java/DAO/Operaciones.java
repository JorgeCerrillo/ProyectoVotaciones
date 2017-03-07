/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Jorge
 */
import Modelo.Votante;
import Modelo.Partido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class Operaciones {

    public static boolean comprobarExistencia(Connection conexion, Votante votante) throws SQLException {
        boolean esta = false;
        String dni = votante.getDni();

        String query = "SELECT dni  "
                + "FROM votante "
                + "WHERE dni=?";

        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);

        ResultSet rs = prepStm.executeQuery();

        if (rs.next()) {
            esta = true;
        }
        return esta;
    }

    public static boolean comprobarVotado(Connection conexion, Votante votante) throws SQLException {
        boolean votado = false;
        String dni = votante.getDni();

        String query = "SELECT votado  "
                + "FROM votante "
                + "WHERE dni=?";

        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);

        ResultSet rs = prepStm.executeQuery();

        if (rs.next()) {
            votado = rs.getBoolean("votado");
        }
        return votado;
    }

    public static boolean login(Connection conexion, Votante votante) throws SQLException {
        boolean aceptado=false;
        String dni=votante.getDni();
        String contraseña=votante.getContraseña();
        
        String query = "SELECT id "
                + "FROM votante "
                + "WHERE dni=? AND AES_DECRYPT(contraseña,'jorge') = ? ";

        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);
        prepStm.setString(2, contraseña);

        ResultSet rs = prepStm.executeQuery();

        if (rs.next()) {
            aceptado=true;
        }
        
        
        return aceptado;
    }

    public static void registro(Connection conexion, Votante votante) throws SQLException {

        String dni = votante.getDni();
        String password = votante.getContraseña();

        String query = "Insert "
                + "INTO votante "
                + "VALUES (null , ? , AES_ENCRYPT(?,'jorge'),False)";

        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);
        prepStm.setString(2, password);

        prepStm.executeUpdate();

    }

    public static void baja(Connection conexion, Votante votante) throws SQLException {
        String dni = votante.getDni();
        String password = votante.getContraseña();

        String query = "DELETE "
                + "FROM votante "
                + "WHERE dni = ? "
                + " AND AES_DECRYPT(contraseña,'jorge') = ? ";

        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);
        prepStm.setString(2, password);

        prepStm.executeUpdate();
    }

    public static void actualizarVotante(Connection conexion, Votante votante) throws SQLException {
        String dni = votante.getDni();

        String query = "UPDATE votante "
                + "SET votado = true "
                + "WHERE dni= ?";
        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, dni);

        if (prepStm.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

    public static void aumentarVotos(Connection conexion, Partido partido) throws SQLException {

        String nombre = partido.getNombre();
//Statments s=Conexion.createStatement();
//resultado=s.executeUpdate("UPDATE partido "
//                + "SET votos = votos +1 "
//                + "WHERE nombre = ?";
        String query = "UPDATE partido "
                + "SET votos = votos +1 "
                + "WHERE nombre = ?";
        PreparedStatement prepStm = conexion.prepareStatement(query);
        prepStm.setString(1, nombre);

        if (prepStm.executeUpdate() == 0) {
            throw new SQLException();
        }
    }

    public static ArrayList<Votante> selectArray(Connection conexion) throws SQLException {
        String query = "SELECT id,dni, AES_DECRYPT(contraseña,'jorge') as contraseña , votado "
                + "FROM votante";
        PreparedStatement prepStm = conexion.prepareStatement(query);

        ResultSet rs = prepStm.executeQuery();
        ArrayList<Votante> votantes = new ArrayList();

        while (rs.next()) {
            votantes.add(new Votante(rs.getInt("id"), rs.getString("dni"), rs.getString("contraseña"), rs.getBoolean("votado")));
        }
        return votantes;

    }

    public static ArrayList<Partido> sacarVotos(Connection conexion) throws SQLException {
        String query = "SELECT * FROM partido order by votos DESC";

        PreparedStatement prepStm = conexion.prepareStatement(query);

        ResultSet rs = prepStm.executeQuery();
        ArrayList<Partido> partidos = new ArrayList();
        
        while (rs.next()){
            partidos.add(new Partido(rs.getInt("id"), rs.getString("nombre"), rs.getInt("votos")));
        }
        return partidos;
    }
}
