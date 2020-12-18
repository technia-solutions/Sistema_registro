/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import static java.awt.Frame.ICONIFIED;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
public class Carrera extends javax.swing.JFrame {
     String titulos [] = {"Id Carrera","Carrera","Facultad", "Nombre de la Facultad"};
    //String fila [] = new String[9];
    DefaultTableModel modelo =  new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;
    final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
     
    /**
     * Creates new form Carrera
     */
    public Carrera() throws SQLException {
          this.con = ConectorSQL.obtenerConexion();
        initComponents();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_Facultad();
            for(int i = 0; i<lista.size();i++){
                cbo_idfacultad.addItem(lista.get(i));
            }
             this.setLocationRelativeTo(null);
            this.setTitle("Carrera");
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.btn_eliminar.setEnabled(false);
            this.btn_actualizar1.setEnabled(false);
            this.lbl_carrera.setVisible(false);
             this.setLocationRelativeTo(null);
            
            
             
    }
    
    public Carrera(String nombreUsuario) throws SQLException {
          this.con = ConectorSQL.obtenerConexion();
        initComponents();
        noVisible();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_Facultad();
            for(int i = 0; i<lista.size();i++){
                cbo_idfacultad.addItem(lista.get(i));
            }
            this.setLocationRelativeTo(null);
            this.setTitle("Carrera");
            this.lbl_usuario.setText(nombreUsuario);
            this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.btn_eliminar.setEnabled(false);
            this.btn_actualizar1.setEnabled(false);
            this.lbl_carrera.setVisible(false);
             this.setLocationRelativeTo(null);
             habilitar(lbl_usuario.getText());
            
    }
          private void noVisible(){
         btn_guardar.setVisible(false);
         btn_actualizar1.setVisible(false);
         btn_buscar.setVisible(false);
         btn_eliminar.setVisible(false);
        btn_eliminar.setVisible(false);
         jMenuItem4.setVisible(false);
        
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("CarreraFunciones").contains("G")){
                    btn_guardar.setVisible(true);
                }
                if(rs.getString("CarreraFunciones").contains("A")){
                    btn_actualizar1.setVisible(true);
                }
            
