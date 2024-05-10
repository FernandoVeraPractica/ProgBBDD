/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebabbdd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class PruebaBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con;
        Statement sentencia;
        String sql;
        String url = "jdbc:mysql://localhost/instituto";
        //ResultSet rs;
        int numero = 3;
        String nombre = "Manolo";
        String curso = "2B";
        double notaMedia = 8.5;
        String fechaNac = "1990-04-19";
        try {
            con = DriverManager.getConnection(url, "root", "1234");
            //sql = "SELECT num, nombre, media, fnac FROM alumnos WHERE fnac > '2009-01-01'";
            //sql = "DELETE FROM alumnos WHERE nombre = 'Pepe'";
            //sql = "SELECT nombre, media FROM alumnos WHERE curso = ? AND media > ?";
            sql = "INSERT INTO alumnos (num, nombre, media, curso, fnac) VALUES (" + numero + ",'" + nombre + "'," + notaMedia + ",'" + curso + "','" + fechaNac + "')";
            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            // Creamos objeto tipo PreparedStatement
            /*PreparedStatement sentencia = con.prepareStatement(sql);
            // Asignamos los parámetros
            sentencia.setString(1,"1A");
            sentencia.setDouble(2,8);
            rs = sentencia.executeQuery();
            rs.next();
            String nombre = rs.getString("nombre");
            Double media = rs.getDouble("media");*/
            //sentencia = con.createStatement();
            /*rs = sentencia.executeQuery(sql);
            rs.next();
            int num = rs.getInt("num");
            String nombre = rs.getString("nombre");
            Date fechaNac = rs.getDate("fnac");*/
            //sentencia.executeUpdate(sql);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PruebaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
