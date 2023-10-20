/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import entidades.Compra;
import entidades.DetalleCompra;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ApioMan
 */
public class ProductosPorFecha extends javax.swing.JInternalFrame {

        private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
        
        
    public ProductosPorFecha() {
         try {
            initComponents();
            armarCabecera();
            fechaActual();
            llenarTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos, verifique los datos ingresados.");
        }

    }

   
     private void armarCabecera() {
        modelo.addColumn("ID - Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("ID - Compra");
        modelo.addColumn("Unidades");
        jTProductos.setModel(modelo);
    }
     
         private void fechaActual() {
        jDCFecha.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    private void llenarTabla() {

        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

        int cantidad = 0;
        CompraData acceso = new CompraData();
        DetalleCompraData accesoD = new DetalleCompraData();

        LocalDate fecha = jDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<Compra> compras = acceso.listarComprasPorFecha(fecha);

        for (Compra compra : compras) {
            List<DetalleCompra> comprasD = accesoD.obtenerProductosIdCompra(compra.getIdCompra());
            for (DetalleCompra detalle : comprasD) {
                modelo.addRow(new Object[]{detalle.getProducto().getIdProducto(), detalle.getProducto().getNombreProducto(), compra.getIdCompra(), detalle.getCantidad()});
                cantidad= cantidad + detalle.getCantidad();
            }
        }
        lResumen.setText("Cantidad de productos en la fecha: " + fecha.toString() + " : " + cantidad);
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLFecha = new javax.swing.JLabel();
        jDCFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        lResumen = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();

        jLFecha.setText("Fecha:");

        jDCFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDCFechaPropertyChange(evt);
            }
        });

        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idProducto", "Producto", "idCompra", "Unidades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTProductos);

        lResumen.setText("Cantidad de productos:");

        jBSalir.setBackground(new java.awt.Color(255, 255, 204));
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLFecha)
                                .addGap(29, 29, 29)
                                .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lResumen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jBSalir)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFecha))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(lResumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jDCFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDCFechaPropertyChange
       llenarTabla();
    }//GEN-LAST:event_jDCFechaPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private com.toedter.calendar.JDateChooser jDCFecha;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProductos;
    private javax.swing.JLabel lResumen;
    // End of variables declaration//GEN-END:variables
}
