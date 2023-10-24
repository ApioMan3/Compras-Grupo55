
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import accesoADatos.ProductoData;
import accesoADatos.ProveedorData;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ApioMan
 */
public class ProveedorPorProducto extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public ProveedorPorProducto() {
        try {
            initComponents();
            llenarCombo();
            armarCabecera();
            llenarTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos, verifique que existan proveedores.");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbProducto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCompras = new javax.swing.JTable();

        setTitle("Producto por proveedor.");
        setToolTipText("Gestor que permite seleccionar un proveedor y devuelve los productos que se le han comprado al mismo.");

        cbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductoActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto:");

        jbSalir.setBackground(new java.awt.Color(255, 255, 204));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        tCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tCompras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void cbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductoActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable tCompras;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        ProductoData acceso = new ProductoData();
        List<Producto> listado = acceso.listarTodosLosProductosActivos();
        for (Producto producto : listado) {
            cbProducto.addItem(producto);
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Proveedor");
        tCompras.setModel(modelo);
    }

    private void llenarTabla() {
        int filas = modelo.getRowCount();
        for (int i = filas - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }

        DetalleCompraData accesoD = new DetalleCompraData();

        Producto producto = (Producto) cbProducto.getSelectedItem();
        List<Proveedor> proveedores = accesoD.proveedoresPorProducto(producto.getIdProducto());
            for (Proveedor prov : proveedores) {
                modelo.addRow(new Object[]{prov.getIdProveedor(),prov.getRazonSocial()});
            }
        
    }
}
