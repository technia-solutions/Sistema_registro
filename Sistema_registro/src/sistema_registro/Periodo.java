/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import static java.awt.Frame.ICONIFIED;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author William & Genesis
 */
public class Periodo extends javax.swing.JFrame {

       String titulos[] = {"Id Período", "Período", "Descripción"};
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;
    
    
    public Periodo() {
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

        btn_eliminar = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        lbl_idPeriodo = new javax.swing.JLabel();
        lbl_NomPer = new javax.swing.JLabel();
        txt_idPeriodo = new javax.swing.JTextField();
        txt_NomPer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Periodo = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        lbl_descripcion = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setText("Eliminar");

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Período");

        lbl_idPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idPeriodo.setText("Id Período");

        lbl_NomPer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NomPer.setText("Nombre del Período");

        txt_idPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_NomPer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Tabla_Periodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Periodo", "Nombre Periodo", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Periodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PeriodoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Periodo);

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setText("Actualizar");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        lbl_descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_descripcion.setText("Descripción Período");

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jMenu.setText("Menu");

        jMenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal.setText("Menu Principal");
        jMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu.add(jMenuPrincipal);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_idPeriodo)
                            .addComponent(lbl_NomPer)
                            .addComponent(lbl_descripcion))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txt_idPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_NomPer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_descripcion))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_guardar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_actualizar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_buscar)
                        .addGap(37, 37, 37)
                        .addComponent(btn_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(lbl_titulo)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_titulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idPeriodo)
                    .addComponent(txt_idPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NomPer)
                    .addComponent(txt_NomPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_descripcion)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_actualizar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
         String cadena1, cadena2, cadena3;
        cadena1 = txt_idPeriodo.getText();
        cadena2 = txt_NomPer.getText();
        String id_facultad = txt_descripcion.getText().toString().substring(0, 4);
        
        if((txt_idPeriodo.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id del período.","Id de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idPeriodo.requestFocus();
            return;
        }
          
        if((txt_NomPer.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre del período.","Nombre del período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NomPer.requestFocus();
            return;
        }
        
         if((txt_descripcion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar una descipcion del período","Descipcion del período",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        

        if (existeNombrePeriodo()) {
            return;
        }
        
        if (existeidPeriodo()) {
            return;
        }

        if (!validarLongitud(txt_idPeriodo, 3)) {
            JOptionPane.showMessageDialog(null, "El id para la asignatura requisito ingresado es muy pequeño, el mínimo es de 4 caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txt_NomPer,1 )) {
            JOptionPane.showMessageDialog(null, "El  nombre de la asignatura requisito ingresado es muy pequeño, el mínimo es de 7 caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Periodo (id_periodo, periodo ,descripcion)"
                + "                VALUES(?,?,?)");
            ps.setString(1, txt_idPeriodo.getText());
            ps.setString(2, txt_NomPer.getText());
            ps.setString(3, txt_descripcion.getText());
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información del período");
        } catch (Exception e) {
            System.out.println(e);

        }

        actualizarDatos();
        LimpiarCajas();
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void Tabla_PeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PeriodoMouseClicked
           if(Tabla_Periodo.getSelectedRow() >= 0){
            llenarCampos();
        }
    }//GEN-LAST:event_Tabla_PeriodoMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       
        actualizarDatos();
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipalActionPerformed
    
         this.dispose();
        Principal P = null;
         try {
             P = new Principal();
         } catch (SQLException ex) {
             Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }
        P.setVisible(true);
        
    }//GEN-LAST:event_jMenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Periodo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Periodo;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_NomPer;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_idPeriodo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_NomPer;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_idPeriodo;
    // End of variables declaration//GEN-END:variables

 private boolean existeNombrePeriodo() {
        try {
            Statement st = con.createStatement();
            String sql = "Select Periodo from periodo where periodo = '" + txt_NomPer.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre del período." + txt_NomPer.getText() + " ya existe", "El período  ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private boolean existeidPeriodo() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_periodo from Periodo where id_periodo = '" + txt_idPeriodo.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id del período " + txt_idPeriodo.getText() + " ya existe", "El id período ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    private boolean validarLongitud(JTextField texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }

    private void llenarCampos() {
        int i = Tabla_Periodo.getSelectedRow();
        txt_idPeriodo.setText(Tabla_Periodo.getValueAt(i, 0).toString());
        txt_NomPer.setText(Tabla_Periodo.getValueAt(i, 1).toString());
        txt_descripcion.setText(Tabla_Periodo.getValueAt(i, 2).toString());

    }
  

private void rellenar() {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el nombre del período que desea consultar", "Consulta del período", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar el nombre del período \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Periodo where id_periodo='"+var+"' or periodo ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idPeriodo.setText(rs2.getString("id_periodo"));
                                txt_NomPer.setText(rs2.getString("periodo"));
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        }

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }

      public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Periodo";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Periodo.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id_periodo");
                datos[1] = rs.getString("periodo");
                datos[2] =rs.getString("descripcion");
                modelo.addRow(datos);
            }
            TableColumn ida = Tabla_Periodo.getColumn(titulos[0]);
            ida.setMaxWidth(300);
            ida.setIdentifier(ICONIFIED);
            TableColumn nRA = Tabla_Periodo.getColumn(titulos[1]);
            nRA.setMaxWidth(300);
            TableColumn cidc = Tabla_Periodo.getColumn(titulos[2]);
                cidc.setMaxWidth(150);
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }

  private void LimpiarCajas(){
        txt_NomPer.setText(null);
        txt_idPeriodo.setText(null);
           txt_descripcion.setText(null);
        
        
        
    }
    
}
