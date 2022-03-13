
package Controlador;

import Modelo.JPI_Modelo;
import Vista.JPI_AgregarProducto;
import Vista.JPI_Inventario;
import Vista.JPI_Login;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
        this.viewInv.jTable1.addMouseListener(this);

        MostrarDatos();
        MostrarRegistroTabla();
        btnTabla();
        viewInv.jTable1.setEnabled(false);
    }
    
    /*Con esta clase dare función a cada Jlabel que sea clikeado implementando
    mouse listener*/
    public void mouseListener(){
        this.viewInv.btnSalir.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                viewInv.setVisible(false);
                viewLogin.setVisible(true);
            }
        });
        
        this.viewAddProduct.btnSalir1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                viewAddProduct.setVisible(false);
                viewLogin.setVisible(true);
            }
        });
        
        //Boton del la vista JPI_AgregarProductos para regresar al Inventario
        this.viewAddProduct.btnback.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                viewInv.setVisible(true);
                viewAddProduct.setVisible(false);
                limpiarCajasText();     
                MostrarRegistroTabla();//Volver a Cargar la tabla de Productos(Actualizar)
            }
        });
        
        //LAMAN AL METODO PARA MOSTRAR REGISTROS DE LA TABLA SEGUN UNA CATEGORIA PARA ELLOS E IMPLEMENTO MOUSELISTENER/
        this.viewInv.btnCategoria1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                MostrarRegistrosFiltro(viewInv.btnCategoria1.getText());
            }            
        });    
        
        this.viewInv.btnCategoria2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                MostrarRegistrosFiltro(viewInv.btnCategoria2.getText());
            }            
        });
        
        this.viewInv.btnCategoria3.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                MostrarRegistrosFiltro(viewInv.btnCategoria3.getText());
            }
        });
        
        this.viewInv.btnCategoria4.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                MostrarRegistrosFiltro(viewInv.btnCategoria4.getText());
            }
        });
        //////////////////////////////////////////////////////////////////
        
        
        this.viewInv.btnFiltrar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                String Categoria = viewInv.CBoxFiltro.getSelectedItem().toString();
                MostrarRegistrosFiltro(Categoria);
                
            }
        });
    }
    
    /*Limpiar Cajas de Texto de la vista JPI_AgregarProductos*/
    public void limpiarCajasText(){
        viewAddProduct.txtNombre.setText("");
        viewAddProduct.txtDescripcion.setText("");
        viewAddProduct.txtUnidades.setText("");
        viewAddProduct.CBoxProveedor.removeAllItems();
        viewAddProduct.CBoxMarca.removeAllItems();
        viewAddProduct.CBoxCategoria.removeAllItems();
    }
    
    
    /*Clase para darle las funciones correspondientes a cada uno de 
    los botones de las vistas*/
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case "ACCEDER":
                model.setID(Integer.parseInt(viewLogin.txtID.getText()));
                model.setConstraseña(viewLogin.txtContraseña.getText());
                              
                boolean res = model.autenticar();
                if(res == true){
                    
                    viewLogin.setVisible(false);
                    viewInv.setVisible(true);
                    
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
            break;
            
            case "AGREGAR PRODUCTO":
                viewInv.setVisible(false);
                viewAddProduct.setVisible(true);
                
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

            break;
            
            case "GUARDAR":
                if(viewAddProduct.txtNombre.equals("")||viewAddProduct.txtDescripcion.equals("")||
                    viewAddProduct.txtUnidades.equals("")||viewAddProduct.CBoxMarca.equals("-- Marcas --")
                    ||viewAddProduct.CBoxProveedor.equals("-- Proveedores --")||viewAddProduct.CBoxCategoria.equals("-- Categorias --")){
                    
                    JOptionPane.showMessageDialog(null, "Lleno todos los campos");

                }else{
                    model.setNombre(viewAddProduct.txtNombre.getText());
                    model.setDescripcion(viewAddProduct.txtDescripcion.getText());
                    model.setUnidades(Integer.parseInt(viewAddProduct.txtUnidades.getText()));
                    model.setMarca(viewAddProduct.CBoxMarca.getSelectedItem().toString());
                    model.setProveedor(viewAddProduct.CBoxProveedor.getSelectedItem().toString());
                    model.setCetegoria(viewAddProduct.CBoxCategoria.getSelectedItem().toString());
                    
                    model.agregarProductos();
                    
                    limpiarCajasText();
                }                
            break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        int fila = viewInv.jTable1.rowAtPoint(e.getPoint());
        int columna = viewInv.jTable1.columnAtPoint(e.getPoint());
        //JOptionPane.showMessageDialog(null, "Fila: "+ fila + "Columna: "+columna);
        if(columna == 5){
            //JOptionPane.showMessageDialog(null, "Booton Modificar: Fila: "+ fila + "Columna: "+columna);
            Modificar(fila, columna);   
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
