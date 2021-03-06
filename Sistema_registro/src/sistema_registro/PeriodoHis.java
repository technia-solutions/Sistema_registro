/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import static java.awt.Frame.ICONIFIED;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
 * @author Mitsuki
 */
public class PeriodoHis extends javax.swing.JFrame {
Connection con;
String titulos[] = {"Nombre del período", "Fecha inicial", "Fecha final", "Período","Descripción"};
DefaultTableModel modelo = new DefaultTableModel();
 final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);


    /**
     * Creates new form PeriodoHis
     */
    public PeriodoHis() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        actualizarDatos();
        this.lbl_nombrePeriodo.setVisible(false);
        this.lbl_nombre.setVisible(false);
          ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_period();
            for(int i = 0; i<lista.size();i++){
                cbo_periodo.addItem(lista.get(i));
                }
            
           this.btn_Actualizar.setEnabled(false); 
           this.setTitle("Período Histórico");
           this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.setLocationRelativeTo(null);
            noVisible();
            habilitar(lbl_usuario.getText());
    }
    
    
     public PeriodoHis(String nombreUsuario) throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
          noVisible();
        actualizarDatos();
        this.lbl_nombrePeriodo.setVisible(false);
        this.lbl_nombre.setVisible(false);
          ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_period();
            for(int i = 0; i<lista.size();i++){
                cbo_periodo.addItem(lista.get(i));
                }
            
           this.btn_Actualizar.setEnabled(false); 
             this.setTitle("Período Histórico");
              this.lbl_usuario.setText(nombreUsuario);
              habilitar(this.lbl_usuario.getText());
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
          this.setLocationRelativeTo(null);
          
         
          
          
    }
      private void noVisible(){
         btn_Guardar.setVisible(false);
         btn_Actualizar.setVisible(false);
         btn_consulta.setVisible(false);
         jMenuItem1.setVisible(false);
         
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("PeriodosFunciones").contains("G")){
                    btn_Guardar.setVisible(true);
                }
                if(rs.getString("PeriodosFunciones").contains("A")){
                    btn_Actualizar.setVisible(true);
                }
            
                       if(rs.getString("PeriodosFunciones").contains("B")){
                  btn_consulta.setVisible(true);
                       }
                       
                     if(rs.getString("PeriodosFunciones").contains("I")){
                  jMenuItem1.setVisible(true);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_periodo = new javax.swing.JLabel();
        lbl_fechaInicial = new javax.swing.JLabel();
        lbl_fechaFinal = new javax.swing.JLabel();
        cld_fechaInicial = new com.toedter.calendar.JDateChooser();
        cld_fechaFinal = new com.toedter.calendar.JDateChooser();
        btn_Guardar = new javax.swing.JButton();
        cbo_periodo = new javax.swing.JComboBox<>();
        btn_Actualizar = new javax.swing.JButton();
        btn_consulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Periodo = new javax.swing.JTable();
        lbl_nombrePeriodo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPrincipal = new javax.swing.JMenuItem();
        jMenuPrincipal1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(232, 251, 249));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Período Histórico");

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        lbl_periodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_periodo.setText("Período:");

        lbl_fechaInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_fechaInicial.setText("Fecha inicial:");

        lbl_fechaFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_fechaFinal.setText("Fecha final:");

        cld_fechaInicial.setDateFormatString("dd/MM/yyyy");

        cld_fechaFinal.setDateFormatString("dd/MM/yyyy");

        btn_Guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_Guardar.setText("Guardar");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });

        cbo_periodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Período" }));

        btn_Actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        btn_consulta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_consulta.setText("Buscar");
        btn_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultaActionPerformed(evt);
            }
        });

        Tabla_Periodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del periodo", "Fecha inicial", "Fecha final", "Periodo", "Descripción"
            }
        ));
        Tabla_Periodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PeriodoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Periodo);

        lbl_nombrePeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombrePeriodo.setText("Nombre del Período:");

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombre.setText("Nombre");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lbl_fechaFinal))
                                .addComponent(lbl_fechaInicial)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(lbl_periodo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_nombrePeriodo)
                                .addGap(5, 5, 5)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_periodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cld_fechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cld_fechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(358, 358, 358))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btn_Guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombrePeriodo)
                    .addComponent(lbl_nombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbl_fechaFinal))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbl_fechaInicial))
                    .addComponent(lbl_periodo)
                    .addComponent(cbo_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cld_fechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(cld_fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1090, -1));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 720));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");

        jMenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuPrincipal.setText("Menu Principal");
        jMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPrincipal);

        jMenuPrincipal1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/books_3025.png"))); // NOI18N
        jMenuPrincipal1.setText("Período");
        jMenuPrincipal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipal1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPrincipal1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        jMenuItem1.setText("Imprimir");
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

    public void Limpiar(){

        cbo_periodo.setSelectedIndex(0);
       
       cld_fechaInicial.setDate(null);
        cld_fechaFinal.setDate(null);
        lbl_nombre.setText(null);
        
       
        
    
        
    }
    
   
    
    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed

            try {
            
        String nombre,periodo;
        periodo=cbo_periodo.getSelectedItem().toString().substring(0,1);
        Date dateinicial = cld_fechaInicial.getDate();
        Date datefinal = cld_fechaFinal.getDate();

   
        
              if((cbo_periodo.getSelectedItem().equals("Seleccione un Período"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un período .","Período Requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
 
      if( (cld_fechaInicial.getDate()== null)){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la fecha de inicio del período.","Fecha Inicial Requerida",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
      
      if( (cld_fechaInicial.equals(cld_fechaFinal))){
        javax.swing.JOptionPane.showMessageDialog(this,"Error al ingresar fecha de inicio del periodo.", "Fecha Inicial invalida", javax.swing.JOptionPane.INFORMATION_MESSAGE);
          //return;
      }
        
       if( (cld_fechaFinal.equals(cld_fechaInicial))){
        javax.swing.JOptionPane.showMessageDialog(this,"Error al ingresar fecha final del periodo.", "Fecha Final invalida", javax.swing.JOptionPane.INFORMATION_MESSAGE);
          //return;
      }
      
        if( (cld_fechaFinal.getDate()== null)){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la fecha final del período.","Fecha Final Requerida",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            cld_fechaFinal.requestFocus();
            return;
         }
        
        
        int mes = cld_fechaInicial.getDate().getMonth() + 1;
        int año = cld_fechaInicial.getDate().getYear() +1900;
        int dia =cld_fechaInicial.getDate().getDate();
        
        
           
        String fecha = año + "-" + mes +"-"+ dia;

        int mes2 = cld_fechaFinal.getDate().getMonth() + 1;
        int año2 = cld_fechaFinal.getDate().getYear() +1900;
        int dia2 =cld_fechaFinal.getDate().getDate();
        String fecha2 = año2 + "-" + mes2 +"-"+ dia2;

      
  
        nombre=año+"-"+periodo;
                    
 //JOptionPane.showMessageDialog(null, "Se ha guardado el período: "+nombre+periodo);

     

        
        
 
        try{
            PreparedStatement ps;
            ResultSet rs;
              Statement stdoble = con.createStatement();
               String sqldoble = "select* from Periodo_historico \n" +
                                    "where nombre_periodo_historico='"+nombre+"'";
               ResultSet rsdoble = stdoble.executeQuery(sqldoble);
               if (rsdoble.next()) {

                  JOptionPane.showMessageDialog(null, "El período: " +nombre+ " ya esta creada. ", "Período Ya Creada", JOptionPane.ERROR_MESSAGE);
                   return ;
               }    
            ps=con.prepareStatement("insert into Periodo_historico(fecha_final,fecha_inicial,id_periodo,nombre_periodo_historico)"
                + "             VALUES(?,?,?,?)");

            ps.setString(1, fecha2);
            ps.setString(2, fecha);
            ps.setString(3, periodo);
            ps.setString(4, nombre);


            int res= ps.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Se ha guardado el periodo: "+nombre);
                actualizarDatos();
                // limpiar();
            }else {
                JOptionPane.showMessageDialog(null, "Error al Guardar la información");
            }

        } catch ( Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Error al Guardar la información de Periodo Historico");
            
        }
        
            } catch (Exception e) {
                
                     try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                myLog = new Log(nombreArchivo);

                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
     
        try {
        
        if ((cbo_periodo.getSelectedItem().equals("Seleccione una Periodo")||  (cld_fechaInicial.getDate()== null) ||  (cld_fechaFinal.getDate()== null))) {
            JOptionPane.showMessageDialog(this, "¡Debe rellenar todos los campos!");
        }

       else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el periodo ?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            String nombre,periodo;
        periodo=cbo_periodo.getSelectedItem().toString().substring(0,1);
        Date dateinicial = cld_fechaInicial.getDate();
        Date datefinal = cld_fechaFinal.getDate();

        int mes = cld_fechaInicial.getDate().getMonth() + 1;
        int año = cld_fechaInicial.getDate().getYear() +1900;
        int dia =cld_fechaInicial.getDate().getDate();
        String fecha = año + "-" + mes +"-"+ dia;

        int mes2 = cld_fechaFinal.getDate().getMonth() + 1;
        int año2 = cld_fechaFinal.getDate().getYear() +1900;
        int dia2 =cld_fechaFinal.getDate().getDate();
        String fecha2 = año2 + "-" + mes2 +"-"+ dia2;

        nombre=año+"-"+periodo;
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("update Periodo_historico set\n" +
                                            "id_periodo=?,\n" +
                                            "fecha_inicial=?,\n" +
                                            "fecha_final=?,\n" +
                                            "nombre_periodo_historico=?\n" +
                                            "where nombre_periodo_historico= '"+lbl_nombre.getText()+"'");
              
                ps.setString(1,periodo);
                ps.setString(2,fecha);
                ps.setString(3,fecha2);
                ps.setString(4,nombre);
                int res = ps.executeUpdate();
                
                 if(res > 0){
                JOptionPane.showMessageDialog(null, "Se ha Actualizado el periodo: "+nombre);
                actualizarDatos();
                Limpiar();
                this.lbl_nombre.setVisible(false);
                this.lbl_nombrePeriodo.setVisible(false);
                this.btn_Actualizar.setEnabled(false);
                this.btn_Guardar.setEnabled(true);
            }else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar la información");
            }
                
            } catch (Exception e) {
                System.out.println(e);
                              JOptionPane.showMessageDialog(null, "No se ha realizado la actualización por: \n 1.El periodo historico ya está definido."
                         + "\n 2. No se encuentra el id del periodo historico a actualizar.","¡Error al Actualizar!", JOptionPane.ERROR_MESSAGE);
            }
          
        }
     //btn_agregarPeriodo.setEnabled(true);
        //this.btn_actualizar.setEnabled(false);
     
     
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                    myLog = new Log(nombreArchivo);

                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    public void rellenar(){
        
        try {
                    try{
                    String cap="";
                    ResultSet rs2 = null;
                    String var = JOptionPane.showInputDialog(this,"Ingrese el nombre del período histórico que desea buscar","Consulta de período histórico",JOptionPane.QUESTION_MESSAGE);
                    if(var == null)
                        JOptionPane.showMessageDialog(this,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this,"Favor de ingresar los datos del período histórico\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            String sql = "SELECT * FROM Periodo_historico as ph join Periodo as p on p.id_periodo = ph.id_periodo\n" +
                                         "where nombre_periodo_historico = '"+var+"' "
                                        + "and ph.id_periodo = (select id_periodo from Periodo_historico where nombre_periodo_historico = '"+var+"')";
                            Statement stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                            if(rs2.next()) {
                                lbl_nombre.setText(rs2.getString("nombre_periodo_historico"));
                                cbo_periodo.setSelectedItem(rs2.getString("id_periodo") + " - " + rs2.getString("descripcion"));
                                cld_fechaInicial.setDate(rs2.getDate("fecha_inicial"));
                                cld_fechaFinal.setDate(rs2.getDate("fecha_final"));
                                lbl_nombre.setText(rs2.getString("nombre_periodo_historico"));
                                lbl_nombrePeriodo.setVisible(true);
                                lbl_nombre.setVisible(true);
                               // aqui poner lo que rellena
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el período histórico! Por favor verifique sí, lo escribió correctamente");
                            }
                        }  
                    }
                    }catch (Exception e) {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                            }
     
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                    myLog = new Log(nombreArchivo);

                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                    
    }
    private void btn_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultaActionPerformed
       
        try {
        
        rellenar();
        btn_Guardar.setEnabled(false);
        this.btn_Actualizar.setEnabled(true);
        // TODO add your handling code here:
        
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btn_consultaActionPerformed

    private void Tabla_PeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PeriodoMouseClicked
    try {
        llenarCampos();
        this.btn_Actualizar.setEnabled(true);
        btn_Guardar.setEnabled(false);
        // TODO add your handling code here:
    } catch (ParseException ex) {
        Logger.getLogger(PeriodoHis.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_Tabla_PeriodoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
        
        Limpiar();
        this.lbl_nombre.setVisible(false);
        this.lbl_nombrePeriodo.setVisible(false);
          this.btn_Actualizar.setEnabled(false);
          this.btn_Guardar.setEnabled(true);
          
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                 myLog = new Log(nombreArchivo);

                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipalActionPerformed
      
        try {
        
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
        
        } catch (Exception e) {
            
                  try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                    myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_jMenuPrincipalActionPerformed

    private void jMenuPrincipal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipal1ActionPerformed
       
        try{
        
        Periodo pp = null;
        try {
            pp = new Periodo(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp.setVisible(true);
        this.dispose();
        
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                    myLog = new Log(nombreArchivo);

                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_jMenuPrincipal1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          try {
            JasperReport reporte = null;
            String path = "src\\reportes\\PeriodoHistorico.jasper";
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
                String nombreArchivo = "src\\Logs\\PeriodoHistorico " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void actualizarDatos() {
        
        try {
        
        try {
            String sql = "SELECT * FROM Periodo_historico as ph join Periodo as p on p.id_periodo = ph.id_periodo";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Periodo.setModel(modelo);
            while (rs.next()) {
                Date fechaInicial = rs.getDate("fecha_inicial");
                Date fechaFinal = rs.getDate("fecha_final");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = formatter.format(fechaInicial);
                String fechaFin = formatter.format(fechaFinal);
                String[] datos = new String[5];
                datos[0] = rs.getString("nombre_periodo_historico");
                datos[1] = fechaInicio;
                datos[2] = fechaFin;
                datos[3] = rs.getString("id_periodo");
                datos[4] = rs.getString("descripcion");
                modelo.addRow(datos);
            }
            TableColumn idC = Tabla_Periodo.getColumn(titulos[0]);
            idC.setWidth(400);
            idC.setIdentifier(ICONIFIED);
            TableColumn fechaInicial = Tabla_Periodo.getColumn(titulos[1]);
            fechaInicial.setWidth(300);
            TableColumn fechaFinal = Tabla_Periodo.getColumn(titulos[2]);
            fechaFinal.setWidth(300);
            TableColumn idPeriodo = Tabla_Periodo.getColumn(titulos[3]);
            idPeriodo.setWidth(300);
            TableColumn descripcion = Tabla_Periodo.getColumn(titulos[4]);
            idPeriodo.setWidth(450);
           
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
        
        } catch (Exception e) {
            
                  try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\PeriodoHis " + fecha + ".txt";
                    myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    private void llenarCampos() throws ParseException{
        int i = Tabla_Periodo.getSelectedRow();
        cbo_periodo.setSelectedItem(Tabla_Periodo.getValueAt(i, 3).toString() + " - " + Tabla_Periodo.getValueAt(i, 4).toString());
        String fechaInicial = Tabla_Periodo.getValueAt(i, 1).toString();
        String fechaFinal = Tabla_Periodo.getValueAt(i, 2).toString();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicial2 = df.parse(fechaInicial);
        Date fechaFinal2 = df.parse(fechaFinal);
        
        cld_fechaInicial.setDate(fechaInicial2);
        cld_fechaFinal.setDate(fechaFinal2);
        this.lbl_nombrePeriodo.setVisible(true);
        this.lbl_nombre.setText(Tabla_Periodo.getValueAt(i, 0).toString());
         this.lbl_nombre.setVisible(true);
        /*cbo_periodo.setSelectedItem(rs2.getString("id_periodo") + " - " + rs2.getString("descripcion"));
        txt_Nombre.setText(Tabla_Empleados.getValueAt(i, 1).toString());
        txt_Apellido.setText(Tabla_Empleados.getValueAt(i, 2).toString());
        txt_Salario.setText(Tabla_Empleados.getValueAt(i, 3).toString().substring(1)); */
  
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
            java.util.logging.Logger.getLogger(PeriodoHis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeriodoHis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeriodoHis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeriodoHis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PeriodoHis().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PeriodoHis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Periodo;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_consulta;
    private javax.swing.JComboBox<String> cbo_periodo;
    private com.toedter.calendar.JDateChooser cld_fechaFinal;
    private com.toedter.calendar.JDateChooser cld_fechaInicial;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JMenuItem jMenuPrincipal1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fechaFinal;
    private javax.swing.JLabel lbl_fechaInicial;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombrePeriodo;
    private javax.swing.JLabel lbl_periodo;
    private javax.swing.JLabel lbl_usuario;
    // End of variables declaration//GEN-END:variables
}
