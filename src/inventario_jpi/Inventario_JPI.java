
package inventario_jpi;

import Controlador.JPI_Controlador;
import Modelo.JPI_Conexion;
import Modelo.JPI_Modelo;
import Vista.JPI_AgregarProducto;
import Vista.JPI_Inventario;
import Vista.JPI_Inventario;
import Vista.JPI_Login;
import java.sql.Connection;


public class Inventario_JPI {

   
    public static void main(String[] args) {
       
       
       JPI_Login JPI_L = new JPI_Login();
       JPI_Inventario JPI_I = new JPI_Inventario();
       JPI_AgregarProducto JPI_AP = new JPI_AgregarProducto();
       JPI_Modelo JPI_M = new JPI_Modelo();
       
       JPI_Controlador JPI_C = new JPI_Controlador(JPI_L, JPI_M, JPI_I, JPI_AP);
       JPI_C.viewLogin.setVisible(true);
    }
    
}
