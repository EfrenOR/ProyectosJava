
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class JPI_Modelo {
    
    JPI_Conexion JPIC = new JPI_Conexion();
    Connection con = JPIC.getConexion();
    
    private int ID;
    private String constraseña;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }
    
    public boolean autenticar(){
        
        PreparedStatement ps;
        String sql;
        
        try{
            sql = "SELECT *FROM usuarios WHERE ID=? and Contraseña=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, this.ID);
            ps.setString(2, this.constraseña);
            
            ResultSet rs =ps.executeQuery();
            if(!rs.next()){
               JOptionPane.showMessageDialog(null, "El usuario no Existe");
            }else{
                return true;
            }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
        return false;
    }
}
