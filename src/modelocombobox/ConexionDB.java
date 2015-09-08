/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelocombobox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para conectarse a una base de datos y almacenar los resultados
 * en un ArrayList denominado arregloCiudades.
 * @author danierfresley
 */
public class ConexionDB {
    
    private String sql;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    private List<Ciudades> arregloCiudades;

    public ConexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Registra el Diver de conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost/datos","root",""); //Con el Driver cargado realiza la conexión de la URL especificada. 
            sql = "select idciudad, nombre_ciudad from ciudades;"; //la variable almacena la instrucción SQL
            pst = conn.prepareStatement(sql); // se prepara la instrucción SQL con sus respectivos parametros si es necesario.
            rs = pst.executeQuery(); // inicia la ejecución de la instrucción en la base de datos.
            arregloCiudades = new ArrayList<Ciudades>();
            while(rs.next()){
                arregloCiudades.add(new Ciudades(rs.getInt("idciudad"), rs.getString("nombre_ciudad")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(pst!=null) pst.close();
                if(rs!=null) rs.close();
                if(conn!=null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
      public List getArregloCiudades() {
        return arregloCiudades;
    }
    

  }
