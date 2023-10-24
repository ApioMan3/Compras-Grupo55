/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import accesoADatos.ProductoData;
import accesoADatos.ProveedorData;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tasha
 */
public class RegistrarCompras extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public RegistrarCompras() {
        initComponents();
        try {
            initComponents();
            llenarComboProducto();
            llenarComboProveedor();
            armarCabecera();
            fechaActual();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos.");
        }

    }

    private void llenarComboProducto() {
        ProductoData acceso = new ProductoData();
        List<Producto> listado = acceso.listarTodosLosProductosActivos();
        for (Producto producto : listado) {
            jCBProducto.addItem(producto);
        }
    }

    private void llenarComboProveedor() {
        ProveedorData acceso = new ProveedorData();
        List<Proveedor> listado = acceso.listarProveedores();
        for (Proveedor proveedor : listado) {
            jCBProveedor.addItem(proveedor);
        }
    }

    private void armarCabecera() {
        modelo.addColumn("ID - Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        jTCompras.setModel(modelo);
    }

    private void fechaActual() {
        jDCFecha.setDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBProveedor = new javax.swing.JComboBox<>();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCompras = new javax.swing.JTable();
        jDCFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jCBProducto = new javax.swing.JComboBox<>();
        jTFCantidad = new javax.swing.JTextField();
        jTFPrecio = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jBEliminar = new javax.swing.JButton();
        jbRegistrar = new javax.swing.JButton();

        setTitle("Registrar compra");
        setToolTipText("Permite gestionar una compra, seleccionando fecha, proveedor y detalles de producto.");

        jLabel1.setText("Proveedor:");

        jBSalir.setBackground(new java.awt.Color(255, 255, 204));
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jTCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idProducto", "Producto", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTCompras);

        jLabel2.setText("Fecha de compra:");

        jLabel3.setText("Agregar Producto:");

        jLabel4.setText("Cantidad de unidades:");

        jBAgregar.setBackground(new java.awt.Color(255, 255, 204));
        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio:");

        jBEliminar.setBackground(new java.awt.Color(255, 255, 204));
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jbRegistrar.setBackground(new java.awt.Color(255, 255, 204));
        jbRegistrar.setText("Registrar");
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAgregar)
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBProducto, 0, 136, Short.MAX_VALUE)
                            .addComponent(jTFCantidad)
                            .addComponent(jTFPrecio))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegistrar)
                .addGap(18, 18, 18)
                .addComponent(jBSalir)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCBProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(jBAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir)
                    .addComponent(jbRegistrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int fila = jTCompras.getSelectedRow();
        if (fila > -1) {
            modelo.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto a eliminar.");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        try {
            Producto producto = (Producto) jCBProducto.getSelectedItem();
            double precio = Double.parseDouble(jTFPrecio.getText());
            int cantidad = Integer.parseInt(jTFCantidad.getText());
            boolean actualizado = false;

            //chequeo si existe agregado
            if (jTCompras.getRowCount() > 0) {
                for (int i = 0; i < jTCompras.getRowCount(); i++) {
                    int actual = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                    if (actual == producto.getIdProducto()) {
                        modelo.setValueAt(Integer.parseInt(modelo.getValueAt(i, 2).toString()) + cantidad, i, 2);
                        actualizado = true;
                    }
                }
            }
            //si no existia, se agrega
            if (!actualizado) {
                modelo.addRow(new Object[]{producto.getIdProducto(), producto.getNombreProducto(), cantidad, precio});
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en campos numéricos.");
        }

        //vaciar campos
        jTFPrecio.setText("");
        jTFCantidad.setText("");
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jButton1RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarActionPerformed

    }//GEN-LAST:event_jBRegistrarActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
   try {

            if (jDCFecha.getDate() == null || jDCFecha.getDate().after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
                JOptionPane.showMessageDialog(this, "La fecha ingresada no es válida.");
            } else {
                if (jTCompras.getRowCount() > 0) {
                    ProductoData accesoProducto = new ProductoData();
                    Compra compra = new Compra();
                    CompraData accesoCompra = new CompraData();
                    DetalleCompraData accesoDetalle = new DetalleCompraData();
                    DetalleCompra detalle = new DetalleCompra();

                    compra.setFecha(jDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    compra.setProveedor((Proveedor) jCBProveedor.getSelectedItem());
                    int idcompra = accesoCompra.guardarCompra(compra);
                    compra.setIdCompra(idcompra);


                    for (int i = 0; i < jTCompras.getRowCount(); i++) {
                        Producto producto = accesoProducto.buscarProducto(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                        detalle.setProducto(producto);
                        detalle.setCompra(compra);
                        detalle.setCantidad(Integer.parseInt(modelo.getValueAt(i, 2).toString()));
                        detalle.setPrecioCosto(Double.parseDouble(modelo.getValueAt(i, 3).toString()));
                        accesoDetalle.guardarDetalleCompra(detalle, idcompra);
                        accesoProducto.actualizarStock(Integer.parseInt(modelo.getValueAt(i, 2).toString()), Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    }

                    int filas = modelo.getRowCount();
                    for (int i = filas - 1; i >= 0; i--) {
                        modelo.removeRow(i);
                    }
                    fechaActual();
                    jTFCantidad.setText("");
                    jTFPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "No hay detalles para agregar.");
                }
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error en la fecha ingresada.");
        }
    }//GEN-LAST:event_jbRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Producto> jCBProducto;
    private javax.swing.JComboBox<Proveedor> jCBProveedor;
    private com.toedter.calendar.JDateChooser jDCFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTCompras;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFPrecio;
    private javax.swing.JButton jbRegistrar;
    // End of variables declaration//GEN-END:variables
}
