/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.Campus;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class PruebaCampus {
        Connection con=null;
     
     
public PruebaCampus(){
     try{
this.con= ConectorSQL.obtenerConexion();
}catch(SQLException e){
         System.out.println(e.getMessage());
    
}
}
private boolean contieneEspeciales(String texto){
    for (int i = 0; i < texto.length(); i++) {
      if (!Character.isLetterOrDigit(texto.charAt(i))) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras y numeros");
            return true;
        }  
      else{
          System.out.println("No tiene caracteres especiales");
      }
    }
    return false;
}
private boolean contieneNumeros(String texto){
    for (int i = 0; i < texto.length(); i++) {
       if (Character.isDigit(texto.charAt(i))) {
         
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
            return true;
        }
      else{
          System.out.println("No tiene numeros");
      }
    }
    return false;
}
     
     public void guardarCampus(String id,String campus){
     
      String cadena1, cadena2;
        cadena1 = id;
        cadena2 = campus;
        
       if(contieneEspeciales(id)){
           return;           
       }
       if(contieneNumeros(campus)){
           return;
       }
        

        if((id.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del campus.","Id campus  requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Debe ingresar el id campus");
            
            return;
        }
        if((campus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del campus."," nombre campus requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             System.out.println("Debe ingresar el campus");
           
            return;
        }
          if (id.length() >4) {
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ID Número máximo de caracteres admitidos");
             System.out.println("ID Cantidad maxima excedida");
               return;
        }
             
           if(campus.length() >35){
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "NOMBRE CAMPUS Número máximo de dígitos admitidos");
              System.out.println("NOMBRE CAMPUS Cantidad maxima excedida");
               return;
        }
        if (existeidCampus(id)) {
            return;
        }
        
        if (existeCampus(campus)) {
            return;
        }

        if (!validarLongitud(id, 3)) {
            JOptionPane.showMessageDialog(null, "El ID del Campus es muy pequeño el mínimo es de 3 caracteres", "Longitud del ID del Campus", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("El id es muy pequeño");
            return;

        }

        if (!validarLongitud(campus, 5)) {
            JOptionPane.showMessageDialog(null, "El nombre del campus ingresado es muy pequeños el mínimo es de 5 caracteres", "Longitud del nombre", JOptionPane.INFORMATION_MESSAGE);
              System.out.println("El id es muy pequeño");
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Campus (id_campus, nombre_campus)"
                + "                VALUES(?,?)");
            ps.setString(1, id);
            ps.setString(2, campus);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información del campus: "+campus+"");
        } catch (Exception e) {
            System.out.println(e);

        }
      /*  actualizarDatos();
        LimpiarCajas();*/
}
      public void actualizarCampus(String id,String campus){
  String nombreCampus = campus + " ";
        if((id.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del campus.","Id campus  requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
          
            return;
        }
        if((campus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del campus."," nombre campus requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);

            return;
        }
           
         else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del campus " + nombreCampus + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Campus set"
                    + " nombre_campus = ? ,"
                    + "id_campus = ? "
                    + " where id_campus =\'"+id+"\'");
                /*ps.setString(1, txt_NombreCampus.getText());*/
                ps.setString(1, campus);
                ps.setString(2, id);
               /*  this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar.setEnabled(false);
                 this.btn_guardar.setEnabled(true);*/
                int res = ps.executeUpdate();
                 if(res > 0){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información del aula " + nombreCampus + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizar la información!.");

                }
           
            } catch (Exception e) {
                System.out.println(e);
            }
            /*actualizarDatos();
            LimpiarCajas();*/
        }

    } 
      
      public void eliminarCampus(String id, String campus){
           String nombreCampus = campus + " " + id;
         if((id.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del campus.","Id campus  requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
        if((campus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del campus."," nombre campus requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del campus " + nombreCampus + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Campus "
                + "where id_campus = (Select id_campus from Campus where nombre_campus = '"+campus+"')";
               /* this.btn_eliminar.setEnabled(false);
                this.btn_actualizar.setEnabled(false);
                this.btn_guardar.setEnabled(true);*/
                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del campus " + nombreCampus + " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
           /* actualizarDatos();
            LimpiarCajas();*/
        }
          
      }
     
     
 private boolean existeidCampus(String id) {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_campus from Campus where id_campus = '" +id+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id: " +id+ " ya existe", "El id del campus ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean existeCampus(String campus) {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_campus from Campus where nombre_campus = '" +campus+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre campus: " +campus+ " ya existe", "El campus ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean validarLongitud(String texto, int longitud) {
        if (texto.length() >= longitud) {
            return true;
        }else{
            return false;
        }
    }
    
    
      public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
    
         System.out.println("HOLA");
         System.out.println("Insertar un numero para realizar la accion");
         System.out.println("1.Guardar informacion");
           System.out.println("2.Actualizar informacion");
          System.out.println("3.Eliminar informacion");
         System.out.println("4.Guardar informacion");
         
       int respuesta=sc.nextInt();
        /*  String id2=sc.nextLine();
          System.out.println(id2);*/
       if(respuesta==1){
         /*  System.out.println("Ingresar una id aula");
            String id=sc.nextLine();
             System.out.println("Ingresar una aula");
            String aula=sc.nextLine();
             System.out.println("Ingresar una PISO");
            String piso=sc.nextLine();
             System.out.println("Ingresar una Edificio");
            String edificio=sc.nextLine();*/
         String id="C665";
          String campus="3333";
           
            new PruebaCampus().guardarCampus(id,campus);
        }
        if(respuesta==2){
            System.out.println("AQUI SE ACTUALIZA");
         /*  System.out.println("Ingresar una id aula");
            String id=sc.nextLine();
             System.out.println("Ingresar una aula");
            String aula=sc.nextLine();
             System.out.println("Ingresar una PISO");
            String piso=sc.nextLine();
             System.out.println("Ingresar una Edificio");
            String edificio=sc.nextLine();*/
        String id="C665";
          String campus="s";
           
           new PruebaCampus().actualizarCampus(id,campus);
          System.out.println("AQUI SE ACTUALIZo");
        }
        
            if(respuesta==3){
            System.out.println("AQUI SE ELIMINA");
         /*  System.out.println("Ingresar una id aula");
            String id=sc.nextLine();
             System.out.println("Ingresar una aula");
            String aula=sc.nextLine();
             System.out.println("Ingresar una PISO");
            String piso=sc.nextLine();
             System.out.println("Ingresar una Edificio");
            String edificio=sc.nextLine();*/
           String id="C666";
          String campus="pruebados";
           
           new PruebaCampus().eliminarCampus(id,campus);
          System.out.println("AQUI SE ELIMINA");
        }
          
      }
}

    

  /*private void LimpiarCajas(){
        txt_NombreCampus.setText(null);
        txt_idCampus.setText(null);
         this.btn_actualizar.setEnabled(false);
         this.btn_eliminar.setEnabled(false);
         this.btn_guardar.setEnabled(true);
            
        
    }
  
  
    private void llenarCampos() {
        int i = Tabla_Campus.getSelectedRow();
        txt_idCampus.setText(Tabla_Campus.getValueAt(i, 0).toString());
        txt_NombreCampus.setText(Tabla_Campus.getValueAt(i, 1).toString());
        lbl_campus.setText(Tabla_Campus.getValueAt(i, 0).toString());
         this.btn_actualizar.setEnabled(true);
         this.btn_eliminar.setEnabled(true);
         this.btn_guardar.setEnabled(false);
            
        
        
    }
  
  private void rellenar() {
        try {
                    String cap = "";
                    ResultSet rs2 = null;
                   
                            String sql = "SELECT * FROM Campus where id_campus='"+var+"' or nombre_campus ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idCampus.setText(rs2.getString("id_campus"));
                                txt_NombreCampus.setText(rs2.getString("nombre_campus"));
                                
                            }
                        

                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }
    
     public void centrar_datos(){
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Campus.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);   
         }
    }
     
      public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Campus";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Campus.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id_campus");
                datos[1] = rs.getString("nombre_campus");
                
                modelo.addRow(datos);
            }
            TableColumn idC = Tabla_Campus.getColumn(titulos[0]);
            idC.setMaxWidth(300);
            idC.setIdentifier(ICONIFIED);
            TableColumn cnombre = Tabla_Campus.getColumn(titulos[1]);
            cnombre.setMaxWidth(300);
           
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
          //  System.err.println(e);
        //}
    






