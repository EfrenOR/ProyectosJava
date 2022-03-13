
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
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
    combobx Vista: JPI_AgregarProducto*/
    public ArrayList<String> cargarProveedores(){
        
        String DBProveedor = null;
        ArrayList<String> Proveedores = new ArrayList<String>();

        PreparedStatement ps;
        String sql;
        
        try{
            sql = "SELECT *FROM proveedores";
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getRow()>0){
                    rs = ps.executeQuery();
                    while(rs.next()){
                        DBProveedor = rs.getString("Empresa");
                        Proveedores.add(DBProveedor);
                    }
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
        return Proveedores;
    }
    
    
    /*AGREGAR PRODUCTOS*/
    public void agregarProductos(){
                
        PreparedStatement ps;
        String sql;
        
        ///PRIMERO IDENTIFICO LOS ID DE LA MARCA Y EL PROVEEDOR SELECCIONADO EN LOS COMBOBOX///
        int BDIdMarca = 0;
        int BDIdProveedor = 0;
        
        try{
            sql="SELECT Codigo FROM marca WHERE Nombre=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, this.Marca);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getRow()>0){
                    rs = ps.executeQuery();
                    while(rs.next()){
                        BDIdMarca = rs.getInt("Codigo");
                    }
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        try{
            sql="SELECT Codigo FROM proveedores WHERE Empresa=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, this.Proveedor);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getRow()>0){
                    rs = ps.executeQuery();
                    while(rs.next()){
                        BDIdProveedor = rs.getInt("Codigo");
                    }
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
        /////////////////////////////////////////////////////////////////////7
        
        
        //OBTENER LA FECHA ACTUAL//////////////////////
        SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy"); //Establecer Formato para mostrar la fecha
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String Fecha = DF.format(dateObj);
        ///////////////////////////////////////////////
        
        try{
            sql = "INSERT INTO productos(Fecha, Nombre, Unidades, Descripcion, Proveedores_Codigo, Marca_Codigo) VALUES(?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, Fecha);
            ps.setString(2, this.Nombre);
            ps.setInt(3, this.Unidades);
            ps.setString(4, this.Descripcion);
            
            /*Paso como parametros los ID de la marca y proeveedor seleccionados porque estos son llaves foranesas en 
            la BD*/
            ps.setInt(5, BDIdProveedor);
            ps.setInt(6, BDIdMarca); 

            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro nuevo agregado");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
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
            SQL = "UPDATE " + table +" SET Codigo=?, Nombre=?, Unidades=?, Marca_Codigo=? WHERE Codigo=? " ;
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
