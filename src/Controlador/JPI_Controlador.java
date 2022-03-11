
package Controlador;

import Modelo.JPI_Modelo;
import Vista.JPI_Inventario;
import Vista.JPI_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class JPI_Controlador implements ActionListener{

    public JPI_Login viewLogin;
    public JPI_Modelo model;
    
    public JPI_Inventario viewInv;
    public JPI_Controlador(JPI_Login vL, JPI_Modelo m, JPI_Inventario vI){
        this.model = m;
        this.viewLogin= vL;
        this.viewInv = vI;
        this.viewLogin.btnAcceder.addActionListener(this);
    }
    
    @Override
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
            
            case "d":
                viewLogin.setVisible(false);
            break;
        }
    }
    
}
