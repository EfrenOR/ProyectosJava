/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Efren
 */
public class JPI_Login extends javax.swing.JFrame {

    /**
     * Creates new form JPI_Vista
     */
    public JPI_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrame = new javax.swing.JPanel();
        jPForm = new javax.swing.JPanel();
        IMG_SERVER = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        LinkRecupContra = new javax.swing.JLabel();
        btnAcceder = new javax.swing.JButton();
        FigCirculo = new javax.swing.JLabel();
        FigCirculo2 = new javax.swing.JLabel();
        Logo_JPI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainFrame.setBackground(new java.awt.Color(49, 151, 214));
        MainFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPForm.setBackground(new java.awt.Color(250, 250, 250));
        jPForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IMG_SERVER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/img_server.png"))); // NOI18N
        jPForm.add(IMG_SERVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, -1, -1));

        Title.setFont(new java.awt.Font("Roboto", 1, 40)); // NOI18N
        Title.setForeground(new java.awt.Color(26, 26, 26));
        Title.setText("Iniciar Sesión");
        jPForm.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 44, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");
        jPForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 147, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jPForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 147, -1, -1));

        txtID.setBackground(new java.awt.Color(246, 246, 246));
        txtID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 189, 189), 1, true));
        jPForm.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 169, 400, 58));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jPForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 256, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Contraseña");
        jPForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 256, -1, -1));

        txtContraseña.setBackground(new java.awt.Color(246, 246, 246));
        txtContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(189, 189, 189), 1, true));
        jPForm.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 280, 400, 58));

        LinkRecupContra.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        LinkRecupContra.setForeground(new java.awt.Color(49, 151, 214));
        LinkRecupContra.setText("¿Olvidaste tu contraseña?");
        LinkRecupContra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPForm.add(LinkRecupContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 345, -1, -1));

        btnAcceder.setBackground(new java.awt.Color(1, 112, 185));
        btnAcceder.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnAcceder.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceder.setText("ACCEDER");
        btnAcceder.setBorder(null);
        jPForm.add(btnAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 415, 220, 52));

        MainFrame.add(jPForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 109, 936, 538));

        FigCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Circle.png"))); // NOI18N
        MainFrame.add(FigCirculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        FigCirculo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Circle2.png"))); // NOI18N
        MainFrame.add(FigCirculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, -1, -1));

        Logo_JPI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        MainFrame.add(Logo_JPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 41, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPI_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPI_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FigCirculo;
    private javax.swing.JLabel FigCirculo2;
    private javax.swing.JLabel IMG_SERVER;
    private javax.swing.JLabel LinkRecupContra;
    private javax.swing.JLabel Logo_JPI;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnAcceder;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPForm;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
