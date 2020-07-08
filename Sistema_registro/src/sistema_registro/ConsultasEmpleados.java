
package sistema_registro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author William P.
 */


 
public class ConsultasEmpleados extends javax.swing.JFrame {

  
    String titulos [] = {"Nombre","Apellido", "Salario", "Telefono", "Identidad", "idCampus", "NombreUsuario", "contraseña", "tipoUsuario"};
    String fila [] = new String[7];
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;
     private String driver;
      initComponents();
      this.Tabla_Empleados.setModel(modelo);
     this.modelo.addComumn("");
    
      

   
    public ConsultasEmpleados()  throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        this.setTitle("Consulta Empleados");
        this.setLocation(335,200);
        this.setResizable(false);
     
        try {
        
        String url = "jdbc:sqlserver://WIL212027:1433;";
            String usuario = "admin";
            String contraseña = "admin";  
            
                    
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
        
               con = DriverManager.getConnection(url);
               if (con!= null)
                   System.out.println("Se ha establecido una conexion a la base de datos"+"\n"+url);

  
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("select* from Empleados");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("id");
                   fila[1] = rs.getString("Nombres");
                   fila[2] = rs.getString("Apellidos");
                   fila[3] = rs.getString("Campus");
                   fila[4] = rs.getString("Telefono");
                   fila[5] = rs.getString("Identidad");
                   fila[6] = rs.getString("Password");
                   fila[7] = rs.getString("Tipo Usuario");
                   
                   modelo.addRow(fila);     
               }
               Tabla_Empleados.setModel(modelo);
                TableColumn ci = Tabla_Empleados.getColumn("id");
                ci.setMaxWidth(25);
                TableColumn cn = Tabla_Empleados.getColumn("Nombre");
                cn.setMaxWidth(165);
                TableColumn cd = Tabla_Empleados.getColumn("Domicilio");
                cd.setMaxWidth(160);
                TableColumn ct = Tabla_Empleados.getColumn("Telefono");
                ct.setMaxWidth(90);
              //  TableColumn ct = Tabla_Empleados.getColumn("Identidad");
                //ct.setMaxWidth(90);
                TableColumn cp = Tabla_Empleados.getColumn("Password");
                cp.setMaxWidth(72);
                TableColumn ctipo = Tabla_Empleados.getColumn("Tipo Usuario");
                ctipo.setMaxWidth(95);
               
            }
                catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Empleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_ConsultaIndividual = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        MenuRegistro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla_Empleados.setBackground(new java.awt.Color(204, 204, 204));
        Tabla_Empleados.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));
        Tabla_Empleados.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Empleados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de empleados");

        btn_modificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_ConsultaIndividual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ConsultaIndividual.setText("Consulta Ind");
        btn_ConsultaIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultaIndividualActionPerformed(evt);
            }
        });

        MenuArchivo.setText("Archivo");

        MenuRegistro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MenuRegistro.setText("Registro Empleados");
        MenuRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRegistroActionPerformed(evt);
            }
        });
        MenuArchivo.add(MenuRegistro);

        BarraMenu.add(MenuArchivo);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(385, 385, 385)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ConsultaIndividual)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar)))
                        .addGap(0, 287, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_ConsultaIndividual))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     
     
    

    
    
    private void MenuRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRegistroActionPerformed

        try {
            this.dispose();
            Empleado E = new Empleado();
            E.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_MenuRegistroActionPerformed

    private void btn_ConsultaIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultaIndividualActionPerformed

       
        //   this.dispose();
        
    //   ConsultaIndividual ci = new ConsultaIndividual();
       // ci.setVisible(true);
        
        
    }//GEN-LAST:event_btn_ConsultaIndividualActionPerformed

    
    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
       
        int fila_seleccionada=Tabla_Empleados.getSelectedRow();
        if (fila_seleccionada>=0) {
            modelo.removeRow(fila_seleccionada);
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione una fila por favor");
        }   
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void Tabla_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosMouseClicked
        
        int fila_seleccionada= Tabla_Empleados.getSelectedRow();
        txt_Nombre.setText(Tabla_Empleados.getValueAt(fila_seleccionada,0).toString());
        
       txt_Apellido.setText(Apellido);
       txt_Salario.setText(Salario);
       txt_Telefono.setText(Telefono);
       txt_Identidad.setText(Identidad);
       cbo_idCampus.setSelectedItem(idCampus);
       txt_NombreUsuario.setText(NombreUsuario);
       pwd_contraseña.setText(contraseña);
       cbo_tipoUsuario.setSelectedItem(tipoUsuario);
       filas = fila_seleccionada;
        
    }//GEN-LAST:event_Tabla_EmpleadosMouseClicked

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

    }//GEN-LAST:event_btn_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultasEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenuItem MenuRegistro;
    private javax.swing.JTable Tabla_Empleados;
    private javax.swing.JButton btn_ConsultaIndividual;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  
}
