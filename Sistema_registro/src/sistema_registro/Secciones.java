/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
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
 * @author William P.
 */
public class Secciones extends javax.swing.JFrame {

    Connection con = null;
      String titulos [] = {"Id Sección","Nombre de la Sección", " Código de la Asignatura ", 
         "Cantidad de Alumnos","Hora Inicial", "Hora Final",  "Período", "Aula",
         "Días de la Asignatura","Cantidad Máxima de Alumnos"};
   
    DefaultTableModel modelo =  new DefaultTableModel();
    Statement stmt = null;
    String var, var2;
    int Contador=0;
    String CantidadAl =String.valueOf(Contador);
     final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
    
    
    
    //JCheckBox Mensaje = new JCheckBox();
    
    /**
     * Creates new form Secciones
     */
    
         
    public Secciones() throws SQLException {
        
        this.con = ConectorSQL.obtenerConexion ();
        initComponents();
       
        
          
                ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_asignatura();
            for(int i = 0; i<lista.size();i++){
                cbo_Asignaturas.addItem(lista.get(i));
                }
            
                 ArrayList<String> lista4 = new ArrayList<String>();
             lista4= new Conexion_consulta().llenar_periodo();
            for(int i = 0; i<lista4.size();i++){
               cbo_IdPeriodo.addItem(lista4.get(i));
             }
            
            
               ArrayList<String> lista5 = new ArrayList<String>();
             lista5= new Conexion_consulta().llenar_aula();
            for(int i = 0; i<lista5.size();i++){
               cbo_IdAula.addItem(lista5.get(i));
             }                    
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.setTitle("Secciones");
            this.btn_actualizar.setEnabled(false);
            this.btn_eliminar.setEnabled(false);
            this.lbl_seccion.setVisible(false);
            this.setLocationRelativeTo(null);
    }
    
    public Secciones(String nombreUsuario) throws SQLException {
        
        this.con = ConectorSQL.obtenerConexion ();
        initComponents();
       
        noVisible();
          
                ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_asignatura();
            for(int i = 0; i<lista.size();i++){
                cbo_Asignaturas.addItem(lista.get(i));
                }
            
                 ArrayList<String> lista4 = new ArrayList<String>();
             lista4= new Conexion_consulta().llenar_periodo();
            for(int i = 0; i<lista4.size();i++){
               cbo_IdPeriodo.addItem(lista4.get(i));
             }
            
            
               ArrayList<String> lista5 = new ArrayList<String>();
             lista5= new Conexion_consulta().llenar_aula();
            for(int i = 0; i<lista5.size();i++){
               cbo_IdAula.addItem(lista5.get(i));
             }                
            String usuario = nombreUsuario;
            this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.setTitle("Secciones");
            this.lbl_usuario.setText(usuario);
            this.btn_actualizar.setEnabled(false);
            this.btn_eliminar.setEnabled(false);
            this.lbl_seccion.setVisible(false);
             this.setLocationRelativeTo(null);
              habilitar(this.lbl_usuario.getText());
    }
    
     private void noVisible(){
         btn_guardar.setVisible(false);
         btn_actualizar.setVisible(false);
         btn_buscar.setVisible(false);
         btn_eliminar.setVisible(false);
         jMenuItem2.setVisible(false);
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("SeccionesFunciones").contains("G")){
                    btn_guardar.setVisible(true);
                }
                if(rs.getString("SeccionesFunciones").contains("A")){
                    btn_actualizar.setVisible(true);
                }
            
                       if(rs.getString("SeccionesFunciones").contains("B")){
                  btn_buscar.setVisible(true);
                }
                       if(rs.getString("SeccionesFunciones").contains("E")){
                  btn_eliminar.setVisible(true);
                }
                 
                       if(rs.getString("SeccionesFunciones").contains("I")){
                           jMenuItem2.setVisible(true);
                       }
                
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
    

