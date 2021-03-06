/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewGUI;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import util.Conexion;

/**
 *
 * @author Daniel
 */
public class requerimiento3 extends javax.swing.JPanel {

    DefaultTableModel model;
    
    public requerimiento3() {
        initComponents();
        
        String[] titulo = {"Nombre_Material","Importado","No_Compras"};
        model = new DefaultTableModel(null,titulo);
        
        jTable1.setModel(model);
        
        mostrarDatos();
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
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos() {
        Conexion objConexion = new Conexion();
        
        try {
            ResultSet resultado = objConexion.consultarRegistros("select m.Nombre_Material, "
                    + "m.Importado, "
                    + "COUNT(*) No_Compras "
                    + "from MaterialConstruccion m "
                    + "join Compra c on "
                    + "m.ID_MaterialConstruccion = c.ID_MaterialConstruccion "
                    + "where m.Importado = 'Si' "
                    + "group by c.ID_MaterialConstruccion "
                    + "order by         "
                    + "No_Compras asc;");
            while(resultado.next()){
                Object[] datos = {
                    resultado.getString("Nombre_Material"),
                    resultado.getString("Importado"),
                    resultado.getString("No_Compras")
                };
                model.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
