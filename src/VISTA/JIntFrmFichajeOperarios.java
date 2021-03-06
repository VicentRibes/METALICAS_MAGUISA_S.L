/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import BLL.FichajeOperariosBLL;
import ENTIDAD.FichajeOperarios;
import static ENTIDAD.fecha.DatetoSpanishString;
import datechooser.beans.DateChooserDialog;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import MODELOS.FormatoTabla;
import MODELOS.ModeloTablaFichajeOperariosVista;
import MODELOS.ModeloTablaInformacionOperarioVista;
import com.toedter.calendar.JDateChooser;
//PARA LA HORA EN TIEMPO REAL
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miguel
 */
public class JIntFrmFichajeOperarios extends javax.swing.JInternalFrame implements Runnable{
    /**
     * Creates new form JIntFrmFichajeOperarios
     */
    //RELOJ EN TIEMPO REAL
    int hora, minutos, segundos;
    Calendar calendario;
    Thread h1;
    //prova
    
    FichajeOperariosBLL fichajeOperariobll=new FichajeOperariosBLL();
    ArrayList<FichajeOperarios> fichajeOperarios= new ArrayList();
    ArrayList<FichajeOperarios> fichajeOperariosSalida= new ArrayList();
    ArrayList<FichajeOperarios> fichajeOperariosInforme= new ArrayList();
//    ArrayList totalMinutos= new ArrayList();
    String totalMinutos="";
    Date data=new Date();
    
    public JIntFrmFichajeOperarios() throws SQLException {
 
        fichajeOperariosSalida=fichajeOperariobll.obtenerFichajeOperariosSalida(data);
        fichajeOperarios=fichajeOperariobll.obtenerFichajeOperarios(data);
        initComponents();
        
         
        h1 = new Thread(this);//hilo para el reloj
        h1.start();
            
        jTOperario.setEditable(false);
        jTFecha.setEditable(false);
        jTFecha.setVisible(false);//SE UTILIZABA EN VERSIONES ANTERIORES, ACTUALMENTE NO SE UTILIZA
        jTHora.setEditable(false);
        jBreset.setVisible(true);
        jDateChooser1.setDate(data);
        //jDateChooser1.getDateEditor().setEnabled(false);
        

        //evento jDateChooser1 para realizar una acción
        
        //REFRESCAR PANTALLA HACIENDO CLICK EN LA DATA
            this.jDateChooser1.getDateEditor().getUiComponent().addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(evt.getClickCount()==1){  
                        resetPantalla();
                    }
                }
            });
        
        
        
        
        
        refrescarDimensionesColumna();

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
        jTFichajeOperarios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTFichajeOperariosSalida = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFecha = new javax.swing.JTextField();
        jTHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBreset = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTInformeOperario = new javax.swing.JTable();
        jTminutos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTOperario = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setAutoscrolls(true);

        jTFichajeOperarios.setBorder(new javax.swing.border.MatteBorder(null));
        jTFichajeOperarios.setModel(new ModeloTablaFichajeOperariosVista(fichajeOperarios));
        jTFichajeOperarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFichajeOperariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFichajeOperarios);

        jTFichajeOperariosSalida.setModel(new ModeloTablaFichajeOperariosVista(fichajeOperariosSalida));
        jTFichajeOperariosSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFichajeOperariosSalidaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTFichajeOperariosSalida);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OPERARIOS DENTRO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OPERARIOS FUERA");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(151, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(151, 17));
        jLabel2.setPreferredSize(new java.awt.Dimension(151, 17));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONTROL OPERARIOS");

        jLabel5.setText("HORA");

        jLabel6.setText("FECHA");

        jBreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/actualizar.jpg"))); // NOI18N
        jBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresetActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jTInformeOperario.setModel(new ModeloTablaInformacionOperarioVista(fichajeOperariosInforme));
        jScrollPane3.setViewportView(jTInformeOperario);

        jLabel7.setText("TOTAL :");

        jLabel8.setText("minutos");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("INFROMACIÓN OPERARIO ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTminutos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jTOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTminutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(jBreset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBreset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFichajeOperariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFichajeOperariosMouseClicked
        
        int row=jTFichajeOperarios.getSelectedRow();//nº fila seleccionada
        //int col=jTFichajeOperarios.getSelectedColumn();//nº columna seleccionada
        String codigo="";
        String nombre="";
//        String fecha="";
//        //fecha=(jTFecha.getText());
//        fecha=getFecha(jDateChooser1);

        //RECUPERAR FECHA DEL CALENDARIO
//        Date data; 
        data=jDateChooser1.getDate();
//        data=convertir_String_Date(fecha);
        
        codigo=(String.valueOf(jTFichajeOperarios.getModel().getValueAt(row,0)));//devuelve el valor de la celda seleccionada
        nombre=(String.valueOf(jTFichajeOperarios.getModel().getValueAt(row,1)));


        jTOperario.setText(codigo+" - "+nombre);
        try {
            //System.out.println(codigo);
            fichajeOperariosInforme=fichajeOperariobll.obtenerFichajeOperariosInforme(codigo,data);
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        jTInformeOperario.setModel(new ModeloTablaInformacionOperarioVista(fichajeOperariosInforme));//introducir contenido en la tabla jTInformeOperario
        TableColumnModel columnModel3 = jTInformeOperario.getColumnModel();//modificardor columnas tabla informe operario
        dimensionesColumnas2(columnModel3);
        sumar();//sumar horas
        //jTInformeOperario.setDefaultRenderer (Object.class, new FormatoTabla());//introducir color al fondo del las celdas vacías
                
    }//GEN-LAST:event_jTFichajeOperariosMouseClicked

    private void jTFichajeOperariosSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFichajeOperariosSalidaMouseClicked
        int row=jTFichajeOperariosSalida.getSelectedRow();//nº fila seleccionada
        //int col=jTFichajeOperarios.getSelectedColumn();//nº columna seleccionada
        String codigo="";
        String nombre="";
//        String fecha="";
//        fecha=(jTFecha.getText());
        //Date data; 
        data=jDateChooser1.getDate();
        codigo=(String.valueOf(jTFichajeOperariosSalida.getModel().getValueAt(row,0)));//devuelve el valor de la celda seleccionada
        nombre=(String.valueOf(jTFichajeOperariosSalida.getModel().getValueAt(row,1)));


        jTOperario.setText(codigo+" - "+nombre);
        //System.out.println(codigo);
        
        try {
            //System.out.println(codigo);
            fichajeOperariosInforme=fichajeOperariobll.obtenerFichajeOperariosInforme(codigo,data);
        } catch (SQLException ex) {
            Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        jTInformeOperario.setModel(new ModeloTablaInformacionOperarioVista(fichajeOperariosInforme));//introducir contenido en la tabla jTInformeOperario
        TableColumnModel columnModel3 = jTInformeOperario.getColumnModel();//modificardor columnas tabla informe operario
        dimensionesColumnas2(columnModel3);
//        jTInformeOperario.setDefaultRenderer (Object.class, new FormatoTabla());//introducir color al fondo del las celdas vacías
        sumar();//sumar horas
    }//GEN-LAST:event_jTFichajeOperariosSalidaMouseClicked

    private void jBresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresetActionPerformed
        resetPantalla();
    }//GEN-LAST:event_jBresetActionPerformed
 //AL PRESIONAR LA TECLA ENTER, SE UTILIZABA PARA EL JTFecha
