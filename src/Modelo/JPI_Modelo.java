
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class JPI_Modelo {
    
    JPI_Conexion JPIC = new JPI_Conexion();
    Connection con = JPIC.getConexion();
    
    private int ID;
    private String constraseña;
    private String Nombre;
    private String Descripcion;
    private String Marca;
    private int Unidades;
    private String Proveedor; 
    
    
    private String SQL;
    private String table;
    private Statement sentencia;
    private ResultSet rst;
    private PreparedStatement preparar;
    private int res;

    public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }    
    
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
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

    /*Cargar las opciones de las diferentes marcas del los productos al
    ComboBox Vista: JPI_AgregarProducto*/
    public ArrayList<String> cargarMarcas(){
        
        String DBMarca = null;
        ArrayList<String> Marcas = new ArrayList<String>();

        PreparedStatement ps;
        String sql;
        
        try{
            sql = "SELECT *FROM marca";
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getRow()>0){
                    rs = ps.executeQuery();
                    while(rs.next()){
                        DBMarca = rs.getString("Nombre");
                        Marcas.add(DBMarca);
                    }
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
        return Marcas;
    }
    
    /*Cargar las opciones de los diferentes proveedores de los productos al
    combobx Vista: JPI_AgregarProducto
    public String cargarProveedores(){
        String DBProveedores = null;
        
        PreparedStatement ps;
        String sql;
        
        try{
            sql = "SELECT *FROM marca";
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getRow()>0){
                    rs = ps.executeQuery();
                    while(rs.next()){
                        DBMarca = rs.getString("Nombre");                        
                    }
                }
            }
        }catch(SQLException e){
        
        }
   
        return null;
    }
    */
    /*AGREGAR PRODUCTOS*/
    public void agregarProductos(){
        
        
    }

    public void ConsultarDatos(String nombreTabla){
		
	table = nombreTabla;
	try {
            sentencia = con.createStatement();
            SQL = "SELECT * FROM " + table +";" ;
            rst = sentencia.executeQuery(SQL);
            //rst.beforeFirst();
	}catch (SQLException e) {
            System.out.print("error: " + e.toString() + "\n" + SQL);
	}
    }
    
    public void ModificarDatos(String nombreTabla, String Datos[]){
		
        table = nombreTabla;
	try {
            sentencia = con.createStatement();
            SQL = "UPDATE " + table +" SET Codigo=?, Descripcion=?, Unidades=?, Marca_Codigo=? WHERE Codigo=? " ;
            preparar = con.prepareStatement(SQL);
                       
            preparar.setString(1, Datos[0]);
            preparar.setString(2, Datos[1]);
            preparar.setString(3, Datos[2]);
            preparar.setString(4, Datos[3]);
            preparar.setString(5, Datos[0]);
                        
            res = preparar.executeUpdate();
            preparar.close();
        }catch (SQLException e) {
            System.out.print("error: " + e.toString() + "\n" + SQL);
        }
    }
        
}
