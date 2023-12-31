/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.DetalleCompraData;
import entidades.DetalleCompra;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tasha
 */
public class ProductosPorCompra extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public ProductosPorCompra() {
        initComponents();
        armarCabecera();
    }

    private void llenarTabla() {

        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        try {
            int idCompra = Integer.parseInt(jTFIdCompra.getText());
            int cantidad = 0;
            int stock = 0;
            DetalleCompraData acceso = new DetalleCompraData();
            List<DetalleCompra> productos = acceso.obtenerProductosIdCompra(idCompra);

            if (productos != null) {
                for (DetalleCompra producto : productos) {
                    modelo.addRow(new Object[]{producto.getCantidad(), producto.getProducto().getNombreProducto(), producto.getPrecioCosto()});
                    cantidad++;
                    stock += producto.getCantidad();
                }
                lResumen.setText("Cantidad de productos: " + cantidad);
                lResumen2.setText("Stock adquirido: " + stock);
            } else {
                System.out.println("Error.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en Id. Compra.");
        }
                jTFIdCompra.setText("");

    }

    private void armarCabecera() {
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        jTCompras.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lidCompra = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jTFIdCompra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompras = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();
        lResumen = new javax.swing.JLabel();
        lResumen2 = new javax.swing.JLabel();

        setTitle("Productos por compra");
        setToolTipText("Gestor que permite buscar una compra y devuelve los productos que fueron adquiridos en la misma.");

        lidCompra.setText("Id. Compra:");

        jBBuscar.setBackground(new java.awt.Color(255, 255, 204));
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTCompras);

        jBSalir.setBackground(new java.awt.Color(255, 255, 204));
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        lResumen.setText(" ");

        lResumen2.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBSalir)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lidCompra)
                                .addGap(27, 27, 27)
                                .addComponent(jTFIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBuscar)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lResumen2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lidCompra)
                    .addComponent(jBBuscar)
                    .addComponent(jTFIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lResumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lResumen2)
                .addGap(10, 10, 10)
                .addComponent(jBSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        try {
            int idCompra = Integer.parseInt(jTFIdCompra.getText());
            DetalleCompraData acceso = new DetalleCompraData();
            List<DetalleCompra> productos = acceso.obtenerProductosIdCompra(idCompra);

            if (productos != null) {
                llenarTabla();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en Id. Compra.");
        }

    }//GEN-LAST:event_jBBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCompras;
    private javax.swing.JTextField jTFIdCompra;
    private javax.swing.JLabel lResumen;
    private javax.swing.JLabel lResumen2;
    private javax.swing.JLabel lidCompra;
    // End of variables declaration//GEN-END:variables
}
