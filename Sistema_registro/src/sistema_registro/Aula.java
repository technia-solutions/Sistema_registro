/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
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
 * @author asus
 */
public class Aula extends javax.swing.JFrame {
    Connection con=null;
     String titulos [] = {"Id Aula", "Nombre de Aula","Piso Aula" ,"Id Edificio"};
     Statement stmt = null;
     DefaultTableModel modelo =  new DefaultTableModel();
    String var;
    
     final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
    /**
     * Creates new form Aula
     */
    public Aula() throws SQLException {
         this.con = ConectorSQL.obtenerConexion();
        initComponents();
         ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_edificio();
            for(int i = 0; i<lista.size();i++){
                cbo_idEdificio.addItem(lista.get(i));
            }
             this.setLocationRelativeTo(null);
            this.setTitle("Aulas");
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
             this.btn_eliminar.setEnabled(false);
             this.btn_actualizar.setEnabled(false);
             this.lbl_aula.setVisible(false);
             this.setLocationRelativeTo(null);
    }       
    
     public Aula(String nombreUsuario) throws SQLException {
         this.con = ConectorSQL.obtenerConexion();
        initComponents();
        noVisible();
         ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_edificio();
            for(int i = 0; i<lista.size();i++){
                cbo_idEdificio.addItem(lista.get(i));
            }
             this.setLocationRelativeTo(null);
            this.setTitle("Aulas");
            this.lbl_usuario.setText(nombreUsuario);
            this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.btn_eliminar.setEnabled(false);
            this.btn_actualizar.setEnabled(false);
            this.lbl_aula.setVisible(false);
            this.setLocationRelativeTo(null);
            habilitar(this.lbl_usuario.getText());
     }
      private void noVisible(){
         btn_guardar.setVisible(false);
         btn_actualizar.setVisible(false);
         btn_buscar.setVisible(false);
         btn_eliminar.setVisible(false);
          jMenuItem4.setVisible(false);
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("AulaFunciones").contains("G")){
                    btn_guardar.setVisible(true);
                }
                if(rs.getString("AulaFunciones").contains("A")){
                    btn_actualizar.setVisible(true);
                }
            
