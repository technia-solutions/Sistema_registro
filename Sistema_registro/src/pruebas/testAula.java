/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

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
import sistema_registro.Aula;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class testAula {
    
     Connection con=null;
     
     
public testAula(){
     try{
this.con= ConectorSQL.obtenerConexion();
}catch(SQLException e){
         System.out.println(e.getMessage());
    
}
}

private boolean contieneNumeros(String texto){
    for (int i = 0; i < texto.length(); i++) {
        if (Character.isDigit(texto.charAt(i))) {
               System.out.println("Contiene numeros");
            return true;
 
        }
        System.out.println("No contiene numeros");
       
    }
    return false;
}
private boolean contieneCaracteresEspeciales(String texto){
    for (int i = 0; i < texto.length(); i++) {
        if (Character.isLetterOrDigit(texto.charAt(i))) {
               System.out.println("solo letras y numeros");
            return true;
 
        }
        System.out.println("teine caracteres");
       
    }
    return false;
}


public void guardarAula(String id,String aula, String piso, String edificio){
     String cadena1, cadena2,cadena3;
        cadena1 = id;
        String id_edificio = edificio;
        cadena2 = aula;
        cadena3 = piso;
        
        contieneNumeros(aula);
      
      //  contieneCaracteresEspeciales(id);

          /* if(piso.length() >=3){
      
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
               System.out.println("Cantidad maxima excedida");
               return;
        }*/
            contieneNumeros(piso);
          
             if (id.length() >4) {
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ID Número máximo de caracteres admitidos");
             System.out.println("ID Cantidad maxima excedida");
               return;
        }
             
           if(piso.length() >1){
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "PISO Número máximo de dígitos admitidos");
              System.out.println("PISO Cantidad maxima excedida");
               return;
        }
           
         if((id.equals(""))){
             System.out.println("Debe ingresar el piso del aula");

            return;
        }
         
           
         if((aula.equals(""))){
             System.out.println("Debe ingresar el piso del aula");
      
            return;
        }
         
            
         if((piso.equals(""))){
             System.out.println("Debe ingresar el piso del aula.");
     
            return;
        }
         
         if((edificio.equals("Seleccione un edificio"))){
             System.out.println("Debe ingresar el piso del aula");
            return;
        }

        if(existeAula(id)){
            return;
        }
        
        if(existeNombreAula(aula)){
            return;
        }

        if(!validarLongitud(cadena1,4)){
            JOptionPane.showMessageDialog(null, "El id del aula debe ser de 4 caracter.", "Longitud de id del aula.", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(aula,3)){
            JOptionPane.showMessageDialog(null, "El Nombre de la aula es muy corto el mínimo es de 3 caracteres.", "Longitud del nombre de aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(piso,1)){
            JOptionPane.showMessageDialog(null, "El piso de la aula es muy corto el mínimo es de 1 caracteres.", "Longitud del piso del aula", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Aula (id_aula,id_edificio ,nombre_aula,piso_aula)"
                + "                VALUES(?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2, id_edificio);
            ps.setString(3, aula);
            ps.setString(4,piso);
            

            int res= ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de aula.");
        } catch ( Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
}


public void actualizarAula(String id,String aula, String piso, String edificio){
       String Aula = aula + " ";
       contieneNumeros(aula);
        contieneNumeros(piso);
        if(piso.length() >=3){
      
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
               System.out.println("Cantidad maxima excedida");
               return;
        }
          
             if (id.length() >=4) {
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
             System.out.println("Cantidad maxima excedida");
               return;
        }
             
           if(piso.length() >=1){
           
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
              System.out.println("Cantidad maxima excedida");
               return;
        }
          if((id.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del aula.","Id aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
         
           
         if((aula.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del aula.","Nombre aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
         
            
         if((piso.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el piso del aula.","Piso de aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
         
         if((edificio.equals("Seleccione un edificio"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un edificio para el aula.","Edificio del aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del aula" +Aula + "?.", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
           //String id_edificio = cbo_idEdificio.getSelectedItem().toString().substring(0, 2);

            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Aula set"
                    + " id_aula= ? ,"
                   + " id_edificio = ? , "
                    + " nombre_aula = ?  , "
                    + " piso_aula = ?  "
                    + " where id_aula =\'"+id+"\'");
                ps.setString(1, id);
                ps.setString(2, edificio);
                ps.setString(3, aula);
                ps.setString(4, piso);
               /*  this.btn_guardar.setEnabled(true);
                 this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar.setEnabled(false);*/

                int res = ps.executeUpdate();
           
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información del aula " + Aula + " correctamente.");

               
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null,"Error al actualizar la información de la aula, podría ser por: \n 1.El aula ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la aula a actualizar.\n 3.El aula tiene secciones creadas","¡Error al actualizar!", JOptionPane.ERROR_MESSAGE);
            }
         /*  actualizarDatos();
            LimpiarCajas();*/

        }
}

public void eliminarAula(String id,String aula, String piso, String edificio){
  String Aula = id + " " + piso;

         if((id.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del aula.","Id aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           // txt_idAula.requestFocus();
            return;
        }
         
           
         if((aula.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del aula.","Nombre aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
          //  txt_nombreAula.requestFocus();
            return;
        }
         
            
         if((piso.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el piso del aula.","Piso de aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
         //   txt_PisoAula.requestFocus();
            return;
        }
         
         if((edificio.equals("Seleccione un edificio"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un edificio para el aula.","Edificio del aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del aula " + Aula + ".", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Aula "
                + "where id_aula = (Select id_aula from Aula where nombre_aula = '"+aula+"')";
                /* this.btn_guardar.setEnabled(true);
                 this.btn_actualizar.setEnabled(false);
                 this.btn_eliminar.setEnabled(false);*/

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del aula " + Aula + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!.");

                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e.getMessage());
             JOptionPane.showMessageDialog(null, "Error al borrar la información del aula, podría ser por: \n 1.El aula ya está en uso."
                         + "\n 2. No se encuentra el código del aula a borrar.\n","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
            }
           /*actualizarDatos();
            LimpiarCajas();*/

        }
}




 private boolean validarLongitud(String texto, int longitud){
       if(texto.length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }
    
    private boolean existeAula(String id) {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_aula from Aula where id_aula = '"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Aula: "+id+" ", "Codigo de aula ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
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
    
      
    private boolean existeNombreAula(String aula) {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_aula from Aula where nombre_aula = '"+aula+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el nombre de aula: "+aula+".", "Nombre de aula ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
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
    
    /* private void actualizarDatos() {
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
    }*/

   /* private void centrar_datos() {
        
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Aula.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }
    }*/
    
    
     /*  private void rellenar(){
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
    
    }*/

 /*   private void LimpiarCajas() {
       
        txt_idAula.setText(null);
        txt_nombreAula.setText(null);
         txt_PisoAula.setText(null);
        cbo_idEdificio.setSelectedIndex(0);
         this.btn_guardar.setEnabled(true); 
         this.btn_eliminar.setEnabled(false);
            this.btn_actualizar.setEnabled(false);
       
        
       
    }*/

   /* private void llenarCampos() throws SQLException {
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
    
    }*/

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
         String id="C666";
          String aula="A55";
           String piso="A";
            String edificio="P";
            new testAula().guardarAula(id, aula, piso, edificio);
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
         String id="C333";
          String aula="554";
           String piso="5";
            String edificio="P";
            new testAula().actualizarAula(id, aula, piso, edificio);
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
         String id="C333";
          String aula="554";
           String piso="5";
            String edificio="P";
            new testAula().eliminarAula(id, aula, piso, edificio);
          System.out.println("AQUI SE ELIMINA");
        }
          
      }
  
          
      }
         
  
         
    
    