//    public void keyPressed(KeyEvent ke) {
//              if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
//                  System.out.println(jTFecha.getText());
//              }
//          }
    
    
    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JIntFrmFichajeOperarios().setVisible(true);
//            }
//        });
//    }
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBreset;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFecha;
    private javax.swing.JTable jTFichajeOperarios;
    private javax.swing.JTable jTFichajeOperariosSalida;
    private javax.swing.JTextField jTHora;
    private javax.swing.JTable jTInformeOperario;
    private javax.swing.JTextField jTOperario;
    private javax.swing.JTextField jTminutos;
    // End of variables declaration//GEN-END:variables
  static void dimensionesColumnas(TableColumnModel columnModel){
              
    /*redimensionar 1 columna de la tabla
        TableColumn columna = jTFichajeOperarios.getColumn("OPERARIO");
        columna.setMinWidth(ancho);
       
       redimensionar todas las columnas

       columnModel.getColumn(0).setPreferredWidth(100);
    */     
        columnModel.getColumn(0).setMinWidth(50);
        columnModel.getColumn(0).setMaxWidth(65);
        columnModel.getColumn(1).setMinWidth(260);
        columnModel.getColumn(2).setMinWidth(200);
        columnModel.getColumn(3).setMinWidth(80);
        columnModel.getColumn(4).setMinWidth(70);

  
  }
  static void dimensionesColumnas2(TableColumnModel columnModel){
        columnModel.getColumn(0).setMinWidth(200);
        columnModel.getColumn(1).setMinWidth(40);
        columnModel.getColumn(2).setMinWidth(10);
        //columnModel.getColumn(2).setPreferredWidth(20);


  
  
  }
