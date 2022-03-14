
package Controlador;

import Modelo.JPI_Modelo;
import Vista.JPI_AgregarProducto;
import Vista.JPI_Inventario;
import Vista.JPI_Login;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class JPI_Controlador implements ActionListener, MouseListener{

    public boolean bandera = false;
    public String Datos[] = new String[5];
    public JPI_Login viewLogin;
    public JPI_Inventario viewInv;
    public JPI_AgregarProducto viewAddProduct;
    public JPI_Modelo model;    
    
    public JPI_Controlador(JPI_Login vL, JPI_Modelo m, JPI_Inventario vI, JPI_AgregarProducto vAddPro){
        this.model = m;
        this.viewLogin= vL;
        this.viewInv = vI;
        this.viewAddProduct = vAddPro;
        this.viewLogin.btnAcceder.addActionListener(this);
        this.viewInv.btnAgregar.addActionListener(this);
        this.viewAddProduct.btnGuardar.addActionListener(this);
        this.viewInv.btnBuscar.addActionListener(this);

        this.viewInv.jTable1.addMouseListener(this);

        this.viewInv.btnSalir.addMouseListener(this);
        this.viewInv.btnCategoria1.addMouseListener(this);
        this.viewInv.btnCategoria2.addMouseListener(this);
        this.viewInv.btnCategoria3.addMouseListener(this);
        this.viewInv.btnCategoria4.addMouseListener(this);
        this.viewInv.btnFiltrar.addMouseListener(this);

        this.viewAddProduct.btnCategoria1.addMouseListener(this);
        this.viewAddProduct.btnCategoria2.addMouseListener(this);
        this.viewAddProduct.btnCategoria3.addMouseListener(this);
        this.viewAddProduct.btnCategoria4.addMouseListener(this);
        this.viewAddProduct.btnSalir1.addMouseListener(this);
        this.viewAddProduct.btnback.addMouseListener(this);


        MostrarDatos();
        MostrarRegistroTabla();
        btnTabla();
        viewInv.jTable1.setEnabled(false);
    }
    
    
    /*Limpiar Cajas de Texto de la vista JPI_AgregarProductos*/
    public void limpiarCajasText(){
        viewAddProduct.txtNombre.setText("");
        viewAddProduct.txtDescripcion.setText("");
        viewAddProduct.txtUnidades.setText("");
        viewAddProduct.CBoxProveedor.setSelectedIndex(0);
        viewAddProduct.CBoxMarca.setSelectedIndex(0);
        viewAddProduct.CBoxCategoria.setSelectedIndex(0);
    }
    
    public void llenarComboBox(){
        viewAddProduct.CBoxCategoria.removeAllItems();
        viewAddProduct.CBoxMarca.removeAllItems();
        viewAddProduct.CBoxProveedor.removeAllItems();
        viewAddProduct.CBoxMarca.addItem("-- Marcas --");
        viewAddProduct.CBoxProveedor.addItem("-- Proveedores --");
        viewAddProduct.CBoxCategoria.addItem("-- Categorias --");

                
        ArrayList<String> Marcas = new ArrayList<String>();
        ArrayList<String> Proveedores = new ArrayList<String>();
        ArrayList<String> Categorias = new ArrayList<String>();
              
        Marcas = model.cargarMarcas();
        for(int i=0; i<Marcas.size(); i++){
            viewAddProduct.CBoxMarca.addItem(Marcas.get(i));
        }
                
        Proveedores = model.cargarProveedores();
        for(int i=0; i<Proveedores.size(); i++){
            viewAddProduct.CBoxProveedor.addItem(Proveedores.get(i));
        }
                
        Categorias = model.cargarCategorias();
        for(int i=0; i<Categorias.size(); i++){
            viewAddProduct.CBoxCategoria.addItem(Categorias.get(i));
        }                    
    }
    
    
    /*Clase para darle las funciones correspondientes a cada uno de 
    los botones de las vistas*/
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==viewInv.btnBuscar){
            if(viewInv.txtBuscar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese el Nombre de un Producto");
            }else{
                model.Buscar(viewInv.txtBuscar.getText());
                MostrarDatos();
                MostrarRegistroTabla_Buscar();
                btnTabla();
            }
        }
        
        switch(e.getActionCommand()){
            case "ACCEDER":
                
                if(viewLogin.txtID.getText().equals("")||viewLogin.txtContraseña.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingrese todos los Datos");
                }else{
                    model.setID(Integer.parseInt(viewLogin.txtID.getText()));
                    model.setConstraseña(viewLogin.txtContraseña.getText());

                    boolean res = model.autenticar();
                    if(res == true){

                        viewLogin.setVisible(false);
                        viewInv.setVisible(true);

                        MostrarRegistroTabla();


                        /*Llenamos el ComboBox de Filtros con las categorias que hay 
                        en la tabla categorias de la BD*/

                        viewInv.CBoxFiltro.removeAllItems();//Reinciamos el comboBox cada que se inicio el sistema.
                        viewInv.CBoxFiltro.addItem("-- Filtros --");

                        ArrayList<String> Categorias = new ArrayList<String>();

                        Categorias = model.cargarCategorias();//Método que obtinene todas las categoriad de la BD
                            for(int i=0; i<Categorias.size(); i++){
                            viewInv.CBoxFiltro.addItem(Categorias.get(i)); //Se llena el ComboBox
                        }
                    }    
                }                
            break;
            
            case "AGREGAR PRODUCTO":
                viewInv.setVisible(false);
                viewAddProduct.setVisible(true);
                
                llenarComboBox();

            break;
            
            case "GUARDAR":
                if(viewAddProduct.txtNombre.getText().equals("")||viewAddProduct.txtDescripcion.getText().equals("")||
                    viewAddProduct.txtUnidades.getText().equals("")||viewAddProduct.CBoxMarca.getSelectedItem().toString().equals("-- Marcas --")
                    ||viewAddProduct.CBoxProveedor.getSelectedItem().toString().equals("-- Proveedores --")||
                        viewAddProduct.CBoxCategoria.getSelectedItem().toString().equals("-- Categorias --")){
                    
                    JOptionPane.showMessageDialog(null, "Lleno todos los campos");

                }else{
                    model.setNombre(viewAddProduct.txtNombre.getText());
                    model.setDescripcion(viewAddProduct.txtDescripcion.getText());
                    model.setUnidades(Integer.parseInt(viewAddProduct.txtUnidades.getText()));
                    model.setMarca(viewAddProduct.CBoxMarca.getSelectedItem().toString());
                    model.setProveedor(viewAddProduct.CBoxProveedor.getSelectedItem().toString());
                    model.setCetegoria(viewAddProduct.CBoxCategoria.getSelectedItem().toString());
                    
                    model.agregarProductos();                    
                    
                    llenarComboBox();
                    limpiarCajasText();
                }                
            break;

        }
    }

    
    /*Con esta clase dare función a cada Jlabel y a los botones de la tabla que sean 
    clikeados, implementando mouse listener*/
    public void mouseClicked(MouseEvent e){
        int fila = viewInv.jTable1.rowAtPoint(e.getPoint());
        int columna = viewInv.jTable1.columnAtPoint(e.getPoint());
        //JOptionPane.showMessageDialog(null, "Fila: "+ fila + "Columna: "+columna);
        if(columna == 5){
            //JOptionPane.showMessageDialog(null, "Booton Modificar: Fila: "+ fila + "Columna: "+columna);
            Modificar(fila, columna);   
        }else if(columna == 6){
            Eliminar(fila);
        }
        
        
        if(e.getSource()== viewInv.btnSalir){
            viewInv.setVisible(false);
            viewLogin.setVisible(true);
        }      
        if(e.getSource() == viewAddProduct.btnSalir1){
            viewAddProduct.setVisible(false);
            viewLogin.setVisible(true);
        }
        //Boton del la vista JPI_AgregarProductos para regresar al Inventario
        if(e.getSource() == viewAddProduct.btnback){
            viewInv.setVisible(true);
            viewAddProduct.setVisible(false);
            limpiarCajasText();     
            MostrarRegistroTabla();//Volver a Cargar la tabla de Productos(Actualizar)            
        }
        
        /*LAMAN AL METODO PARA MOSTRAR REGISTROS DE LA TABLA SEGUN UNA CATEGORIA 
        PARA ELLOS E IMPLEMENTO MOUSELISTENER; ESTAS PERTENCE A LA VISTA JPI_INVENTARIO*/
        if(e.getSource()== viewInv.btnCategoria1){
            MostrarRegistrosFiltro(viewInv.btnCategoria1.getText());    
        }
        if(e.getSource()== viewInv.btnCategoria2){
            MostrarRegistrosFiltro(viewInv.btnCategoria2.getText());                       
        }        
        if(e.getSource()== viewInv.btnCategoria3){
            MostrarRegistrosFiltro(viewInv.btnCategoria3.getText());                       
        }    
        if(e.getSource()== viewInv.btnCategoria4){
            MostrarRegistrosFiltro(viewInv.btnCategoria4.getText());                       
        } 
        
        /*LAMAN AL METODO PARA MOSTRAR REGISTROS DE LA TABLA SEGUN UNA CATEGORIA 
        PARA ELLOS E IMPLEMENTO MOUSELISTENER; ESTAS PERTENCE A LA VISTA JPI_AGREGAPRODUCTO*/
        if(e.getSource() == viewAddProduct.btnCategoria1){
            viewAddProduct.setVisible(false);
            viewInv.setVisible(true);
            MostrarRegistrosFiltro(viewInv.btnCategoria1.getText());            
        }
        if(e.getSource() == viewAddProduct.btnCategoria2){
            viewAddProduct.setVisible(false);
            viewInv.setVisible(true);
            MostrarRegistrosFiltro(viewInv.btnCategoria2.getText());            
        }
        if(e.getSource() == viewAddProduct.btnCategoria3){
            viewAddProduct.setVisible(false);
            viewInv.setVisible(true);
            MostrarRegistrosFiltro(viewInv.btnCategoria3.getText());            
        }   
        if(e.getSource() == viewAddProduct.btnCategoria4){
            viewAddProduct.setVisible(false);
            viewInv.setVisible(true);
            MostrarRegistrosFiltro(viewInv.btnCategoria4.getText());            
        }   
        
        //Boton para Filtrar los registros de la Tabla
        if(e.getSource()== viewInv.btnFiltrar){
            String Categoria = viewInv.CBoxFiltro.getSelectedItem().toString();
            if(Categoria.equals("-- Filtros --")){
                MostrarRegistroTabla();
            }else{
                MostrarRegistrosFiltro(Categoria);
            }                
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void MostrarDatos(){
        DefaultTableModel MiTabla =(DefaultTableModel)viewInv.jTable1.getModel();
        String EncabezadoTabla[]={"Codigo","Producto","Unidades","Marca","Categoria","MODIFICAR","ELIMINAR"};
        MiTabla = new DefaultTableModel(null,EncabezadoTabla);
        viewInv.jTable1.setModel(MiTabla);    
    }    
    
    
    public void MostrarRegistroTabla(){
        try {
            model.ConsultarDatos("productos");
            //model.Consultar("productos");
            ResultSet rst = model.getRst();
            DefaultTableModel lamismatabla= (DefaultTableModel)viewInv.jTable1.getModel();
            
            
            int filas=viewInv.jTable1.getRowCount();
            for (int i = 0;filas>i; i++) {
                lamismatabla.removeRow(0);
            }
            
            String Registro[]=new String[7];
            while(rst.next()){
                
                Registro[0]=rst.getString("Codigo");
                Registro[1]=rst.getString("Nombre");//Nombre del Producto
                Registro[2]=rst.getString("Unidades");
                Registro[3]=rst.getString("Marca_Codigo"); //Nombre de la Marca
                Registro[4]=rst.getString("Categoria");
                Registro[5]="Modificar";
                Registro[6]="Eliminar";
                lamismatabla.addRow(Registro);
            }
            
            viewInv.jTable1.setModel(lamismatabla);
            viewInv.tablaDiseño();
            
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error Tabla "+ e);
        }
    }
       
    public void MostrarRegistroTabla_Buscar(){
        try {
            ResultSet rst = model.getRst();
            DefaultTableModel lamismatabla= (DefaultTableModel)viewInv.jTable1.getModel();
            
            
            int filas=viewInv.jTable1.getRowCount();
            for (int i = 0;filas>i; i++) {
                lamismatabla.removeRow(0);
            }
            
            String Registro[]=new String[7];
            while(rst.next()){
                
                Registro[0]=rst.getString("Codigo");
                Registro[1]=rst.getString("Nombre");//Nombre del Producto
                Registro[2]=rst.getString("Unidades");
                Registro[3]=rst.getString("Marca_Codigo"); //Nombre de la Marca
                Registro[4]=rst.getString("Categoria");
                Registro[5]="Modificar";
                Registro[6]="Eliminar";
                lamismatabla.addRow(Registro);
            }
            
            viewInv.jTable1.setModel(lamismatabla);
            viewInv.tablaDiseño();
            
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error Tabla "+ e);
        }
    }
    
    public void btnTabla(){
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        Alinear.setBackground(new Color(38,196,133));
        Alinear.setForeground(Color.WHITE);
        viewInv.jTable1.getColumnModel().getColumn(5).setCellRenderer(Alinear);

        DefaultTableCellRenderer Alinear2 = new DefaultTableCellRenderer();
        Alinear2.setHorizontalAlignment(SwingConstants.CENTER);
        Alinear2.setBackground(new Color(218,44,56));
        Alinear2.setForeground(Color.WHITE);
        viewInv.jTable1.getColumnModel().getColumn(6).setCellRenderer(Alinear2);
        
    }

    public void Modificar(int f, int c){
        
        if(bandera==false){
            viewInv.jTable1.setEnabled(true);
            bandera=true;
        }else{
            viewInv.jTable1.setEnabled(false);
            for(int x=0; x<c; x++){
                Datos[x] = viewInv.jTable1.getValueAt(f, x).toString();
            }
            model.ModificarDatos("productos", Datos);
            if(model.getRes()>0){
                JOptionPane.showMessageDialog(null,"Datos Actualizados Correctamente");
                MostrarRegistroTabla();
            }
            bandera=false;
        }
    }
    
    public void Eliminar(int f){
        
        if(bandera==false){
            viewInv.jTable1.setEnabled(true);
            bandera=true;
        }else{
            viewInv.jTable1.setEnabled(false);
             int Codigo = Integer.parseInt(viewInv.jTable1.getValueAt(f, 0).toString());
            
            model.Eliminar(Codigo);
            if(model.getRes()>0){
                JOptionPane.showMessageDialog(null,"Registro Eliminado Correctamente");
                MostrarRegistroTabla();
            }
            bandera=false;
        }
    }   

    /*Muestra en la tabla los registros según la categoría seleccionada en la vista*/
    public void MostrarRegistrosFiltro(String Filtro){
        try {
            model.ConsultarDatosFiltros(Filtro);
            ResultSet rst = model.getRst();
            DefaultTableModel lamismatabla= (DefaultTableModel)viewInv.jTable1.getModel();
            
            
            int filas=viewInv.jTable1.getRowCount();
            for (int i = 0;filas>i; i++) {
                lamismatabla.removeRow(0);
            }
            
            String Registro[]=new String[7];
            while(rst.next()){
                
                Registro[0]=rst.getString("Codigo");
                Registro[1]=rst.getString("Nombre");//Nombre del Producto
                Registro[2]=rst.getString("Unidades");
                Registro[3]=rst.getString("Marca_Codigo"); //Nombre de la Marca
                Registro[4]=rst.getString("Categoria");
                Registro[5]="Modificar";
                Registro[6]="Eliminar";
                lamismatabla.addRow(Registro);
            }
            
            viewInv.jTable1.setModel(lamismatabla);
            viewInv.tablaDiseño();
            
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error Tabla "+ e);
            System.out.print("Error Controlador");
        }        
    }
}
