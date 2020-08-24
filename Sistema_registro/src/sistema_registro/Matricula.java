/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistema_registro.SQL.ConectorSQL;


/**
 *
 * @author Carlos
 */
public class Matricula extends javax.swing.JFrame {
 Connection con=null;
    ResultSet rs;
    
    String titulos [] = {"Codigo de Asignatura", "Nombre de la Asignatura", "Seccion", "Hora Inicial", "Hora Final","Periodo", "Unidades Valorativas",  "Matrícula"};
   
    DefaultTableModel modelo =  new DefaultTableModel();
    Statement stmt = null;
    String var, var2;
    
    /**
     * Creates new form Matricula
     */
    public Matricula()throws SQLException{
        this.con = ConectorSQL.obtenerConexion();
         initComponents();
         desactivar();
         obtenerPeriodo();
          this.setTitle("Matricula");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage()); 
         this.lbl_periodo.setVisible(false);
        this.btn_matricularAsignatura.setEnabled(false);
        this.btn_generarReporte.setEnabled(false);
    }
    
        public Matricula(String nombreUsuario)throws SQLException{
        this.con = ConectorSQL.obtenerConexion();
         initComponents();
         desactivar();
         obtenerPeriodo();
          this.setTitle("Matricula");
          this.lbl_periodo.setVisible(false);
          this.lbl_usuario.setText(nombreUsuario);
          this.btn_matricularAsignatura.setEnabled(false);
          this.btn_generarReporte.setEnabled(false);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        
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
        tbl_asignaturas = new javax.swing.JTable();
        btn_matricularAsignatura = new javax.swing.JButton();
        btn_generarReporte = new javax.swing.JButton();
        lbl_cancelarAsignatura = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_numeroCuenta = new javax.swing.JLabel();
        txt_numeroCuenta = new javax.swing.JTextField();
        btn_buscarClases = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_periodo = new javax.swing.JLabel();
        lbl_codAsignatura = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_asignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Asignatura", "Nombre Asignatura", "Seccion", "Hora inicial", "Hora final", "Periodo", "Aula", "UV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_asignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_asignaturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_asignaturas);
        if (tbl_asignaturas.getColumnModel().getColumnCount() > 0) {
            tbl_asignaturas.getColumnModel().getColumn(0).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(1).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(2).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(3).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(4).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(5).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(6).setResizable(false);
            tbl_asignaturas.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 954, 210));

        btn_matricularAsignatura.setBackground(new java.awt.Color(235, 250, 251));
        btn_matricularAsignatura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_matricularAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_matricularAsignatura.setText("Matricular asignatura");
        btn_matricularAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_matricularAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_matricularAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        btn_generarReporte.setBackground(new java.awt.Color(235, 250, 251));
        btn_generarReporte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_generarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/writing-on-an-open-book_icon-icons.com_70325.png"))); // NOI18N
        btn_generarReporte.setText("Generar reporte matricula");
        btn_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, -1, -1));

        lbl_cancelarAsignatura.setBackground(new java.awt.Color(235, 250, 251));
        lbl_cancelarAsignatura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_cancelarAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        lbl_cancelarAsignatura.setText("Cancelar asignatura");
        lbl_cancelarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_cancelarAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(lbl_cancelarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lbl_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_numeroCuenta.setText("Número de cuenta:");

        txt_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_numeroCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numeroCuentaKeyTyped(evt);
            }
        });

        btn_buscarClases.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscarClases.setText("Buscar clases");
        btn_buscarClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarClasesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(lbl_numeroCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_numeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_buscarClases)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscarClases)
                    .addComponent(lbl_numeroCuenta)
                    .addComponent(txt_numeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 950, -1));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Matrícula");

        lbl_periodo.setText("jLabel1");

        lbl_codAsignatura.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_codAsignatura)
                .addGap(357, 357, 357)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(lbl_periodo)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_periodo)
                    .addComponent(lbl_codAsignatura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 950, 50));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 650));

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu.setText("Menu");

        jMenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuPrincipal.setText("Menu Principal");
        jMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu.add(jMenuPrincipal);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_cancelarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_cancelarAsignaturaActionPerformed
       
     
           this.dispose();
         CancelarAsignatura aa = null;
         try {
             aa = new CancelarAsignatura(lbl_usuario.getText());
         } catch (SQLException ex) {
             Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
         }
        aa.setVisible(true);
        
    
        
    }//GEN-LAST:event_lbl_cancelarAsignaturaActionPerformed

     private void obtenerPeriodo() throws SQLException{
        Statement st = con.createStatement();
        Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       String fecha = año+"-"+mes+"-"+ d;
        String sql = "select nombre_periodo_historico from Periodo_historico\n" +
        "where fecha_inicial < '"+fecha+"' and fecha_final > '"+fecha+"'";
        ResultSet rs2 = st.executeQuery(sql);
        if(rs2.next()){
            lbl_periodo.setText(rs2.getString(1));
            lbl_periodo.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

     private boolean existeNumeroCuenta() {
        try {
            Statement st = con.createStatement();
            String sql = "select A.numero_cuenta_alumno from Alumno as A\n" +
                           "where A.numero_cuenta_alumno='"+txt_numeroCuenta.getText()+"';";
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                     LimpiarCajas();
                JOptionPane.showMessageDialog(null, "El número de cuenta: " +txt_numeroCuenta.getText()+ " no existe", "Número de Cuenta Incorrecto", JOptionPane.ERROR_MESSAGE);
                return true;
            } else {
                
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
    }
    
    private boolean validarRequisito1(String codigo){      
     try {
         Statement st = con.createStatement();
         String sql = "select requisito1 from Asignaturas\n" +
                      "where cod_asignaturas = '"+codigo+"'";
         ResultSet rs1 = st.executeQuery(sql);
         if(rs1.next()){
             if(!rs1.getString("requisito1").equals("Sin r")){
                 String requisito = rs1.getString("requisito1");
                 String consulta = "select * from notas as n join Matricula as m on m.id_matricula = n.id_matricula\n" +
                                "where numero_cuenta = '"+txt_numeroCuenta.getText()+"' and id_seccion like '"+requisito+"'";
               Statement st1 = con.createStatement();  
                ResultSet rs2 = st1.executeQuery(consulta);
                if(rs2.next()){
                    if(rs2.getString("estado").equals("APB")){
                        return true;
                    }
                    if(rs2.getString("estado").equals("RPB") || rs2.getString("estado").equals("S/C")){
                        return false;
                    }
                }
             }
             else{
                 return true;
             }
         }
                
     } catch (SQLException ex) {
         Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
     }
       return true;    
    }

     
  
     
    
    
    
    public void buscar(){
        
        this.tbl_asignaturas.setVisible(true);
           
        if((txt_numeroCuenta.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de cuenta.","Número de Cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_numeroCuenta.requestFocus();
            return;
        }
         if(existeNumeroCuenta()){
            return;
            
        }
       
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tbl_asignaturas.setModel(modelo);
            
            PreparedStatement ps=null;
            ResultSet rs=null;
            
           /* String sql="select A.cod_asignaturas, A.nombre_asignaturas, S.Nombre_seccion, S.Hora_inicial, S.Hora_final, S.id_periodo,S.id_aula, A.UV from Secciones as S\n" +
                        "join Asignaturas as A on S.cod_asignaturas=A.cod_asignaturas join Matricula as m on m.id_seccion = s.id_seccion \n" +
                        "join notas as n on n.id_matricula = m.id_matricula\n" +
                        "where n.estado = 'S/C' or n.estado = 'RPB' and m.numero_cuenta_alumno = '"+txt_numeroCuenta.getText()+"' and a.id_carrera = 'INFO'";*/
           
           String sql="select A.cod_asignaturas, A.nombre_asignaturas, S.Nombre_seccion, S.Hora_inicial, S.Hora_final, S.id_periodo,S.id_aula, A.UV from Secciones as S\n" +
"join Asignaturas as A on S.cod_asignaturas=A.cod_asignaturas ";
           
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery(); 
            
            ResultSetMetaData rsMd =rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Cod.Asignatura");
            modelo.addColumn("Nombre");
            modelo.addColumn("Sección");
            modelo.addColumn("Hora Inicial");
            modelo.addColumn("Hora Final");
            modelo.addColumn("Período");
            modelo.addColumn("Aula");
            modelo.addColumn("UV");
            modelo.addColumn("Selecciona");
            TableColumn tc = tbl_asignaturas.getColumnModel().getColumn(8);
            tc.setCellEditor(tbl_asignaturas.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(tbl_asignaturas.getDefaultRenderer(Boolean.class));
            
            //[]anchos ={50,200,50,50};
            
            for (int x = 0; x < cantidadColumnas ; x++) {
                tbl_asignaturas.getColumnModel().getColumn(x);
                
            }
            
            while(rs.next()){
                
                Object[] filas =new Object[cantidadColumnas ];
                
                for(int i=0; i< cantidadColumnas ; i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
                this.txt_numeroCuenta.setEnabled(false);
               /* tbl_asignaturas.setShowGrid(true);
                tbl_asignaturas.setShowHorizontalLines(true);
                this.tbl_asignaturas.setEnabled(true);
                this.btn_generarReporte.setEnabled(true);*/
                
           }
         }catch(SQLException ex){
             System.out.println(ex.toString());
             
         }    
        
    }
    
    
   public boolean validarCantidadMaximaEstudiantes(String CantidadMinima, String CantidadMaxima){
        
       int minima=Integer.parseInt(CantidadMinima);
       int maxima=Integer.parseInt(CantidadMaxima);
       
        if(minima<maxima){
            return true;
            
        }
        else{
            if(minima>maxima){
                JOptionPane.showMessageDialog(null,"Esta Sección está llena");
                return false;
                
            }
        
     
        }    
        return false;
    }
   
   private void desactivar(){
      
        this.btn_matricularAsignatura.setEnabled(false);
    } 
   
   
    private void btn_buscarClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarClasesActionPerformed
     buscar();
     
      
    //.btn_matricularAsignatura.setEnabled(true);
 
      //  mostrarClientes();
     //   String idAlumno;
   // existeNumeroCuenta();
   //idAlumno=txt_numeroCuenta.getText();
 
        
        
    }//GEN-LAST:event_btn_buscarClasesActionPerformed
        

              
  
    
    public boolean IsSelected(int row,int column, JTable tbl_asignaturas){
        return tbl_asignaturas.getValueAt(row, column) != null;
             
    }
      public boolean ValidacionSeleccionMultiple(int row,int column, JTable tbl_asignaturas){
          
         
          
        return tbl_asignaturas.getValueAt(row, column) != null;
             
    }
    

    
    public boolean agregarMatricula(String nombre, String codigo){
        String numeroCuenta,id_periodo,estado,reposicion,nota1,nota2,nota3,promedio;
        ResultSet rs=null;
        numeroCuenta =txt_numeroCuenta.getText();
        id_periodo= lbl_periodo.getText().substring(5);
        estado="RPB";
        reposicion="S/N";
        nota1="0";
        nota2="0";
        nota3="0";
        promedio="0";
        existeNumeroCuenta();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        try{
         String idseccion = null;
         Statement stat = con.createStatement();
           String sql2="select * from Secciones as S\n" +
       "where S.cod_asignaturas= '"+nombre+"' and S.Nombre_seccion='"+codigo+"'";
         ResultSet rs2 = stat.executeQuery(sql2);
                  if (rs2.next()) {
                        idseccion = rs2.getString("id_seccion");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error");
                  }
                  
            Statement cantidast = con.createStatement();
            String cantidadAlumno = "";
            String maximaAlumno="";
            String cantidadsql = "select  cantidad_alumnos, cantidad_maxima from Secciones where id_seccion='"+idseccion+"'";
             ResultSet rs5 = stat.executeQuery(cantidadsql);
                  if (rs5.next()) {
                        cantidadAlumno = rs5.getString("cantidad_alumnos");
                        maximaAlumno=rs5.getString("cantidad_maxima");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error");
                  }
       int minima=Integer.parseInt(cantidadAlumno);
       int maxima=Integer.parseInt(maximaAlumno);
       
       /* if(minima<maxima){
            return true;
        }
        else{*/
            if(minima>=maxima){
                JOptionPane.showMessageDialog(null,"Esta Sección está llena");
                return false;
               
            }
   
        
         
        Statement stdoble2 = con.createStatement();
               String sqldoble2 = "select * from matricula as m join secciones as s on s.id_seccion = m.id_seccion join Asignaturas as a on a.cod_asignaturas = s.cod_asignaturas \n" +
                           "where numero_cuenta_alumno='"+numeroCuenta+"' and s.cod_asignaturas='"+lbl_codAsignatura.getText()+"'";
               ResultSet rsdoble2 = stdoble2.executeQuery(sqldoble2);
               if (rsdoble2.next()) {

                  JOptionPane.showMessageDialog(null, "El Alumno tiene la asignatura: " +rsdoble2.getString("nombre_asignaturas")+ " ya matriculada  ", "Asignatura Ya Matriculada", JOptionPane.ERROR_MESSAGE);
                   return true;
               }     
     
               Statement stdoble = con.createStatement();
               String sqldoble = "select * from matricula as m\n" +
                           "where numero_cuenta_alumno='"+numeroCuenta+"' and id_seccion='"+idseccion+"'";
               ResultSet rsdoble = stdoble.executeQuery(sqldoble);
               if (rsdoble.next()) {

                  JOptionPane.showMessageDialog(null, "El Alumno esta matriculado en la seccion: " +idseccion+ " ", "Asignatura Ya Matriculada", JOptionPane.ERROR_MESSAGE);
                   return true;
               }         
        
                   
            
            String sql="insert Matricula (numero_cuenta_alumno,id_seccion)\n" +
                  "values (?,?)";
            
            pst=con.prepareStatement(sql);
           
            pst.setString(1,numeroCuenta);
             
            pst.setString(2,idseccion);
            
              int i= pst.executeUpdate();
              
           
            Statement prueba = con.createStatement();
            String id_matricula = "";
            String pruebasql = "select top 1 * from Matricula order by id_matricula desc";
             ResultSet rs3 = stat.executeQuery(pruebasql);
                  if (rs3.next()) {
                        id_matricula = rs3.getString("id_matricula");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error");
                  }
              
             String sql3="Insert into Notas (numero_cuenta,id_periodo,estado,reposicion,nota1,nota2,nota3,promedio,id_matricula)\n" +
                  "values (?,?,?,?,?,?,?,?,?)";  
             pst2=con.prepareStatement(sql3);
           
            pst2.setString(1,numeroCuenta);
            pst2.setString(2,id_periodo);
            pst2.setString(3,estado);
            pst2.setString(4,reposicion);
            pst2.setString(5,nota1);
            pst2.setString(6,nota2);
            pst2.setString(7,nota3);
            pst2.setString(8,promedio);
            pst2.setString(9,id_matricula);
             int res= pst2.executeUpdate();
              if(res > 0){
                      
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la calificación"); 
 
                  }
         
          PreparedStatement ps;
          ResultSet rs4;
          ps=con.prepareStatement("Update Secciones\n" +
                                        "set cantidad_alumnos=cantidad_alumnos+1\n" +
                                        "where id_seccion= '"+idseccion+"'");
                
                
                 // ps.setString(6,reposicion);
                  int res4= ps.executeUpdate();
                  if(res > 0){
                      
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar"); 
 
                  }
            if(i !=0){
                
            JOptionPane.showMessageDialog(null, "La matrícula del alumno "+numeroCuenta+" se ha realizado con éxito");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar la calificación"); 
            
                return false;
            }
       
             
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        
    }
  
    private void btn_matricularAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_matricularAsignaturaActionPerformed
        for (int i = 0; i < tbl_asignaturas.getRowCount(); i++) {
            
            if (IsSelected(i,8, tbl_asignaturas)) {
                
                 agregarMatricula(tbl_asignaturas.getValueAt(i,0).toString(),tbl_asignaturas.getValueAt(i,2).toString());
                 buscar();
                
            }   
        }
         desactivar();
        
    }//GEN-LAST:event_btn_matricularAsignaturaActionPerformed

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

    private void tbl_asignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_asignaturasMouseClicked
        int i = tbl_asignaturas.getSelectedRow();
        lbl_codAsignatura.setText(tbl_asignaturas.getValueAt(i, 0).toString());
        this.btn_generarReporte.setEnabled(true);
        this.lbl_cancelarAsignatura.setEnabled(true);
        this.btn_matricularAsignatura.setEnabled(true);
    }//GEN-LAST:event_tbl_asignaturasMouseClicked

    private void btn_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarReporteActionPerformed
      try {
            JasperReport reporte = null;
            String path = "src\\reportes\\report2.jasper";
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("periodoHistorico",lbl_periodo.getText());
            parameters.put("numeroCuenta",txt_numeroCuenta.getText());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint;
            jprint=JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);      
       } catch (JRException ex) {
           Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btn_generarReporteActionPerformed

    private void jMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipalActionPerformed
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
    }//GEN-LAST:event_jMenuPrincipalActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
   LimpiarCajas();
   this.btn_matricularAsignatura.setEnabled(false);
   this.txt_numeroCuenta.setEnabled(true);
   
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.txt_numeroCuenta.setEnabled(true);
        this.txt_numeroCuenta.setText("");
        this.tbl_asignaturas.setVisible(false);
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
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Matricula().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarClases;
    private javax.swing.JButton btn_generarReporte;
    private javax.swing.JButton btn_matricularAsignatura;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lbl_cancelarAsignatura;
    private javax.swing.JLabel lbl_codAsignatura;
    private javax.swing.JLabel lbl_numeroCuenta;
    private javax.swing.JLabel lbl_periodo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTable tbl_asignaturas;
    private javax.swing.JTextField txt_numeroCuenta;
    // End of variables declaration//GEN-END:variables

    
   public void LimpiarCajas(){
        txt_numeroCuenta.getText();
    }
     
   /* public void CancelarA(String nombre, String id) throws SQLException{
        try{
          /*  String id_seccion = null;
            Statement stm = con.createStatement();
            String sql3 = "select * from Secciones as S\n"+
                     "where id_seccion ='"+nombre+"'";
            ResultSet rs1 = stm.executeQuery(sql3);
            if(rs1.next()){
                id_seccion = rs1.getString("id_seccion");
            }
            else{
               JOptionPane.showMessageDialog(null,"error");  
            }
            
            String id_matricula = "";
            
            String sql4 = "select * from Matricula as M\n"+
                        "where id_matricula ='"+id_matricula+"'";*/
  
              //Statement st2=con.createStatement();
           
            /// String sql ="Delete from Matricula where numero_cuenta_alumno = '"+txt_numeroCuenta.getText()+"' " +  "and id_seccion ='"+id_seccion+"' "+" and id_matricula ='"+id_matricula+"' ";
            
              // int rs4 = st2.executeUpdate(sql);
               
               //if(rs4 > 0){ 
                    //  JOptionPane.showMessageDialog(null, "Se ha cancelado la asignatura correctamente."); 
                  //}else {
                     //JOptionPane.showMessageDialog(null, "¡Error al cancelar la asignatura!"); 
                 // }
          ///}catch ( Exception e) {
         //  JOptionPane.showMessageDialog(null, e.getMessage()); 
        //}
          //  return false;
            
    //}*/
   
    }

    

    