//RELOJ TIEMPO REAL
 @Override
    public void run() {
        
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            jTHora.setText(hora + ":" + minutos + ":" + segundos);
            
            //resetPantalla();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }
    public void resetPantalla(){
   
        //if(data!=jDateChooser1.getDate()){
            //System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            try {
            data=jDateChooser1.getDate();
            fichajeOperariosSalida=fichajeOperariobll.obtenerFichajeOperariosSalida(data);
            fichajeOperarios=fichajeOperariobll.obtenerFichajeOperarios(data);
            fichajeOperariosInforme=fichajeOperariobll.obtenerFichajeOperariosInforme(null,data);

            } catch (SQLException ex) {
                Logger.getLogger(JIntFrmFichajeOperarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTFichajeOperarios.setModel(new ModeloTablaFichajeOperariosVista(fichajeOperarios));
            jTFichajeOperariosSalida.setModel(new ModeloTablaFichajeOperariosVista(fichajeOperariosSalida));
            jTInformeOperario.setModel(new ModeloTablaInformacionOperarioVista(fichajeOperariosInforme));
            jTOperario.setText("");
            jTminutos.setText("");
            refrescarDimensionesColumna();
        //}
    
    }

    public void cambiarTextoColumna(int row){
        if(String.valueOf(jTInformeOperario.getValueAt(row,2)).equals("S")){            
            jTInformeOperario.setValueAt("SALIDA", row, 2);
        }
    
    }
    public void refrescarDimensionesColumna(){
        TableColumnModel columnModel = jTFichajeOperarios.getColumnModel();//modificador columnas tabla operarios entrada
        TableColumnModel columnModel2 = jTFichajeOperariosSalida.getColumnModel();//modificador columnas tabla operarios salida
        TableColumnModel columnModel3 = jTInformeOperario.getColumnModel();//modificardor columnas tabla informe operario
        dimensionesColumnas(columnModel);
        dimensionesColumnas(columnModel2);
        dimensionesColumnas2(columnModel3);
    
    
    }
    public Date convertir_String_Date(String data){
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
//            String strFecha = "2007-12-25";
            Date fecha = null;
            try {

                fecha = formatoDelTexto.parse(data);

            } catch (ParseException ex) {

                ex.printStackTrace();

            }

//    System.out.println(fecha.toString());
        return fecha;
    }
            
    public String getFecha(JDateChooser jd){
        SimpleDateFormat Formato=new SimpleDateFormat("dd-MM-yyy");
	if(jd.getDate()!=null){
		return Formato.format(jd.getDate());
	}
	else{
		return null;
	}

    }


    int minutosTotales=0;

    
    public void sumar(){
//AQUI SE SUMAN LOS VALORES DE CADA FILA PARA COLOCARLO EN EL CAMPO DE TOTAL       
        int totalRow= jTInformeOperario.getRowCount();
        int minutosDia=0;
        totalRow-=1;
        String horaEntrada="";
        String horaSalida="";
        String diaE="";
        String diaS="";
        String [] dEn=null;
        String [] dSal=null;
        String [] vHE=null;
        String [] vHS=null;
        minutosTotales=0;
        int h,m,s,totalDia;
        int resto=0;
        for(int i=0;i<=(totalRow);i++)
        {
            h=0;//vaciamos cache
            m=0;
            s=0;
            resto=0;
            diaE="";
            diaS="";
            horaEntrada="";
            horaSalida="";
            totalDia=0;
            vHE=null;
            vHS=null;
            dEn=null;
            dSal=null;
            minutosDia=0;    
       
            //recoger dias entre entrada y salida 
            diaE=jTInformeOperario.getValueAt(i,2).toString();
            dEn=diaE.split("-");
            diaS=jTInformeOperario.getValueAt(i,4).toString();
            dSal=diaS.split("-");
            totalDia=Integer.parseInt(dSal[2])-Integer.parseInt(dEn[2]);
            if(totalDia>0){//si obtenemos más de 0 dias, convertimos los dias en minutos
                minutosDia=totalDia*1440;
            }
            //recoger hora entrada
            horaEntrada=jTInformeOperario.getValueAt(i,1).toString();
            vHE=horaEntrada.split(":");
            
            //recoger hora salida
            horaSalida=jTInformeOperario.getValueAt(i,3).toString();
            vHS=horaSalida.split(":");

            s=Integer.parseInt(vHS[2])-Integer.parseInt(vHE[2]);
            if(s<0){
                resto=1;
                s=60+s;
            }       
            m = (Integer.parseInt(vHS[1])-Integer.parseInt(vHE[1]))-resto;
            resto = 0;
            if (m < 0){
                m = 60 + m;
                resto = 1;
            }         
            h = (Integer.parseInt(vHS[0])-Integer.parseInt(vHE[0]))-resto;

            minutosTotales+=(h*60)+m+(s/60);
            //en el caso de que entre el dia anterior, para que no salgan los minutos negativos, sumamos 24horas (1440 minutos)

        }
        minutosTotales=minutosTotales+minutosDia;//la suma de minutosDia es por si la fichada de entrada es diferente a la fichada de salida
//            if (minutosTotales<0){
//                minutosTotales=minutosTotales+1440;
//            }
             
            jTminutos.setText(String.valueOf(minutosTotales));
        
    }
    
}
