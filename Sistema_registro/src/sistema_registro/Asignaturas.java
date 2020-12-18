/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
 * @author William
 */
public class Asignaturas extends javax.swing.JFrame {
   String titulos [] = {"Código de Asignatura", "Nombre de la Asignatura", "Unidades Valorativas", "Id Carrera", "Requisito1", "Requisito2"};

    Connection con = null;
   
    DefaultTableModel modelo =  new DefaultTableModel();
    Statement stmt = null;
    String var, var2;
    final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
     
   
/**
    /**
     * Creates new form Asignaturas
     */
    public Asignaturas() throws SQLException {
        this.con = ConectorSQL.obtenerConexion ();
        initComponents();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_IdCarrera.addItem(lista.get(i));
            }
             ArrayList<String> lista2 = new ArrayList<String>();
             lista2 = new Conexion_consulta().llenar_requisito();
            for(int i = 0; i<lista2.size();i++){
               cbo_Req1.addItem(lista2.get(i));
               cbo_Req2.addItem(lista2.get(i));
            }
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.setTitle("Asignaturas");
            this.btn_eliminar1.setEnabled(false);
            this.btn_actualizar.setEnabled(false);
            this.lbl_codigo.setVisible(false);
              this.setLocationRelativeTo(null);
    }
    
     public Asignaturas(String nombreUsuario) throws SQLException {
        this.con = ConectorSQL.obtenerConexion ();
        initComponents();
        noVisible();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_IdCarrera.addItem(lista.get(i));
            }
             ArrayList<String> lista2 = new ArrayList<String>();
             lista2 = new Conexion_consulta().llenar_requisito();
            for(int i = 0; i<lista2.size();i++){
               cbo_Req1.addItem(lista2.get(i));
               cbo_Req2.addItem(lista2.get(i));
            }
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.setTitle("Asignaturas");
            String usuario = nombreUsuario;
            this.lbl_usuario.setText(usuario);
            this.btn_eliminar1.setEnabled(false);
            this.btn_actualizar.setEnabled(false);
            this.lbl_codigo.setVisible(false);
              this.setLocationRelativeTo(null);
              habilitar(this.lbl_usuario.getText());
    }
     
      private void noVisible(){
         btn_guardar.setVisible(false);
         btn_actualizar.setVisible(false);
         btn_buscar.setVisible(false);
         btn_eliminar1.setVisible(false);
          jMenuItem3.setVisible(false);
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("AsignaturaFunciones").contains("G")){
                    btn_guardar.setVisible(true);
                }
                if(rs.getString("AsignaturaFunciones").contains("A")){
                    btn_actualizar.setVisible(true);
                }
            
                       if(rs.getString("AsignaturaFunciones").contains("B")){
                  btn_buscar.setVisible(true);
                }
                       if(rs.getString("AsignaturaFunciones").contains("E")){
                  btn_eliminar1.setVisible(true);
                }
                           if(rs.getString("SeccionesFunciones").contains("I")){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_RegistroAsignatura = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_UniVal = new javax.swing.JLabel();
        lbl_IdCarrera = new javax.swing.JLabel();
        cbo_Req1 = new javax.swing.JComboBox<>();
        cbo_Req2 = new javax.swing.JComboBox<>();
        lbl_Req1 = new javax.swing.JLabel();
        lbl_Req2 = new javax.swing.JLabel();
        cbo_IdCarrera = new javax.swing.JComboBox<>();
        txt_UniVal = new javax.swing.JTextField();
        txt_codA = new javax.swing.JTextField();
        lbl_NombreA = new javax.swing.JLabel();
        lbl_codA = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar1 = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_requisitos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_NombreA = new javax.swing.JTextArea();
        btn_consultar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        lbl_codigo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_RegistroAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Asignatura", "Asignatura", "UV", "Id Carrera", "Requisito 1", "Requisito 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_RegistroAsignatura.setToolTipText("Presiona consulta para ver todas las asignaturas\n");
        Tabla_RegistroAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_RegistroAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_RegistroAsignatura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 840, 106));

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Asignatura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(338, 338, 338))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 70));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        lbl_UniVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_UniVal.setText("Unidad Valorativa:");

        lbl_IdCarrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_IdCarrera.setText("Carrera:");

        cbo_Req1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la asignatura 1:", "Sin requisito" }));
        cbo_Req1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Req1ActionPerformed(evt);
            }
        });

        cbo_Req2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la asignatura 2:", "Sin requisito" }));
        cbo_Req2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_Req2ActionPerformed(evt);
            }
        });

        lbl_Req1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Req1.setText("Requisito 1:");

        lbl_Req2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Req2.setText("Requisito 2:");

        cbo_IdCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una carrera" }));
        cbo_IdCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_IdCarreraActionPerformed(evt);
            }
        });

        txt_UniVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_UniVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UniValActionPerformed(evt);
            }
        });
        txt_UniVal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_UniValKeyTyped(evt);
            }
        });

        txt_codA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_codA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codAFocusLost(evt);
            }
        });
        txt_codA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codAActionPerformed(evt);
            }
        });
        txt_codA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codAKeyTyped(evt);
            }
        });

        lbl_NombreA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreA.setText("Nombre de la Asignatura:");

        lbl_codA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_codA.setText("Código de la Asignatura:");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/magnifier-1_icon-icons.com_56924.png"))); // NOI18N
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

        btn_eliminar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar1.setText("Eliminar");
        btn_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar1ActionPerformed(evt);
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

        btn_requisitos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_requisitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/writing-on-an-open-book_icon-icons.com_70325.png"))); // NOI18N
        btn_requisitos.setText("Requisitos");
        btn_requisitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requisitosActionPerformed(evt);
            }
        });

        txa_NombreA.setColumns(20);
        txa_NombreA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txa_NombreA.setLineWrap(true);
        txa_NombreA.setRows(5);
        txa_NombreA.setWrapStyleWord(true);
        txa_NombreA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txa_NombreAKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txa_NombreA);

        btn_consultar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
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

        lbl_codigo.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_requisitos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_NombreA)
                            .addComponent(lbl_UniVal)
                            .addComponent(lbl_codA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codA, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_UniVal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_Req2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_Req2, 0, 208, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_IdCarrera)
                                    .addComponent(lbl_Req1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_Req1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(cbo_IdCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(102, 102, 102))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_codigo)
                .addGap(198, 198, 198))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(btn_actualizar))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lbl_codA)
                            .addGap(27, 27, 27)
                            .addComponent(lbl_NombreA)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_codigo)
                        .addGap(18, 18, 18)
                        .addComponent(txt_codA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar1)
                    .addComponent(txt_UniVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UniVal))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar)
                    .addComponent(cbo_IdCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IdCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_Req1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Req1))
                    .addComponent(btn_requisitos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbo_Req2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Req2)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar)
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 840, 480));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 1240, 790));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem1.setText("Menu Principal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mortarboard_icon-icons.com_64579.png"))); // NOI18N
        jMenuItem2.setText("Carrera");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
            try{
             rellenar();
        }
        catch(Exception e){
             try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
  
        try {
             String nombreAsignatura = txa_NombreA.getText() + " ";
         String uv = txt_UniVal.getText();
       
        
         if((txt_codA.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el código de la asignatura.","Código asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_codA.requestFocus();
            return;
         }
        
          if((txa_NombreA.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la asignatura.","Nombre asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txa_NombreA.requestFocus();
            return;
         }
         
          if((txt_UniVal.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la unidad valorativa de la asignatura.","Unidad valorativa de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_UniVal.requestFocus();
            return;
         }
          
         if((cbo_IdCarrera.getSelectedItem().equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una carrera para la asignatura","Carrera de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
         
         if((cbo_Req1.getSelectedItem().equals("Seleccione la asignatura 1:"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un requisito para la asignatura","Requisito1 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
            }
        
         if((cbo_Req2.getSelectedItem().equals("Seleccione la asignatura 2:"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un requisito para la asignatura","Requisito2 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
            }

     

            if(!validarLongitud(txt_codA,3)){
            JOptionPane.showMessageDialog(null, "El codigo de asignaturas tiene que ser minimo de 3 caracteres", "Longitud de codigo de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
         }

          if(!validarLongitud(txa_NombreA,7)){
            JOptionPane.showMessageDialog(null, "El Nombre de la asignatura es muy corto el mínimo es de 7 caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
         }
           if(!validarUV(uv)){
            JOptionPane.showMessageDialog(null, "La unidades solo pueden ser valores entre 1 y 15", "Valor de la unidad valorativa", JOptionPane.INFORMATION_MESSAGE);
            return;
           }
       
            if(!validarLongitud(txt_UniVal,1)){
            JOptionPane.showMessageDialog(null, "La unidades valorativas debe ser de un mínimo de 1 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
         }
        
            if(!validarRequisitos(cbo_Req1.getSelectedItem().toString(),cbo_Req2.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 no puede ser igual al requisito 2", "Requisitos iguales", JOptionPane.INFORMATION_MESSAGE);
            return;
         }
            
         if(validarVacio(cbo_Req1.getSelectedItem().toString(),cbo_Req2.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 y el requisito 2 están vacíos.", "Requisitos vacíos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        
           else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de la asignatura " +nombreAsignatura + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
         ) == JOptionPane.YES_OPTION) {
            String id_carrera = cbo_IdCarrera.getSelectedItem().toString().substring(0, 4);
            String requisito1 = cbo_Req1.getSelectedItem().toString().substring(0, 6);
            String requisito2 = cbo_Req2.getSelectedItem().toString().substring(0, 6);
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Asignaturas set"
                    + " cod_asignaturas = ? ,"
                    + " nombre_asignaturas = ? , "
                    + " UV = ?, "
                    + " id_carrera =?, "
                    + " requisito1 = ? , "
                    + " requisito2 = ? "
                    + " where cod_asignaturas ='"+lbl_codigo.getText()+"'");
                  ps.setString(1, txt_codA.getText());
                  ps.setString(2, txa_NombreA.getText());
                  ps.setString(3, txt_UniVal.getText());
                  ps.setString(4, id_carrera);
                  ps.setString(5, requisito1);
                  ps.setString(6, requisito2);
                  this.btn_guardar.setEnabled(true);
                  this.btn_actualizar.setEnabled(false);
                  this.btn_eliminar1.setEnabled(false);
                  this.btn_buscar.setEnabled(true);
               
                int res = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado la información en de la asignatura: " + txa_NombreA.getText());
                actualizarDatos();
                LimpiarCajas();
                if(res > 0){
                }else {
                     JOptionPane.showMessageDialog(null, "Error al actualizar la informacion de la asignatura, podría ser por: \n 1.La Asignatura ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la Asignatura a actualizar.\n 3.La Asignatura tiene secciones creadas","¡Error al Actuarlizar!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e);
               
                }
            

         }
        } catch (Exception e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
                 myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private boolean validarUV(String uv){
        int unidad = Integer.parseInt(uv);
        if(unidad >= 1 && unidad <= 15){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean validarRequisitos(String requisitoA, String requisitoB){
        if(requisitoA.equals("Sin requisito") || requisitoA.equals("Sin requisito")){
            return true;
        }
       
        if(!requisitoA.equals(requisitoB)){
            return true;
        }
        else{
            return false;
        }

       
    }
    
    private boolean validarVacio(String RequisitoA, String RequisitoB){
     if(RequisitoA.equals("Seleccione la asignatura 1:")|| RequisitoB.equals("Seleccione la asignatura 2:")){
         return true;
     }
   else{
    return false;
        
    }
    }
    
   

    
    private boolean existeCodAsignatura() {
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where cod_asignaturas = '" + txt_codA.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El código de la asignatura: " + txt_codA.getText() + " ya existe", "El código de la asignatura ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private boolean existeAsignatura() {
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where nombre_asignaturas = '" + txa_NombreA.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La asignatura: " + txa_NombreA.getText() + " ya existe", "El nombre de la asignatura ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
        try {
              String cadena1, cadena2, cadena3, cadena4, cadena5, cadena6;
        cadena1 = txt_codA.getText();
        cadena2 = txa_NombreA.getText();
        cadena3 = txt_UniVal.getText();
        String id_carrera = cbo_IdCarrera.getSelectedItem().toString().substring(0, 4);
        String requisito1= cbo_Req1.getSelectedItem().toString().substring(0,6);
        String requisito2= cbo_Req2.getSelectedItem().toString().substring(0,6);
  
        
        if((txt_codA.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el código de la asignatura.","Código asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_codA.requestFocus();
            return;
        }
        
          if((txa_NombreA.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la asignatura.","Nombre asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txa_NombreA.requestFocus();
            return;
        }
         
          if((txt_UniVal.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la unidad valorativa de la asignatura.","Unidad valorativa de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_UniVal.requestFocus();
            return;
        }
          
         if((cbo_IdCarrera.getSelectedItem().equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una carrera para la asignatura","Carrera de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((cbo_Req1.getSelectedItem().equals("Seleccione la asignatura 1:"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un requisito para la asignatura","Requisito1 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((cbo_Req2.getSelectedItem().equals("Seleccione la asignatura 2:"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un requisito para la asignatura","Requisito2 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(existeCodAsignatura()){
            return;
        }
        
        if(existeAsignatura()){
            return;
        }
        

        if(!validarLongitud(txt_codA,3)){
            JOptionPane.showMessageDialog(null, "El código de asignaturas tiene que ser mínimo de 3 caracteres", "Longitud de código de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

       if(!validarLongitud(txa_NombreA,7)){
            JOptionPane.showMessageDialog(null, "El Nombre de la asignatura es muy corto el mínimo es de 7 caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitud(txt_UniVal,1)){
            JOptionPane.showMessageDialog(null, "La unidades valorativas debe ser de un mínimo de 1 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(!validarUV(cadena3)){
            JOptionPane.showMessageDialog(null, "La unidades solo pueden ser valores entre 1 y 15", "Valor de la unidad valorativa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarRequisitos(cbo_Req1.getSelectedItem().toString(),cbo_Req2.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 no puede ser igual al requisito 2", "Requisitos iguales", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if(validarVacio(cbo_Req1.getSelectedItem().toString(),cbo_Req2.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 y el requisito 2 están vacíos.", "Requisitos vacíos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
      

        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Asignaturas (cod_asignaturas, nombre_asignaturas, UV, id_carrera, requisito1, requisito2 )"
                + "                VALUES(?,?,?,?,?,?)");
            ps.setString(1, txt_codA.getText());
            ps.setString(2, txa_NombreA.getText());
            ps.setString(3, txt_UniVal.getText());
            ps.setString(4, id_carrera);
            ps.setString(5, requisito1);
            ps.setString(6, requisito2);
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de Asignatura");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, "Error al guardar la información");
        }
        

        actualizarDatos();
        LimpiarCajas();
        } catch (Exception e) {
             try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar1ActionPerformed
        try {
                      String Asignatura = txa_NombreA.getText() + " " + txt_codA.getText();
          
           if ((txa_NombreA.getText().equals("")) || (txt_codA.getText().equals(""))  || (txt_UniVal.getText().equals(""))  ) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar la asignatura que desea eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de asignatura " + Asignatura + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Asignaturas "
                + "where cod_asignaturas = (Select cod_asignaturas from Asignaturas where nombre_asignaturas = '"+txa_NombreA.getText()+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la asignatura" + Asignatura + " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                   JOptionPane.showMessageDialog(null, "Error al borrar la información de la asignatura, podría ser por: \n 1.La Asignatura ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la Asignatura a borrar.\n 3.La Asignatura tiene secciones creadas","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
            }

        }
        actualizarDatos();
        LimpiarCajas();
        } catch (Exception e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_btn_eliminar1ActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void Tabla_RegistroAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_RegistroAsignaturaMouseClicked
        if(Tabla_RegistroAsignatura.getSelectedRow () >= 0){
            //llenarCampos();
            this.btn_actualizar.setEnabled(true);
            this.btn_eliminar1.setEnabled(true);
            this.btn_guardar.setEnabled(false);
            this.btn_buscar.setEnabled(false);
            int i = Tabla_RegistroAsignatura.getSelectedRow();
            rellenar2(Tabla_RegistroAsignatura.getValueAt(i, 0).toString());
        }
    }//GEN-LAST:event_Tabla_RegistroAsignaturaMouseClicked

    private void txt_codAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codAActionPerformed

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
        } catch (SQLException e) {
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cbo_Req2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Req2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_Req2ActionPerformed

    private void cbo_Req1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_Req1ActionPerformed
      if(cbo_Req1.getSelectedItem().toString().length()==0){
     System.out.println("No hay texto");
    }

    }//GEN-LAST:event_cbo_Req1ActionPerformed

    private void btn_requisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requisitosActionPerformed
        
     this.dispose();
        RequisitoAsignatura req = null;
    try {
        req = new RequisitoAsignatura(lbl_usuario.getText());
    } catch (SQLException e) { 
        try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        req.setVisible(true);
        
    }//GEN-LAST:event_btn_requisitosActionPerformed

    private void txt_codAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codAKeyTyped
       if (txt_codA.getText().length() >= 6) {
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
    }//GEN-LAST:event_txt_codAKeyTyped

    private void txt_UniValKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UniValKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_UniVal.getText().length() >=2){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_UniValKeyTyped

    private void txt_codAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codAFocusLost
         String id = txt_codA.getText();
        String upper = id.toUpperCase();
        txt_codA.setText(upper); 
    }//GEN-LAST:event_txt_codAFocusLost

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         Carrera cc = null;
        try {
            cc = new Carrera(lbl_usuario.getText());
        } catch (SQLException e) {
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txa_NombreAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txa_NombreAKeyTyped
        
        if (txa_NombreA.getText().length() >= 50) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
            || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
            || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
         if(evt.getKeyChar() == 32){
             if(txa_NombreA.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txa_NombreA.getText().substring(txa_NombreA.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
        char a = evt.getKeyChar();
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }   
    }//GEN-LAST:event_txa_NombreAKeyTyped

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        try {
            actualizarDatos();
        } catch (Exception e) {
             try {
                Log myLog; 
             String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        LimpiarCajas();
        btn_guardar.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_UniValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UniValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UniValActionPerformed

    private void cbo_IdCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_IdCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_IdCarreraActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       try {
            JasperReport reporte = null;
            String path = "src\\reportes\\asignatura.jasper";
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
                String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Asignaturas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_RegistroAsignatura;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_eliminar1;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_requisitos;
    private javax.swing.JComboBox<String> cbo_IdCarrera;
    private javax.swing.JComboBox<String> cbo_Req1;
    private javax.swing.JComboBox<String> cbo_Req2;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_IdCarrera;
    private javax.swing.JLabel lbl_NombreA;
    private javax.swing.JLabel lbl_Req1;
    private javax.swing.JLabel lbl_Req2;
    private javax.swing.JLabel lbl_UniVal;
    private javax.swing.JLabel lbl_codA;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextArea txa_NombreA;
    private javax.swing.JTextField txt_UniVal;
    private javax.swing.JTextField txt_codA;
    // End of variables declaration//GEN-END:variables


public boolean existeidAsignatura(){
        try {
            Statement st = con.createStatement();
            String sql = "Select cod_asignaturas from Asignaturas where cod_asignaturas = '"+txt_codA.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Asignatura: "+txt_codA.getText()+" ", "Codigo de asignatura ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
       
           private boolean validarLongitud(JTextArea texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
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
         
 public void actualizarDatos(){
     try {
              try {
               
               String sql = "SELECT * FROM Asignaturas";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               modelo = new DefaultTableModel(null, titulos);
               Tabla_RegistroAsignatura.setModel(modelo);
                 while(rs.next()) {
                     
                      String []datos= new String[7];
                      datos[0] =rs.getString("cod_asignaturas");
                      datos[1] =rs.getString("nombre_asignaturas");
                      datos[2] =rs.getString("UV");
                      datos[3] =rs.getString("id_carrera");
                      datos[4] =rs.getString("requisito1");
                      datos[5] =rs.getString("requisito2");
                      
                     modelo.addRow(datos);
                      
                      centrar_datos();
                 }
            TableColumn TaRA = Tabla_RegistroAsignatura.getColumn(titulos[0]);
            TaRA.setMaxWidth(125);
            TableColumn cRA= Tabla_RegistroAsignatura.getColumn(titulos[1]);
            cRA.setMaxWidth(165);
            TableColumn UV= Tabla_RegistroAsignatura.getColumn(titulos[2]);
            UV.setMaxWidth(125);            
            TableColumn idC= Tabla_RegistroAsignatura.getColumn(titulos[3]);
           idC.setMaxWidth(165);
           TableColumn req1C= Tabla_RegistroAsignatura.getColumn(titulos[4]);
           req1C.setMaxWidth(165);
            TableColumn req2C= Tabla_RegistroAsignatura.getColumn(titulos[5]);
           req2C.setMaxWidth(165);
        }
        catch (Exception e) {
          System.err.println(e);
         
        }
     } catch (Exception e) {
         try {
                Log myLog; 
               String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
           }
           
     public void centrar_datos() {
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_RegistroAsignatura.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }
     
    }
     
    
             
    
       private void rellenar(){
      try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el nombre de la asignatura que desea consultar", "Consulta de facultad", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar el nombre de la asignatura \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Asignaturas as a join Carrera as c on c.id_carrera = a.id_carrera where cod_asignaturas='"+var+"' or nombre_asignaturas ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_codA.setText(rs2.getString("cod_asignaturas"));
                                lbl_codigo.setText(rs2.getString("cod_asignaturas"));
                                txa_NombreA.setText(rs2.getString("nombre_asignaturas"));
                                txt_UniVal.setText(rs2.getString("UV"));
                                cbo_IdCarrera.setSelectedItem(rs2.getString("id_carrera")+ " - " + rs2.getString("nombre_carrera"));
                                String requisito1 = rs2.getString("requisito1");
                                String requisito2 = rs2.getString("requisito2");
                                if(requisito1.equals("Sin re")){
                                    requisito1 = "Sin requisito";
                                }
                                if(requisito2.equals("Sin re")){
                                    requisito2 = "Sin requisito";
                                }
                                cbo_Req1.setSelectedItem(requisito1);
                                cbo_Req2.setSelectedItem(requisito2);
                                this.btn_consultar.setEnabled(true);
                                this.btn_guardar.setEnabled(false);
                                this.btn_eliminar1.setEnabled(true);
                                this.btn_actualizar.setEnabled(true);
                                this.jScrollPane1.setEnabled(true);
                                this.jScrollPane1.setEnabled(true);
                                this.Tabla_RegistroAsignatura.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        }

                    }
                } catch (Exception e) {
                    try {
                    Log myLog; 
                    String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                    myLog.logger.setLevel(Level.SEVERE);
                    myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                }
    
    }

    private void rellenar2(String var){
      try {
                    String cap = "";
                    ResultSet rs2 = null;
                  
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar el nombre de la asignatura \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Asignaturas as a join Carrera as c on c.id_carrera = a.id_carrera where cod_asignaturas='"+var+"' or nombre_asignaturas ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                            if (rs2.next()) {
                                txt_codA.setText(rs2.getString("cod_asignaturas"));
                                lbl_codigo.setText(rs2.getString("cod_asignaturas"));
                                txa_NombreA.setText(rs2.getString("nombre_asignaturas"));
                                txt_UniVal.setText(rs2.getString("UV"));
                                cbo_IdCarrera.setSelectedItem(rs2.getString("id_carrera")+ " - " + rs2.getString("nombre_carrera"));
                                String requisito1 = rs2.getString("requisito1");
                                String requisito2 = rs2.getString("requisito2");
                               
                                Statement st2 = con.createStatement();
                                String sql2 = "select * from Requisito_Asignatura where id_asignatura = '"+requisito1+"'";
                                ResultSet rs3 = st2.executeQuery(sql2);
                                if(rs3.next()){
                                    cbo_Req1.setSelectedItem(rs3.getString("id_asignatura") + " - " + rs3.getString("RequisitoAsignatura"));
                                }
                                Statement st3 = con.createStatement();
                                String sql3 = "select * from Requisito_Asignatura where id_asignatura = '"+requisito2+"'";
                                ResultSet rs4 = st3.executeQuery(sql3);
                                if(rs4.next()){
                                    cbo_Req2.setSelectedItem(rs4.getString("id_asignatura") + " - " + rs4.getString("RequisitoAsignatura"));
                                }
                                if(requisito1.equals("Sin re")){
                                    requisito1 = "Sin requisito";
                                    cbo_Req1.setSelectedItem(requisito1);
                                }
                                if(requisito2.equals("Sin re")){
                                    requisito2 = "Sin requisito";
                                    cbo_Req2.setSelectedItem(requisito2);
                                }
                               
                               
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        }

                    }
                } catch (Exception e) {
                     try {
                      Log myLog; 
                     String nombreArchivo = "src\\Logs\\Asignaturas " + fecha + ".txt";
               myLog = new Log(nombreArchivo);
                     myLog.logger.setLevel(Level.SEVERE);
                    myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                }
    
    }
    private void LimpiarCajas() {
       
        txa_NombreA.setText(null);
        txt_UniVal.setText(null);
        txt_codA.setText(null);
        cbo_IdCarrera.setSelectedIndex(0);
        cbo_Req1.setSelectedIndex(0);
        cbo_Req2.setSelectedIndex(0);
       
    }

    private void llenarCampos() {
      int i = Tabla_RegistroAsignatura.getSelectedRow();
        txt_codA.setText(Tabla_RegistroAsignatura.getValueAt(i, 0).toString());
        txa_NombreA.setText(Tabla_RegistroAsignatura.getValueAt(i, 1).toString());
        txt_UniVal.setText(Tabla_RegistroAsignatura.getValueAt(i, 2).toString());
        cbo_IdCarrera.setSelectedItem(Tabla_RegistroAsignatura.getValueAt(i, 3).toString());
        cbo_Req1.setSelectedItem(Tabla_RegistroAsignatura.getValueAt(i, 4).toString());
        cbo_Req2.setSelectedItem(Tabla_RegistroAsignatura.getValueAt(i, 5).toString());

    }
  


}
