package pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author wianp
 */
public class PeriodoHistoricoTest {
    
      Connection con = null;
      Statement st;
      String idPeriodo;
      String nombrePeriodo;
      Date fechaInicial;
     Date  fechaFinal;
    
     public static SimpleDateFormat sdf= new SimpleDateFormat ("dd-MM-YYYY");
public static Calendar calendar = new GregorianCalendar();

     
       public  PeriodoHistoricoTest () {
    
           cargarFecha(2,10,2020);
Date fecha = getDateCalendar ();
String fechaCadena = DateAString(fecha);
System.out.println(fechaCadena);
           
        try{
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
      
    }
       
       public static void cargarFecha (int dia, int mes, int anio){

calendar.set(anio, mes, dia);
       }
       
       
public static Date getDateCalendar (){

 return calendar.getTime();
}

public static String DateAString (Date fecha){

 return sdf.format(fecha);
}
        public void AgregarPeriodoHistorico ( String idPeriodo, String nombrePeriodo, String fechaInicial, String fechaFinal) {
         
            //Define Fechas  en base a campos calendar
            /* periodo=cbo_periodo.getSelectedItem().toString().substring(0,1);
        Date dateinicial = cld_fechaInicial.getDate();
        Date datefinal = cld_fechaFinal.getDate();*/
            
          if ( (nombrePeriodo.equals("") ) || (idPeriodo.equals("") ) || (fechaInicial.equals("") )  || (fechaFinal.equals("") ))   {
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del período.","Nombre de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }
          
          //Parametros a recibir de calendar 
          
          if( (getDateCalendar()== null)){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la fecha de inicio del período.","Fecha Inicial Requerida",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
        if( (getDateCalendar()== null)){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la fecha final del período.","Fecha Final Requerida",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
         }
          
              if(idPeriodo.equals(idPeriodo) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar el id del período","Id del período no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
               if(nombrePeriodo.equals(nombrePeriodo) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar el nombre del período","Nombre del período no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
               }
               
               if(fechaInicial.equals(fechaInicial) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar la fecha Inicial del período historico","Hora Inicial del período historico no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
               }
               
                if(fechaFinal.equals(fechaFinal) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar la fecha Final del período historico","Hora Final del período historico no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
               }
        
          /*int mes = cld_fechaInicial.getDate().getMonth() + 1;
        int año = cld_fechaInicial.getDate().getYear() +1900;
        int dia =cld_fechaInicial.getDate().getDate();
        
        
           
        String fecha = año + "-" + mes +"-"+ dia;

        int mes2 = cld_fechaFinal.getDate().getMonth() + 1;
        int año2 = cld_fechaFinal.getDate().getYear() +1900;
        int dia2 =cld_fechaFinal.getDate().getDate();
        String fecha2 = año2 + "-" + mes2 +"-"+ dia2;

      
  
        nombre=año+"-"+periodo;
*/
       
          
          try{
            PreparedStatement ps;
            ResultSet rs;
              Statement stdoble = con.createStatement();
               String sqldoble = "select* from Periodo_historico \n" +
                                    "where nombre_periodo_historico='"+nombrePeriodo+"'";
               ResultSet rsdoble = stdoble.executeQuery(sqldoble);
               if (rsdoble.next()) {

                  JOptionPane.showMessageDialog(null, "El período: " +nombrePeriodo+ " ya esta creada. ", "Período Ya Creada", JOptionPane.ERROR_MESSAGE);
                   return ;
               }    
            ps=con.prepareStatement("insert into Periodo_historico(fecha_final,fecha_inicial,id_periodo,nombre_periodo_historico)"
                + "             VALUES(?,?,?,?)");

            ps.setString(1, fechaFinal);
            ps.setString(2, fechaInicial);
            ps.setString(3, idPeriodo);
            ps.setString(4, nombrePeriodo);


            int res= ps.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Se ha guardado el periodo: "+nombrePeriodo);
            //    actualizarDatos();
                // limpiar();
            }else {
                JOptionPane.showMessageDialog(null, "Error al Guardar la información");
            }

        } catch ( Exception e) {
             System.out.println(e);
             JOptionPane.showMessageDialog(null, "Error al Guardar la información de Periodo Historico");
            
        }
          
}
        
 
        public void ActualizarPriodoHistorico ( String idPeriodo, String nombrePeriodo,  String fechaInicial, String fechaFinal) {
            
         if ( (nombrePeriodo.equals("") ) || (idPeriodo.equals("Seleccione un periodo") ) || (fechaInicial.equals("") )  || (fechaFinal.equals("") )) {
            JOptionPane.showMessageDialog(null, "¡Debe rellenar todos los campos!");
        }

       else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el periodo ?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            
           /* periodo=cbo_periodo.getSelectedItem().toString().substring(0,1);
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

        nombre=año+"-"+periodo;*/
           
                
     }
            
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("update Periodo_historico set\n" +
                                            "id_periodo=?,\n" +
                                            "fecha_inicial=?,\n" +
                                            "fecha_final=?,\n" +
                                            "nombre_periodo_historico=?\n" +
                                            "where nombre_periodo_historico= '"+nombrePeriodo+"'");
              
                ps.setString(1,idPeriodo);
                
                //Cambio ps.setString por ps.setDate
                ps.setString(2, fechaInicial);
                ps.setString(3, fechaFinal);
                ps.setString(4,nombrePeriodo);
                int res = ps.executeUpdate();
                
                 if(res > 0){
                JOptionPane.showMessageDialog(null, "Se ha Actualizado el periodo: "+nombrePeriodo);
             //   actualizarDatos();
                //Limpiar();
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar la información");
            }
                
            } catch (Exception e) {
                System.out.println(e);
                              JOptionPane.showMessageDialog(null, "No se ha realizado la actualización por: \n 1.El periodo historico ya está definido."
                         + "\n 2. No se encuentra el id del periodo historico a actualizar.","¡Error al Actualizar!", JOptionPane.ERROR_MESSAGE);
            }
          
        }
        
