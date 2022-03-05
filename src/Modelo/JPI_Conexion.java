package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JPI_Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/db_jpi";
    public static final String USER = "root";
    public static final String PASSWORD ="1234";
    
    public Connection getConexion(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        
        return con;
    }    
}
