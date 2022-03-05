
package inventario_jpi;

import Modelo.JPI_Conexion;
import java.sql.Connection;


public class Inventario_JPI {

   
    public static void main(String[] args) {
        
        JPI_Conexion conecta = new JPI_Conexion();    
        Connection con=conecta.getConexion();
    }
    
}
