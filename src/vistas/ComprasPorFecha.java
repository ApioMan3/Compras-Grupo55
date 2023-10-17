/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import accesoADatos.ProveedorData;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Proveedor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tasha
 */
public class ComprasPorFecha extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public ComprasPorFecha() {
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
        modelo.addColumn("ID - Compra");
        modelo.addColumn("Proveedor");
        jTComrpasPorFecha.setModel(modelo);
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
                modelo.addRow(new Object[]{compra.getIdCompra(), compra.getProveedor().getRazonSocial()});
                cantidad++;
        }
        lResumen.setText("Cantidad de compras realizadas en la fecha: " + fecha.toString() + " : " + cantidad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDCFecha = new com.toedter.calendar.JDateChooser();
        jLFecha = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        lResumen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComrpasPorFecha = new javax.swing.JTable();

        jDCFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDCFechaPropertyChange(evt);
            }
        });

        jLFecha.setText("Fecha:");

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        lResumen.setText("Cantidad de compras realizadas: ");

        jTComrpasPorFecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idCompra", "Proveedor", "Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTComrpasPorFecha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLFecha)
                                .addGap(37, 37, 37)
                                .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jBSalir))
                            .addComponent(lResumen)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFecha)
                    .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lResumen)
                .addGap(32, 32, 32)
                .addComponent(jBSalir)
                .addGap(22, 22, 22))
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
    private javax.swing.JTable jTComrpasPorFecha;
    private javax.swing.JLabel lResumen;
    // End of variables declaration//GEN-END:variables
}