        /*public void rellenar(){
                    try{
                    String cap="";
                    ResultSet rs2 = null;
                    String var = JOptionPane.showInputDialog(null,"Ingrese el nombre del período histórico que desea buscar","Consulta de período histórico",JOptionPane.QUESTION_MESSAGE);
                    if(var == null)
                        JOptionPane.showMessageDialog(null,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(null,"Favor de ingresar los datos del período histórico\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            String sql = "SELECT * FROM Periodo_historico as ph join Periodo as p on p.id_periodo = ph.id_periodo\n" +
                                         "where nombre_periodo_historico = '"+var+"' "
                                        + "and ph.id_periodo = (select id_periodo from Periodo_historico where nombre_periodo_historico = '"+var+"')";
                            Statement stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                            if(rs2.next()) {
                                nombrePeriodo.equals("nombre_periodo_historico");
                                idPeriodo.equals(("id_periodo") + " - " + rs2.equals("descripcion"));
                                fechaInicial.setDate(rs2.getDate("fecha_inicial"));
                                fechaFinal.setDate(rs2.getDate("fecha_final"));
                                nombrePeriodo.setString(rs2.equals("nombre_periodo_historico"));
                                
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
     
        
         }*/
        
        public void ConsultarPeriodoHistorico (String idPeriodo, String nombrePeriodo, String fechaInicial, String fechaFinal){
            
            //Metodo Rellenar
        }
            
        
        public void ActualizarDatos (){
            
             try {
            String sql = "SELECT * FROM Periodo_historico as ph join Periodo as p on p.id_periodo = ph.id_periodo";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Date fechaInicial = rs.getDate("fecha_inicial");
                Date fechaFinal = rs.getDate("fecha_final");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = formatter.format(fechaInicial);
                String fechaFin = formatter.format(fechaFinal);
              
            }
           
           
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
            
        }
   }
