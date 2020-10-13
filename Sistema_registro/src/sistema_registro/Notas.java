/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author 
 */
public class Notas extends javax.swing.JFrame {

   Connection con=null;
    ResultSet rs;
    int notaFinal = 0;
    
     
     Statement stmt = null;
     
     
    public Notas() throws SQLException {
         this.con = ConectorSQL.obtenerConexion();
         initComponents();
         this.lbl_idmatricula.setVisible(false);
         desactivar();
         this.Tabla_asignatura.setEnabled(true);
         this.setLocationRelativeTo(null);
         this.setTitle("Notas");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
    }
    
     public Notas(String nombreUsuario) throws SQLException {
         this.con = ConectorSQL.obtenerConexion();
         initComponents();
         this.lbl_idmatricula.setVisible(false);
         desactivar();
         this.lbl_usuario.setText(nombreUsuario);
         this.Tabla_asignatura.setEnabled(true);
         this.setLocationRelativeTo(null);
         this.setTitle("Notas");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
    }

    
     private void LimpiarCajas(){
        desactivar();
        txt_notaParcialI.setText(null);
        txt_notaParcialII.setText(null);
        txt_notaParcialIII.setText(null);
        txt_numeroCuenta.setText(null);
        lbl_asignatura.setText(null);
        this.Tabla_asignatura.setVisible(false);
        this.txt_numeroCuenta.setEnabled(true);
        this.btn_generarReporte.setEnabled(false);
        this.rad_reposicionParcialI.setEnabled(false);
        this.rad_reposicionParcialII.setEnabled(false);
        cbo_reposicion.setSelected(false);
        rad_reposicionParcialI.setSelected(false);
        rad_reposicionParcialII.setSelected(false);
        this.cbo_reposicion.setEnabled(false);
       
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_numeroCuenta = new javax.swing.JLabel();
        txt_numeroCuenta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_notaParcialI = new javax.swing.JLabel();
        txt_notaParcialI = new javax.swing.JTextField();
        lbl_notaParcialII = new javax.swing.JLabel();
        txt_notaParcialII = new javax.swing.JTextField();
        lbl_notaParcialIII = new javax.swing.JLabel();
        txt_notaParcialIII = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        rad_reposicionParcialI = new javax.swing.JRadioButton();
        rad_reposicionParcialII = new javax.swing.JRadioButton();
        lbl_reposiciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_asignatura = new javax.swing.JTable();
        cbo_reposicion = new javax.swing.JCheckBox();
        btn_generarReporte = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_asignatura = new javax.swing.JLabel();
        lbl_clase = new javax.swing.JLabel();
        btn_buscarClases = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_idmatricula = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_numeroCuenta.setText("Numero de cuenta:");
        getContentPane().add(lbl_numeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        txt_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_numeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroCuentaActionPerformed(evt);
            }
        });
        txt_numeroCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numeroCuentaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_numeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 220, -1));

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_titulo.setText("Notas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(lbl_titulo)
                .addContainerGap(593, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1190, -1));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));
        jPanel2.setLayout(null);

        lbl_notaParcialI.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_notaParcialI.setText("Nota Parcial I:");
        jPanel2.add(lbl_notaParcialI);
        lbl_notaParcialI.setBounds(110, 50, 140, 22);

        txt_notaParcialI.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_notaParcialI.setEnabled(false);
        txt_notaParcialI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_notaParcialIFocusLost(evt);
            }
        });
        txt_notaParcialI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_notaParcialIActionPerformed(evt);
            }
        });
        txt_notaParcialI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_notaParcialIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_notaParcialIKeyTyped(evt);
            }
        });
        jPanel2.add(txt_notaParcialI);
        txt_notaParcialI.setBounds(250, 50, 80, 28);

        lbl_notaParcialII.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_notaParcialII.setText("Nota Parcial II:");
        jPanel2.add(lbl_notaParcialII);
        lbl_notaParcialII.setBounds(110, 90, 119, 22);

        txt_notaParcialII.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_notaParcialII.setEnabled(false);
        txt_notaParcialII.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_notaParcialIIFocusLost(evt);
            }
        });
        txt_notaParcialII.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_notaParcialIIKeyTyped(evt);
            }
        });
        jPanel2.add(txt_notaParcialII);
        txt_notaParcialII.setBounds(250, 90, 80, 28);

        lbl_notaParcialIII.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_notaParcialIII.setText("Nota Parcial III:");
        jPanel2.add(lbl_notaParcialIII);
        lbl_notaParcialIII.setBounds(100, 130, 126, 22);

        txt_notaParcialIII.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_notaParcialIII.setEnabled(false);
        txt_notaParcialIII.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_notaParcialIIIFocusLost(evt);
            }
        });
        txt_notaParcialIII.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_notaParcialIIIKeyTyped(evt);
            }
        });
        jPanel2.add(txt_notaParcialIII);
        txt_notaParcialIII.setBounds(250, 130, 80, 28);

        btn_guardar.setBackground(new java.awt.Color(235, 250, 251));
        btn_guardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("  Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_guardar);
        btn_guardar.setBounds(110, 200, 210, 40);

        rad_reposicionParcialI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rad_reposicionParcialI.setText("Realizó reposición del I Parcial");
        rad_reposicionParcialI.setEnabled(false);
        rad_reposicionParcialI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_reposicionParcialIActionPerformed(evt);
            }
        });
        jPanel2.add(rad_reposicionParcialI);
        rad_reposicionParcialI.setBounds(370, 80, 267, 31);

        rad_reposicionParcialII.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rad_reposicionParcialII.setText("Realizó reposición del II Parcial");
        rad_reposicionParcialII.setEnabled(false);
        rad_reposicionParcialII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_reposicionParcialIIActionPerformed(evt);
            }
        });
        jPanel2.add(rad_reposicionParcialII);
        rad_reposicionParcialII.setBounds(370, 120, 273, 31);

        lbl_reposiciones.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_reposiciones.setText("Reposiciones");
        jPanel2.add(lbl_reposiciones);
        lbl_reposiciones.setBounds(430, 10, 101, 22);

        Tabla_asignatura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Tabla_asignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Asignaturas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_asignatura.setEnabled(false);
        Tabla_asignatura.setGridColor(new java.awt.Color(0, 51, 51));
        Tabla_asignatura.setRowHeight(30);
        Tabla_asignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_asignaturaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_asignatura);
        if (Tabla_asignatura.getColumnModel().getColumnCount() > 0) {
            Tabla_asignatura.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(830, 30, 260, 260);

        cbo_reposicion.setText("¿El estudiante hizo reposición?");
        cbo_reposicion.setEnabled(false);
        cbo_reposicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_reposicionActionPerformed(evt);
            }
        });
        jPanel2.add(cbo_reposicion);
        cbo_reposicion.setBounds(380, 40, 260, 23);

        btn_generarReporte.setBackground(new java.awt.Color(235, 250, 251));
        btn_generarReporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_generarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/writing-on-an-open-book_icon-icons.com_70325.png"))); // NOI18N
        btn_generarReporte.setText("Generar historial academico");
        btn_generarReporte.setEnabled(false);
        btn_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarReporteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_generarReporte);
        btn_generarReporte.setBounds(380, 200, 240, 40);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 1190, 330));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_asignatura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(lbl_asignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 280, 30));

        lbl_clase.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_clase.setText("Clase:");
        jPanel3.add(lbl_clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        btn_buscarClases.setBackground(new java.awt.Color(235, 250, 251));
        btn_buscarClases.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscarClases.setText("Buscar clases");
        btn_buscarClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarClasesActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscarClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 170, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 120, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 1190, 60));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 680));

        lbl_idmatricula.setText("jLabel2");
        getContentPane().add(lbl_idmatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 20, -1, -1));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");
        jMenu1.setToolTipText("");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem1.setText("Menú Principal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rad_reposicionParcialIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_reposicionParcialIIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad_reposicionParcialIIActionPerformed

    private void rad_reposicionParcialIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_reposicionParcialIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad_reposicionParcialIActionPerformed

  
    private void desactivar(){
        this.txt_notaParcialI.setEnabled(false);
        this.txt_notaParcialII.setEnabled(false);
        this.txt_notaParcialIII.setEnabled(false);
        this.btn_guardar.setEnabled(false);
    } 
    
     private boolean existeNumeroCuenta() {
        try {
            Statement st = con.createStatement();
            String sql = "select N.numero_cuenta from Notas as N  where numero_cuenta= '"+txt_numeroCuenta.getText()+"';";
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {  
                JOptionPane.showMessageDialog(null, "El número de cuenta: " + txt_numeroCuenta.getText() + " no existe o no tiene asignaturas matriculadas", "Número de cuenta incorrecto", JOptionPane.ERROR_MESSAGE);
                LimpiarCajas();
                return true;
            } else {
                
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
  
    
     
        private void activar(){
            this.txt_notaParcialI.setEnabled(true);
            this.txt_notaParcialII.setEnabled(true);
            this.txt_notaParcialIII.setEnabled(true);
            this.cbo_reposicion.setEnabled(true);
            this.btn_guardar.setEnabled(true);
            this.btn_generarReporte.setEnabled(true);
            this.Tabla_asignatura.setEnabled(true);
        }
    
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        String numeroDeCuenta,nota1, nota2, nota3, clase,periodo,promedio,estado,matricula,reposicion;
 
    
        numeroDeCuenta =txt_numeroCuenta.getText();
        nota1 = txt_notaParcialI.getText();
        nota2 = txt_notaParcialII.getText();
        nota3 = txt_notaParcialIII.getText();
        reposicion = "S/N";
        
         if(txt_notaParcialI.getText().equals("")){
             txt_notaParcialI.setText("0");
             javax.swing.JOptionPane.showMessageDialog(this,"Por favor verificar el campo Nota del primer parcial, campo vacío.","Verificar la nota",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_notaParcialI.requestFocus();
            return;
            
            }
          
         if(txt_notaParcialII.getText().equals("")){
             txt_notaParcialII.setText("0");
             javax.swing.JOptionPane.showMessageDialog(this,"Por favor verificar el campo nota  del segundo parcial,campo vacio., campo vacío","Verificar la nota",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_notaParcialII.requestFocus();
            return;
            
            }
          
         if(txt_notaParcialIII.getText().equals("")){
             txt_notaParcialIII.setText("0");
             javax.swing.JOptionPane.showMessageDialog(this,"Por favor verificar el campo Nota del tercer parcial, campo vacío.","Verificar la nota",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_notaParcialIII.requestFocus();
            return;
            
            }
         
         if(cbo_reposicion.isSelected()){
             rad_reposicionParcialI.setEnabled(true);
             rad_reposicionParcialII.setEnabled(true);
             if(rad_reposicionParcialI.isSelected()){
                 reposicion = "1P";
                     }
             if(rad_reposicionParcialII.isSelected()){
                 reposicion = "2P";
                     }
         }
        double calificacion1=Double.parseDouble(nota1);

        double calificacion2=Double.parseDouble(nota2);
        double calificacion3=Double.parseDouble(nota3);    
        double notafinal=((calificacion1+calificacion2+calificacion3)/3);
        promedio= String.valueOf(notafinal);
        
  
           if(calificacion1>100){
               JOptionPane.showMessageDialog(null, "La calificacion: '" + nota1 + "' es incorrecta porfavor revisar que sea un valor menor o igual a 100.", "Calificación Incorrecta", JOptionPane.ERROR_MESSAGE);
                    txt_notaParcialI.setText(null);
             return;  
           }
            if(calificacion2>100){
               JOptionPane.showMessageDialog(null, "La calificacion: '" + nota2 + "' es incorrecta porfavor revisar que sea un valor menor o igual a 100.", "Calificación Incorrecta", JOptionPane.ERROR_MESSAGE);
                  txt_notaParcialII.setText(null);
             return;  
           } 
            if(calificacion3>100){
               JOptionPane.showMessageDialog(null, "La calificacion: '" + nota3 + "' es incorrecta porfavor revisar que sea un valor menor o igual a 100.", "Calificación Incorrecta", JOptionPane.ERROR_MESSAGE);
                    txt_notaParcialIII.setText(null);
             return;  
           }
       
            /*     if((txt_notaParcialII.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los nombres del alumno.","Nombres del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_notaParcialI.requestFocus();
            return;
            }
            
          if((txt_notaParcialIII.getText().equals(""))){
           
           txt_notaParcialIII.setText("0");
            
            }*/
            
            
       
             
    
        
       if(notafinal >=65){
            estado="APB";
        }else{
            estado="RPB";
        }
        
        
            
    
 
      try{
          PreparedStatement ps;
          ResultSet rs;
          ps=con.prepareStatement("update Notas\n" +
                                    "set nota1 = ?,\n" +
                                    "nota2 = ?,\n" +
                                    "nota3 = ?,\n" +
                                    "promedio = ?,\n" +
                                    "estado = ?\n" + 
                                  //  "reposicion = ?" +
                                    "where id_matricula = (select id_matricula from Matricula where numero_cuenta_alumno = '"+numeroDeCuenta+"' and id_seccion = '"+lbl_idmatricula.getText()+"')");
                  ps.setString(1, nota1);
                  ps.setString(2, nota2);
                  ps.setString(3, nota3);
                  ps.setString(4,promedio);
                  ps.setString(5,estado);
                 // ps.setString(6,reposicion);
                  int res= ps.executeUpdate();
                  if(res > 0){
                       JOptionPane.showMessageDialog(null, "Se ha guardado con éxito la nota del alumno: "+numeroDeCuenta);
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la calificación"); 
 
                  }
                  
                  Statement ps2 = con.createStatement();
                  String sql = "update Notas set reposicion = '"+reposicion+"' "
                          +"where id_matricula = (select id_matricula from Matricula where numero_cuenta_alumno = '"+numeroDeCuenta+"' and id_seccion = '"+lbl_idmatricula.getText()+"')";
                  int res2= ps2.executeUpdate(sql);
      } catch ( Exception e) {
           System.out.println(e);
             JOptionPane.showMessageDialog(null, "Error al Guardar la información");
            
        }
      rad_reposicionParcialI.setSelected(false);
      rad_reposicionParcialII.setSelected(false);
      cbo_reposicion.setSelected(false);
      rad_reposicionParcialI.setEnabled(false);
      rad_reposicionParcialII.setEnabled(false);
     // LimpiarCajas();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_buscarClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarClasesActionPerformed
    String idAlumno;
  
    idAlumno=txt_numeroCuenta.getText();
    if(txt_numeroCuenta.getText().equals("")){
        javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de cuenta de el alumno."," Número de cuenta de el alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        txt_numeroCuenta.requestFocus();
        return;
    }
    else if (existeNumeroCuenta())
    
 
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            Tabla_asignatura.setModel(modelo);
            
            PreparedStatement ps=null;
            ResultSet rs=null;
            
            String sql="select A.nombre_asignaturas from Asignaturas as A\n" +
                "where A.cod_asignaturas in(select S.cod_asignaturas from Secciones as S where id_seccion in(select M.id_seccion from Matricula as M where  M.numero_cuenta_alumno= '"+idAlumno+"' ));";
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            
            ResultSetMetaData rsMd =rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Selecciona una Asignatura");
            
            int[]anchos ={50,200,50,50};
            
            for (int x = 0; x < cantidadColumnas; x++) {
                Tabla_asignatura.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
                
            }
            
            while(rs.next()){
                
                Object[] filas =new Object[cantidadColumnas];
                
                for(int i=0; i< cantidadColumnas; i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
                Tabla_asignatura.setShowGrid(true);
                Tabla_asignatura.setShowHorizontalLines(true);
                this.Tabla_asignatura.setVisible(true);
                this.btn_generarReporte.setEnabled(true);
                this.txt_numeroCuenta.setEnabled(false);
                
            }
         }catch(SQLException ex){
             System.out.println(ex.toString());
             
         }
    }//GEN-LAST:event_btn_buscarClasesActionPerformed

    private void txt_notaParcialIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_notaParcialIFocusLost
       
    }//GEN-LAST:event_txt_notaParcialIFocusLost

    private void txt_notaParcialIIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_notaParcialIIFocusLost
      
    }//GEN-LAST:event_txt_notaParcialIIFocusLost

    private void txt_notaParcialIIIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_notaParcialIIIFocusLost
      
    }//GEN-LAST:event_txt_notaParcialIIIFocusLost

    private void txt_notaParcialIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_notaParcialIActionPerformed

    }//GEN-LAST:event_txt_notaParcialIActionPerformed

    private void txt_notaParcialIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notaParcialIKeyPressed

    }//GEN-LAST:event_txt_notaParcialIKeyPressed

    private void txt_notaParcialIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notaParcialIKeyTyped
           char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 46 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
            
        if(txt_notaParcialI.getText().length() >=6){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
       if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
            return;
        }
        
    }//GEN-LAST:event_txt_notaParcialIKeyTyped

    private void txt_notaParcialIIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notaParcialIIKeyTyped
              char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
            }
   
            
        if(txt_notaParcialII.getText().length() >=6){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
       if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
        
    }//GEN-LAST:event_txt_notaParcialIIKeyTyped

    private void txt_notaParcialIIIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_notaParcialIIIKeyTyped
                    char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
            }
   
            
        if(txt_notaParcialIII.getText().length() >=6){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
       if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
    }//GEN-LAST:event_txt_notaParcialIIIKeyTyped

    private void Tabla_asignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_asignaturaMouseClicked
       
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            int Fila= Tabla_asignatura.getSelectedRow();
            String codigo = Tabla_asignatura.getValueAt(Fila, 0).toString();

            ps=con.prepareStatement("select n.nota1,nota2,nota3,id_seccion from notas as n join Matricula as m on n.id_matricula = m.id_matricula\n" +
                                    "where m.numero_cuenta_alumno = ? and n.id_matricula in(select m.id_matricula from Matricula as m where m.id_seccion in(Select S.id_seccion from Secciones as S where s.cod_asignaturas in\n" +
                                    "(select A.cod_asignaturas from Asignaturas as A where A.nombre_asignaturas= ?)))");
            
            ps.setString(1, txt_numeroCuenta.getText());
            ps.setString(2, codigo);
            rs= ps.executeQuery();
           
            while(rs.next()){
                lbl_asignatura.setText(codigo);
                txt_notaParcialI.setText(rs.getString("nota1").substring(0,5));
                txt_notaParcialII.setText(rs.getString("nota2").substring(0,5));
                txt_notaParcialIII.setText(rs.getString("nota3").substring(0,5));
                lbl_idmatricula.setText(rs.getString("id_seccion"));
                if(rs.getString("nota1").contains("100")){
                     txt_notaParcialI.setText(rs.getString("nota1").substring(0,6));
                }
                if(rs.getString("nota2").contains("100")){
                     txt_notaParcialII.setText(rs.getString("nota2").substring(0,6));
                }
                if(rs.getString("nota3").contains("100")){
                     txt_notaParcialIII.setText(rs.getString("nota3").substring(0,6));
                }  
                if(rs.getString("nota1").startsWith("0")){
                     txt_notaParcialI.setText(rs.getString("nota1").substring(0,4));
                }
                if(rs.getString("nota2").startsWith("0")){
                     txt_notaParcialII.setText(rs.getString("nota2").substring(0,4));
                }
                if(rs.getString("nota3").startsWith("0")){
                     txt_notaParcialIII.setText(rs.getString("nota3").substring(0,4));
                }
                
                 if(Double.parseDouble(rs.getString("nota1")) < 10){
                      txt_notaParcialI.setText(rs.getString("nota1").substring(0,4));
                }
                  if(Double.parseDouble(rs.getString("nota2")) < 10){
                      txt_notaParcialII.setText(rs.getString("nota2").substring(0,4));
                }
                   if(Double.parseDouble(rs.getString("nota3")) < 10){
                      txt_notaParcialIII.setText(rs.getString("nota3").substring(0,4));
                }
                
                
                
                activar();
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_Tabla_asignaturaMouseClicked

    private void cbo_reposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_reposicionActionPerformed
        if(cbo_reposicion.isSelected()){
            rad_reposicionParcialI.setEnabled(true);
            rad_reposicionParcialII.setEnabled(true);
        }
        else{
            rad_reposicionParcialI.setEnabled(false);
            rad_reposicionParcialII.setEnabled(false);
        }
    }//GEN-LAST:event_cbo_reposicionActionPerformed

    private void txt_numeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroCuentaActionPerformed

    private void txt_numeroCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroCuentaKeyTyped
          char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_numeroCuenta.getText().length() >=10){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
      
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
    }//GEN-LAST:event_txt_numeroCuentaKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     try {
            String sql2 = "Select nombres_empleado + ' ' + apellido_empleado from Empleados where id_empleado = (select id_empleado from Acceso where nombre_usuario = '"+lbl_usuario.getText()+"')";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                if(rs2.next()){
                Principal principal = new Principal(lbl_usuario.getText(),rs2.getString(1));
                principal.setVisible(true); 
                this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarReporteActionPerformed
       try {
            JasperReport reporte = null;
            String path = "src\\reportes\\report1.jasper";
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("numeroCuenta",txt_numeroCuenta.getText());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint;
            jprint=JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);      
       } catch (JRException ex) {
           Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btn_generarReporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LimpiarCajas();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Notas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_asignatura;
    private javax.swing.JButton btn_buscarClases;
    private javax.swing.JButton btn_generarReporte;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JCheckBox cbo_reposicion;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_asignatura;
    private javax.swing.JLabel lbl_clase;
    private javax.swing.JLabel lbl_idmatricula;
    private javax.swing.JLabel lbl_notaParcialI;
    private javax.swing.JLabel lbl_notaParcialII;
    private javax.swing.JLabel lbl_notaParcialIII;
    private javax.swing.JLabel lbl_numeroCuenta;
    private javax.swing.JLabel lbl_reposiciones;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JRadioButton rad_reposicionParcialI;
    private javax.swing.JRadioButton rad_reposicionParcialII;
    private javax.swing.JTextField txt_notaParcialI;
    private javax.swing.JTextField txt_notaParcialII;
    private javax.swing.JTextField txt_notaParcialIII;
    private javax.swing.JTextField txt_numeroCuenta;
    // End of variables declaration//GEN-END:variables
}
