/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jorge
 */
public class ConexionBBDD {
     private static ConexionBBDD UnicaConexion = null;
    private Connection con;

    private String driver = "com.mysql.jdbc.Driver",
//            url = "jdbc:mysql://localhost/votaciones_jcm",
//            user = "root",
//            password = "root";
            
            url = "jdbc:mysql://mysql13834-votacionesjcm.jelastic.cloudhosted.es/votaciones_jcm",
            user = "root",
            password="ZRGfla55855";
            
            
    private ConexionBBDD() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
    }

    public synchronized static ConexionBBDD init() throws ClassNotFoundException, SQLException {
        if (UnicaConexion == null) {
            UnicaConexion = new ConexionBBDD();
        }

        return UnicaConexion;
    }

    public Connection GetCon() {
        return con;
    }

    public void destroy() throws SQLException {

        if (con != null) {

            con.close();
            con = null;

        }
    }
}