    private Secciones(JTextField txt_NombreSeccion, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Tabla_Seccion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_eliminar = new javax.swing.JButton();
        lbl_NombreSeccion1 = new javax.swing.JLabel();
        txt_NombreSeccion = new javax.swing.JTextField();
        lbl_CantidadM = new javax.swing.JLabel();
        txt_CantidadM = new javax.swing.JTextField();
        lbl_CodAsignatura = new javax.swing.JLabel();
        cbo_Asignaturas = new javax.swing.JComboBox<>();
        lbl_horaInicial = new javax.swing.JLabel();
        lbl_horaFinal = new javax.swing.JLabel();
        txt_HoraInicial = new javax.swing.JFormattedTextField();
        txt_HoraFinal = new javax.swing.JFormattedTextField();
        lbl_Periodo = new javax.swing.JLabel();
        lbl_aula = new javax.swing.JLabel();
        cbo_IdPeriodo = new javax.swing.JComboBox<>();
        cbo_IdAula = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        chb_Lunes = new javax.swing.JCheckBox();
        chb_Martes = new javax.swing.JCheckBox();
        chb_Miercoles = new javax.swing.JCheckBox();
        chb_Jueves = new javax.swing.JCheckBox();
        chb_Viernes = new javax.swing.JCheckBox();
        chb_Sabado = new javax.swing.JCheckBox();
        chb_Domingo = new javax.swing.JCheckBox();
        btn_limpiar = new javax.swing.JButton();
        lbl_seccion = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem_Asignatura = new javax.swing.JMenuItem();
        jMenuItem_Periodo = new javax.swing.JMenuItem();
        jMenuItem_Aula = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_Seccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Sección", " Asignatura", "Hora Inicial", "Hora Final", "Período", "Aula", "Días", "Cantidad Máxima de Alumnos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Seccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_SeccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Seccion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 1320, 103));

        jPanel3.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Registro de sección");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(545, 545, 545))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1320, 80));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        lbl_NombreSeccion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreSeccion1.setText("Nombre sección:");

        txt_NombreSeccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_NombreSeccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_NombreSeccionFocusLost(evt);
            }
        });
        txt_NombreSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreSeccionActionPerformed(evt);
            }
        });
        txt_NombreSeccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreSeccionKeyTyped(evt);
            }
        });

        lbl_CantidadM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_CantidadM.setText("Cantidad máxima:");

        txt_CantidadM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_CantidadM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CantidadMActionPerformed(evt);
            }
        });
        txt_CantidadM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CantidadMKeyTyped(evt);
            }
        });

        lbl_CodAsignatura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_CodAsignatura.setText("Código Asignatura:");

        cbo_Asignaturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una asignatura:" }));
        cbo_Asignaturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbo_AsignaturasKeyTyped(evt);
            }
        });

        lbl_horaInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_horaInicial.setText("Hora inicial:");

        lbl_horaFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_horaFinal.setText("Hora final:");

        txt_HoraInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        txt_HoraInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_HoraInicialFocusLost(evt);
            }
        });
        txt_HoraInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_HoraInicialKeyTyped(evt);
            }
        });

        txt_HoraFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        txt_HoraFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HoraFinalActionPerformed(evt);
            }
        });
        txt_HoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_HoraFinalKeyTyped(evt);
            }
        });

        lbl_Periodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Periodo.setText("Periodo:");

        lbl_aula.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_aula.setText("Aula: ");

        cbo_IdPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un período:" }));
        cbo_IdPeriodo.setToolTipText("");
        cbo_IdPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_IdPeriodoActionPerformed(evt);
            }
        });

        cbo_IdAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un aula:" }));

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

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dias de Asignaturas"));

        chb_Lunes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Lunes.setText("Lunes");

        chb_Martes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Martes.setText("Martes");
        chb_Martes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_MartesActionPerformed(evt);
            }
        });

        chb_Miercoles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Miercoles.setText("Miércoles");

        chb_Jueves.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Jueves.setText("Jueves");

        chb_Viernes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Viernes.setText("Viernes");

        chb_Sabado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Sabado.setText("Sábado");

        chb_Domingo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_Domingo.setText("Domingo");
        chb_Domingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_DomingoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chb_Jueves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chb_Lunes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chb_Domingo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chb_Viernes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chb_Martes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chb_Miercoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chb_Sabado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chb_Lunes)
                    .addComponent(chb_Martes)
                    .addComponent(chb_Miercoles))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chb_Jueves)
                    .addComponent(chb_Viernes)
                    .addComponent(chb_Sabado))
                .addGap(18, 18, 18)
                .addComponent(chb_Domingo)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_seccion.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_NombreSeccion1)
                            .addComponent(lbl_Periodo)
                            .addComponent(lbl_aula)
                            .addComponent(lbl_horaFinal)
                            .addComponent(lbl_CantidadM)
                            .addComponent(lbl_CodAsignatura)
                            .addComponent(lbl_horaInicial))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_IdAula, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NombreSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_CantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_HoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_HoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_IdPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(602, 602, 602)
                        .addComponent(lbl_seccion)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_horaFinal)
                        .addComponent(txt_HoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_IdPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Periodo))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_aula)
                    .addComponent(cbo_IdAula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbl_seccion)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_NombreSeccion1)
                            .addComponent(txt_NombreSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_CantidadM)
                            .addComponent(txt_CantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_CodAsignatura)
                            .addComponent(cbo_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_guardar)
                        .addGap(20, 20, 20)
                        .addComponent(btn_actualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_horaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(txt_HoraInicial))
                    .addComponent(btn_buscar))
                .addGap(16, 16, 16)
                .addComponent(btn_limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1320, 380));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 740));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem1.setText("Menú Principal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem_Asignatura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Asignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/books_3025.png"))); // NOI18N
        jMenuItem_Asignatura.setText("Asignatura");
        jMenuItem_Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AsignaturaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Asignatura);

        jMenuItem_Periodo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Periodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mortarboard_icon-icons.com_64579.png"))); // NOI18N
        jMenuItem_Periodo.setText("Periodo");
        jMenuItem_Periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_PeriodoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Periodo);

        jMenuItem_Aula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Aula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aula.png"))); // NOI18N
        jMenuItem_Aula.setText("Aula");
        jMenuItem_Aula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AulaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Aula);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imprimir.png"))); // NOI18N
        jMenuItem2.setText("Imprimir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

        try{
        
        String Mensaje = "";
        String Seccion = txt_NombreSeccion.getText() + " ";
                   if((txt_NombreSeccion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreSeccion.requestFocus();
            return;
        }
            
         if((cbo_Asignaturas.getSelectedItem().equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((txt_HoraInicial.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraInicial.requestFocus();
            return;
        }
        
           if((txt_HoraFinal.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraFinal.requestFocus();
            return;
        }
           
         if((cbo_IdPeriodo.getSelectedItem().equals("Seleccione un período"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((cbo_IdAula.getSelectedItem().equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((chb_Lunes.getText().equals("")) || (chb_Martes.getText().equals("")) || (chb_Miercoles.getText().equals("")) || (chb_Jueves.getText().equals("")) ||
             (chb_Viernes.getText().equals("")) || (chb_Sabado.getText().equals("")) || (chb_Domingo.getText().equals(""))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar el día de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            chb_Lunes.requestFocus();
            return;
        }
        
        if(chb_Lunes.isSelected()){
           Mensaje +=  "Lu";

        }
        if(chb_Martes.isSelected()){
            Mensaje +=  "Ma";
        }
        if(chb_Miercoles.isSelected()){
            Mensaje += "Mi";
        }
        if(chb_Jueves.isSelected()){
            Mensaje +=  "Ju";
        }
        if(chb_Viernes.isSelected()){
            Mensaje +=  "Vi";
        }
        
        if(chb_Sabado.isSelected()){
            Mensaje +=  "Sa";
        }
        if(chb_Domingo.isSelected()){
            Mensaje +=  "Do";
        }
            
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de la sección" +Seccion + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            String id_seccion = cbo_Asignaturas.getSelectedItem().toString().substring(0, 6) + "-" +  txt_NombreSeccion.getText();
            String id_asignatura = cbo_Asignaturas.getSelectedItem().toString().substring(0, 6);
            String id_periodo = cbo_IdPeriodo.getSelectedItem().toString().substring(5, 6);
            //Correcion para aceptar el idperiodo
            //String id_periodo= cbo_IdPeriodo.getSelectedItem().toString().substring(0,6);
            
            String id_aula = cbo_IdAula.getSelectedItem().toString().substring(0, 4);
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Secciones set"
                    + " id_seccion = ? ,"
                    + " Nombre_seccion = ? , "
                    + " cod_asignaturas = ? , "
                    + " Hora_inicial= ? , "
                    + " Hora_final= ? , "
                    + " id_periodo= ? , "
                    + " id_aula= ? , "
                    + "dias= ?, "
                   + "cantidad_maxima = ? "
                  + " where id_seccion =\'"+lbl_seccion.getText()+"\'");
                  ps.setString(1,id_seccion);
                  ps.setString(2, txt_NombreSeccion.getText());
                  ps.setString(3,id_asignatura);
                  ps.setString(4, txt_HoraInicial.getText());
                  ps.setString(5, txt_HoraFinal.getText());
                  ps.setString(6,id_periodo);
                  ps.setString(7,id_aula);
                  ps.setString(8,Mensaje);
                  ps.setString(9, txt_CantidadM.getText());
                   this.btn_actualizar.setEnabled(false);
                   this.btn_eliminar.setEnabled(false);
                    this.btn_guardar.setEnabled(true);
           
                  
            
             int res = ps.executeUpdate();
               if(res > 0){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información de la sección " + Seccion + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizar la información!.");

                }
             
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al actualizar la información de la sección, podría ser por: \n 1.La sección ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la sección a borrar.\n 3.La sección tiene asignaturas creadas","¡Error al actualizar!", JOptionPane.ERROR_MESSAGE);
            }
            
            actualizarDatos();
            LimpiarCajas();

        
        }
        
        } catch (Exception e){
            
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

            try {
        
         String Seccion = txt_NombreSeccion.getText();
           String id_seccion = cbo_Asignaturas.getSelectedItem().toString().substring(0, 4) + "-" +  txt_NombreSeccion.getText();
                      if((txt_NombreSeccion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreSeccion.requestFocus();
            return;
        }
            
         if((cbo_Asignaturas.getSelectedItem().equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((txt_HoraInicial.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraInicial.requestFocus();
            return;
        }
        
           if((txt_HoraFinal.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraFinal.requestFocus();
            return;
        }
           
         if((cbo_IdPeriodo.getSelectedItem().equals("Seleccione un período"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((cbo_IdAula.getSelectedItem().equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((chb_Lunes.getText().equals("")) || (chb_Martes.getText().equals("")) || (chb_Miercoles.getText().equals("")) || (chb_Jueves.getText().equals("")) ||
             (chb_Viernes.getText().equals("")) || (chb_Sabado.getText().equals("")) || (chb_Domingo.getText().equals(""))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar el día de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            chb_Lunes.requestFocus();
            return;
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de sección" + Seccion+ "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Secciones "
                + "where id_seccion = '"+id_seccion+"' ";
                 this.btn_guardar.setEnabled(true);
                 this.btn_actualizar.setEnabled(false);
                 this.btn_eliminar.setEnabled(false);

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la sección" + Seccion+ " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");
               JOptionPane.showMessageDialog(null, "Error al eliminar la información de la sección, podría ser por: \n 1.La sección ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la sección a borrar.\n 3.La sección tiene asignaturas creadas","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
            }

        }
        actualizarDatos();
        LimpiarCajas();

            } catch (Exception e){
                
                try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Seccion.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       try {
           actualizarDatos();
       } catch (Exception e){
       
       try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void chb_DomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_DomingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chb_DomingoActionPerformed

    private void chb_MartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_MartesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chb_MartesActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        try {
        
        String Mensaje = "";
  
        String cadena2, cadena5, cadena4, cadena8, cadena9;
        //Id Seccion
        String id_seccion = cbo_Asignaturas.getSelectedItem().toString().substring(0, 6) + "-" +  txt_NombreSeccion.getText();
        cadena2 = txt_NombreSeccion.getText();
        String codigo_asignatura = cbo_Asignaturas.getSelectedItem().toString().substring(0, 6);
        cadena4 = txt_HoraInicial.getText();
        cadena5 = txt_HoraFinal.getText();
        String id_periodo= cbo_IdPeriodo.getSelectedItem().toString().substring(5,6);
        //Correcion para aceptar el idperiodo
       //String id_periodo= cbo_IdPeriodo.getSelectedItem().toString().substring(0,6);
       String id_aula= cbo_IdAula.getSelectedItem().toString().substring(0,4);
       
       
  //   Cadena8 = txt_MensajeDias.getText();
   //    txt_MensajeDias.setText(Mensaje);
      // makeLabel(Mensaje);
        cadena9 = txt_CantidadM.getText();
        
        int cantidad=Integer.parseInt(cadena9);
        
         if(chb_Lunes.isSelected()){
           Mensaje +=  "Lu";

        }
        if(chb_Martes.isSelected()){
            Mensaje +=  "Ma";
        }
        if(chb_Miercoles.isSelected()){
            Mensaje += "Mi";
        }
        if(chb_Jueves.isSelected()){
            Mensaje +=  "Ju";
        }
        if(chb_Viernes.isSelected()){
            Mensaje +=  "Vi";
        }
        
        if(chb_Sabado.isSelected()){
            Mensaje +=  "Sa";
        }
        if(chb_Domingo.isSelected()){
            Mensaje +=  "Do";
        }
       
      //  lbl_MensajeDias.setText(Mensaje);
       
      
        
        /*if((txt_IdSeccion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la sección.","Id sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdSeccion.requestFocus();
            return;
        }*/
        
            if((txt_NombreSeccion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreSeccion.requestFocus();
            return;
        }
            
         if((cbo_Asignaturas.getSelectedItem().equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((txt_HoraInicial.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraInicial.requestFocus();
            return;
        }
        
           if((txt_HoraFinal.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_HoraFinal.requestFocus();
            return;
        }
           
         if((cbo_IdPeriodo.getSelectedItem().equals(":"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((cbo_IdAula.getSelectedItem().equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una aula para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((chb_Lunes.getText().equals("")) || (chb_Martes.getText().equals("")) || (chb_Miercoles.getText().equals("")) || (chb_Jueves.getText().equals("")) ||
             (chb_Viernes.getText().equals("")) || (chb_Sabado.getText().equals("")) || (chb_Domingo.getText().equals(""))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar los dias correspondientes de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            chb_Lunes.requestFocus();
            return;
        }
           
                     
                    
    

        if(existeSeccion()){
            return;
        }
        
           if(existeidSeccion()){
            return;
        }

        if(!validarLongitud(txt_CantidadM,1)){
            JOptionPane.showMessageDialog(null, "La cantidad máxima tiene que ser minimo de 1 caracteres", "Longitud de cantidad máxima", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(txt_NombreSeccion,1)){
            JOptionPane.showMessageDialog(null, "El Nombre de la sección es muy corto el mínimo es de 1 caracteres", "Longitud del nombre de la sección", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
/*         if(!validarLongitud(CantidadAl,1)){
            JOptionPane.showMessageDialog(null, "La cantidad de alumnos debe ser de un mínimo de 2 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }*/
         
         if(!validarLongitud(txt_HoraInicial,4)){
            JOptionPane.showMessageDialog(null, "La Hora inicial es muy corto el mínimo es de 5 caracteres", "Longitud de la hora inicial", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitud(txt_HoraFinal,4)){
            JOptionPane.showMessageDialog(null, "La Hora final  debe ser de un mínimo de 5 caracter", "Longitud de la hora final", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try{
            PreparedStatement ps;


            ps=con.prepareStatement("INSERT INTO Secciones ( id_seccion, Nombre_seccion, cod_asignaturas,cantidad_alumnos,Hora_inicial, Hora_final, id_periodo, id_aula, dias, cantidad_maxima)"
                + "                VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id_seccion);
            ps.setString(2, txt_NombreSeccion.getText());
            ps.setString(3,codigo_asignatura);
            ps.setString(4,"0");
            ps.setString(5, txt_HoraInicial.getText());
            ps.setString(6, txt_HoraFinal.getText());
            ps.setString(7, id_periodo);
            ps.setString(8,id_aula);
            ps.setString(9, Mensaje);
            ps.setString(10, cadena9);
            
            
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de Sección");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        

        actualizarDatos();
        LimpiarCajas();
       
         
        }catch (Exception e){
        
        try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

      
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_IdSeccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdSeccionKeyTyped
    
          /*   if (txt_IdSeccion.getText().length() >= 8) {
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
        }*/
        
    }//GEN-LAST:event_txt_IdSeccionKeyTyped

    private void cbo_AsignaturasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_AsignaturasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_AsignaturasKeyTyped

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem_PeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_PeriodoActionPerformed
           
        try {
        
        Periodo pp = null;
        try {
            pp = new Periodo(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Secciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp.setVisible(true);
        this.dispose();
        
        } catch (Exception e){
            
        try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_jMenuItem_PeriodoActionPerformed

    private void jMenuItem_AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AsignaturaActionPerformed
          
        try{
        
        Asignaturas as = null;
        try {
            as = new Asignaturas(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        as.setVisible(true);
        this.dispose(); 
        
        } catch (Exception e){
            
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_jMenuItem_AsignaturaActionPerformed

    private void jMenuItem_AulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AulaActionPerformed
           
        try {
        
        Aula au = null;
        try {
            au = new Aula(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        au.setVisible(true);
        this.dispose();
        
        } catch (Exception e){
            
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_jMenuItem_AulaActionPerformed

    private void txt_HoraFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HoraFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoraFinalActionPerformed

    private void txt_NombreSeccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreSeccionKeyTyped
            char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_NombreSeccion.getText().length() >=1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a) ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_NombreSeccionKeyTyped

    private void cbo_IdPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_IdPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_IdPeriodoActionPerformed

    private void Tabla_SeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_SeccionMouseClicked
           if(Tabla_Seccion.getSelectedRow () >= 0){
               try {
                   llenarCampos();
              
               } catch (SQLException ex) {
                   Logger.getLogger(Secciones.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
    }//GEN-LAST:event_Tabla_SeccionMouseClicked

    private void txt_CantidadMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CantidadMKeyTyped
            char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_CantidadM.getText().length() >=2){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_CantidadMKeyTyped

    private void txt_NombreSeccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NombreSeccionFocusLost
         String id = txt_NombreSeccion.getText();
         String upper = id.toUpperCase();
         txt_NombreSeccion.setText(upper); 
    }//GEN-LAST:event_txt_NombreSeccionFocusLost

    private void txt_HoraInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HoraInicialKeyTyped
         char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 || evt.getKeyChar() == 58) {
        return;
        }
        if(txt_HoraInicial.getText().length() >= 5){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_HoraInicialKeyTyped

    private void txt_HoraFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HoraFinalKeyTyped
         char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 || evt.getKeyChar() == 58) {
        return;
        }
        if(txt_HoraFinal.getText().length() >=5){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_HoraFinalKeyTyped

    private void txt_NombreSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreSeccionActionPerformed

    private void txt_CantidadMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CantidadMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CantidadMActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_HoraInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_HoraInicialFocusLost
        String horaInicial = txt_HoraInicial.getText();
        int hora = Integer.parseInt(horaInicial.substring(0, 2)) + 1;
        int minutos = Integer.parseInt(horaInicial.substring(3, 5));
        String horafinal = hora + ":" + minutos;
        if(minutos < 10){
            horafinal = hora + ":0" + minutos;
        }
        if(hora >= 24){
            hora = hora - 24;
            if(minutos < 10){
            horafinal = hora + ":0" + minutos;
        } 
            horafinal = hora + ":" + minutos;
            
        }
        if(hora <10 && minutos < 10){
                 horafinal = "0"+ hora + ":0" + minutos;
            }
            if(hora <10 && minutos > 10){
                 horafinal = "0"+ hora + ":" + minutos;
            }
            if(hora >10 && minutos < 10){
                 horafinal = ""+ hora + ":0" + minutos;
            }
            if(hora >10 && minutos > 10){
                 horafinal = ""+ hora + ":" + minutos;
            }
        txt_HoraFinal.setText(horafinal);
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoraInicialFocusLost

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        LimpiarCajas();
         this.btn_guardar.setEnabled(true);
         this.btn_actualizar.setEnabled(false);
         this.btn_eliminar.setEnabled(false);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          try {
            JasperReport reporte = null;
            String path = "src\\reportes\\Secciones.jasper";
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
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Secciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Secciones().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Secciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Seccion;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbo_Asignaturas;
    private javax.swing.JComboBox<String> cbo_IdAula;
    private javax.swing.JComboBox<String> cbo_IdPeriodo;
    private javax.swing.JCheckBox chb_Domingo;
    private javax.swing.JCheckBox chb_Jueves;
    private javax.swing.JCheckBox chb_Lunes;
    private javax.swing.JCheckBox chb_Martes;
    private javax.swing.JCheckBox chb_Miercoles;
    private javax.swing.JCheckBox chb_Sabado;
    private javax.swing.JCheckBox chb_Viernes;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_Asignatura;
    private javax.swing.JMenuItem jMenuItem_Aula;
    private javax.swing.JMenuItem jMenuItem_Periodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CantidadM;
    private javax.swing.JLabel lbl_CodAsignatura;
    private javax.swing.JLabel lbl_NombreSeccion1;
    private javax.swing.JLabel lbl_Periodo;
    private javax.swing.JLabel lbl_aula;
    private javax.swing.JLabel lbl_horaFinal;
    private javax.swing.JLabel lbl_horaInicial;
    private javax.swing.JLabel lbl_seccion;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_CantidadM;
    private javax.swing.JFormattedTextField txt_HoraFinal;
    private javax.swing.JFormattedTextField txt_HoraInicial;
    private javax.swing.JTextField txt_NombreSeccion;
    // End of variables declaration//GEN-END:variables

    
    public boolean existeSeccion(){
        try {
            
            Statement st = con.createStatement();
            String sql = "Select Nombre_seccion from Secciones where Nombre_seccion = '"+txt_NombreSeccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Sección: "+txt_NombreSeccion+" ", " Sección ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
    
     public boolean existeidSeccion(){
          String id_seccion = cbo_Asignaturas.getSelectedItem().toString().substring(0, 4) + "-" +  txt_NombreSeccion.getText();
        try {
            
            Statement st = con.createStatement();
            String sql = "Select id_seccion from Secciones where id_seccion = '"+id_seccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el id de esta sección: "+id_seccion+" ", " Id sección ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
       
           private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }

    
    
public void actualizarDatos(){
        try {
               
               String sql = "SELECT * FROM Secciones";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               modelo = new DefaultTableModel(null, titulos);
               Tabla_Seccion.setModel(modelo);
                 while(rs.next()) {
                     
                     //Registro Anterior (Posible Error)//
                       String []datos= new String[11];
                      datos[0] =rs.getString("id_seccion");
                      datos[1] =rs.getString("Nombre_seccion");
                      datos[2] =rs.getString("cod_asignaturas");
                      datos[3] =rs.getString("cantidad_alumnos");
                      datos[4] =rs.getString("Hora_inicial");
                      datos[5] =rs.getString("Hora_final");
                      datos[6] =rs.getString("id_periodo");
                      datos[7] =rs.getString("id_aula");
                      datos[8] =rs.getString("dias");
                      datos[9] =rs.getString("cantidad_maxima");
                      
                   
                   
                     modelo.addRow(datos);
                      
                      centrar_datos();
                 }
            TableColumn ise= Tabla_Seccion.getColumn(titulos[0]);
            ise.setMaxWidth(145);
            TableColumn nse= Tabla_Seccion.getColumn(titulos[1]);
            nse.setMaxWidth(145);
            TableColumn coda= Tabla_Seccion.getColumn(titulos[2]);
            coda.setMaxWidth(145);            
            TableColumn cana= Tabla_Seccion.getColumn(titulos[3]); //Puede ser este un error//
            cana.setMaxWidth(145);
           TableColumn hin= Tabla_Seccion.getColumn(titulos[4]);
           hin.setMaxWidth(145);
            TableColumn hfi= Tabla_Seccion.getColumn(titulos[5]);
           hfi.setMaxWidth(145);
           TableColumn idp= Tabla_Seccion.getColumn(titulos[7]);
           idp.setMaxWidth(145);
           TableColumn idau= Tabla_Seccion.getColumn(titulos[6]);
           idau.setMaxWidth(145);
           TableColumn dias= Tabla_Seccion.getColumn(titulos[8]);
           dias.setMaxWidth(145);
           TableColumn cm= Tabla_Seccion.getColumn(titulos[9]);
           cm.setMaxWidth(145);
          
        }
        catch (Exception e) {
           
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           }

 public void centrar_datos() {
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Seccion.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }

}
 
 private void rellenar(){
      try {
                    String cap = "";
                    ResultSet rs2 = null;
                    
                       
                            String sql = "SELECT * FROM Secciones where id_seccion='"+var+"' or nombre_seccion ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_NombreSeccion.setText(rs2.getString("Nombre_seccion"));
                                cbo_Asignaturas.setSelectedItem((rs2.getString("cod_asignaturas")+ " - " + rs2.getString("nombre_asignaturas")));
                                txt_HoraInicial.setText(rs2.getString("Hora_inicial"));
                                txt_HoraFinal.setText(rs2.getString("Hora_final"));
                               cbo_IdPeriodo.setSelectedItem((rs2.getString("id_periodo")+ " - " + rs2.getString("descripcion")));
                               cbo_Asignaturas.setSelectedItem((rs2.getString("id_aula")+ " - " + rs2.getString("nombre_aula")));
                               txt_CantidadM.setText(rs2.getString("cantidad_maxima"));
                            }
                        

                    
                } catch (Exception e) {
                    
                    try {
                Log myLog; 
                 String nombreArchivo = "src\\Logs\\Secciones " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " El motivo se debio a: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                }
    
    }

     private void LimpiarCajas() {
       
        deseleccionar();
        txt_NombreSeccion.setText(null);
   //   CantidadAl =String.valueOf(Contador);
        txt_HoraInicial.setText(null);
         txt_HoraFinal.setText(null);
        cbo_Asignaturas.setSelectedIndex(0);
        cbo_IdPeriodo.setSelectedIndex(0);
        cbo_IdAula.setSelectedIndex(0);
        txt_CantidadM.setText(null);
        this.btn_guardar.setEnabled(true);
        this.btn_eliminar.setEnabled(false);
        this.btn_actualizar.setEnabled(false);
        
       
    }
     
     private void deseleccionar(){
         chb_Lunes.setSelected(false);
         chb_Martes.setSelected(false);
         chb_Miercoles.setSelected(false);
         chb_Jueves.setSelected(false);
         chb_Viernes.setSelected(false);
         chb_Sabado.setSelected(false);
         chb_Domingo.setSelected(false);
     }
     private void llenarCampos() throws SQLException {
      int i = Tabla_Seccion.getSelectedRow();
        deseleccionar();
        Calendar c1 = Calendar.getInstance();
        int año = c1.get(Calendar.YEAR);
     
        txt_NombreSeccion.setText(Tabla_Seccion.getValueAt(i, 1).toString());
        String codAsignatura = Tabla_Seccion.getValueAt(i, 2).toString();
        Statement st = con.createStatement();
        String sql = "Select * from Asignaturas where cod_asignaturas = '"+codAsignatura+"'";
        ResultSet rs3 = st.executeQuery(sql);
        if(rs3.next()){
            cbo_Asignaturas.setSelectedItem(rs3.getString("cod_asignaturas") + " - " + rs3.getString("nombre_asignaturas"));
        }
        cbo_Asignaturas.setSelectedItem(Tabla_Seccion.getValueAt(i, 2).toString());
        txt_CantidadM.setText(Tabla_Seccion.getValueAt(i, 9).toString());
        txt_HoraInicial.setText(Tabla_Seccion.getValueAt(i, 4).toString().substring(0, 5));
        txt_HoraFinal.setText(Tabla_Seccion.getValueAt(i, 5).toString().substring(0,5));
        
        cbo_IdPeriodo.setSelectedItem(año+"-"+Tabla_Seccion.getValueAt(i, 6).toString() + " Período");
        lbl_seccion.setText(Tabla_Seccion.getValueAt(i, 0).toString());
        

        cbo_IdAula.setSelectedItem(Tabla_Seccion.getValueAt(i, 7).toString() + " - " + Tabla_Seccion.getValueAt(i, 7).toString().substring(1));
        //txt_HoraFinal.setText(Tabla_Seccion.getValueAt(i, 5).toString());
        
        String dias = "";
        dias =Tabla_Seccion.getValueAt(i,8).toString();
        
        if(dias.contains("Lu")){
            chb_Lunes.setSelected(true);
        }
        if(dias.contains("Ma")){
            chb_Martes.setSelected(true);
        }
        if(dias.contains("Mi")){
            chb_Miercoles.setSelected(true);
        }
        if(dias.contains("Ju")){
            chb_Jueves.setSelected(true);
        }
        if(dias.contains("Vi")){
            chb_Viernes.setSelected(true);
        }
        if(dias.contains("Sa")){
            chb_Sabado.setSelected(true);
        }
        if(dias.contains("Do")){
            chb_Domingo.setSelected(true);
        }
        
        this.btn_guardar.setEnabled(false);
        this.btn_eliminar.setEnabled(true);
        this.btn_actualizar.setEnabled(true);
    }
     
     /*private boolean validarDias(String Lu, String Ma, String Mi, String Ju, String Vi, String Sa, String Do){
        if(Lu.equals("Lu") || Lu.equals("Lu")){
            return true;
        }
       
        if(!Lu.equals(Ma)){
            return true;
        }
        else{
            return false;
        }
    }*/
 
 
}
