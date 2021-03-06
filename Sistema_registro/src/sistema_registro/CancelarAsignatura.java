/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Génesis
 */
public class CancelarAsignatura extends javax.swing.JFrame {
     Connection con=null;
    ResultSet rs;
    
    String titulos [] = {"Código de Asignatura", "Nombre de la Asignatura", "Sección", "Hora Inicial", "Hora Final","Período", "Unidades Valorativas",  "Matrícula"};
   
    DefaultTableModel modelo =  new DefaultTableModel();
    Statement stmt = null;
    String var, var2;
     final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
    
    /**
     * Creates new form CancelarAsignatura
     */
    public CancelarAsignatura() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        obtenerPeriodo();
         this.setTitle("Cancelar Asignatura");
          this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        this.lbl_idMatricula.setVisible(false);
        this.lbl_nombreAsignatura.setVisible(false);
        this.lbl_idPeriodo.setVisible(false);
        this.lbl_idSeccion.setVisible(false);
        this.btn_CancelarAsig.setEnabled(false);
        this.btn_eliminarM.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        
        
    }
    
     public CancelarAsignatura(String nombreUsuario) throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        obtenerPeriodo();
        noVisible();
         this.setTitle("Cancelar Asignatura");
         this.lbl_usuario.setText(nombreUsuario);
          this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        this.lbl_idMatricula.setVisible(false);
        this.lbl_nombreAsignatura.setVisible(false);
        this.lbl_idPeriodo.setVisible(false);
        this.lbl_idSeccion.setVisible(false);
        this.btn_CancelarAsig.setEnabled(false);
        this.btn_eliminarM.setEnabled(false); 
        this.setLocationRelativeTo(null);
        habilitar(lbl_usuario.getText());
        
    }
     private void noVisible(){
          btn_CancelarAsig.setVisible(false);
         btn_eliminarM.setVisible(false);
         btn_buscar.setVisible(false);
        jMenuItem3.setVisible(false);
         }
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("CancelarAsignaturasFunciones").contains("A")){
                    btn_CancelarAsig.setVisible(true);
                }
                if(rs.getString("CancelarAsignaturasFunciones").contains("E")){
                   btn_eliminarM.setVisible(true);
                }
            
                       if(rs.getString("CancelarAsignaturasFunciones").contains("B")){
                  btn_buscar.setVisible(true);
                }
                               if(rs.getString("MatriculaFunciones").contains("I")){
                 jMenuItem3.setVisible(true);
                }
      
                
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        txt_NumC = new javax.swing.JTextField();
        lbl_numeroCuenta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Cancelar = new javax.swing.JTable();
        lbl_idMatricula = new javax.swing.JLabel();
        lbl_idPeriodo = new javax.swing.JLabel();
        btn_eliminarM = new javax.swing.JButton();
        btn_CancelarAsig = new javax.swing.JButton();
        lbl_idSeccion = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        lbl_nombreAsignatura = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cancelar Asignatura ");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(367, 367, 367))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 940, 60));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/magnifier-1_icon-icons.com_56924.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_NumC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_NumC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumCActionPerformed(evt);
            }
        });
        txt_NumC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NumCKeyTyped(evt);
            }
        });

        lbl_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_numeroCuenta.setText("Número de cuenta:");

        Tabla_Cancelar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CancelarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Cancelar);

        lbl_idMatricula.setText("jLabel2");

        lbl_idPeriodo.setText("jLabel3");

        btn_eliminarM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminarM.setText("Eliminar Matricula");
        btn_eliminarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarMActionPerformed(evt);
            }
        });

        btn_CancelarAsig.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_CancelarAsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar matricula.png"))); // NOI18N
        btn_CancelarAsig.setText("Cancelar Asignatura");
        btn_CancelarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarAsigActionPerformed(evt);
            }
        });

        lbl_idSeccion.setText("jLabel4");

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_nombreAsignatura.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_nombreAsignatura)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 142, Short.MAX_VALUE)
                        .addComponent(lbl_numeroCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_NumC, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbl_idMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_idPeriodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_idSeccion)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_CancelarAsig)
                                .addGap(42, 42, 42)
                                .addComponent(btn_eliminarM)
                                .addGap(43, 43, 43)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nombreAsignatura)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_idMatricula)
                        .addComponent(lbl_idPeriodo)
                        .addComponent(lbl_idSeccion))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_NumC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_numeroCuenta)
                        .addComponent(btn_buscar)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_CancelarAsig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_eliminarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 940, 380));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenu1.setText("Regresar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        jMenuItem1.setText("Matricula");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        jMenuItem3.setText("Imprimir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("jLabel2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        try {
                
        buscar();
        
        } catch (Exception e) {
            
            try{ 
           Log myLog; 
                String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void Tabla_CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CancelarMouseClicked
          this.btn_CancelarAsig.setEnabled(true);
        this.btn_eliminarM.setEnabled(true);
          int i = Tabla_Cancelar.getSelectedRow();
         if(Tabla_Cancelar.getSelectedRow() >= 0){
          lbl_idSeccion.setText(Tabla_Cancelar.getValueAt(i,0).toString()/*+"-"+Tabla_Cancelar.getValueAt(i,2).toString()*/);
          lbl_idPeriodo.setText(Tabla_Cancelar.getValueAt(i,5).toString());
          lbl_nombreAsignatura.setText(Tabla_Cancelar.getValueAt(i, 2).toString());
              try {
                   Statement st = con.createStatement();
                   String sql2 = "select * from Matricula as m join Secciones as s on m.id_seccion = s.id_seccion\n" +
                    "where m.numero_cuenta_alumno = '"+txt_NumC.getText()+"' and s.id_seccion = '"+lbl_idSeccion.getText()+"'\n" +
                    "and s.id_periodo = '"+lbl_idPeriodo.getText()+"'";
                  ResultSet rs = st.executeQuery(sql2);
                 if(rs.next()){
                     lbl_idMatricula.setText(rs.getString(3));
                 }
          
              } catch (SQLException ex) {
                  Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
              }
       }
         
    }//GEN-LAST:event_Tabla_CancelarMouseClicked

      private void eliminarMatricula(){
            if (validarNotas()) {
            return;
        }
         try {
             Statement st = con.createStatement();
             String sql2 = "select * from Matricula as m join Secciones as s on m.id_seccion = s.id_seccion\n" +
            "where m.numero_cuenta_alumno = '"+txt_NumC.getText()+"'" +
            "and s.id_periodo = '"+lbl_idPeriodo.getText()+"'";
             ResultSet rs2 = st.executeQuery(sql2);
             ArrayList<String> id_matricula = new ArrayList<String>();
             ArrayList<String> id_seccion = new ArrayList<String>();
             while(rs2.next()){
                 id_matricula.add(rs2.getString(3));
                 id_seccion.add(rs2.getString(2));
             }
             if(id_matricula.size() > 0){
             for (int i = 0; i < id_matricula.size(); i++) {
                 Statement st2 = con.createStatement();
                
                 String sql3 = "Delete Notas\n" +
                                "where id_matricula = '"+id_matricula.get(i)+"'";
                 int rs3 = st2.executeUpdate(sql3);
                 
                 Statement st3 = con.createStatement();
                 String sql4 = "Delete Matricula\n"
                         + "where id_matricula = '"+id_matricula.get(i)+"'";
                 int rs4 = st3.executeUpdate(sql4);
                 
                 Statement st4 = con.createStatement();
                 String sql5 = "Update Secciones\n" +
                            "set cantidad_alumnos = cantidad_alumnos - 1 "
                         + " where id_seccion = '"+id_seccion.get(i)+"'";
              
                 int rs5 = st4.executeUpdate(sql5);
                 
             }
             JOptionPane.showMessageDialog(null,"Se ha cancelado la matricula exitosamente");
                }
             else if(id_matricula.isEmpty()){
                  JOptionPane.showMessageDialog(null,"No hay matricula registrada");
             }
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
         }
      
    }
      
    private boolean validarNotas(){
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Notas where numero_cuenta = '" + txt_NumC.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El número de cuenta: " + txt_NumC.getText() + " ya contiene notas. \n No se puede eliminar la matrícula", "Notas ya ingresadas.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean validarNotas2(){
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Notas where numero_cuenta = '" + txt_NumC.getText() + "' and id_matricula = '"+lbl_idMatricula.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if(rs.getString("nota1").equals("0.00000")){
                    return false;
                }
                JOptionPane.showMessageDialog(null, "El número de cuenta : " + txt_NumC.getText() + " ya contiene notas. \n No se puede eliminar la asignatura, ", "Notas ya ingresadas.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
    private void btn_CancelarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarAsigActionPerformed

    try{

//CancelarA(var, var);
         String numeroCuenta,id_seccion,id_periodo,id_matricula;
        
       
            numeroCuenta = txt_NumC.getText();
            id_matricula =lbl_idMatricula.getText();
            id_seccion = lbl_idSeccion.getText();
            id_periodo = lbl_idPeriodo.getText();
            
            
            int matricula =Integer.parseInt(id_matricula);
          
            if (validarNotas2()) {
            return;
        }
        
        try{
          
                if ((txt_NumC.getText().equals(""))  ) {

                javax.swing.JOptionPane.showMessageDialog(this,"¡Debe llenar el espacio! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                     txt_NumC.requestFocus();
                        return;
              }
               
           
             Statement st2 =con.createStatement();
             String sql = "Delete  Notas "
                      + "where numero_cuenta='"+numeroCuenta+"' and id_periodo='"+id_periodo+"' and id_matricula='"+id_matricula+"'"; 
                     
                     
              int rs2 = st2.executeUpdate(sql);
          }catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            
        }
      try{
          PreparedStatement ps;
          ResultSet rs4;
         Statement st=con.createStatement();
         String sql ="Delete  Matricula "
                            + "where id_matricula='"+id_matricula+"' and numero_cuenta_alumno='"+numeroCuenta+"' and id_seccion ='"+id_seccion+"' ";
                 
                 
                 
                    int res=st.executeUpdate(sql);
                    
                    
                  Statement st4 = con.createStatement();
                 String sql5 = "Update Secciones\n" +
                            "set cantidad_alumnos = cantidad_alumnos - 1"
                         + " where id_seccion = '"+id_seccion+"'";
              
                 int rs5 = st4.executeUpdate(sql5);
                    
                  
                  if(res > 0){ 
                      
                      JOptionPane.showMessageDialog(null, "Se ha cancelado la asignatura "+lbl_nombreAsignatura.getText()+" del alumno: "+numeroCuenta+" correctamente."); 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al cancelar la asignatura!"); 
                  }
      } catch ( Exception e) { 
           JOptionPane.showMessageDialog(null, "Error al borrar la información, podría ser por: \n 1.Podria ser porque la asignatura ya contenga notas"
                         + "\n 2. No existe una matricula de esta clase.","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
        }
      buscar();
     
    } catch (Exception e) {
        
         try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    
    }//GEN-LAST:event_btn_CancelarAsigActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          
        try{
        
        this.dispose();
       Matricula mm = null;
         try {
             mm = new Matricula(lbl_usuario.getText());
         } catch (SQLException ex) {
             Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
         }
        mm.setVisible(true);
        
        } catch (Exception e){
            
             try {
                Log myLog; 
              String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyTyped
       
    }//GEN-LAST:event_jLabel1KeyTyped

    private void txt_NumCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NumCKeyTyped
             char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_NumC.getText().length() >=10){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
      
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
                      
    }//GEN-LAST:event_txt_NumCKeyTyped

    private void txt_NumCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumCActionPerformed
/*public void actualizarDatos(){
        try {
               String sql = "select A.cod_asignaturas, A.nombre_asignaturas, S.Nombre_seccion, S.Hora_inicial, S.Hora_final, S.id_periodo,S.id_aula, A.UV from Secciones as S\n" +
                        "join Asignaturas as A on S.cod_asignaturas=A.cod_asignaturas "+
                        "join Matricula as M on M.id_seccion = S.id_seccion";
           
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               
               modelo = new DefaultTableModel(null,titulos);
               Tabla_Empleados.setModel(modelo);
               Locale locale = new Locale("es", "HN");      
               NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
               NumberFormat formatter = NumberFormat.getCurrencyInstance();
                 while(rs.next()) {
                      String []datos= new String[8];
                      datos[0] =rs.getString("Cod.Asignatura");
                      datos[1] =rs.getString("Nombre");
                      datos[2] =rs.getString("Seccion");
                      datos[3] =currencyFormatter.format(rs.getDouble("Hora Inicial"));
                      datos[4] =rs.getString("Hora Final");
                      datos[5] =rs.getString("Período");
                      datos[6] =rs.getString("Aula");
                      datos[7] =rs.getString("UV");
                      datos[8] = rs.getString("Selecciona");
                   
                      modelo.addRow(datos);
                      
                     
               }
                TableColumn idE = Tabla_Empleados.getColumn(titulos[0]);
                idE.setMaxWidth(125);
                idE.setIdentifier(ICONIFIED);
                TableColumn cn = Tabla_Empleados.getColumn(titulos[1]);
                cn.setMaxWidth(165);
                TableColumn ca = Tabla_Empleados.getColumn(titulos[2]);
                ca.setMaxWidth(165);
                TableColumn cs = Tabla_Empleados.getColumn(titulos[3]);
                cs.setMaxWidth(75);
                TableColumn ct = Tabla_Empleados.getColumn(titulos[4]);
                ct.setMaxWidth(90);
                TableColumn cid = Tabla_Empleados.getColumn(titulos[5]);
                cid.setMaxWidth(170);
                TableColumn cnomu = Tabla_Empleados.getColumn(titulos[6]);
                cnomu.setMaxWidth(165);
                TableColumn cidc = Tabla_Empleados.getColumn(titulos[7]);
                cidc.setMaxWidth(150);
                TableColumn ctipou = Tabla_Empleados.getColumn(titulos[8]);
                ctipou.setMaxWidth(95);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }*/
    private void btn_eliminarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarMActionPerformed
       
        try{
            
        
        eliminarMatricula();
        buscar();
        
        } catch (Exception e) {
            
             try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_btn_eliminarMActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
               try {
            JasperReport reporte = null;
            String path = "src\\reportes\\CancelarMatricula.jasper";
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("NombreUsuario",lbl_usuario.getText());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint;
            jprint=JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer view = new JasperViewer(jprint,false);
            final JRViewer viewer = new JRViewer(jprint);
            JRSaveContributor[] contrbs = viewer.getSaveContributors();

            for (JRSaveContributor saveContributor : contrbs)
            {
                if (!(saveContributor instanceof net.sf.jasperreports.view.save.JRDocxSaveContributor || saveContributor instanceof net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor 
                        || saveContributor instanceof net.sf.jasperreports.view.save.JRPdfSaveContributor))
                    viewer.removeSaveContributor(saveContributor);
            }
            view.setContentPane(viewer);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
             } catch (Exception e) {
              
            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed

        try {

            LimpiarCajas();
            // TODO add your handling code here:

        } catch (Exception e){

            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btn_limpiarActionPerformed

     private void obtenerPeriodo() throws SQLException{
       
         try {
         
         Statement st = con.createStatement();
        Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       String fecha = año+"-"+mes+"-"+ d;
        String sql = "select id_periodo from Periodo_historico\n" +
        "where fecha_inicial < '"+fecha+"' and fecha_final > '"+fecha+"'";
        ResultSet rs2 = st.executeQuery(sql);
        if(rs2.next()){
            lbl_idPeriodo.setText(rs2.getString(1));
            lbl_idPeriodo.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Error");
        }
         
         } catch (Exception e) {
             
               try {
                Log myLog; 
              String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
         }
    }
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
            java.util.logging.Logger.getLogger(CancelarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CancelarAsignatura().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Cancelar;
    private javax.swing.JButton btn_CancelarAsig;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminarM;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_idMatricula;
    private javax.swing.JLabel lbl_idPeriodo;
    private javax.swing.JLabel lbl_idSeccion;
    private javax.swing.JLabel lbl_nombreAsignatura;
    private javax.swing.JLabel lbl_numeroCuenta;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_NumC;
    // End of variables declaration//GEN-END:variables

     public void buscar(){
         
         try {
         
         try {
         
         this.Tabla_Cancelar.setVisible(true);
        String numeroCuenta;
         numeroCuenta = txt_NumC.getText();
           
        if((txt_NumC.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de cuenta.","Número de Cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NumC.requestFocus();
            return;
        }
         if(existeNumeroCuenta()){
            return;
            
        }
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla_Cancelar.setModel(modelo);
            
            PreparedStatement ps=null;
            ResultSet rs=null;
            
           
           
           String sql= "select S.id_seccion, S.Nombre_seccion,A.nombre_asignaturas, S.Hora_inicial, S.Hora_final, S.id_periodo,S.id_aula from Secciones as S\n"+
                         "join Matricula as M on S.id_seccion = M.id_seccion\n"+
                          "join Asignaturas as A on S.cod_asignaturas = A.cod_asignaturas\n"+
                         "where numero_cuenta_alumno = '"+numeroCuenta+"'";

            ps= con.prepareStatement(sql);
            rs= ps.executeQuery(); 
            
            ResultSetMetaData rsMd =rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Id Sección");
            modelo.addColumn("Sección");
            modelo.addColumn("Asignatura");
            modelo.addColumn("Hora Inicial");
            modelo.addColumn("Hora Final");
            modelo.addColumn("Período");
            modelo.addColumn("Aula");
            modelo.addColumn("Selecciona");
            TableColumn tc = Tabla_Cancelar.getColumnModel().getColumn(7);
            tc.setCellEditor(Tabla_Cancelar.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(Tabla_Cancelar.getDefaultRenderer(Boolean.class));
            
            //[]anchos ={50,200,50,50};
            
            for (int x = 0; x < cantidadColumnas ; x++) {
                Tabla_Cancelar.getColumnModel().getColumn(x);
                
            }
            
            while(rs.next()){
                
                Object[] filas =new Object[cantidadColumnas ];
                
                for(int i=0; i< cantidadColumnas ; i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
                this.txt_NumC.setEnabled(false);
                this.btn_eliminarM.setEnabled(true);
           }
            if(Tabla_Cancelar.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "El alumno no tiene clases matriculadas");
                LimpiarCajas();
                return;
            }
         }catch(SQLException ex){
             System.out.println(ex.toString());
             
         }    
      
         } catch (Exception e){
             
               try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
         }
         
         } catch (Exception e) {
             
               try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
         }
      
    }
     
      /*public boolean CancelarA(String campus, String periodo){
         String numeroCuenta = null,id_matricula,id_seccion;
        
           // numeroCuenta ="";
            id_matricula = "";   
            id_seccion = "";
      
        
        
        try{
            numeroCuenta = null;
            
             Statement stat = con.createStatement();
            String sql2="select * from NumerosCuenta as NC\n" +
           "where NC.campus= '"+campus+"' and NC.id_periodo='"+periodo+"'";
            ResultSet rs3 = stat.executeQuery(sql2);
                  if (rs3.next()) {
                        numeroCuenta = rs3.getString("numero_cuenta_alumno");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error");
                  }
           
             Statement st2 =con.createStatement();
             String sql ="Delete from Matricula "
                            + "where id_matricula =(Select id_matricula from Matricula where numero_cuenta_alumno='"+numeroCuenta+"' and id_seccion ='"+id_seccion+"')";
              int rs2 = st2.executeUpdate(sql);
          }catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            
        }
      try{
          PreparedStatement ps;
          ResultSet rs4;
         Statement st=con.createStatement();
         String sql ="Delete from Notas "
                      + "where numero_cuenta='"+numeroCuenta+"'";
                 
                    int res=st.executeUpdate(sql);
                  
                  if(res > 0){ 
                      JOptionPane.showMessageDialog(null, "Se ha cancelado la asignatura de el alumno: "+numeroCuenta+" correctamente."); 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al cancelar la asignatura!"); 
                  }
      } catch ( Exception e) {
            System.out.println(e);
        }
            return false;
         
         
      
    }*/
      
       public boolean IsSelected(int row,int column, JTable tbl_asignaturas){
        return tbl_asignaturas.getValueAt(row, column) != null;
             
    }
      public boolean ValidacionSeleccionMultiple(int row,int column, JTable tbl_asignaturas){
          
         
          
        return tbl_asignaturas.getValueAt(row, column) != null;
             
    }
      
      
      
      private boolean existeNumeroCuenta() {
        
          try{
          
          try {
            Statement st = con.createStatement();
            String sql = "select A.numero_cuenta_alumno from Alumno as A\n" +
                           "where A.numero_cuenta_alumno='"+txt_NumC.getText()+"';";
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                     LimpiarCajas();
                JOptionPane.showMessageDialog(null, "El número de cuenta: " +txt_NumC.getText()+ " no existe", "Número de Cuenta Incorrecto", JOptionPane.ERROR_MESSAGE);
                return true;
            } else {
                
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        
          }catch (Exception e) {
              
                    try {
                Log myLog; 
              String nombreArchivo = "src\\Logs\\CancelarAsignatura " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
          return false;
    }

    private void LimpiarCajas() {
       txt_NumC.setText(null);
       this.btn_CancelarAsig.setEnabled(false);
       this.btn_eliminarM.setEnabled(false);
       this.txt_NumC.setEnabled(true);
       this.Tabla_Cancelar.setVisible(false);
    }
    
  
}




