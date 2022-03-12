
package Controlador;

import Modelo.JPI_Modelo;
import Vista.JPI_AgregarProducto;
import Vista.JPI_Inventario;
import Vista.JPI_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class JPI_Controlador implements ActionListener{

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
        
        this.viewAddProduct.btnback.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                viewInv.setVisible(true);
                viewAddProduct.setVisible(false);
            }
        });
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
                }                
            break;
            
            case "AGREGAR PRODUCTO":
                viewInv.setVisible(false);
                viewAddProduct.setVisible(true);
                
                ArrayList<String> Marcas = new ArrayList<String>();

                Marcas = model.cargarMarcas();
                for(int i=0; i<Marcas.size(); i++){
                    viewAddProduct.CBoxMarca.addItem(Marcas.get(i));
                }
            break;
            
            case "GUARDAR":
                /*Implementación del método agregar productos a la base de datos
                */
                
                
            break;
        }
    }
    
}