                       if(rs.getString("CarreraFunciones").contains("B")){
                  btn_buscar.setVisible(true);
                }
                       if(rs.getString("CarreraFunciones").contains("E")){
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

        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Carrera = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar1 = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_nombreCarrera = new javax.swing.JLabel();
        lbl_facultad = new javax.swing.JLabel();
        cbo_idfacultad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxt_NombreCarrera = new javax.swing.JTextArea();
        txt_idCarrera = new javax.swing.JTextField();
        lbl_idCarrera = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        lbl_carrera = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        Regresar_Asignatura = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_Carrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Carrera", "Carrera", "Facultad", "Nombre de la Facultad"
            }
        ));
        Tabla_Carrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CarreraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Carrera);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 870, 110));

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_actualizar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar1.setText("Actualizar");
        btn_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar1ActionPerformed(evt);
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

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        lbl_nombreCarrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreCarrera.setText("Carrera: ");

        lbl_facultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_facultad.setText("Facultad:");

        cbo_idfacultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una facultad" }));

        jtxt_NombreCarrera.setColumns(20);
        jtxt_NombreCarrera.setLineWrap(true);
        jtxt_NombreCarrera.setRows(5);
        jtxt_NombreCarrera.setWrapStyleWord(true);
        jtxt_NombreCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_NombreCarreraKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jtxt_NombreCarrera);

        txt_idCarrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idCarrera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idCarreraFocusLost(evt);
            }
        });
        txt_idCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCarreraActionPerformed(evt);
            }
        });
        txt_idCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idCarreraKeyTyped(evt);
            }
        });

        lbl_idCarrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCarrera.setText("ID Carrera:");

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_carrera.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_actualizar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_facultad)
                                    .addComponent(lbl_idCarrera))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_nombreCarrera)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_idfacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_carrera)
                        .addGap(306, 306, 306))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_guardar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_actualizar1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_buscar)
                            .addComponent(lbl_nombreCarrera)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_carrera)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idCarrera))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar)
                        .addGap(11, 11, 11)
                        .addComponent(btn_limpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_idfacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_facultad))
                        .addGap(68, 68, 68))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 870, 310));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Carrera");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(373, 373, 373))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_titulo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 870, 70));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 630));

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

        Regresar_Asignatura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Regresar_Asignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/books_3025.png"))); // NOI18N
        Regresar_Asignatura.setText("Asignaturas");
        Regresar_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_AsignaturaActionPerformed(evt);
            }
        });
        jMenu1.add(Regresar_Asignatura);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mortarboard_icon-icons.com_64579.png"))); // NOI18N
        jMenuItem1.setText("Facultad");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        jMenuItem4.setText("Imprimir ");
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

    private void txt_idCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCarreraActionPerformed

    private void txt_idCarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idCarreraKeyTyped
        if (txt_idCarrera.getText().length() >=4) {
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
    }//GEN-LAST:event_txt_idCarreraKeyTyped

    private void Tabla_CarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CarreraMouseClicked
          if(Tabla_Carrera.getSelectedRow() >= 0){
           
           
              llenarCampos();
        }
    }//GEN-LAST:event_Tabla_CarreraMouseClicked

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
             String cadena1, cadena2, cadena3;
        cadena1 = txt_idCarrera.getText();
        cadena2 = jtxt_NombreCarrera.getText();
       String id_facultad = cbo_idfacultad.getSelectedItem().toString().substring(0, 3);

        if((txt_idCarrera.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idCarrera.requestFocus();
            return;
        }
        
        if((jtxt_NombreCarrera.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jtxt_NombreCarrera.requestFocus();
            return;
        }
        
          
        if((cbo_idfacultad.getSelectedItem().equals("Seleccione una facultad"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       

        if (existeCarrera()) {
            return;
        }
        
          if (existeidCarrera()) {
            return;
        }

        if (!validarLongitud(txt_idCarrera, 3)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy pequeño el mínimo es de 3 caracteres", "Longitud de id carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(jtxt_NombreCarrera,10 )) {
            JOptionPane.showMessageDialog(null, "El  nombre ingresado es muy pequeño el mínimo es de 10 caracteres", "Longitud de nombre carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Carrera (id_carrera, nombre_carrera,id_facultad)"
                + "                VALUES(?,?,?)");
            ps.setString(1, txt_idCarrera.getText());
            ps.setString(2, jtxt_NombreCarrera.getText());
             ps.setString(3, id_facultad);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guradod la información de la carrera");
        } catch (Exception e) {
            System.out.println(e);

        }
     
        actualizarDatos();
        LimpiarCajas();
          } catch (Exception e) {
              
            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Carrera.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            actualizarDatos();
            
        } catch (Exception e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
              String nombreCarrera = jtxt_NombreCarrera.getText();
          
          if((txt_idCarrera.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idCarrera.requestFocus();
            return;
            }
        
            if((jtxt_NombreCarrera.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jtxt_NombreCarrera.requestFocus();
            return;
         }
        
          
            if((cbo_idfacultad.getSelectedItem().equals("Seleccione una facultad"))){
                javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }
              else if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro de la carrera "+nombreCarrera+"","Confirmación de eliminación",
                       JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
                )==JOptionPane.YES_OPTION){   
                    String id_facultad = cbo_idfacultad.getSelectedItem().toString().substring(0, 2);
          try{
              PreparedStatement ps;
              ResultSet rs;
              ps=con.prepareStatement("Delete Carrera "
                  + "where id_carrera = (Select id_carrera from Carrera where nombre_carrera = '"+jtxt_NombreCarrera.getText()+"')");
                        this.btn_eliminar.setEnabled(false);
            this.btn_actualizar1.setEnabled(false);
            this.btn_guardar.setEnabled(true);
            
                int res= ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Se ha borrado la información de la carrera "+nombreCarrera+" correctamente");
                  if(res > 0){ 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                  }
        } catch ( Exception e) {
            System.out.println(e);
        }
           }
           actualizarDatos();
           LimpiarCajas();
        } catch (Exception e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar1ActionPerformed
            
        try {
              
            String nombreCarrera = jtxt_NombreCarrera.getText() + " ";
              if((txt_idCarrera.getText().equals(""))){
                javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txt_idCarrera.requestFocus();
                return;
            }

            if((jtxt_NombreCarrera.getText().equals(""))){
                javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jtxt_NombreCarrera.requestFocus();
                return;
            }


            if((cbo_idfacultad.getSelectedItem().equals("Seleccione una facultad"))){
                javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }
                else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de carrera" + nombreCarrera + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
            ) == JOptionPane.YES_OPTION) {
               String id_facultad = cbo_idfacultad.getSelectedItem().toString().substring(0, 2);
                try {
                    PreparedStatement ps;
                    ResultSet rs;
                    ps = con.prepareStatement("Update Carrera set"
                            + " nombre_carrera = ? ,"
                            + " id_carrera = ? ,"
                            + " id_facultad = ? "
                            + " where id_carrera =\'"+lbl_carrera.getText()+"\'");

                    ps.setString(1, jtxt_NombreCarrera.getText());
                    ps.setString(2, txt_idCarrera.getText());
                    ps.setString(3, id_facultad);
                    this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar1.setEnabled(false);
                 this.btn_guardar.setEnabled(true);
                    int res = ps.executeUpdate();
                     if(res > 0){
                        JOptionPane.showMessageDialog(null, "Se ha actualizado la información de la carerra " +nombreCarrera + " correctamente.");

                    }else {
                        JOptionPane.showMessageDialog(null, "¡Error al actualizado la información!.");

                     }

                } catch (Exception e) {
                    System.out.println(e);
            }
           
            }
            actualizarDatos();
            LimpiarCajas();
        } catch (Exception e) {
             try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btn_actualizar1ActionPerformed

    private void Regresar_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_AsignaturaActionPerformed
        
         this.dispose();
        Asignaturas aa = null;
         try {
             aa = new Asignaturas(lbl_usuario.getText());
         } catch (SQLException e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }
        aa.setVisible(true);
        
    


        
    }//GEN-LAST:event_Regresar_AsignaturaActionPerformed

    private void txt_idCarreraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idCarreraFocusLost
         String id = txt_idCarrera.getText();
        String lower = id.toLowerCase();
        txt_idCarrera.setText(lower); 
    }//GEN-LAST:event_txt_idCarreraFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     this.dispose();
        Facultad ff = null;
         try {
             ff = new Facultad(lbl_usuario.getText());
         } catch (SQLException e) {
             try {
                Log myLog; 
                 String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }
        ff.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jtxt_NombreCarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_NombreCarreraKeyTyped
       
          if (jtxt_NombreCarrera.getText().length() >= 100) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
            || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
            || evt.getKeyChar() == 32 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
        
    }//GEN-LAST:event_jtxt_NombreCarreraKeyTyped

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
        } catch (SQLException e) {
            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        LimpiarCajas();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
             
           
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
               try {
            JasperReport reporte = null;
            String path = "src\\reportes\\carrera.jasper";
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
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
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
            java.util.logging.Logger.getLogger(Carrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Carrera().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Regresar_Asignatura;
    private javax.swing.JTable Tabla_Carrera;
    private javax.swing.JButton btn_actualizar1;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbo_idfacultad;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtxt_NombreCarrera;
    private javax.swing.JLabel lbl_carrera;
    private javax.swing.JLabel lbl_facultad;
    private javax.swing.JLabel lbl_idCarrera;
    private javax.swing.JLabel lbl_nombreCarrera;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_idCarrera;
    // End of variables declaration//GEN-END:variables

    private boolean existeidCarrera() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_carrera from Carrera where id_carrera = '" + txt_idCarrera.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id carrera: " + txt_idCarrera.getText() + " ya existe", "El id  carrera ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
      private boolean existeCarrera() {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_carrera from Carrera where nombre_carrera = '" + jtxt_NombreCarrera.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La carrera: " + jtxt_NombreCarrera.getText() + " ya existe", "La  carrera ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean validarLongitud( JTextArea texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }
    
     private boolean validarLongitud( JTextField texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }

    private void llenarCampos() {
        int i = Tabla_Carrera.getSelectedRow();
        txt_idCarrera.setText(Tabla_Carrera.getValueAt(i, 0).toString());
        jtxt_NombreCarrera.setText(Tabla_Carrera.getValueAt(i, 1).toString());
        cbo_idfacultad.setSelectedItem(Tabla_Carrera.getValueAt(i, 2).toString() + " - " + Tabla_Carrera.getValueAt(i, 3).toString());
         this.btn_eliminar.setEnabled(true);
         this.btn_actualizar1.setEnabled(true);
         this.btn_guardar.setEnabled(false);
         this.lbl_carrera.setText((Tabla_Carrera.getValueAt(i, 0).toString()));
    }

    private void rellenar() {
        try {
                    String cap = "";
                    ResultSet rs2 = null;
                   
                            String sql = "SELECT * FROM Carrera where id_carrera='"+var+"' or nombre_carrera ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idCarrera.setText(rs2.getString("id_carrera"));
                                jtxt_NombreCarrera.setText(rs2.getString("nombre_carrera"));
                                cbo_idfacultad.setSelectedItem((rs2.getString("id_facultad")+ " - " + rs2.getString("nombre_facultad")));
                            }
                        

                    
                } catch (Exception e) {
                     try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                }
    }
    
     public void centrar_datos(){
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Carrera.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);   
         }
    }
     
      public void actualizarDatos() {
          
        try {
            String sql = "SELECT * FROM Carrera as c join Facultad as f on f.id_facultad = c.id_facultad";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Carrera.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[4];
                datos[0] = rs.getString("id_carrera");
                datos[1] = rs.getString("nombre_carrera");
                datos[2] =rs.getString("id_facultad");
                datos[3] =rs.getString("nombre_facultad");
                modelo.addRow(datos);
            }
            TableColumn idC = Tabla_Carrera.getColumn(titulos[0]);
            idC.setMaxWidth(300);
            idC.setIdentifier(ICONIFIED);
            TableColumn cnombre = Tabla_Carrera.getColumn(titulos[1]);
            cnombre.setMaxWidth(300);
            TableColumn cfacultad = Tabla_Carrera.getColumn(titulos[2]);
                cfacultad.setMaxWidth(300);
                TableColumn facultad = Tabla_Carrera.getColumn(titulos[3]);
                facultad.setMaxWidth(300);
        } catch (Exception e) {
           try {
               
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Carrera " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       
            }
            
        }
    }
      
    private void LimpiarCajas(){
        jtxt_NombreCarrera.setText(null);
        txt_idCarrera.setText(null);
        cbo_idfacultad.setSelectedIndex(0);
        this.btn_eliminar.setEnabled(false);
         this.btn_actualizar1.setEnabled(false);
         this.btn_guardar.setEnabled(true);
        
    }
}

