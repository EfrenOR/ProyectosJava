
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import Material.TextPrompt;

public class JPI_Inventario extends javax.swing.JFrame {


    public JPI_Inventario() {
        initComponents();
        buscador();
    }

    //Método para establecer un diseño a la tabla y llamarlo desde el controlador
    public void tablaDiseño(){        
        JTableHeader Header =  jTable1.getTableHeader();
        Header.setBackground(new Color(1, 112, 185));
        Header.setForeground(Color.white);
        Header.setFont(new Font("Dialog", Font.BOLD, 13));
        Header.setPreferredSize(new Dimension(20, 30));
        
        TableColumnModel columnModel = jTable1.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(70);
    }
        
    public void buscador(){
        
        /*Nos permite colocar un placeholder a un jtextfield*/
        /*Obtenido de https://tips4java.wordpress.com/2009/11/29/text-prompt/*/
        TextPrompt placeholder = new TextPrompt("  ¿Qué esta buscando?", txtBuscar);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelWhite = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        CBoxFiltro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCategoria4 = new javax.swing.JLabel();
        btnCategoria2 = new javax.swing.JLabel();
        btnCategoria3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        btnCategoria1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(49, 151, 214));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelWhite.setBackground(new java.awt.Color(250, 250, 250));
        PanelWhite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 151, 214)));
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setDropMode(javax.swing.DropMode.INSERT);
        txtBuscar.setName(""); // NOI18N
        txtBuscar.setOpaque(false);
        PanelWhite.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 116, 518, 50));

        btnBuscar.setBackground(new java.awt.Color(1, 112, 185));
        btnBuscar.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        PanelWhite.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 116, 146, 50));

        CBoxFiltro.setBackground(new java.awt.Color(255, 255, 255));
        CBoxFiltro.setBorder(null);
        PanelWhite.add(CBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 196, 139, 36));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Header.png"))); // NOI18N
        PanelWhite.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 31, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(1, 112, 185));
        btnAgregar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR PRODUCTO");
        PanelWhite.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 246, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jTable1.setRowHeight(30);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        PanelWhite.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 264, 890, 300));

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelWhite.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, -1, -1));

        jPanel1.add(PanelWhite, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 0, 1052, 720));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 36, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setRequestFocusEnabled(false);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 213, 109, 10));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Categorias");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 200, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 280, 10));

        btnCategoria4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        btnCategoria4.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria4.setText("Sin Categorizar");
        btnCategoria4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnCategoria4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 434, -1, -1));

        btnCategoria2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        btnCategoria2.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria2.setText("Eléctrico");
        btnCategoria2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnCategoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 316, -1, -1));

        btnCategoria3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        btnCategoria3.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria3.setText("Electrónica");
        btnCategoria3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnCategoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 375, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 520, 70, 10));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Configuraciones");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 508, -1, 20));

        btnCategoria1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        btnCategoria1.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria1.setText("Automatización");
        btnCategoria1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 257, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Circle_Inventario.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 130, 100));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Perfil");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 565, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leave.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 598, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(JPI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPI_Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPI_Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBoxFiltro;
    public javax.swing.JPanel PanelWhite;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JLabel btnCategoria1;
    public javax.swing.JLabel btnCategoria2;
    public javax.swing.JLabel btnCategoria3;
    public javax.swing.JLabel btnCategoria4;
    public javax.swing.JLabel btnFiltrar;
    public javax.swing.JLabel btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