                       if(rs.getString("AulaFunciones").contains("B")){
                  btn_buscar.setVisible(true);
                }
                       if(rs.getString("AulaFunciones").contains("E")){
                  btn_eliminar.setVisible(true);
                }
                 if(rs.getString("MatriculaFunciones").contains("I")){
                 jMenuItem4.setVisible(true);
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
        lbl_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_idAula = new javax.swing.JTextField();
        txt_nombreAula = new javax.swing.JTextField();
        txt_PisoAula = new javax.swing.JTextField();
        lbl_idAula = new javax.swing.JLabel();
        lbl_nombreAula = new javax.swing.JLabel();
        lbl_pisoAula = new javax.swing.JLabel();
        lbl_edificio = new javax.swing.JLabel();
        cbo_idEdificio = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Aula = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        lbl_aula = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Aula");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(lbl_titulo)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 720, 60));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        txt_idAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idAula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idAulaFocusLost(evt);
            }
        });
        txt_idAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idAulaActionPerformed(evt);
            }
        });
        txt_idAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idAulaKeyTyped(evt);
            }
        });

        txt_nombreAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombreAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreAulaKeyTyped(evt);
            }
        });

        txt_PisoAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_PisoAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PisoAulaKeyTyped(evt);
            }
        });

        lbl_idAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idAula.setText("Id Aula:");

        lbl_nombreAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreAula.setText("Nombre del Aula:");

        lbl_pisoAula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pisoAula.setText("Piso Aula:");

        lbl_edificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_edificio.setText("Edificio:");

        cbo_idEdificio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un edificio" }));
        cbo_idEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idEdificioActionPerformed(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
        });
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        Tabla_Aula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Aula", "Aula", "Piso Aula", "Edificio"
            }
        ));
        Tabla_Aula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_AulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Aula);

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_aula.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_pisoAula, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_edificio, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_nombreAula, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_idAula, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nombreAula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_idAula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbo_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_PisoAula, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_aula)
                                .addGap(212, 212, 212))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbl_aula)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idAula))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombreAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nombreAula))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_PisoAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_pisoAula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_edificio))
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_buscar)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpiar)))
                        .addGap(30, 30, 30))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 720, 410));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenu1.setText("Regresar");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem3.setText("Menú Principal");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edificio.png"))); // NOI18N
        jMenuItem2.setText("Administrar Edificio");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Seccion.png"))); // NOI18N
        jMenuItem1.setText("Sección");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        jMenuItem4.setText("Imprimir Reporte");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PisoAulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PisoAulaKeyTyped
         char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_PisoAula.getText().length() >=1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_PisoAulaKeyTyped

    private void Tabla_AulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_AulaMouseClicked
        if(Tabla_Aula.getSelectedRow () >= 0){
            try {
                llenarCampos();
             this.btn_guardar.setEnabled(false); 
             this.btn_eliminar.setEnabled(true);
             this.btn_actualizar.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Tabla_AulaMouseClicked

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
try{
        String cadena1, cadena2,cadena3;
        cadena1 = txt_idAula.getText();
        String id_edificio = cbo_idEdificio.getSelectedItem().toString().substring(0, 2);
        cadena2 = txt_nombreAula.getText();
        cadena3 = txt_PisoAula.getText();
        
      
        
         if((txt_idAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id del aula.","Id  de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idAula.requestFocus();
            return;
        }
         
           
         if((txt_nombreAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre del aula.","Nombre de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreAula.requestFocus();
            return;
        }
         
            
         if((txt_PisoAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el piso del aula.","Piso de aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_PisoAula.requestFocus();
            return;
        }
         
         if((cbo_idEdificio.getSelectedItem().equals("Seleccione un edificio"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un edificio para el aula.","Edificio para el aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(existeAula()){
            return;
        }
        
        if(existeNombreAula()){
            return;
        }

        if(!validarLongitud(txt_idAula,4)){
            JOptionPane.showMessageDialog(null, "El id del aula debe ser de 4 caracter.", "Longitud de id del aula.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(txt_nombreAula,3)){
            JOptionPane.showMessageDialog(null, "El Nombre de la aula es muy corto el mínimo es de 3 caracteres.", "Longitud del nombre de aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(txt_PisoAula,1)){
            JOptionPane.showMessageDialog(null, "El piso de la aula es muy corto el mínimo es de 1 caracteres.", "Longitud del piso del aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Aula (id_aula,id_edificio ,nombre_aula,piso_aula)"
                + "                VALUES(?,?,?,?)");
            ps.setString(1, txt_idAula.getText());
            ps.setString(2, id_edificio);
            ps.setString(3, txt_nombreAula.getText());
            ps.setString(4, txt_PisoAula.getText());
            

            int res= ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de aula.");
        } catch ( Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

       actualizarDatos();
        LimpiarCajas();
             }catch(Exception e){
           try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Aula " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
try{
        String Aula = txt_nombreAula.getText() + " ";
        String aula= txt_nombreAula.getText();
        String cap = aula.substring(0, 1).toUpperCase() + aula.substring(1);
          if((txt_idAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id del aula.","Id de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idAula.requestFocus();
            return;
        }
         
           
         if((txt_nombreAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre del aula.","Nombre de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreAula.requestFocus();
            return;
        }
         
            
         if((txt_PisoAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el piso del aula.","Piso de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_PisoAula.requestFocus();
            return;
        }
             if(!validarLongitud(txt_idAula,4)){
            JOptionPane.showMessageDialog(null, "El id del aula debe ser de 4 caracter.", "Longitud de id del aula.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(txt_nombreAula,3)){
            JOptionPane.showMessageDialog(null, "El Nombre de la aula es muy corto el mínimo es de 3 caracteres.", "Longitud del nombre de aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(txt_PisoAula,1)){
            JOptionPane.showMessageDialog(null, "El piso de la aula es muy corto el mínimo es de 1 caracteres.", "Longitud del piso del aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((cbo_idEdificio.getSelectedItem().equals("Seleccione un edificio"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un edificio para el aula.","Edificio para el aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del aula" +Aula + "?.", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            String id_edificio = cbo_idEdificio.getSelectedItem().toString().substring(0, 2);

            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Aula set"
                    + " id_aula= ? ,"
                   + " id_edificio = ? , "
                    + " nombre_aula = ?  , "
                    + " piso_aula = ?  "
                    + " where id_aula =\'"+lbl_aula.getText()+"\'");
                ps.setString(1, txt_idAula.getText());
                ps.setString(2, id_edificio);
                ps.setString(3, txt_nombreAula.getText());
                ps.setString(4, txt_PisoAula.getText());
                 this.btn_guardar.setEnabled(true);
                 this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar.setEnabled(false);

                int res = ps.executeUpdate();
           
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información del aula " + Aula + " correctamente.");

               
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,"Error al actualizar la información de la aula, podría ser por: \n 1.El aula ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la aula a actualizar.\n 3.El aula tiene secciones creadas","¡Error al actualizar!", JOptionPane.ERROR_MESSAGE);
            }
           actualizarDatos();
            LimpiarCajas();

        }
                }catch(Exception e){
           
                try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Aula " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Aula.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
try{
        actualizarDatos();
         }catch(Exception e){
           
                try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Aula " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
try{
    

        String Aula = txt_idAula.getText() + " " + txt_PisoAula.getText();

         if((txt_idAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id del aula.","Id de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idAula.requestFocus();
            return;
        }
         
           
         if((txt_nombreAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre del aula.","Nombre de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreAula.requestFocus();
            return;
        }
         
            
         if((txt_PisoAula.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el piso del aula.","Piso de la aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_PisoAula.requestFocus();
            return;
        }
         
         if((cbo_idEdificio.getSelectedItem().equals("Seleccione un edificio"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un edificio para el aula.","Edificio para el aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          /* if (noexisteAula()){
               return;
           }*/
          if(!noexisteAula()){
               JOptionPane.showMessageDialog(null, "Error al borrar la información del aula, podría ser por que el código de aula no existe.","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
            
                   return;
               }
        
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del aula " + Aula + "?", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Aula "
                + "where id_aula = (Select id_aula from Aula where nombre_aula = '"+txt_nombreAula.getText()+"')";
                 this.btn_guardar.setEnabled(true);
                 this.btn_actualizar.setEnabled(false);
                 this.btn_eliminar.setEnabled(false);

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del aula " + Aula + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!.");

                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e.getMessage());
              JOptionPane.showMessageDialog(null, "Error al borrar la información del aula, podría ser por que el aula se encuentra en uso.","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
     
            }
           actualizarDatos();
            LimpiarCajas();

        }
                    }catch(Exception e){
             try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Aula " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    
    private void cbo_idEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_idEdificioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_idEdificioActionPerformed

    private void txt_idAulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idAulaKeyTyped

        if (txt_idAula.getText().length() >=4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
            || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
            || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
        char a = evt.getKeyChar();
        if (!Character.isLetterOrDigit(a)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras y numeros");
        }
    }//GEN-LAST:event_txt_idAulaKeyTyped

    private void txt_nombreAulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreAulaKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_nombreAula.getText().length() >=3){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_nombreAulaKeyTyped

    private void txt_idAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idAulaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          Secciones ss = null;
        try {
            ss = new Secciones(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
          ss.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
             Edificio ee = null;
        try {
            ee = new Edificio(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Edificio.class.getName()).log(Level.SEVERE, null, ex);
        }
          ee.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
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
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        LimpiarCajas();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_idAulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idAulaFocusLost
        String id = txt_idAula.getText();
        String upper = id.toUpperCase();
        txt_idAula.setText(upper); 
    }//GEN-LAST:event_txt_idAulaFocusLost

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      try {
            JasperReport reporte = null;
            String path = "src\\reportes\\Aula.jasper";
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombreUsuario",lbl_usuario.getText());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint;
            jprint=JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer view = new JasperViewer(jprint,false);
            final JRViewer viewer = new JRViewer(jprint);
            JRSaveContributor[] contrbs = viewer.getSaveContributors();

            for (JRSaveContributor saveContributor : contrbs)
            {
                if (!(saveContributor instanceof net.sf.jasperreports.view.save.JRDocxSaveContributor ||
                    saveContributor instanceof net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor
                    || saveContributor instanceof net.sf.jasperreports.view.save.JRPdfSaveContributor))
            viewer.removeSaveContributor(saveContributor);
        }
        view.setContentPane(viewer);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setVisible(true);
        } catch (Exception e) {

            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Aula " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Aula().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Aula;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbo_idEdificio;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_aula;
    private javax.swing.JLabel lbl_edificio;
    private javax.swing.JLabel lbl_idAula;
    private javax.swing.JLabel lbl_nombreAula;
    private javax.swing.JLabel lbl_pisoAula;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_PisoAula;
    private javax.swing.JTextField txt_idAula;
    private javax.swing.JTextField txt_nombreAula;
    // End of variables declaration//GEN-END:variables

    private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }
    
     private boolean noexisteAula() {
          try {
            Statement st = con.createStatement();
            String sql = "Select id_aula from Aula where id_aula = '"+txt_idAula.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
               
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean existeAula() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_aula from Aula where id_aula = '"+txt_idAula.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Aula: "+txt_idAula.getText()+" ", "Codigo de aula ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
      
    private boolean existeNombreAula() {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_aula from Aula where nombre_aula = '"+txt_nombreAula.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el nombre de aula: "+txt_nombreAula.getText()+".", "Nombre de aula ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private void actualizarDatos() {
        try {
               
               String sql = "SELECT * FROM Aula";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               modelo = new DefaultTableModel(null, titulos);
               Tabla_Aula.setModel(modelo);
                 while(rs.next()) {
                     
                          String []datos= new String[4];
                      datos[0] =rs.getString("id_aula");
                      datos[1] =rs.getString("nombre_aula");          
                      datos[2] =rs.getString("piso_aula");
                      datos[3] =rs.getString("id_edificio");
                      
                      
                     modelo.addRow(datos);
                      
                      centrar_datos();
                 }
           TableColumn  idA= Tabla_Aula.getColumn(titulos[0]);
            idA.setMaxWidth(300);
            TableColumn nomA= Tabla_Aula.getColumn(titulos[1]);
            nomA.setMaxWidth(300);
            TableColumn pisA= Tabla_Aula.getColumn(titulos[2]);
           pisA.setMaxWidth(300);
           TableColumn idE= Tabla_Aula.getColumn(titulos[3]);
           idE.setMaxWidth(300);
         
        }
        catch (Exception e) {
           
            System.err.println(e);
        }
    }

    private void centrar_datos() {
        
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Aula.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }
    }
    
    
       private void rellenar(){
      try {
                    String cap = "";
                    ResultSet rs2 = null;
                  
                            String sql = "SELECT * FROM Aula where id_aula='"+var+"' or nombre_aula ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idAula.setText(rs2.getString("id_aula"));
                                txt_nombreAula.setText(rs2.getString("nombre_aula"));
                                txt_PisoAula.setText(rs2.getString("nombre_aula"));
                               cbo_idEdificio.setSelectedItem((rs2.getString("id_edificio"))+ " - " + rs2.getString("periodo"));
                            }
                        

                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    
    }

    private void LimpiarCajas() {
       
        txt_idAula.setText(null);
        txt_nombreAula.setText(null);
         txt_PisoAula.setText(null);
        cbo_idEdificio.setSelectedIndex(0);
         this.btn_guardar.setEnabled(true); 
         this.btn_eliminar.setEnabled(false);
            this.btn_actualizar.setEnabled(false);
       
        
       
    }

    private void llenarCampos() throws SQLException {
      int i = Tabla_Aula.getSelectedRow();
        txt_idAula.setText(Tabla_Aula.getValueAt(i, 0).toString());
        txt_nombreAula.setText(Tabla_Aula.getValueAt(i, 1).toString());
       txt_PisoAula.setText(Tabla_Aula.getValueAt(i, 2).toString());
       lbl_aula.setText(Tabla_Aula.getValueAt(i, 0).toString());
       String idEdificio = Tabla_Aula.getValueAt(i, 3).toString();
        Statement st = con.createStatement();
        String sql = "select * from Edificio where id_edificio = '"+idEdificio+"'";
        ResultSet rs3 = st.executeQuery(sql);
        if(rs3.next()){
            cbo_idEdificio.setSelectedItem(rs3.getString("id_edificio") + " - " + rs3.getString("nombre_edificio"));
        }
    
    }


}
